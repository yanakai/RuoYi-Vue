package com.ruoyi.business.statisticsAlarm.service;


import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;
import com.ruoyi.business.statisticsAlarm.dto.AlarmHourDto;

import java.util.List;

/**
 * 分级预警报警 IStatisticsAlarmService
 *
 * @author lx
 * @date 2024-07-04
 */
public interface IStatisticsAlarmService{
    List<TDataGasoutHourStatistics> selectTDataGasout4alarmList(AlarmHourDto alarmHourDto);

    List<TDataWateroutHourStatistics> selectTDataWaterout4alarmList(AlarmHourDto alarmHourDto);
}
