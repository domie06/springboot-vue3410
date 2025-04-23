package com.entity.vo;

import com.entity.JianyanxianceEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 建言献策
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianyanxiance")
public class JianyanxianceVO implements Serializable {
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
     * 建言献策编号
     */

    @TableField(value = "jianyanxiance_uuid_number")
    private String jianyanxianceUuidNumber;


    /**
     * 建言献策名称
     */

    @TableField(value = "jianyanxiance_name")
    private String jianyanxianceName;


    /**
     * 建言献策类型
     */

    @TableField(value = "jianyanxiance_types")
    private Integer jianyanxianceTypes;


    /**
     * 建言献策内容
     */

    @TableField(value = "jianyanxiance_content")
    private String jianyanxianceContent;


    /**
     * 建言献策时间
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
	 * 设置：建言献策编号
	 */
    public String getJianyanxianceUuidNumber() {
        return jianyanxianceUuidNumber;
    }


    /**
	 * 获取：建言献策编号
	 */

    public void setJianyanxianceUuidNumber(String jianyanxianceUuidNumber) {
        this.jianyanxianceUuidNumber = jianyanxianceUuidNumber;
    }
    /**
	 * 设置：建言献策名称
	 */
    public String getJianyanxianceName() {
        return jianyanxianceName;
    }


    /**
	 * 获取：建言献策名称
	 */

    public void setJianyanxianceName(String jianyanxianceName) {
        this.jianyanxianceName = jianyanxianceName;
    }
    /**
	 * 设置：建言献策类型
	 */
    public Integer getJianyanxianceTypes() {
        return jianyanxianceTypes;
    }


    /**
	 * 获取：建言献策类型
	 */

    public void setJianyanxianceTypes(Integer jianyanxianceTypes) {
        this.jianyanxianceTypes = jianyanxianceTypes;
    }
    /**
	 * 设置：建言献策内容
	 */
    public String getJianyanxianceContent() {
        return jianyanxianceContent;
    }


    /**
	 * 获取：建言献策内容
	 */

    public void setJianyanxianceContent(String jianyanxianceContent) {
        this.jianyanxianceContent = jianyanxianceContent;
    }
    /**
	 * 设置：建言献策时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：建言献策时间
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
