package com.ruoyi.business.statisticsAlarm.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataEntScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.statisticsAlarm.mapper.TDataMonitorFaultHourMapper;
import com.ruoyi.business.statisticsAlarm.domain.TDataMonitorFaultHour;
import com.ruoyi.business.statisticsAlarm.service.ITDataMonitorFaultHourService;

/**
 * 小时数据缺失---废水、废气Service业务层处理
 * 
 * @author lx
 * @date 2024-10-26
 */
@Service
public class TDataMonitorFaultHourServiceImpl implements ITDataMonitorFaultHourService 
{
    @Autowired
    private TDataMonitorFaultHourMapper tDataMonitorFaultHourMapper;

    /**
     * 查询小时数据缺失---废水、废气
     * 
     * @param alarmId 小时数据缺失---废水、废气主键
     * @return 小时数据缺失---废水、废气
     */
    @Override
    public TDataMonitorFaultHour selectTDataMonitorFaultHourByAlarmId(Long alarmId)
    {
        return tDataMonitorFaultHourMapper.selectTDataMonitorFaultHourByAlarmId(alarmId);
    }

    /**
     * 查询小时数据缺失---废水、废气列表
     * 
     * @param tDataMonitorFaultHour 小时数据缺失---废水、废气
     * @return 小时数据缺失---废水、废气
     */
    @Override
    @DataEntScope
    public List<TDataMonitorFaultHour> selectTDataMonitorFaultHourList(TDataMonitorFaultHour tDataMonitorFaultHour)
    {
        return tDataMonitorFaultHourMapper.selectTDataMonitorFaultHourList(tDataMonitorFaultHour);
    }

    /**
     * 新增小时数据缺失---废水、废气
     * 
     * @param tDataMonitorFaultHour 小时数据缺失---废水、废气
     * @return 结果
     */
    @Override
    public int insertTDataMonitorFaultHour(TDataMonitorFaultHour tDataMonitorFaultHour)
    {
        return tDataMonitorFaultHourMapper.insertTDataMonitorFaultHour(tDataMonitorFaultHour);
    }

    /**
     * 修改小时数据缺失---废水、废气
     * 
     * @param tDataMonitorFaultHour 小时数据缺失---废水、废气
     * @return 结果
     */
    @Override
    public int updateTDataMonitorFaultHour(TDataMonitorFaultHour tDataMonitorFaultHour)
    {
        return tDataMonitorFaultHourMapper.updateTDataMonitorFaultHour(tDataMonitorFaultHour);
    }

    /**
     * 批量删除小时数据缺失---废水、废气
     * 
     * @param alarmIds 需要删除的小时数据缺失---废水、废气主键
     * @return 结果
     */
    @Override
    public int deleteTDataMonitorFaultHourByAlarmIds(Long[] alarmIds)
    {
        return tDataMonitorFaultHourMapper.deleteTDataMonitorFaultHourByAlarmIds(alarmIds);
    }

    /**
     * 删除小时数据缺失---废水、废气信息
     * 
     * @param alarmId 小时数据缺失---废水、废气主键
     * @return 结果
     */
    @Override
    public int deleteTDataMonitorFaultHourByAlarmId(Long alarmId)
    {
        return tDataMonitorFaultHourMapper.deleteTDataMonitorFaultHourByAlarmId(alarmId);
    }
}
