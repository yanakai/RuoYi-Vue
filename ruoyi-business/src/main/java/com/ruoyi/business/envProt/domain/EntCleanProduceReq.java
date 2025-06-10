package com.ruoyi.business.envProt.domain;

import lombok.Data;

import java.util.List;

/**
 * 企业清洁生产基础对象 t_bas_ent_clean_produce
 */
@Data
public class EntCleanProduceReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /** 企业编码 */
    private String entCode;
    /** 企业名称，模糊 */
    private String entName;

    /** 名称 */
    private String cleanName;

    /** 权限管理 */
    private List<String> entCodes;
}
