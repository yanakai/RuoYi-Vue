package com.ruoyi.business.envProt.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 企业环评环保管理-项目对象 t_env_mange_project
 */
@Data
public class EnvMangeProject {

    /** 环评环保管理-项目主键id */
    private String mProjectId;

    /** 企业编码 */
    private String entCode;
    private String entName;

    /** 项目名称 */
    private String projectName;

    /** 项目代码 */
    private String projectCode;

    /** 项目性质 */
    private String projectNature;

    /** 主要建设内容 */
    private String mainContent;

    /** 产品 */
    private String product;

    /** 产能 */
    private String pCapacity;

    /** 生产班制 */
    private String productShiftSys;

    /** 建设地点 */
    private String constructSide;

    /** 国民经济行业类别 */
    /* 类别示例
    "industryCategory": "94,610",
    "industryCategoryList": ["铜矿采选", "汽柴油车整车制造"],
    "industryCodeList": ["C1234","A12344"],
    "industryList": [[12,79,92,94],[12,79,92,94]],
    */
    private String industryCategory;
    private List<String> industryCategoryList;
    private List<String> industryCodeList;
    private List<List<Long>> industryList;

    /** 环评等级，1报告书、2报告表、3登记表、0无需环评（默认） */
    private int grade;

    /** 判断依据 */
    private String judgmentReason;

    /** 用地面积(平米) */
    private Float landArea;

    /** 对外立项时间 */
    private LocalDate extApprTime;

    /** 开工时间 */
    private LocalDate commenceTime;

    /** 投产时间 */
    private LocalDate productTime;

    /** 主要环保设施 */
    private String mainEnvFacilities;

    /** 备注 */
    private String remark;

    /** 附件列表（更新时用） */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> annexIds;
}
