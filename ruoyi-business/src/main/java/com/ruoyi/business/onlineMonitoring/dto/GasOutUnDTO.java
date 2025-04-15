package com.ruoyi.business.onlineMonitoring.dto;

import com.ruoyi.business.common.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 废气无组织排口
 */
@Data
@ApiModel
public class GasOutUnDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    /**
     * 废气无组织排口code
     */
    @ApiParam(name = "outPutCode", value = "排口编码", required = true)
    private String outPutCode;
    @ApiModelProperty
    private DataEnum dataEnum;

    private String entCode;

    private String mnNum;

    private Integer size;
    private Integer current;

}
