package com.ruoyi.business.envProt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业排污许可基础对象 t_bas_ent_out_pollutant_permit
 */
@Data
public class EntOutPollutantPermit {
    private static final long serialVersionUID = 1L;

    /** 排污许可id */
    private String pollPermitId;

    /** 企业编码 */
    private String entCode;

    /** 企业名称 */
    private String entName;

    /** 持证单位名称 */
    private String certUnitName;

    /** 持证单位社会信用代码 */
    private String certUnitCode;

    /** 排污许可管理类别 */
    private String permitLevel;
    private String permitLevelDesc;

    /** 许可证编号 */
    private String permitNum;

    /** 有效期-开始时间（yyyy-MM-dd） */
    private String beginDate;

    /** 有效期-结束时间（yyyy-MM-dd） */
    private String endDate;

    /** 发证机关 */
    private String issueOffice;

    /** 发证日期（yyyy-MM-dd） */
    private String issueDate;

    /** 执行报告报送要求 */
    private String reportRequire;

    /** 主要产品(与字典中企业产品进行值转换) */
    private String productIds;
    private String productDesc;

    /** 产量 */
    private Double productOutput;

    /** 平台账号 */
    private String account;

    /** 平台密码 */
    private String password;

    /** 废气污染物种类(pollutantCodes) */
    private String gasPollType;
    private String gasPollDesc;

    /** 废气排放规律 */
    private String gasEmissionRule;
    private String gasEmissionRuleDesc;

    /** 废气执行标准 */
    private String gasExecuteStandard;

    /** 废水污染物种类(pollutantCodes) */
    private String waterPollType;
    private String waterPollDesc;

    /** 废水排放规律 */
    private String waterEmissionRule;
    private String waterEmissionRuleDesc;

    /** 废水执行标准 */
    private String waterExecuteStandard;

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

    /** 备注 */
    private String remark;

    /** 附件主键id */
    private List<String> annexIds;
}
