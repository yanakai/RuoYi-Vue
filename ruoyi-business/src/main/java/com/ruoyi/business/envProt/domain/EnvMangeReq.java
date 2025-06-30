package com.ruoyi.business.envProt.domain;

import lombok.Data;

/**
 * 企业环评环保管理-项目对象 t_env_mange_project
 */
@Data
public class EnvMangeReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /** 查询字段，用作项目名称、获取环评时的项目主键id */
    private String key;

    /** 企业筛选，模糊 */
    private String entName;

    /** 权限管理 */
    private String permEntCode;
}
