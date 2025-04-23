
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import org.apache.poi.hssf.record.chart.DatRecord;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 医保卡缴费
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shebaokaJiaofei")
public class ShebaokaJiaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(ShebaokaJiaofeiController.class);

    @Autowired
    private ShebaokaJiaofeiService shebaokaJiaofeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shebaokaJiaofeiService.queryPage(params);

        //字典表数据转换
        List<ShebaokaJiaofeiView> list =(List<ShebaokaJiaofeiView>)page.getList();
        for(ShebaokaJiaofeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShebaokaJiaofeiEntity shebaokaJiaofei = shebaokaJiaofeiService.selectById(id);
        if(shebaokaJiaofei !=null){
            //entity转view
            ShebaokaJiaofeiView view = new ShebaokaJiaofeiView();
            BeanUtils.copyProperties( shebaokaJiaofei , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shebaokaJiaofei.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShebaokaJiaofeiEntity shebaokaJiaofei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shebaokaJiaofei:{}",this.getClass().getName(),shebaokaJiaofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shebaokaJiaofei.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShebaokaJiaofeiEntity> queryWrapper = new EntityWrapper<ShebaokaJiaofeiEntity>()
            .eq("yonghu_id", shebaokaJiaofei.getYonghuId())
            .eq("yuefen_month",  new SimpleDateFormat("yyyy-MM").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebaokaJiaofeiEntity shebaokaJiaofeiEntity = shebaokaJiaofeiService.selectOne(queryWrapper);
        if(shebaokaJiaofeiEntity==null){



            YonghuEntity yonghuEntity = yonghuService.selectById(shebaokaJiaofei.getYonghuId());
            if(yonghuEntity == null)
                return R.error("查不到登录的用户");
            yonghuEntity.setYibaoJine(yonghuEntity.getYibaoJine()+shebaokaJiaofei.getShebaokaJiaofeiJine());
            yonghuService.updateById(yonghuEntity);




//            shebaokaJiaofei.setShebaokaJiaofeiUuidNumber(String.valueOf(new Date().getTime()));
            shebaokaJiaofei.setYuefenMonth(new SimpleDateFormat("yyyy-MM").format(new Date()));
            shebaokaJiaofei.setInsertTime(new Date());
            shebaokaJiaofei.setCreateTime(new Date());
            shebaokaJiaofeiService.insert(shebaokaJiaofei);
            return R.ok();
        }else {
            return R.error(511,"当前月份已有缴费记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShebaokaJiaofeiEntity shebaokaJiaofei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shebaokaJiaofei:{}",this.getClass().getName(),shebaokaJiaofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shebaokaJiaofei.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShebaokaJiaofeiEntity> queryWrapper = new EntityWrapper<ShebaokaJiaofeiEntity>()
            .notIn("id",shebaokaJiaofei.getId())
            .andNew()
            .eq("yonghu_id", shebaokaJiaofei.getYonghuId())
            .eq("yuefen_month", shebaokaJiaofei.getYuefenMonth())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebaokaJiaofeiEntity shebaokaJiaofeiEntity = shebaokaJiaofeiService.selectOne(queryWrapper);
        if(shebaokaJiaofeiEntity==null){
            shebaokaJiaofeiService.updateById(shebaokaJiaofei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该月份已有缴费记录");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shebaokaJiaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShebaokaJiaofeiEntity> shebaokaJiaofeiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShebaokaJiaofeiEntity shebaokaJiaofeiEntity = new ShebaokaJiaofeiEntity();
//                            shebaokaJiaofeiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shebaokaJiaofeiEntity.setShebaokaJiaofeiUuidNumber(data.get(0));                    //医保卡缴费编号 要改的
//                            shebaokaJiaofeiEntity.setShebaokaJiaofeiJine(data.get(0));                    //医保卡缴费金额 要改的
//                            shebaokaJiaofeiEntity.setYuefenMonth(data.get(0));                    //所属月份 要改的
//                            shebaokaJiaofeiEntity.setInsertTime(date);//时间
//                            shebaokaJiaofeiEntity.setCreateTime(date);//时间
                            shebaokaJiaofeiList.add(shebaokaJiaofeiEntity);


                            //把要查询是否重复的字段放入map中
                                //医保卡缴费编号
                                if(seachFields.containsKey("shebaokaJiaofeiUuidNumber")){
                                    List<String> shebaokaJiaofeiUuidNumber = seachFields.get("shebaokaJiaofeiUuidNumber");
                                    shebaokaJiaofeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shebaokaJiaofeiUuidNumber = new ArrayList<>();
                                    shebaokaJiaofeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shebaokaJiaofeiUuidNumber",shebaokaJiaofeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //医保卡缴费编号
                        List<ShebaokaJiaofeiEntity> shebaokaJiaofeiEntities_shebaokaJiaofeiUuidNumber = shebaokaJiaofeiService.selectList(new EntityWrapper<ShebaokaJiaofeiEntity>().in("shebaoka_jiaofei_uuid_number", seachFields.get("shebaokaJiaofeiUuidNumber")));
                        if(shebaokaJiaofeiEntities_shebaokaJiaofeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShebaokaJiaofeiEntity s:shebaokaJiaofeiEntities_shebaokaJiaofeiUuidNumber){
                                repeatFields.add(s.getShebaokaJiaofeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [医保卡缴费编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shebaokaJiaofeiService.insertBatch(shebaokaJiaofeiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shebaokaJiaofeiService.queryPage(params);

        //字典表数据转换
        List<ShebaokaJiaofeiView> list =(List<ShebaokaJiaofeiView>)page.getList();
        for(ShebaokaJiaofeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShebaokaJiaofeiEntity shebaokaJiaofei = shebaokaJiaofeiService.selectById(id);
            if(shebaokaJiaofei !=null){


                //entity转view
                ShebaokaJiaofeiView view = new ShebaokaJiaofeiView();
                BeanUtils.copyProperties( shebaokaJiaofei , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shebaokaJiaofei.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShebaokaJiaofeiEntity shebaokaJiaofei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shebaokaJiaofei:{}",this.getClass().getName(),shebaokaJiaofei.toString());
        Wrapper<ShebaokaJiaofeiEntity> queryWrapper = new EntityWrapper<ShebaokaJiaofeiEntity>()
            .eq("yonghu_id", shebaokaJiaofei.getYonghuId())
            .eq("shebaoka_jiaofei_uuid_number", shebaokaJiaofei.getShebaokaJiaofeiUuidNumber())
            .eq("yuefen_month", shebaokaJiaofei.getYuefenMonth())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebaokaJiaofeiEntity shebaokaJiaofeiEntity = shebaokaJiaofeiService.selectOne(queryWrapper);
        if(shebaokaJiaofeiEntity==null){
            shebaokaJiaofei.setInsertTime(new Date());
            shebaokaJiaofei.setCreateTime(new Date());
        shebaokaJiaofeiService.insert(shebaokaJiaofei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
