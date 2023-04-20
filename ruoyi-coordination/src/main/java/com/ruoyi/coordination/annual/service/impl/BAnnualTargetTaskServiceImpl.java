package com.ruoyi.coordination.annual.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetTaskMapper;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTask;
import com.ruoyi.coordination.annual.service.IBAnnualTargetTaskService;

/**
 * @description: 协同平台--年度目标任务--任务主Service业务层处理
 * @author: yanakai@126.com
 * @date: 2023/4/20 15:11
 * @param: null
 * @return:
 **/
@Service
public class BAnnualTargetTaskServiceImpl implements IBAnnualTargetTaskService
{
    @Autowired
    private BAnnualTargetTaskMapper bAnnualTargetTaskMapper;

    /**
     * 查询协同平台--年度目标任务--任务主
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 协同平台--年度目标任务--任务主
     */
    @Override
    public BAnnualTargetTask selectBAnnualTargetTaskByTaskId(Long taskId)
    {
        return bAnnualTargetTaskMapper.selectBAnnualTargetTaskByTaskId(taskId);
    }

    /**
     * 查询协同平台--年度目标任务--任务主列表
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 协同平台--年度目标任务--任务主
     */
    @Override
    public List<BAnnualTargetTask> selectBAnnualTargetTaskList(BAnnualTargetTask bAnnualTargetTask)
    {
        return bAnnualTargetTaskMapper.selectBAnnualTargetTaskList(bAnnualTargetTask);
    }

    /**
     * 新增协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    @Override
    public int insertBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask)
    {
        bAnnualTargetTask.setCreateTime(DateUtils.getNowDate());
        return bAnnualTargetTaskMapper.insertBAnnualTargetTask(bAnnualTargetTask);
    }

    /**
     * 修改协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    @Override
    public int updateBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask)
    {
        return bAnnualTargetTaskMapper.updateBAnnualTargetTask(bAnnualTargetTask);
    }

    /**
     * 批量删除协同平台--年度目标任务--任务主
     *
     * @param taskIds 需要删除的协同平台--年度目标任务--任务主主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetTaskByTaskIds(Long[] taskIds)
    {
        return bAnnualTargetTaskMapper.deleteBAnnualTargetTaskByTaskIds(taskIds);
    }

    /**
     * 删除协同平台--年度目标任务--任务主信息
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetTaskByTaskId(Long taskId)
    {
        return bAnnualTargetTaskMapper.deleteBAnnualTargetTaskByTaskId(taskId);
    }
}
