package com.ruoyi.business.statistics.service.impl;

import com.ruoyi.business.statistics.domain.TDataWateroutDayStatistics;
import com.ruoyi.business.statistics.mapper.TDataWateroutDayStatisticsMapper;
import com.ruoyi.business.statistics.service.ITDataWateroutDayStatisticsService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 废水排口--日报统计数据Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TDataWateroutDayStatisticsServiceImpl implements ITDataWateroutDayStatisticsService {
    @Autowired
    private TDataWateroutDayStatisticsMapper tDataWateroutDayStatisticsMapper;

    /**
     * 查询废水排口--日报统计数据
     *
     * @param id 废水排口--日报统计数据主键
     * @return 废水排口--日报统计数据
     */
    @Override
    public TDataWateroutDayStatistics selectTDataWateroutDayStatisticsById(Long id) {
        return tDataWateroutDayStatisticsMapper.selectTDataWateroutDayStatisticsById(id);
    }

    /**
     * 查询废水排口--日报统计数据列表
     *
     * @param tDataWateroutDayStatistics 废水排口--日报统计数据
     * @return 废水排口--日报统计数据
     */
    @Override
    public List<TDataWateroutDayStatistics> selectTDataWateroutDayStatisticsList(TDataWateroutDayStatistics tDataWateroutDayStatistics) {
        return tDataWateroutDayStatisticsMapper.selectTDataWateroutDayStatisticsList(tDataWateroutDayStatistics);
    }

    /**
     * 新增废水排口--日报统计数据
     *
     * @param tDataWateroutDayStatistics 废水排口--日报统计数据
     * @return 结果
     */
    @Override
    public int insertTDataWateroutDayStatistics(TDataWateroutDayStatistics tDataWateroutDayStatistics) {
        return tDataWateroutDayStatisticsMapper.insertTDataWateroutDayStatistics(tDataWateroutDayStatistics);
    }

    /**
     * 修改废水排口--日报统计数据
     *
     * @param tDataWateroutDayStatistics 废水排口--日报统计数据
     * @return 结果
     */
    @Override
    public int updateTDataWateroutDayStatistics(TDataWateroutDayStatistics tDataWateroutDayStatistics) {
        tDataWateroutDayStatistics.setUpdateTime(DateUtils.getNowDate());
        return tDataWateroutDayStatisticsMapper.updateTDataWateroutDayStatistics(tDataWateroutDayStatistics);
    }

    /**
     * 批量删除废水排口--日报统计数据
     *
     * @param ids 需要删除的废水排口--日报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataWateroutDayStatisticsByIds(Long[] ids) {
        return tDataWateroutDayStatisticsMapper.deleteTDataWateroutDayStatisticsByIds(ids);
    }

    /**
     * 删除废水排口--日报统计数据信息
     *
     * @param id 废水排口--日报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataWateroutDayStatisticsById(Long id) {
        return tDataWateroutDayStatisticsMapper.deleteTDataWateroutDayStatisticsById(id);
    }
}
