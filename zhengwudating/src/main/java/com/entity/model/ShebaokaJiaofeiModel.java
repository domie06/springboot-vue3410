package com.entity.model;

import com.entity.ShebaokaJiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医保卡缴费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShebaokaJiaofeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 医保卡缴费编号
     */
    private String shebaokaJiaofeiUuidNumber;


    /**
     * 医保卡缴费金额
     */
    private Double shebaokaJiaofeiJine;


    /**
     * 所属月份
     */
    private String yuefenMonth;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：医保卡缴费编号
	 */
    public String getShebaokaJiaofeiUuidNumber() {
        return shebaokaJiaofeiUuidNumber;
    }


    /**
	 * 设置：医保卡缴费编号
	 */
    public void setShebaokaJiaofeiUuidNumber(String shebaokaJiaofeiUuidNumber) {
        this.shebaokaJiaofeiUuidNumber = shebaokaJiaofeiUuidNumber;
    }
    /**
	 * 获取：医保卡缴费金额
	 */
    public Double getShebaokaJiaofeiJine() {
        return shebaokaJiaofeiJine;
    }


    /**
	 * 设置：医保卡缴费金额
	 */
    public void setShebaokaJiaofeiJine(Double shebaokaJiaofeiJine) {
        this.shebaokaJiaofeiJine = shebaokaJiaofeiJine;
    }
    /**
	 * 获取：所属月份
	 */
    public String getYuefenMonth() {
        return yuefenMonth;
    }


    /**
	 * 设置：所属月份
	 */
    public void setYuefenMonth(String yuefenMonth) {
        this.yuefenMonth = yuefenMonth;
    }
    /**
	 * 获取：缴费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：缴费时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
