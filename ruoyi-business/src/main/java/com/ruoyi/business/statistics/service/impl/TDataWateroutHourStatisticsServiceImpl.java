package com.ruoyi.business.statistics.service.impl;

import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;
import com.ruoyi.business.statistics.mapper.TDataWateroutHourStatisticsMapper;
import com.ruoyi.business.statistics.service.ITDataWateroutHourStatisticsService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 废水排口--小时报统计数据Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TDataWateroutHourStatisticsServiceImpl implements ITDataWateroutHourStatisticsService {
    @Autowired
    private TDataWateroutHourStatisticsMapper tDataWateroutHourStatisticsMapper;

    /**
     * 查询废水排口--小时报统计数据
     *
     * @param id 废水排口--小时报统计数据主键
     * @return 废水排口--小时报统计数据
     */
    @Override
    public TDataWateroutHourStatistics selectTDataWateroutHourStatisticsById(Long id) {
        return tDataWateroutHourStatisticsMapper.selectTDataWateroutHourStatisticsById(id);
    }

    /**
     * 查询废水排口--小时报统计数据列表
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 废水排口--小时报统计数据
     */
    @Override
    public List<TDataWateroutHourStatistics> selectTDataWateroutHourStatisticsList(TDataWateroutHourStatistics tDataWateroutHourStatistics) {
        return tDataWateroutHourStatisticsMapper.selectTDataWateroutHourStatisticsList(tDataWateroutHourStatistics);
    }

    /**
     * 新增废水排口--小时报统计数据
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 结果
     */
    @Override
    public int insertTDataWateroutHourStatistics(TDataWateroutHourStatistics tDataWateroutHourStatistics) {
        return tDataWateroutHourStatisticsMapper.insertTDataWateroutHourStatistics(tDataWateroutHourStatistics);
    }

    /**
     * 修改废水排口--小时报统计数据
     *
     * @param tDataWateroutHourStatistics 废水排口--小时报统计数据
     * @return 结果
     */
    @Override
    public int updateTDataWateroutHourStatistics(TDataWateroutHourStatistics tDataWateroutHourStatistics) {
        tDataWateroutHourStatistics.setUpdateTime(DateUtils.getNowDate());
        return tDataWateroutHourStatisticsMapper.updateTDataWateroutHourStatistics(tDataWateroutHourStatistics);
    }

    /**
     * 批量删除废水排口--小时报统计数据
     *
     * @param ids 需要删除的废水排口--小时报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataWateroutHourStatisticsByIds(Long[] ids) {
        return tDataWateroutHourStatisticsMapper.deleteTDataWateroutHourStatisticsByIds(ids);
    }

    /**
     * 删除废水排口--小时报统计数据信息
     *
     * @param id 废水排口--小时报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataWateroutHourStatisticsById(Long id) {
        return tDataWateroutHourStatisticsMapper.deleteTDataWateroutHourStatisticsById(id);
    }
}
