package com.ruoyi.business.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Map;

/**
 * BaseDto
 * 基础DTO
 * 用于封装公共参数
 */
@Data
public abstract class BaseDto {
    @ApiParam(name = "params", value = "参数", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> params;
}
