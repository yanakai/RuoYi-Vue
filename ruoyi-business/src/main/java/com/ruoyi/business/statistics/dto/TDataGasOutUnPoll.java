package com.ruoyi.business.statistics.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 废气无组织排口--统计数据对象
 */
@Data
public class TDataGasOutUnPoll {

    /**
     * 结果值
     */
    private BigDecimal totalValue;

    /**
     * 污染物编码
     */
    private String pollutantCode;

    /**
     * 时间
     */
    @JsonIgnore
    private String monitorTime;

    /**
     * 总条数
     */
    @JsonIgnore
    private Long totals;
}