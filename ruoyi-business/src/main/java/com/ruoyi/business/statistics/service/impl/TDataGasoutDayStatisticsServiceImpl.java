package com.ruoyi.business.statistics.service.impl;

import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.mapper.TDataGasoutDayStatisticsMapper;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 废气排口--日报统计数据Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TDataGasoutDayStatisticsServiceImpl implements ITDataGasoutDayStatisticsService {
    @Autowired
    private TDataGasoutDayStatisticsMapper tDataGasoutDayStatisticsMapper;

    /**
     * 查询废气排口--日报统计数据
     *
     * @param id 废气排口--日报统计数据主键
     * @return 废气排口--日报统计数据
     */
    @Override
    public TDataGasoutDayStatistics selectTDataGasoutDayStatisticsById(Long id) {
        return tDataGasoutDayStatisticsMapper.selectTDataGasoutDayStatisticsById(id);
    }

    /**
     * 查询废气排口--日报统计数据列表
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 废气排口--日报统计数据
     */
    @Override
    public List<TDataGasoutDayStatistics> selectTDataGasoutDayStatisticsList(TDataGasoutDayStatistics tDataGasoutDayStatistics) {
        return tDataGasoutDayStatisticsMapper.selectTDataGasoutDayStatisticsList(tDataGasoutDayStatistics);
    }

    /**
     * 新增废气排口--日报统计数据
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 结果
     */
    @Override
    public int insertTDataGasoutDayStatistics(TDataGasoutDayStatistics tDataGasoutDayStatistics) {
        return tDataGasoutDayStatisticsMapper.insertTDataGasoutDayStatistics(tDataGasoutDayStatistics);
    }

    /**
     * 修改废气排口--日报统计数据
     *
     * @param tDataGasoutDayStatistics 废气排口--日报统计数据
     * @return 结果
     */
    @Override
    public int updateTDataGasoutDayStatistics(TDataGasoutDayStatistics tDataGasoutDayStatistics) {
        tDataGasoutDayStatistics.setUpdateTime(DateUtils.getNowDate());
        return tDataGasoutDayStatisticsMapper.updateTDataGasoutDayStatistics(tDataGasoutDayStatistics);
    }

    /**
     * 批量删除废气排口--日报统计数据
     *
     * @param ids 需要删除的废气排口--日报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataGasoutDayStatisticsByIds(Long[] ids) {
        return tDataGasoutDayStatisticsMapper.deleteTDataGasoutDayStatisticsByIds(ids);
    }

    /**
     * 删除废气排口--日报统计数据信息
     *
     * @param id 废气排口--日报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataGasoutDayStatisticsById(Long id) {
        return tDataGasoutDayStatisticsMapper.deleteTDataGasoutDayStatisticsById(id);
    }
}
