package com.chenhm.springboot.mapper.material.domain;

import lombok.Data;

import java.util.Date;

/**
 * 素材库
 *
 * @author chen-hongmin
 * @date 2018-09-20 16:41:04
 * @since V1.0
 */
@Data
public class MaterialDO {
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
}