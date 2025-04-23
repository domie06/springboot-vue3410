
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
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
 * 公积金缴费
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongjijinJiaofei")
public class GongjijinJiaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(GongjijinJiaofeiController.class);

    @Autowired
    private GongjijinJiaofeiService gongjijinJiaofeiService;


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
        PageUtils page = gongjijinJiaofeiService.queryPage(params);

        //字典表数据转换
        List<GongjijinJiaofeiView> list =(List<GongjijinJiaofeiView>)page.getList();
        for(GongjijinJiaofeiView c:list){
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
        GongjijinJiaofeiEntity gongjijinJiaofei = gongjijinJiaofeiService.selectById(id);
        if(gongjijinJiaofei !=null){
            //entity转view
            GongjijinJiaofeiView view = new GongjijinJiaofeiView();
            BeanUtils.copyProperties( gongjijinJiaofei , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(gongjijinJiaofei.getYonghuId());
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
    public R save(@RequestBody GongjijinJiaofeiEntity gongjijinJiaofei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongjijinJiaofei:{}",this.getClass().getName(),gongjijinJiaofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            gongjijinJiaofei.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<GongjijinJiaofeiEntity> queryWrapper = new EntityWrapper<GongjijinJiaofeiEntity>()
            .eq("yonghu_id", gongjijinJiaofei.getYonghuId())
            .eq("yuefen_month", new SimpleDateFormat("yyyy-MM").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongjijinJiaofeiEntity gongjijinJiaofeiEntity = gongjijinJiaofeiService.selectOne(queryWrapper);
        if(gongjijinJiaofeiEntity==null){



            YonghuEntity yonghuEntity = yonghuService.selectById(gongjijinJiaofei.getYonghuId());
            if(yonghuEntity == null)
                return R.error("查不到登录的用户");
            yonghuEntity.setGongjijinJine(yonghuEntity.getGongjijinJine()+gongjijinJiaofei.getGongjijinJiaofeiJine());
            yonghuService.updateById(yonghuEntity);



//            gongjijinJiaofei.setGongjijinJiaofeiUuidNumber(String.valueOf(new Date().getTime()));
            gongjijinJiaofei.setYuefenMonth(new SimpleDateFormat("yyyy-MM").format(new Date()));
            gongjijinJiaofei.setInsertTime(new Date());
            gongjijinJiaofei.setCreateTime(new Date());
            gongjijinJiaofeiService.insert(gongjijinJiaofei);






            return R.ok();
        }else {
            return R.error(511,"当前月份已有缴费记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongjijinJiaofeiEntity gongjijinJiaofei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongjijinJiaofei:{}",this.getClass().getName(),gongjijinJiaofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            gongjijinJiaofei.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<GongjijinJiaofeiEntity> queryWrapper = new EntityWrapper<GongjijinJiaofeiEntity>()
            .notIn("id",gongjijinJiaofei.getId())
            .andNew()
            .eq("yonghu_id", gongjijinJiaofei.getYonghuId())
            .eq("yuefen_month", gongjijinJiaofei.getYuefenMonth())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongjijinJiaofeiEntity gongjijinJiaofeiEntity = gongjijinJiaofeiService.selectOne(queryWrapper);
        if(gongjijinJiaofeiEntity==null){
            gongjijinJiaofeiService.updateById(gongjijinJiaofei);//根据id更新
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
        gongjijinJiaofeiService.deleteBatchIds(Arrays.asList(ids));
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
            List<GongjijinJiaofeiEntity> gongjijinJiaofeiList = new ArrayList<>();//上传的东西
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
                            GongjijinJiaofeiEntity gongjijinJiaofeiEntity = new GongjijinJiaofeiEntity();
//                            gongjijinJiaofeiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            gongjijinJiaofeiEntity.setGongjijinJiaofeiUuidNumber(data.get(0));                    //公积金缴费编号 要改的
//                            gongjijinJiaofeiEntity.setGongjijinJiaofeiJine(data.get(0));                    //公积金缴费金额 要改的
//                            gongjijinJiaofeiEntity.setYuefenMonth(data.get(0));                    //所属月份 要改的
//                            gongjijinJiaofeiEntity.setInsertTime(date);//时间
//                            gongjijinJiaofeiEntity.setCreateTime(date);//时间
                            gongjijinJiaofeiList.add(gongjijinJiaofeiEntity);


                            //把要查询是否重复的字段放入map中
                                //公积金缴费编号
                                if(seachFields.containsKey("gongjijinJiaofeiUuidNumber")){
                                    List<String> gongjijinJiaofeiUuidNumber = seachFields.get("gongjijinJiaofeiUuidNumber");
                                    gongjijinJiaofeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gongjijinJiaofeiUuidNumber = new ArrayList<>();
                                    gongjijinJiaofeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gongjijinJiaofeiUuidNumber",gongjijinJiaofeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //公积金缴费编号
                        List<GongjijinJiaofeiEntity> gongjijinJiaofeiEntities_gongjijinJiaofeiUuidNumber = gongjijinJiaofeiService.selectList(new EntityWrapper<GongjijinJiaofeiEntity>().in("gongjijin_jiaofei_uuid_number", seachFields.get("gongjijinJiaofeiUuidNumber")));
                        if(gongjijinJiaofeiEntities_gongjijinJiaofeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongjijinJiaofeiEntity s:gongjijinJiaofeiEntities_gongjijinJiaofeiUuidNumber){
                                repeatFields.add(s.getGongjijinJiaofeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [公积金缴费编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongjijinJiaofeiService.insertBatch(gongjijinJiaofeiList);
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
        PageUtils page = gongjijinJiaofeiService.queryPage(params);

        //字典表数据转换
        List<GongjijinJiaofeiView> list =(List<GongjijinJiaofeiView>)page.getList();
        for(GongjijinJiaofeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongjijinJiaofeiEntity gongjijinJiaofei = gongjijinJiaofeiService.selectById(id);
            if(gongjijinJiaofei !=null){


                //entity转view
                GongjijinJiaofeiView view = new GongjijinJiaofeiView();
                BeanUtils.copyProperties( gongjijinJiaofei , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(gongjijinJiaofei.getYonghuId());
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
    public R add(@RequestBody GongjijinJiaofeiEntity gongjijinJiaofei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gongjijinJiaofei:{}",this.getClass().getName(),gongjijinJiaofei.toString());
        Wrapper<GongjijinJiaofeiEntity> queryWrapper = new EntityWrapper<GongjijinJiaofeiEntity>()
            .eq("yonghu_id", gongjijinJiaofei.getYonghuId())
            .eq("gongjijin_jiaofei_uuid_number", gongjijinJiaofei.getGongjijinJiaofeiUuidNumber())
            .eq("yuefen_month", gongjijinJiaofei.getYuefenMonth())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongjijinJiaofeiEntity gongjijinJiaofeiEntity = gongjijinJiaofeiService.selectOne(queryWrapper);
        if(gongjijinJiaofeiEntity==null){
            gongjijinJiaofei.setInsertTime(new Date());
            gongjijinJiaofei.setCreateTime(new Date());
        gongjijinJiaofeiService.insert(gongjijinJiaofei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
