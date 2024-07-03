package com.ruoyi.business.statistics.service;

import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;

import java.util.List;

/**
 * 废气排口--小时报统计数据Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface ITDataGasoutHourStatisticsService {
    /**
     * 查询废气排口--小时报统计数据
     *
     * @param id 废气排口--小时报统计数据主键
     * @return 废气排口--小时报统计数据
     */
    public TDataGasoutHourStatistics selectTDataGasoutHourStatisticsById(Long id);

    /**
     * 查询废气排口--小时报统计数据列表
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 废气排口--小时报统计数据集合
     */
    public List<TDataGasoutHourStatistics> selectTDataGasoutHourStatisticsList(TDataGasoutHourStatistics tDataGasoutHourStatistics);

    /**
     * 新增废气排口--小时报统计数据
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 结果
     */
    public int insertTDataGasoutHourStatistics(TDataGasoutHourStatistics tDataGasoutHourStatistics);

    /**
     * 修改废气排口--小时报统计数据
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 结果
     */
    public int updateTDataGasoutHourStatistics(TDataGasoutHourStatistics tDataGasoutHourStatistics);

    /**
     * 批量删除废气排口--小时报统计数据
     *
     * @param ids 需要删除的废气排口--小时报统计数据主键集合
     * @return 结果
     */
    public int deleteTDataGasoutHourStatisticsByIds(Long[] ids);

    /**
     * 删除废气排口--小时报统计数据信息
     *
     * @param id 废气排口--小时报统计数据主键
     * @return 结果
     */
    public int deleteTDataGasoutHourStatisticsById(Long id);
}
