package com.ruoyi.business.base.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础信息---企业基础对象 t_bas_enterprise
 *
 * @author ruoyi
 * @date 2024-06-26
 */
@Data
@ApiModel("1、企业档案---企业基础")
public class TBasEnterpriseBaseInfoDto extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 企业编码
     */
    @ApiModelProperty(value = "企业编码")
    @Excel(name = "企业编码")
    private String entCode;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    @Excel(name = "企业名称")
    private String entName;

    /**
     * 社会统一信用代码
     */
    @ApiModelProperty(value = "社会统一信用代码")
    @Excel(name = "社会统一信用代码")
    private String socialCreditCode;

    /**
     * 企业简称
     */
    @ApiModelProperty(value = "企业简称")
    @Excel(name = "企业简称")
    private String shorterName;

}
