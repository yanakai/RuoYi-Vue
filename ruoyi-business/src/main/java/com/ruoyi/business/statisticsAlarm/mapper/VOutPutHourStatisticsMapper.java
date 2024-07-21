package com.ruoyi.business.statisticsAlarm.mapper;

import com.ruoyi.business.statisticsAlarm.domain.VOutPutHourStatistics;

import java.util.List;

/**
 * 排口小时报警统计视图Mapper接口
 *
 * @author lx
 * @date 2024-07-19
 */
public interface VOutPutHourStatisticsMapper {
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

    /**
     * 新增排口小时报警统计视图
     *
     * @param vOutPutHourStatistics 排口小时报警统计视图
     * @return 结果
     */
    int insertVOutPutHourStatistics(VOutPutHourStatistics vOutPutHourStatistics);

    /**
     * 修改排口小时报警统计视图
     *
     * @param vOutPutHourStatistics 排口小时报警统计视图
     * @return 结果
     */
    int updateVOutPutHourStatistics(VOutPutHourStatistics vOutPutHourStatistics);

    /**
     * 删除排口小时报警统计视图
     *
     * @param entName 排口小时报警统计视图主键
     * @return 结果
     */
    int deleteVOutPutHourStatisticsByEntName(String entName);

    /**
     * 批量删除排口小时报警统计视图
     *
     * @param entNames 需要删除的数据主键集合
     * @return 结果
     */
    int deleteVOutPutHourStatisticsByEntNames(String[] entNames);
}
