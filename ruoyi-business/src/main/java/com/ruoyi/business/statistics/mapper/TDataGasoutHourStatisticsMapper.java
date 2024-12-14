package com.ruoyi.business.statistics.mapper;

import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;

import java.util.List;

/**
 * 废气排口--小时报统计数据Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TDataGasoutHourStatisticsMapper {
    /**
     * 查询废气排口--小时报统计数据
     *
     * @param id 废气排口--小时报统计数据主键
     * @return 废气排口--小时报统计数据
     */
    TDataGasoutHourStatistics selectTDataGasoutHourStatisticsById(Long id);

    /**
     * 查询废气排口--小时报统计数据列表
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 废气排口--小时报统计数据集合
     */
    List<TDataGasoutHourStatistics> selectTDataGasoutHourStatisticsList(TDataGasoutHourStatistics tDataGasoutHourStatistics);

    /**
     * 新增废气排口--小时报统计数据
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 结果
     */
    int insertTDataGasoutHourStatistics(TDataGasoutHourStatistics tDataGasoutHourStatistics);

    /**
     * 修改废气排口--小时报统计数据
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 结果
     */
    int updateTDataGasoutHourStatistics(TDataGasoutHourStatistics tDataGasoutHourStatistics);

    /**
     * 删除废气排口--小时报统计数据
     *
     * @param id 废气排口--小时报统计数据主键
     * @return 结果
     */
    int deleteTDataGasoutHourStatisticsById(Long id);

    /**
     * 批量删除废气排口--小时报统计数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTDataGasoutHourStatisticsByIds(Long[] ids);

    List<TDataGasoutHourStatistics> selectTDataGasout4alarmList(TDataGasoutHourStatistics tDataGasoutHourStatistics);

    int selectTDataGasoutHourStatisticsCount(TDataGasoutHourStatistics tDataGasoutHourStatistics);
}
