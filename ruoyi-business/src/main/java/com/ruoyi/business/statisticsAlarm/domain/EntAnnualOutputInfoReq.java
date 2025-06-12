package com.ruoyi.business.statisticsAlarm.domain;

import lombok.Data;

import java.util.List;

/**
 * 企业年排量信息记录对象 t_bas_ent_annual_output_info
 */
@Data
public class EntAnnualOutputInfoReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /** 企业编码 */
    private String entName;

    /** 排放口编码 */
    private String outPutName;

    /** 排放口类型，1：废水；2：废气；3：无组织 */
    private Integer outPutType;

    /** 污染因子编码 */
    private String pollutantNameCn;
    private String pollutantNameEn;

    /** 排放时间，年 */
    private Integer annualNum;

    /** 权限管理 */
    private List<String> entCodes;
}
