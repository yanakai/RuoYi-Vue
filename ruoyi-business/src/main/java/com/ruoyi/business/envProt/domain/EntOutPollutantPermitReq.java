package com.ruoyi.business.envProt.domain;

import lombok.Data;

import java.util.List;

/**
 * 企业排污许可基础请求对象 t_bas_ent_out_pollutant_permit
 */
@Data
public class EntOutPollutantPermitReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /** 企业编码 */
    private String entCode;
    /** 企业名称，模糊 */
    private String entName;

    /** 持证单位名称，模糊 */
    private String certUnitName;

    /** 许可证编号 */
    private String permitNum;

    /** 权限管理 */
    private List<String> entCodes;

}
