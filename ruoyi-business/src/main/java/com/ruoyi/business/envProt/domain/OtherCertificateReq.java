package com.ruoyi.business.envProt.domain;

import lombok.Data;

/**
 * 其他证书对象 t_other_certificate
 */
@Data
public class OtherCertificateReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /** 证书名称（模糊） */
    private String certName;

    /** 发证机构（模糊） */
    private String issueOffice;

    /** 归属（模糊） */
    private String certBelong;

    /** 归属类型，1机构，2个人 */
    private Integer belongType;

    /** 权限管理 */
    private String userId;
    /** 添加的账号（模糊） */
    private String userName;
}
