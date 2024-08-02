package com.ruoyi.business.statistics.mapper;

import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutMonthStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutRealOrMinuteStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutYearStatistics;

import java.util.List;

/**
 * 废气排口--日报统计数据Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TDataGasoutDayStatisticsMapper {
    /**
     * 查询废气排口--日报统计数据
     *
     * @param id 废气排口--日报统计数据主键
     * @return 废气排口--日报统计数据
     */
    TDataGasoutDayStatistics selectTDataGasoutDayStatisticsById(Long id);

    /**
     * 查询废气排口--日报统计数据列表
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 废气排口--日报统计数据集合
     */
    List<TDataGasoutDayStatistics> selectTDataGasoutDayStatisticsList(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 新增废气排口--日报统计数据
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 结果
     */
    int insertTDataGasoutDayStatistics(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 修改废气排口--日报统计数据
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 结果
     */
    int updateTDataGasoutDayStatistics(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 删除废气排口--日报统计数据
     *
     * @param id 废气排口--日报统计数据主键
     * @return 结果
     */
    int deleteTDataGasoutDayStatisticsById(Long id);

    /**
     * 批量删除废气排口--日报统计数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTDataGasoutDayStatisticsByIds(Long[] ids);


    /**
     * 查询废气排口--月度统计数据列表
     *
     * @param tDataGasoutDayStatistics 废气排口--月度统计数据
     * @return 废气排口--月度统计数据集合
     */
    List<TDataGasoutMonthStatistics> selectTDataGasoutMonthStatisticsList(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 查询废气排口--季度统计数据列表
     *
     * @param tDataGasoutDayStatistics 废气排口--季度统计数据
     * @return 废气排口--季度统计数据集合
     */
    List<TDataGasoutDayStatistics> selectTDataGasoutQuarterStatisticsList(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 查询废气排口--年度统计数据列表
     *
     * @param tDataGasoutDayStatistics 废气排口--年度统计数据
     * @return 废气排口--年度统计数据集合
     */
    List<TDataGasoutYearStatistics> selectTDataGasoutYearStatisticsList(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 查询废气排口--实时或者分钟数据列表
     *
     * @param tDataGasoutDayStatistics 废气排口--实时或者分钟数据列表
     * @return 废气排口--实时或者分钟数据列表
     */
    List<TDataGasoutRealOrMinuteStatistics> selectTDataGasoutMinuteOrRealStatisticsList(TDataGasoutDayStatistics tDataGasoutDayStatistics);

}
