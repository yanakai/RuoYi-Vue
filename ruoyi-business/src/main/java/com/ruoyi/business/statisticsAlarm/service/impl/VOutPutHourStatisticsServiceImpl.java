package com.ruoyi.business.statisticsAlarm.service.impl;

import com.ruoyi.business.statisticsAlarm.domain.VOutPutHourStatistics;
import com.ruoyi.business.statisticsAlarm.mapper.VOutPutHourStatisticsMapper;
import com.ruoyi.business.statisticsAlarm.service.IVOutPutHourStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排口小时报警统计视图Service业务层处理
 *
 * @author lx
 * @date 2024-07-19
 */
@Service
public class VOutPutHourStatisticsServiceImpl implements IVOutPutHourStatisticsService {
    @Autowired
    private VOutPutHourStatisticsMapper vOutPutHourStatisticsMapper;

    /**
     * 查询排口小时报警统计视图
     *
     * @param entName 排口小时报警统计视图主键
     * @return 排口小时报警统计视图
     */
    @Override
    public VOutPutHourStatistics selectVOutPutHourStatisticsByEntName(String entName) {
        return vOutPutHourStatisticsMapper.selectVOutPutHourStatisticsByEntName(entName);
    }

    /**
     * 查询排口小时报警统计视图列表
     *
     * @param vOutPutHourStatistics 排口小时报警统计视图
     * @return 排口小时报警统计视图
     */
    @Override
    public List<VOutPutHourStatistics> selectVOutPutHourStatisticsList(VOutPutHourStatistics vOutPutHourStatistics) {
        return vOutPutHourStatisticsMapper.selectVOutPutHourStatisticsList(vOutPutHourStatistics);
    }

    /**
     * 新增排口小时报警统计视图
     *
     * @param vOutPutHourStatistics 排口小时报警统计视图
     * @return 结果
     */
    @Override
    public int insertVOutPutHourStatistics(VOutPutHourStatistics vOutPutHourStatistics) {
        return vOutPutHourStatisticsMapper.insertVOutPutHourStatistics(vOutPutHourStatistics);
    }

    /**
     * 修改排口小时报警统计视图
     *
     * @param vOutPutHourStatistics 排口小时报警统计视图
     * @return 结果
     */
    @Override
    public int updateVOutPutHourStatistics(VOutPutHourStatistics vOutPutHourStatistics) {
        return vOutPutHourStatisticsMapper.updateVOutPutHourStatistics(vOutPutHourStatistics);
    }

    /**
     * 批量删除排口小时报警统计视图
     *
     * @param entNames 需要删除的排口小时报警统计视图主键
     * @return 结果
     */
    @Override
    public int deleteVOutPutHourStatisticsByEntNames(String[] entNames) {
        return vOutPutHourStatisticsMapper.deleteVOutPutHourStatisticsByEntNames(entNames);
    }

    /**
     * 删除排口小时报警统计视图信息
     *
     * @param entName 排口小时报警统计视图主键
     * @return 结果
     */
    @Override
    public int deleteVOutPutHourStatisticsByEntName(String entName) {
        return vOutPutHourStatisticsMapper.deleteVOutPutHourStatisticsByEntName(entName);
    }
}
