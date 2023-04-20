package com.ruoyi.coordination.annual.service;

import java.util.List;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTask;

/**
 * @BelongsProject: RuoYi-Vue
 * @BelongsPackage: com.ruoyi.coordination.annual.service
 * @Author: yanakai@126.com
 * @CreateTime: 2023-04-20  15:07
 * @Description: 协同平台--年度目标任务--任务主Service接口
 * @Version: 1.0
 */
public interface IBAnnualTargetTaskService {
    /**
     * 查询协同平台--年度目标任务--任务主
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 协同平台--年度目标任务--任务主
     */
    public BAnnualTargetTask selectBAnnualTargetTaskByTaskId(Long taskId);

    /**
     * 查询协同平台--年度目标任务--任务主列表
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 协同平台--年度目标任务--任务主集合
     */
    public List<BAnnualTargetTask> selectBAnnualTargetTaskList(BAnnualTargetTask bAnnualTargetTask);

    /**
     * 新增协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    public int insertBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask);

    /**
     * 修改协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    public int updateBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask);

    /**
     * 批量删除协同平台--年度目标任务--任务主
     *
     * @param taskIds 需要删除的协同平台--年度目标任务--任务主主键集合
     * @return 结果
     */
    public int deleteBAnnualTargetTaskByTaskIds(Long[] taskIds);

    /**
     * 删除协同平台--年度目标任务--任务主信息
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 结果
     */
    public int deleteBAnnualTargetTaskByTaskId(Long taskId);
}
