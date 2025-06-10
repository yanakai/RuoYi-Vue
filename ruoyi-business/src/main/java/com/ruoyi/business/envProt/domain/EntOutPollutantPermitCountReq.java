package com.ruoyi.business.envProt.domain;

import lombok.Data;

/**
 * 企业排污许可总量基础对象 t_bas_ent_out_pollutant_permit_total
 */
@Data
public class EntOutPollutantPermitCountReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /** 排污许可id */
    private String pollPermitId;

    /** 污染因子名称（模糊） */
    private String pollutantNameCn;
    private String pollutantNameEn;

    /** 年份 */
    private Integer permitYear;
}
