package com.ruoyi.business.statistics.dto;

import com.ruoyi.business.common.BaseDto;
import com.ruoyi.business.onlineMonitoring.dto.DataEnum;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 废气排口--DTO TDataGasoutStatisticsDTO
 *
 * @author lx
 * @date 2024-07-08
 */
@Data
public class TDataGasoutStatisticsDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    /**
     * 废气排口code
     */
    @ApiParam(name = "outPutCode", value = "排口编码", required = true)
    private String outPutCode;

    /**
     * 废气排口名称
     */
    @ApiParam(name = "outPutName", value = "排口名称")
    private String outPutName;

    private DataEnum dataEnum;

    private String entCode;

    private String mnNum;
}
