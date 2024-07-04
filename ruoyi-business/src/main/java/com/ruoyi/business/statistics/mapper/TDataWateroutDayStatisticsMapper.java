package com.ruoyi.business.statistics.mapper;

import com.ruoyi.business.statistics.domain.TDataWateroutDayStatistics;

import java.util.List;

/**
 * 废水排口--日报统计数据Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TDataWateroutDayStatisticsMapper {
    /**
     * 查询废水排口--日报统计数据
     *
     * @param id 废水排口--日报统计数据主键
     * @return 废水排口--日报统计数据
     */
    TDataWateroutDayStatistics selectTDataWateroutDayStatisticsById(Long id);

    /**
     * 查询废水排口--日报统计数据列表
     *
     * @param tDataWateroutDayStatistics 废水排口--日报统计数据
     * @return 废水排口--日报统计数据集合
     */
    List<TDataWateroutDayStatistics> selectTDataWateroutDayStatisticsList(TDataWateroutDayStatistics tDataWateroutDayStatistics);

    /**
     * 新增废水排口--日报统计数据
     *
     * @param tDataWateroutDayStatistics 废水排口--日报统计数据
     * @return 结果
     */
    int insertTDataWateroutDayStatistics(TDataWateroutDayStatistics tDataWateroutDayStatistics);

    /**
     * 修改废水排口--日报统计数据
     *
     * @param tDataWateroutDayStatistics 废水排口--日报统计数据
     * @return 结果
     */
    int updateTDataWateroutDayStatistics(TDataWateroutDayStatistics tDataWateroutDayStatistics);

    /**
     * 删除废水排口--日报统计数据
     *
     * @param id 废水排口--日报统计数据主键
     * @return 结果
     */
    int deleteTDataWateroutDayStatisticsById(Long id);

    /**
     * 批量删除废水排口--日报统计数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTDataWateroutDayStatisticsByIds(Long[] ids);
}
