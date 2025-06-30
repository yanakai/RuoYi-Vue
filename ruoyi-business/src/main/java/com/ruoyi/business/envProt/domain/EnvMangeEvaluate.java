package com.ruoyi.business.envProt.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 企业环评环保管理-环评对象 t_env_mange_evaluate
 */
@Data
public class EnvMangeEvaluate {

    /** 环评环保管理-环评主键id */
    private String mEvaluateId;

    /** 环评环保管理-项目主键id */
    private String mProjectId;

    /** 环评层级 */
    private String eiaLevel;

    /** 审批部门 */
    private String approvalDepart;

    /** 批复文号 */
    private String replyNo;

    /** 评价机构 */
    private String ratingAgency;

    /** 主笔人员 */
    private String leadAuthor;

    /** 评价费用(元) */
    private Integer ratingCost;

    /** 主要污染物 */
    private String pollutantCode;
    private String pollutantCodeDesc;

    /** 污染物总量(kg) */
    private Float pollutantTotal;

    /** 合同签订时间 */
    private LocalDate contractTime;

    /** 报告提交时间 */
    private LocalDate reportSubTime;

    /** 对外公示时间 */
    private LocalDate publicityTime;

    /** 批复时间 */
    private LocalDate approvalTime;

    /** 备注 */
    private String remark;

    /** 附件列表（更新时用） */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> annexIds;
}
