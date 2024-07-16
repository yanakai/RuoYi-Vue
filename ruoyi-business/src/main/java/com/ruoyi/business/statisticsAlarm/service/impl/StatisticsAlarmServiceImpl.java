package com.ruoyi.business.statisticsAlarm.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;
import com.ruoyi.business.statistics.mapper.TDataGasoutHourStatisticsMapper;
import com.ruoyi.business.statistics.mapper.TDataWateroutHourStatisticsMapper;
import com.ruoyi.business.statisticsAlarm.domain.TDataGasoutControlHour;
import com.ruoyi.business.statisticsAlarm.dto.AlarmHourDto;
import com.ruoyi.business.statisticsAlarm.dto.OutControlHourDto;
import com.ruoyi.business.statisticsAlarm.mapper.TDataGasoutControlHourMapper;
import com.ruoyi.business.statisticsAlarm.service.IStatisticsAlarmService;
import com.ruoyi.business.statisticsAlarm.service.ITDataGasoutControlHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 废气排口--小时剩余排放平均值Service业务层处理
 *
 * @author lx
 * @date 2024-07-13
 */
@Service
public class StatisticsAlarmServiceImpl implements IStatisticsAlarmService {
   @Resource
   private TDataGasoutHourStatisticsMapper tDataGasoutHourStatisticsMapper;

   @Resource
   private TDataWateroutHourStatisticsMapper tDataWateroutHourStatisticsMapper;


    @Override
    public List<TDataGasoutHourStatistics> selectTDataGasout4alarmList(AlarmHourDto alarmHourDto) {
        TDataGasoutHourStatistics tDataGasoutHourStatistics = new TDataGasoutHourStatistics();
        BeanUtil.copyProperties(alarmHourDto, tDataGasoutHourStatistics);
        return tDataGasoutHourStatisticsMapper.selectTDataGasout4alarmList(tDataGasoutHourStatistics);
    }

    @Override
    public List<TDataWateroutHourStatistics> selectTDataWaterout4alarmList(AlarmHourDto alarmHourDto) {
        TDataWateroutHourStatistics tDataWateroutHourStatistics = new TDataWateroutHourStatistics();
        BeanUtil.copyProperties(alarmHourDto, tDataWateroutHourStatistics);
        return tDataWateroutHourStatisticsMapper.selectTDataWaterout4alarmList(tDataWateroutHourStatistics);
    }
}
