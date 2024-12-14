package com.ruoyi.business.statistics.service.impl;

import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.mapper.TDataGasoutHourStatisticsMapper;
import com.ruoyi.business.statistics.service.ITDataGasoutHourStatisticsService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 废气排口--小时报统计数据Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TDataGasoutHourStatisticsServiceImpl implements ITDataGasoutHourStatisticsService {
    @Autowired
    private TDataGasoutHourStatisticsMapper tDataGasoutHourStatisticsMapper;

    /**
     * 查询废气排口--小时报统计数据
     *
     * @param id 废气排口--小时报统计数据主键
     * @return 废气排口--小时报统计数据
     */
    @Override
    public TDataGasoutHourStatistics selectTDataGasoutHourStatisticsById(Long id) {
        return tDataGasoutHourStatisticsMapper.selectTDataGasoutHourStatisticsById(id);
    }

    /**
     * 查询废气排口--小时报统计数据列表
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 废气排口--小时报统计数据
     */
    @Override
    public List<TDataGasoutHourStatistics> selectTDataGasoutHourStatisticsList(TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        return tDataGasoutHourStatisticsMapper.selectTDataGasoutHourStatisticsList(tDataGasoutHourStatistics);
    }

    /**
     * 新增废气排口--小时报统计数据
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 结果
     */
    @Override
    public int insertTDataGasoutHourStatistics(TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        return tDataGasoutHourStatisticsMapper.insertTDataGasoutHourStatistics(tDataGasoutHourStatistics);
    }

    /**
     * 修改废气排口--小时报统计数据
     *
     * @param tDataGasoutHourStatistics 废气排口--小时报统计数据
     * @return 结果
     */
    @Override
    public int updateTDataGasoutHourStatistics(TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        tDataGasoutHourStatistics.setUpdateTime(DateUtils.getNowDate());
        return tDataGasoutHourStatisticsMapper.updateTDataGasoutHourStatistics(tDataGasoutHourStatistics);
    }

    /**
     * 批量删除废气排口--小时报统计数据
     *
     * @param ids 需要删除的废气排口--小时报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataGasoutHourStatisticsByIds(Long[] ids) {
        return tDataGasoutHourStatisticsMapper.deleteTDataGasoutHourStatisticsByIds(ids);
    }

    /**
     * 删除废气排口--小时报统计数据信息
     *
     * @param id 废气排口--小时报统计数据主键
     * @return 结果
     */
    @Override
    public int deleteTDataGasoutHourStatisticsById(Long id) {
        return tDataGasoutHourStatisticsMapper.deleteTDataGasoutHourStatisticsById(id);
    }

    @Override
    public int selectTDataGasoutHourStatisticsCount(TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        return tDataGasoutHourStatisticsMapper.selectTDataGasoutHourStatisticsCount(tDataGasoutHourStatistics);
    }
}
