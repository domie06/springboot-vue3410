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
 * 公积金缴费
 *
 * @author 
 * @email
 */
@TableName("gongjijin_jiaofei")
public class GongjijinJiaofeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongjijinJiaofeiEntity() {

	}

	public GongjijinJiaofeiEntity(T t) {
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
     * 公积金缴费编号
     */
    @TableField(value = "gongjijin_jiaofei_uuid_number")

    private String gongjijinJiaofeiUuidNumber;


    /**
     * 公积金缴费金额
     */
    @TableField(value = "gongjijin_jiaofei_jine")

    private Double gongjijinJiaofeiJine;


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
	 * 设置：公积金缴费编号
	 */
    public String getGongjijinJiaofeiUuidNumber() {
        return gongjijinJiaofeiUuidNumber;
    }
    /**
	 * 获取：公积金缴费编号
	 */

    public void setGongjijinJiaofeiUuidNumber(String gongjijinJiaofeiUuidNumber) {
        this.gongjijinJiaofeiUuidNumber = gongjijinJiaofeiUuidNumber;
    }
    /**
	 * 设置：公积金缴费金额
	 */
    public Double getGongjijinJiaofeiJine() {
        return gongjijinJiaofeiJine;
    }
    /**
	 * 获取：公积金缴费金额
	 */

    public void setGongjijinJiaofeiJine(Double gongjijinJiaofeiJine) {
        this.gongjijinJiaofeiJine = gongjijinJiaofeiJine;
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
        return "GongjijinJiaofei{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", gongjijinJiaofeiUuidNumber=" + gongjijinJiaofeiUuidNumber +
            ", gongjijinJiaofeiJine=" + gongjijinJiaofeiJine +
            ", yuefenMonth=" + yuefenMonth +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
