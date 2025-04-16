package com.ruoyi.business.statistics.mapper;

import com.ruoyi.business.onlineMonitoring.dto.GasOutUnDTO;
import com.ruoyi.business.statistics.dto.TDataGasOutUnPoll;
import com.ruoyi.business.statistics.dto.TDataGasOutUnStatistics;

import java.util.List;

/**
 * 废气无组织排口--统计数据Mapper接口
 */
public interface TDataGasOutUnDayStatisticsMapper {

    /**
     * 查询废气排口--统计数据列表
     * 年、月、日查询日表
     * 小时查询时表
     * 分钟查询分表
     * 实时查询实时表
     * @param gasOutUnDTO 废气无组织查询参数
     * @return 废气排口--统计数据集合
     */
    List<TDataGasOutUnStatistics> selectTDataGasOutUnStatisticsList(GasOutUnDTO gasOutUnDTO);
    List<TDataGasOutUnPoll> selectTDataGasOutUnStatisticsListTest(GasOutUnDTO gasOutUnDTO);

}