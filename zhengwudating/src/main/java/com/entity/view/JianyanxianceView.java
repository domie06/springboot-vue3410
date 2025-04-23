package com.entity.view;

import com.entity.JianyanxianceEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 建言献策
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jianyanxiance")
public class JianyanxianceView extends JianyanxianceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 建言献策类型的值
		*/
		private String jianyanxianceValue;



		//级联表 yonghu
			/**
			* 用户唯一编号
			*/
			private String yonghuUuidNumber;
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 公积金余额
			*/
			private Double gongjijinJine;
			/**
			* 医保卡余额
			*/
			private Double yibaoJine;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public JianyanxianceView() {

	}

	public JianyanxianceView(JianyanxianceEntity jianyanxianceEntity) {
		try {
			BeanUtils.copyProperties(this, jianyanxianceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 建言献策类型的值
			*/
			public String getJianyanxianceValue() {
				return jianyanxianceValue;
			}
			/**
			* 设置： 建言献策类型的值
			*/
			public void setJianyanxianceValue(String jianyanxianceValue) {
				this.jianyanxianceValue = jianyanxianceValue;
			}


















				//级联表的get和set yonghu

					/**
					* 获取： 用户唯一编号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 用户唯一编号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 公积金余额
					*/
					public Double getGongjijinJine() {
						return gongjijinJine;
					}
					/**
					* 设置： 公积金余额
					*/
					public void setGongjijinJine(Double gongjijinJine) {
						this.gongjijinJine = gongjijinJine;
					}

					/**
					* 获取： 医保卡余额
					*/
					public Double getYibaoJine() {
						return yibaoJine;
					}
					/**
					* 设置： 医保卡余额
					*/
					public void setYibaoJine(Double yibaoJine) {
						this.yibaoJine = yibaoJine;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}




}
