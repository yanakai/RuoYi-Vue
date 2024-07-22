package com.ruoyi.business.statisticsAlarm.service;

import com.ruoyi.business.statisticsAlarm.domain.VOutPutHourStatistics;
import com.ruoyi.business.statisticsAlarm.dto.DataMissingDto;

import java.util.List;

/**
 * 排口小时报警统计视图Service接口
 *
 * @author lx
 * @date 2024-07-19
 */
public interface IVOutPutHourStatisticsService {
    /**
     * 查询排口小时报警统计视图
     *
     * @param entName 排口小时报警统计视图主键
     * @return 排口小时报警统计视图
     */
    VOutPutHourStatistics selectVOutPutHourStatisticsByEntName(String entName);

    /**
     * 查询排口小时报警统计视图列表
     *
     * @param vOutPutHourStatistics 排口小时报警统计视图
     * @return 排口小时报警统计视图集合
     */
    List<VOutPutHourStatistics> selectVOutPutHourStatisticsList(VOutPutHourStatistics vOutPutHourStatistics);

    /**
     * 排放量报警
     * @param vOutPutHourStatistics
     * @return
     */
    List<VOutPutHourStatistics> selectVOutPutHourEmissionsList(VOutPutHourStatistics vOutPutHourStatistics);

    List<DataMissingDto> selectDataMissingList(DataMissingDto dataMissingDto);
}
