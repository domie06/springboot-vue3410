package com.entity.view;

import com.entity.ZiliaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 资料
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("ziliao")
public class ZiliaoView extends ZiliaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 资料类型的值
		*/
		private String ziliaoValue;



	public ZiliaoView() {

	}

	public ZiliaoView(ZiliaoEntity ziliaoEntity) {
		try {
			BeanUtils.copyProperties(this, ziliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 资料类型的值
			*/
			public String getZiliaoValue() {
				return ziliaoValue;
			}
			/**
			* 设置： 资料类型的值
			*/
			public void setZiliaoValue(String ziliaoValue) {
				this.ziliaoValue = ziliaoValue;
			}












}
