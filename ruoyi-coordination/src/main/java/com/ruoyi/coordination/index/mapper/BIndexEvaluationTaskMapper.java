package com.ruoyi.coordination.index.mapper;

import java.util.List;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTask;
import com.ruoyi.coordination.index.domain.dto.EvaTaskAndReceive;

/**
 * 协同平台--指标管理--指标主任务Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface BIndexEvaluationTaskMapper 
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
    public int insertBIndexEvaluationTask(BIndexEvaluationTask bIndexEvaluationTask);

    /**
     * 修改协同平台--指标管理--指标主任务
     * 
     * @param bIndexEvaluationTask 协同平台--指标管理--指标主任务
     * @return 结果
     */
    public int updateBIndexEvaluationTask(BIndexEvaluationTask bIndexEvaluationTask);

    /**
     * 删除协同平台--指标管理--指标主任务
     * 
     * @param taskId 协同平台--指标管理--指标主任务主键
     * @return 结果
     */
    public int deleteBIndexEvaluationTaskByTaskId(Long taskId);

    /**
     * 批量删除协同平台--指标管理--指标主任务
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBIndexEvaluationTaskByTaskIds(Long[] taskIds);

    List<EvaTaskAndReceive> selectBIndexEvaluationTaskListByDeptId(BIndexEvaluationTask bIndexEvaluationTask);
}
