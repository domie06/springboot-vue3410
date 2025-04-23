package com.entity.model;

import com.entity.JubaotousuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 举报投诉
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JubaotousuModel implements Serializable {
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
     * 举报投诉编号
     */
    private String jubaotousuUuidNumber;


    /**
     * 举报投诉标题
     */
    private String jubaotousuName;


    /**
     * 举报投诉类型
     */
    private Integer jubaotousuTypes;


    /**
     * 举报投诉内容
     */
    private String jubaotousuContent;


    /**
     * 举报投诉时间
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
	 * 获取：举报投诉编号
	 */
    public String getJubaotousuUuidNumber() {
        return jubaotousuUuidNumber;
    }


    /**
	 * 设置：举报投诉编号
	 */
    public void setJubaotousuUuidNumber(String jubaotousuUuidNumber) {
        this.jubaotousuUuidNumber = jubaotousuUuidNumber;
    }
    /**
	 * 获取：举报投诉标题
	 */
    public String getJubaotousuName() {
        return jubaotousuName;
    }


    /**
	 * 设置：举报投诉标题
	 */
    public void setJubaotousuName(String jubaotousuName) {
        this.jubaotousuName = jubaotousuName;
    }
    /**
	 * 获取：举报投诉类型
	 */
    public Integer getJubaotousuTypes() {
        return jubaotousuTypes;
    }


    /**
	 * 设置：举报投诉类型
	 */
    public void setJubaotousuTypes(Integer jubaotousuTypes) {
        this.jubaotousuTypes = jubaotousuTypes;
    }
    /**
	 * 获取：举报投诉内容
	 */
    public String getJubaotousuContent() {
        return jubaotousuContent;
    }


    /**
	 * 设置：举报投诉内容
	 */
    public void setJubaotousuContent(String jubaotousuContent) {
        this.jubaotousuContent = jubaotousuContent;
    }
    /**
	 * 获取：举报投诉时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：举报投诉时间
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
