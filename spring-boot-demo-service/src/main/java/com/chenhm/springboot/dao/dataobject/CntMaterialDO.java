package com.chenhm.springboot.dao.dataobject;

import java.util.Date;

/**
 * 素材库
 *
 * @author chen-hongmin
 * @date 2018-09-20 16:41:04
 * @since V1.0
 */
public class CntMaterialDO {
    /**
     * 自增ID，不用于业务
     */
    private Long id;

    /**
     * 素材编码
     */
    private String materialCode;

    /**
     * 素材文件ID
     */
    private String fileId;

    /**
     * 素材标题
     */
    private String title;

    /**
     * 素材分类  1 -美萌 2 -新奇 3 -搞笑 4 -潮酷 5 -场景
     */
    private Integer category;

    /**
     * 素材来源 1 -运营上传 2 -第三方
     */
    private Integer source;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作人ID
     */
    private Long operatorId;

    /**
     * 上下线状态 0 -下线 1 -上线 默认0
     */
    private Integer status;

    /**
     * 是否删除 0 -否 1 -是 默认0
     */
    private Integer delFlag;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialCode() {
        return this.materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategory() {
        return this.category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSource() {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}