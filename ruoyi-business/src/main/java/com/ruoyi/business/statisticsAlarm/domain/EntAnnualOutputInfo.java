package com.ruoyi.business.statisticsAlarm.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 企业年排量信息记录对象 t_bas_ent_annual_output_info
 */
@Data
public class EntAnnualOutputInfo {

    /** 年排量主键id */
    private String annualOutputId;

    /** 企业编码 */
    private String entCode;
    private String entName;

    /** 排放口编码 */
    private String outPutCode;
    private String outPutName;

    /** 排放口类型，1：废水；2：废气；3：无组织 */
    private Integer outPutType;

    /** 污染因子编码 */
    private String pollutantCode;
    private String pollutantNameCn;
    private String pollutantNameEn;

    /** 排放时间，年 */
    private Integer annualNum;

    /** 年排放量 */
    private BigDecimal annualCount;

    /** 年排放量限值 */
    private BigDecimal annualEmissionLimit;

    /** 截止当前排放量限值(截止当前月，包含) */
    private BigDecimal presentEmissionLimit;

    /** 报警类型：即将超标；已超标，未超标 */
    private String alarmType = "未超标";
}
