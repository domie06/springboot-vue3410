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
 * 医保卡缴费
 *
 * @author 
 * @email
 */
@TableName("shebaoka_jiaofei")
public class ShebaokaJiaofeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShebaokaJiaofeiEntity() {

	}

	public ShebaokaJiaofeiEntity(T t) {
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
     * 医保卡缴费编号
     */
    @TableField(value = "shebaoka_jiaofei_uuid_number")

    private String shebaokaJiaofeiUuidNumber;


    /**
     * 医保卡缴费金额
     */
    @TableField(value = "shebaoka_jiaofei_jine")

    private Double shebaokaJiaofeiJine;


    /**
     * 所属月份
     */
    @TableField(value = "yuefen_month")

    private String yuefenMonth;


    /**
     * 缴费时间
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
	 * 设置：医保卡缴费编号
	 */
    public String getShebaokaJiaofeiUuidNumber() {
        return shebaokaJiaofeiUuidNumber;
    }
    /**
	 * 获取：医保卡缴费编号
	 */

    public void setShebaokaJiaofeiUuidNumber(String shebaokaJiaofeiUuidNumber) {
        this.shebaokaJiaofeiUuidNumber = shebaokaJiaofeiUuidNumber;
    }
    /**
	 * 设置：医保卡缴费金额
	 */
    public Double getShebaokaJiaofeiJine() {
        return shebaokaJiaofeiJine;
    }
    /**
	 * 获取：医保卡缴费金额
	 */

    public void setShebaokaJiaofeiJine(Double shebaokaJiaofeiJine) {
        this.shebaokaJiaofeiJine = shebaokaJiaofeiJine;
    }
    /**
	 * 设置：所属月份
	 */
    public String getYuefenMonth() {
        return yuefenMonth;
    }
    /**
	 * 获取：所属月份
	 */

    public void setYuefenMonth(String yuefenMonth) {
        this.yuefenMonth = yuefenMonth;
    }
    /**
	 * 设置：缴费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：缴费时间
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
        return "ShebaokaJiaofei{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", shebaokaJiaofeiUuidNumber=" + shebaokaJiaofeiUuidNumber +
            ", shebaokaJiaofeiJine=" + shebaokaJiaofeiJine +
            ", yuefenMonth=" + yuefenMonth +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
