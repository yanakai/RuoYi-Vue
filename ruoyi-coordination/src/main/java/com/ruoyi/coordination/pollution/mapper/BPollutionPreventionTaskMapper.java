package com.ruoyi.coordination.pollution.mapper;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;
import org.apache.ibatis.annotations.Param;

/**
 * 协同平台--污染防治目标--主任务Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface BPollutionPreventionTaskMapper 
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
    public List<BPollutionPreventionTask> selectBPollutionPreventionTaskList(@Param("task") BPollutionPreventionTask bPollutionPreventionTask,@Param("deptIds") List<Long> childDeptIds);

    /**
     * 新增协同平台--污染防治目标--主任务
     * 
     * @param bPollutionPreventionTask 协同平台--污染防治目标--主任务
     * @return 结果
     */
    public int insertBPollutionPreventionTask(BPollutionPreventionTask bPollutionPreventionTask);

    /**
     * 修改协同平台--污染防治目标--主任务
     * 
     * @param bPollutionPreventionTask 协同平台--污染防治目标--主任务
     * @return 结果
     */
    public int updateBPollutionPreventionTask(BPollutionPreventionTask bPollutionPreventionTask);

    /**
     * 删除协同平台--污染防治目标--主任务
     * 
     * @param taskId 协同平台--污染防治目标--主任务主键
     * @return 结果
     */
    public int deleteBPollutionPreventionTaskByTaskId(Long taskId);

    /**
     * 批量删除协同平台--污染防治目标--主任务
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionTaskByTaskIds(Long[] taskIds);

    List<BPollutionPreventionTask> selectBPollutionPreventionTaskListByDeptId(@Param("task") BPollutionPreventionTask bPollutionPreventionTask,@Param("deptId") Long deptId);
}
