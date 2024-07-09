package com.ruoyi.business.statistics.service;

import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;

import java.util.List;

/**
 * 废气排口--日报统计数据Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface ITDataGasoutDayStatisticsService {
    /**
     * 查询废气排口--日报统计数据
     *
     * @param id 废气排口--日报统计数据主键
     * @return 废气排口--日报统计数据
     */
    public TDataGasoutDayStatistics selectTDataGasoutDayStatisticsById(Long id);

    /**
     * 查询废气排口--日报统计数据列表
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 废气排口--日报统计数据集合
     */
    public List<TDataGasoutDayStatistics> selectTDataGasoutDayStatisticsList(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 新增废气排口--日报统计数据
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 结果
     */
    public int insertTDataGasoutDayStatistics(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 修改废气排口--日报统计数据
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 结果
     */
    public int updateTDataGasoutDayStatistics(TDataGasoutDayStatistics tDataGasoutDayStatistics);

    /**
     * 批量删除废气排口--日报统计数据
     *
     * @param ids 需要删除的废气排口--日报统计数据主键集合
     * @return 结果
     */
    public int deleteTDataGasoutDayStatisticsByIds(Long[] ids);

    /**
     * 删除废气排口--日报统计数据信息
     *
     * @param id 废气排口--日报统计数据主键
     * @return 结果
     */
    public int deleteTDataGasoutDayStatisticsById(Long id);

    /**
     * 查询废气排口--月度统计数据列表
     *
     * @param tDataGasoutStatisticsDTO 废气排口--月度统计数据
     * @return 废气排口--月度统计数据集合
     */
    public List<TDataGasoutDayStatistics> selectTDataGasoutMonthStatisticsList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO);

    /**
     * 查询废气排口--季度统计数据列表
     *
     * @param tDataGasoutStatisticsDTO 废气排口--季度统计数据
     * @return 废气排口--季度统计数据集合
     */
    public List<TDataGasoutDayStatistics> selectTDataGasoutQuarterStatisticsList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO);

    /**
     * 查询废气排口--年度统计数据列表
     *
     * @param tDataGasoutStatisticsDTO 废气排口--年度统计数据
     * @return 废气排口--年度统计数据集合
     */
    public List<TDataGasoutDayStatistics> selectTDataGasoutYearStatisticsList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO);
}
