package com.ruoyi.business.statisticsAlarm.dto;

import com.ruoyi.business.common.BaseDto;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *  OutControlHourDto
 *
 * @author lx
 * @date 2024-07-13
 */
@ApiModel
@Data
public class OutControlHourDto extends BaseDto {
    private static final long serialVersionUID = 1L;


    /**
     * 企业编码
     */
    @ApiParam(name = "entCode", value = "企业编码")
    private String entCode;

    /**
     * 企业名称
     */
    @ApiParam(name = "entName", value = "企业名称")
    private String entName;

    /**
     * 废气排口编码
     */
    @ApiParam(name = "outPutCode", value = "排口编码")
    private String outPutCode;

    /**
     * 废气排口名称
     */
    @ApiParam(name = "outPutName", value = "排口名称")
    private String outPutName;

    private OutPutEnum outPutEnum;
}
