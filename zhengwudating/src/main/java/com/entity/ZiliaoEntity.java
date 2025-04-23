package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 资料
 *
 * @author 
 * @email
 */
@TableName("ziliao")
public class ZiliaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZiliaoEntity() {

	}

	public ZiliaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 资料编号
     */
    @TableField(value = "ziliao_uuid_number")

    private String ziliaoUuidNumber;


    /**
     * 资料名称
     */
    @TableField(value = "ziliao_name")

    private String ziliaoName;


    /**
     * 资料配图
     */
    @TableField(value = "ziliao_photo")

    private String ziliaoPhoto;


    /**
     * 资料类型
     */
    @TableField(value = "ziliao_types")

    private Integer ziliaoTypes;


    /**
     * 资料文件
     */
    @TableField(value = "ziliao_file")

    private String ziliaoFile;


    /**
     * 资料介绍
     */
    @TableField(value = "ziliao_content")

    private String ziliaoContent;


    /**
     * 资料录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：资料编号
	 */
    public String getZiliaoUuidNumber() {
        return ziliaoUuidNumber;
    }
    /**
	 * 获取：资料编号
	 */

    public void setZiliaoUuidNumber(String ziliaoUuidNumber) {
        this.ziliaoUuidNumber = ziliaoUuidNumber;
    }
    /**
	 * 设置：资料名称
	 */
    public String getZiliaoName() {
        return ziliaoName;
    }
    /**
	 * 获取：资料名称
	 */

    public void setZiliaoName(String ziliaoName) {
        this.ziliaoName = ziliaoName;
    }
    /**
	 * 设置：资料配图
	 */
    public String getZiliaoPhoto() {
        return ziliaoPhoto;
    }
    /**
	 * 获取：资料配图
	 */

    public void setZiliaoPhoto(String ziliaoPhoto) {
        this.ziliaoPhoto = ziliaoPhoto;
    }
    /**
	 * 设置：资料类型
	 */
    public Integer getZiliaoTypes() {
        return ziliaoTypes;
    }
    /**
	 * 获取：资料类型
	 */

    public void setZiliaoTypes(Integer ziliaoTypes) {
        this.ziliaoTypes = ziliaoTypes;
    }
    /**
	 * 设置：资料文件
	 */
    public String getZiliaoFile() {
        return ziliaoFile;
    }
    /**
	 * 获取：资料文件
	 */

    public void setZiliaoFile(String ziliaoFile) {
        this.ziliaoFile = ziliaoFile;
    }
    /**
	 * 设置：资料介绍
	 */
    public String getZiliaoContent() {
        return ziliaoContent;
    }
    /**
	 * 获取：资料介绍
	 */

    public void setZiliaoContent(String ziliaoContent) {
        this.ziliaoContent = ziliaoContent;
    }
    /**
	 * 设置：资料录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：资料录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ziliao{" +
            "id=" + id +
            ", ziliaoUuidNumber=" + ziliaoUuidNumber +
            ", ziliaoName=" + ziliaoName +
            ", ziliaoPhoto=" + ziliaoPhoto +
            ", ziliaoTypes=" + ziliaoTypes +
            ", ziliaoFile=" + ziliaoFile +
            ", ziliaoContent=" + ziliaoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
