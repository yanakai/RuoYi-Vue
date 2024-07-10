package com.ruoyi.business.onlineMonitoring.dto;

import com.ruoyi.business.common.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 废气排口--DTO TDataGasoutStatisticsDTO
 *
 * @author lx
 * @date 2024-07-08
 */
@ApiModel
@Data
public class GasoutDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    /**
     * 废气排口code
     */
    @ApiParam(name = "outPutCode", value = "排口编码", required = true)
    private String outPutCode;
    @ApiModelProperty
    private DataEnum dataEnum;

}
