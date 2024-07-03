package com.ruoyi.business.statistics.service;

import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;

import java.util.List;

/**
 * 废水排口--小时报统计数据Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface ITDataWateroutHourStatisticsService {
    /**
     * 查询废水排口--小时报统计数据
     *
     * @param id 废水排口--小时报统计数据主键
     * @return 废水排口--小时报统计数据
     */
    public TDataWateroutHourStatistics selectTDataWateroutHourStatisticsById(Long id);

    /**
     * 查询废水排口--小时报统计数据列表
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 废水排口--小时报统计数据集合
     */
    public List<TDataWateroutHourStatistics> selectTDataWateroutHourStatisticsList(TDataWateroutHourStatistics tDataWateroutHourStatistics);

    /**
     * 新增废水排口--小时报统计数据
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 结果
     */
    public int insertTDataWateroutHourStatistics(TDataWateroutHourStatistics tDataWateroutHourStatistics);

    /**
     * 修改废水排口--小时报统计数据
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 结果
     */
    public int updateTDataWateroutHourStatistics(TDataWateroutHourStatistics tDataWateroutHourStatistics);

    /**
     * 批量删除废水排口--小时报统计数据
     *
     * @param ids 需要删除的废水排口--小时报统计数据主键集合
     * @return 结果
     */
    public int deleteTDataWateroutHourStatisticsByIds(Long[] ids);

    /**
     * 删除废水排口--小时报统计数据信息
     *
     * @param id 废水排口--小时报统计数据主键
     * @return 结果
     */
    public int deleteTDataWateroutHourStatisticsById(Long id);
}
