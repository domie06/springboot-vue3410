package com.entity.vo;

import com.entity.JubaotousuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 举报投诉
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jubaotousu")
public class JubaotousuVO implements Serializable {
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
