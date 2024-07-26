package com.ruoyi.business.statistics.service;

import com.ruoyi.business.statistics.domain.TDataWateroutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataWateroutStatisticsDTO;

import java.util.List;

/**
 * 废水排口--日报统计数据Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface ITDataWateroutDayStatisticsService {
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
     * 批量删除废水排口--日报统计数据
     *
     * @param ids 需要删除的废水排口--日报统计数据主键集合
     * @return 结果
     */
    int deleteTDataWateroutDayStatisticsByIds(Long[] ids);

    /**
     * 删除废水排口--日报统计数据信息
     *
     * @param id 废水排口--日报统计数据主键
     * @return 结果
     */
    int deleteTDataWateroutDayStatisticsById(Long id);

    /**
     * 查询废水排口--月统计数据
     *
     * @param tDataWateroutDayStatisticsDTO 废水排口--月统计数据
     * @return 废水排口--月统计数据
     */
    List<TDataWateroutDayStatistics> selectTDataWateroutMonthStatisticsList(TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO);

    /**
     * 查询废水排口--季度统计数据
     *
     * @param tDataWateroutDayStatisticsDTO 废水排口--季度统计数据
     * @return 废水排口--季度统计数据
     */
    List<TDataWateroutDayStatistics> selectTDataWateroutQuarterStatisticsList(TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO);

    /**
     * 查询废水排口--年统计数据
     *
     * @param tDataWateroutDayStatisticsDTO 废水排口--年统计数据
     * @return 废水排口--年统计数据
     */
    List<TDataWateroutDayStatistics> selectTDataWateroutYearStatisticsList(TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO);


    List<TDataWateroutDayStatistics> selectTDataWateroutMinuteOrRealStatisticsList(TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO);

}
