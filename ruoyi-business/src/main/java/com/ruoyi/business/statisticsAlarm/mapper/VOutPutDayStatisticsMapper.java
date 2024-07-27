package com.ruoyi.business.statisticsAlarm.mapper;

import com.ruoyi.business.statisticsAlarm.domain.VOutPutDayStatistics;
import com.ruoyi.business.statisticsAlarm.dto.AlarmEmissionsDto;

import java.util.List;

/**
 * VIEWMapper接口
 * 
 * @author lx
 * @date 2024-07-27
 */
public interface VOutPutDayStatisticsMapper {

    /**
     * 查询VIEW列表
     * 
     * @param vOutPutDayStatistics VIEW
     * @return VIEW集合
     */
    List<VOutPutDayStatistics> selectVOutPutDayStatisticsList(VOutPutDayStatistics vOutPutDayStatistics);

    List<AlarmEmissionsDto>  selectAlarmExceptionDtoList(VOutPutDayStatistics vOutPutDayStatistics);

}
