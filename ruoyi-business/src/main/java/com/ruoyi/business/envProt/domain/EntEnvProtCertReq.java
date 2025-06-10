package com.ruoyi.business.envProt.domain;

import lombok.Data;

import java.util.List;

/**
 * 企业环保证书基础对象 t_bas_ent_env_prot_cert
 */
@Data
public class EntEnvProtCertReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /** 企业编码 */
    private String entCode;
    /** 企业名称，模糊 */
    private String entName;

    /** 证书名称 */
    private String protCertName;

    /** 权限管理 */
    private List<String> entCodes;
}
