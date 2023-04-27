package com.ruoyi.coordination.index.service;

import java.util.List;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTask;
import com.ruoyi.coordination.index.domain.dto.EvaTaskAndFile;
import com.ruoyi.coordination.index.domain.dto.EvaTaskAndReceive;

/**
 * 协同平台--指标管理--指标主任务Service接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface IBIndexEvaluationTaskService 
{
    /**
     * 查询协同平台--指标管理--指标主任务
     * 
     * @param taskId 协同平台--指标管理--指标主任务主键
     * @return 协同平台--指标管理--指标主任务
     */
    public BIndexEvaluationTask selectBIndexEvaluationTaskByTaskId(Long taskId);

    /**
     * 查询协同平台--指标管理--指标主任务列表
     * 
     * @param bIndexEvaluationTask 协同平台--指标管理--指标主任务
     * @return 协同平台--指标管理--指标主任务集合
     */
    public List<BIndexEvaluationTask> selectBIndexEvaluationTaskList(BIndexEvaluationTask bIndexEvaluationTask);

    /**
     * 新增协同平台--指标管理--指标主任务
     * 
     * @param bIndexEvaluationTask 协同平台--指标管理--指标主任务
     * @return 结果
     */
    public int insertBIndexEvaluationTask(EvaTaskAndFile bIndexEvaluationTask);

    /**
     * 修改协同平台--指标管理--指标主任务
     * 
     * @param bIndexEvaluationTask 协同平台--指标管理--指标主任务
     * @return 结果
     */
    public int updateBIndexEvaluationTask(BIndexEvaluationTask bIndexEvaluationTask);

    /**
     * 批量删除协同平台--指标管理--指标主任务
     * 
     * @param taskIds 需要删除的协同平台--指标管理--指标主任务主键集合
     * @return 结果
     */
    public int deleteBIndexEvaluationTaskByTaskIds(Long[] taskIds);

    /**
     * 删除协同平台--指标管理--指标主任务信息
     * 
     * @param taskId 协同平台--指标管理--指标主任务主键
     * @return 结果
     */
    public int deleteBIndexEvaluationTaskByTaskId(Long taskId);

    List<EvaTaskAndReceive> selectBIndexEvaluationTaskListByDeptId(EvaTaskAndReceive bIndexEvaluationTask);
}
