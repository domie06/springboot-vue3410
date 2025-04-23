package com.dao;

import com.entity.JubaotousuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JubaotousuView;

/**
 * 举报投诉 Dao 接口
 *
 * @author 
 */
public interface JubaotousuDao extends BaseMapper<JubaotousuEntity> {

   List<JubaotousuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
