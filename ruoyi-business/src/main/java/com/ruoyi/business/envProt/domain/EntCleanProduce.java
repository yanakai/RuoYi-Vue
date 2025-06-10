package com.ruoyi.business.envProt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业清洁生产基础对象 t_bas_ent_clean_produce
 */
@Data
public class EntCleanProduce {

    /** 排污许可id */
    private String cleanProduceId;

    /** 企业编码 */
    private String entCode;
    /** 企业名称 */
    private String entName;

    /** 名称 */
    private String cleanName;

    /** 编制单位 */
    private String makeUnit;

    /** 编制时间 */
    private String makeDate;

    /** 审核重点 */
    private String auditInfo;

    /** 审核状态，1提交审核，2审核通过、3审核拒绝，null未提交 */
    private Integer auditStatus;

    /** 审核内容/备注 */
    private String auditDesc;

    /** 审批意见 */
    private String auditOpinion;

    /** 方案情况 */
    private String planInfo;

    /** 预计减排效果 */
    private String mayReduce;

    /** 工作进展(与字典中工作进展进行值转换) */
    private String workProgress;
    private String workProgressDesc;

    /** 计划实施时间 */
    private String planDate;

    /** 创建人 */
    private String createUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 更新人 */
    private String updateUser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /** 审批人 */
    private String auditUser;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime auditTime;

    /** 附件主键id */
    private List<String> annexIds;
}
