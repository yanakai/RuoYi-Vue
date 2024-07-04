package com.ruoyi.business.statistics.mapper;

import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;

import java.util.List;

/**
 * 废水排口--小时报统计数据Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TDataWateroutHourStatisticsMapper {
    /**
     * 查询废水排口--小时报统计数据
     *
     * @param id 废水排口--小时报统计数据主键
     * @return 废水排口--小时报统计数据
     */
    TDataWateroutHourStatistics selectTDataWateroutHourStatisticsById(Long id);

    /**
     * 查询废水排口--小时报统计数据列表
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 废水排口--小时报统计数据集合
     */
    List<TDataWateroutHourStatistics> selectTDataWateroutHourStatisticsList(TDataWateroutHourStatistics tDataWateroutHourStatistics);

    /**
     * 新增废水排口--小时报统计数据
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 结果
     */
    int insertTDataWateroutHourStatistics(TDataWateroutHourStatistics tDataWateroutHourStatistics);

    /**
     * 修改废水排口--小时报统计数据
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 结果
     */
    int updateTDataWateroutHourStatistics(TDataWateroutHourStatistics tDataWateroutHourStatistics);

    /**
     * 删除废水排口--小时报统计数据
     *
     * @param id 废水排口--小时报统计数据主键
     * @return 结果
     */
    int deleteTDataWateroutHourStatisticsById(Long id);

    /**
     * 批量删除废水排口--小时报统计数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTDataWateroutHourStatisticsByIds(Long[] ids);
}
