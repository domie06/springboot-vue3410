package com.entity.vo;

import com.entity.ShebaokaJiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医保卡缴费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shebaoka_jiaofei")
public class ShebaokaJiaofeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
