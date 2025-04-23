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
 * 举报投诉
 *
 * @author 
 * @email
 */
@TableName("jubaotousu")
public class JubaotousuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JubaotousuEntity() {

	}

	public JubaotousuEntity(T t) {
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
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 举报投诉编号
     */
    @TableField(value = "jubaotousu_uuid_number")

    private String jubaotousuUuidNumber;


    /**
     * 举报投诉标题
     */
    @TableField(value = "jubaotousu_name")

    private String jubaotousuName;


    /**
     * 举报投诉类型
     */
    @TableField(value = "jubaotousu_types")

    private Integer jubaotousuTypes;


    /**
     * 举报投诉内容
     */
    @TableField(value = "jubaotousu_content")

    private String jubaotousuContent;


    /**
     * 举报投诉时间
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：举报投诉编号
	 */
    public String getJubaotousuUuidNumber() {
        return jubaotousuUuidNumber;
    }
    /**
	 * 获取：举报投诉编号
	 */

    public void setJubaotousuUuidNumber(String jubaotousuUuidNumber) {
        this.jubaotousuUuidNumber = jubaotousuUuidNumber;
    }
    /**
	 * 设置：举报投诉标题
	 */
    public String getJubaotousuName() {
        return jubaotousuName;
    }
    /**
	 * 获取：举报投诉标题
	 */

    public void setJubaotousuName(String jubaotousuName) {
        this.jubaotousuName = jubaotousuName;
    }
    /**
	 * 设置：举报投诉类型
	 */
    public Integer getJubaotousuTypes() {
        return jubaotousuTypes;
    }
    /**
	 * 获取：举报投诉类型
	 */

    public void setJubaotousuTypes(Integer jubaotousuTypes) {
        this.jubaotousuTypes = jubaotousuTypes;
    }
    /**
	 * 设置：举报投诉内容
	 */
    public String getJubaotousuContent() {
        return jubaotousuContent;
    }
    /**
	 * 获取：举报投诉内容
	 */

    public void setJubaotousuContent(String jubaotousuContent) {
        this.jubaotousuContent = jubaotousuContent;
    }
    /**
	 * 设置：举报投诉时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：举报投诉时间
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
        return "Jubaotousu{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", jubaotousuUuidNumber=" + jubaotousuUuidNumber +
            ", jubaotousuName=" + jubaotousuName +
            ", jubaotousuTypes=" + jubaotousuTypes +
            ", jubaotousuContent=" + jubaotousuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
