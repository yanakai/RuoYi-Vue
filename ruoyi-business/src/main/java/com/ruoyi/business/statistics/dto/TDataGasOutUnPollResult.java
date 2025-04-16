package com.ruoyi.business.statistics.dto;

import lombok.Data;

import java.util.List;

/**
 * 废气无组织排口--统计数据对象
 */
@Data
public class TDataGasOutUnPollResult {

    /**
     * 时间
     */
    private String monitorTime;

    private List<TDataGasOutUnPoll> list;
}
