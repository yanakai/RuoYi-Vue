package com.ruoyi.business.statistics.dto;

import com.ruoyi.business.common.BaseDto;
import com.ruoyi.business.onlineMonitoring.dto.DataEnum;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 废水排口--DTO TDataWateroutMonthStatisticsDTO
 *
 * @author lx
 * @date 2024-07-08
 */
@Data
public class TDataWateroutStatisticsDTO extends BaseDto {
    private static final long serialVersionUID = 1L;


    /**
     * 排口code
     */
    @ApiParam(name = "outPutCode", value = "排口编码", required = true)
    private String outPutCode;

    /**
     * 排口名称
     */
    @ApiParam(name = "outPutName", value = "排口名称")
    private String outPutName;

    private DataEnum dataEnum;

    private String entCode;

    private String mnNum;


}
