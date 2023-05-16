package com.ruoyi.coordination.clue.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.coordination.clue.domain.BClueInfoTask;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndFile;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndReceive;

/**
 * 协同平台--污染线索处置----线索主任务Service接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface IBClueInfoTaskService 
{
    /**
     * 查询协同平台--污染线索处置----线索主任务
     * 
     * @param taskId 协同平台--污染线索处置----线索主任务主键
     * @return 协同平台--污染线索处置----线索主任务
     */
    public BClueInfoTask selectBClueInfoTaskByTaskId(Long taskId);

    /**
     * 查询协同平台--污染线索处置----线索主任务列表
     * 
     * @param bClueInfoTask 协同平台--污染线索处置----线索主任务
     * @return 协同平台--污染线索处置----线索主任务集合
     */
    public List<BClueInfoTask> selectBClueInfoTaskList(BClueInfoTask bClueInfoTask);

    /**
     * 新增协同平台--污染线索处置----线索主任务
     * 
     * @param bClueInfoTask 协同平台--污染线索处置----线索主任务
     * @return 结果
     */
    public int insertBClueInfoTask(BClueInfoTask bClueInfoTask);

    /**
     * 修改协同平台--污染线索处置----线索主任务
     * 
     * @param bClueInfoTask 协同平台--污染线索处置----线索主任务
     * @return 结果
     */
    public int updateBClueInfoTask(BCITaskAndFile bClueInfoTask);

    /**
     * 批量删除协同平台--污染线索处置----线索主任务
     * 
     * @param taskIds 需要删除的协同平台--污染线索处置----线索主任务主键集合
     * @return 结果
     */
    public int deleteBClueInfoTaskByTaskIds(Long[] taskIds);

    /**
     * 删除协同平台--污染线索处置----线索主任务信息
     * 
     * @param taskId 协同平台--污染线索处置----线索主任务主键
     * @return 结果
     */
    public int deleteBClueInfoTaskByTaskId(Long taskId);

    List<BCITaskAndReceive> selectBClueInfoTaskToDoList(BCITaskAndReceive bClueInfoTask);

    List<BCITaskAndReceive> selectBClueInfoUrgingTaskList(BClueInfoTask bClueInfoTask);

    List<Map<String, Object>> getSourceAnalysis(BCITaskAndReceive bClueInfoTask);
}
