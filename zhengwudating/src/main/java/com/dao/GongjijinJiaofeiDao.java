package com.dao;

import com.entity.GongjijinJiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongjijinJiaofeiView;

/**
 * 公积金缴费 Dao 接口
 *
 * @author 
 */
public interface GongjijinJiaofeiDao extends BaseMapper<GongjijinJiaofeiEntity> {

   List<GongjijinJiaofeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
