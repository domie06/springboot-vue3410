package com.entity.model;

import com.entity.JianyanxianceEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 建言献策
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianyanxianceModel implements Serializable {
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
     * 建言献策编号
     */
    private String jianyanxianceUuidNumber;


    /**
     * 建言献策名称
     */
    private String jianyanxianceName;


    /**
     * 建言献策类型
     */
    private Integer jianyanxianceTypes;


    /**
     * 建言献策内容
     */
    private String jianyanxianceContent;


    /**
     * 建言献策时间
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
	 * 获取：建言献策编号
	 */
    public String getJianyanxianceUuidNumber() {
        return jianyanxianceUuidNumber;
    }


    /**
	 * 设置：建言献策编号
	 */
    public void setJianyanxianceUuidNumber(String jianyanxianceUuidNumber) {
        this.jianyanxianceUuidNumber = jianyanxianceUuidNumber;
    }
    /**
	 * 获取：建言献策名称
	 */
    public String getJianyanxianceName() {
        return jianyanxianceName;
    }


    /**
	 * 设置：建言献策名称
	 */
    public void setJianyanxianceName(String jianyanxianceName) {
        this.jianyanxianceName = jianyanxianceName;
    }
    /**
	 * 获取：建言献策类型
	 */
    public Integer getJianyanxianceTypes() {
        return jianyanxianceTypes;
    }


    /**
	 * 设置：建言献策类型
	 */
    public void setJianyanxianceTypes(Integer jianyanxianceTypes) {
        this.jianyanxianceTypes = jianyanxianceTypes;
    }
    /**
	 * 获取：建言献策内容
	 */
    public String getJianyanxianceContent() {
        return jianyanxianceContent;
    }


    /**
	 * 设置：建言献策内容
	 */
    public void setJianyanxianceContent(String jianyanxianceContent) {
        this.jianyanxianceContent = jianyanxianceContent;
    }
    /**
	 * 获取：建言献策时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：建言献策时间
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
