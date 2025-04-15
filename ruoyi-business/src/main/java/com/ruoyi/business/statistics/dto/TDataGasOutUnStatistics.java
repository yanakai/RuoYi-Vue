package com.ruoyi.business.statistics.dto;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

/**
 * 废气无组织排口--统计数据对象
 */
@Data
public class TDataGasOutUnStatistics {

    /**
     * 数据监测时间
     */
    @Excel(name = "数据监测时间")
    private String monitorTime;

    /**
     * TSP
     */
    @Excel(name = "TSP（纳克/立方米）")
    private String tsp;

    /**
     * 风速
     */
    @Excel(name = "风速（米/秒）")
    private String speed;

    /**
     * 风向
     */
    @Excel(name = "风向")
    private String direction;

    /**
     * 温度
     */
    @Excel(name = "温度（摄氏度）")
    private String temperature;

    /**
     * 湿度
     */
    @Excel(name = "湿度（%）")
    private String humidity;

    /**
     * 气压
     */
    @Excel(name = "气压（千帕）")
    private String pressure;
}
