package com.ruoyi.coordination.pollution.service;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;
import com.ruoyi.coordination.pollution.domain.dto.BPPTaskAndFile;
import com.ruoyi.coordination.pollution.domain.dto.BPPTaskAndReceive;

/**
 * 协同平台--污染防治目标--主任务Service接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface IBPollutionPreventionTaskService 
{
    /**
     * 查询协同平台--污染防治目标--主任务
     * 
     * @param taskId 协同平台--污染防治目标--主任务主键
     * @return 协同平台--污染防治目标--主任务
     */
    public BPollutionPreventionTask selectBPollutionPreventionTaskByTaskId(Long taskId);

    /**
     * 查询协同平台--污染防治目标--主任务列表
     * 
     * @param bPollutionPreventionTask 协同平台--污染防治目标--主任务
     * @return 协同平台--污染防治目标--主任务集合
     */
    public List<BPollutionPreventionTask> selectBPollutionPreventionTaskList(BPollutionPreventionTask bPollutionPreventionTask);

    /**
     * 新增协同平台--污染防治目标--主任务
     * 
     * @param bppTaskAndFile 协同平台--污染防治目标--主任务
     * @return 结果
     */
    public int insertBPollutionPreventionTask(BPPTaskAndFile bppTaskAndFile);

    /**
     * 修改协同平台--污染防治目标--主任务
     * 
     * @param bPollutionPreventionTask 协同平台--污染防治目标--主任务
     * @return 结果
     */
    public int updateBPollutionPreventionTask(BPollutionPreventionTask bPollutionPreventionTask);

    /**
     * 批量删除协同平台--污染防治目标--主任务
     * 
     * @param taskIds 需要删除的协同平台--污染防治目标--主任务主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionTaskByTaskIds(Long[] taskIds);

    /**
     * 删除协同平台--污染防治目标--主任务信息
     * 
     * @param taskId 协同平台--污染防治目标--主任务主键
     * @return 结果
     */
    public int deleteBPollutionPreventionTaskByTaskId(Long taskId);

    List<BPPTaskAndReceive> selectBPollutionPreventionTaskListByDeptId(BPPTaskAndReceive bPollutionPreventionTask);

    List<BPPTaskAndReceive> selectBPollutionPreventionExTaskListByDeptId(BPPTaskAndReceive bPollutionPreventionTask);
}
