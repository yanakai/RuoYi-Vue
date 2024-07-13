package com.ruoyi.business.onlineMonitoring.dto;

import com.ruoyi.business.common.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 废水排口--DTO TDataWateroutMonthStatisticsDTO
 *
 * @author lx
 * @date 2024-07-08
 */
@ApiModel
@Data
public class WateroutDTO extends BaseDto {
    private static final long serialVersionUID = 1L;
    /**
     * 排口code
     */
    @ApiParam(name = "outPutCode", value = "排口编码", required = true)
    private String outPutCode;

    @ApiModelProperty
    private DataEnum dataEnum;
}
