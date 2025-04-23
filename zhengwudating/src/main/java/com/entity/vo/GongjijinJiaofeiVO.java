package com.entity.vo;

import com.entity.GongjijinJiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 公积金缴费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongjijin_jiaofei")
public class GongjijinJiaofeiVO implements Serializable {
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
