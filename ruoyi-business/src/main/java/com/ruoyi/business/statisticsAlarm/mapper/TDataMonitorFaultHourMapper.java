package com.ruoyi.business.statisticsAlarm.mapper;

import java.util.List;
import com.ruoyi.business.statisticsAlarm.domain.TDataMonitorFaultHour;

/**
 * 小时数据缺失---废水、废气Mapper接口
 * 
 * @author lx
 * @date 2024-10-26
 */
public interface TDataMonitorFaultHourMapper 
{
    /**
     * 查询小时数据缺失---废水、废气
     * 
     * @param alarmId 小时数据缺失---废水、废气主键
     * @return 小时数据缺失---废水、废气
     */
    public TDataMonitorFaultHour selectTDataMonitorFaultHourByAlarmId(Long alarmId);

    /**
     * 查询小时数据缺失---废水、废气列表
     * 
     * @param tDataMonitorFaultHour 小时数据缺失---废水、废气
     * @return 小时数据缺失---废水、废气集合
     */
    public List<TDataMonitorFaultHour> selectTDataMonitorFaultHourList(TDataMonitorFaultHour tDataMonitorFaultHour);

    /**
     * 新增小时数据缺失---废水、废气
     * 
     * @param tDataMonitorFaultHour 小时数据缺失---废水、废气
     * @return 结果
     */
    public int insertTDataMonitorFaultHour(TDataMonitorFaultHour tDataMonitorFaultHour);

    /**
     * 修改小时数据缺失---废水、废气
     * 
     * @param tDataMonitorFaultHour 小时数据缺失---废水、废气
     * @return 结果
     */
    public int updateTDataMonitorFaultHour(TDataMonitorFaultHour tDataMonitorFaultHour);

    /**
     * 删除小时数据缺失---废水、废气
     * 
     * @param alarmId 小时数据缺失---废水、废气主键
     * @return 结果
     */
    public int deleteTDataMonitorFaultHourByAlarmId(Long alarmId);

    /**
     * 批量删除小时数据缺失---废水、废气
     * 
     * @param alarmIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTDataMonitorFaultHourByAlarmIds(Long[] alarmIds);
}
