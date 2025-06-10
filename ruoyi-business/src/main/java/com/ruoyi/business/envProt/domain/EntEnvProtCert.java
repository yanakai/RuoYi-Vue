package com.ruoyi.business.envProt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业环保证书基础对象 t_bas_ent_env_prot_cert
 */
@Data
public class EntEnvProtCert {
    private static final long serialVersionUID = 1L;

    /** 排污许可id */
    private String protCertId;

    /** 企业编码 */
    private String entCode;
    /** 企业名称，模糊 */
    private String entName;

    /** 证书名称 */
    private String protCertName;

    /** 发证机关 */
    private String issueOffice;

    /** 有效期-开始时间（yyyy-MM-dd） */
    private String beginDate;

    /** 有效期-结束时间（yyyy-MM-dd） */
    private String endDate;

    /** 发证日期（yyyy-MM-dd） */
    private String issueDate;

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

    /** 附件主键id */
    private List<String> annexIds;
}
