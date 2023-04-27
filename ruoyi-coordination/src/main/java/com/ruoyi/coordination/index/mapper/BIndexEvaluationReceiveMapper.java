package com.ruoyi.coordination.index.mapper;

import java.util.List;
import com.ruoyi.coordination.index.domain.BIndexEvaluationReceive;

/**
 * 协同平台---指标管理--指标任务接收单位Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface BIndexEvaluationReceiveMapper 
{
    /**
     * 查询协同平台---指标管理--指标任务接收单位
     * 
     * @param receiveId 协同平台---指标管理--指标任务接收单位主键
     * @return 协同平台---指标管理--指标任务接收单位
     */
    public BIndexEvaluationReceive selectBIndexEvaluationReceiveByReceiveId(Long receiveId);

    /**
     * 查询协同平台---指标管理--指标任务接收单位列表
     * 
     * @param bIndexEvaluationReceive 协同平台---指标管理--指标任务接收单位
     * @return 协同平台---指标管理--指标任务接收单位集合
     */
    public List<BIndexEvaluationReceive> selectBIndexEvaluationReceiveList(BIndexEvaluationReceive bIndexEvaluationReceive);

    /**
     * 新增协同平台---指标管理--指标任务接收单位
     * 
     * @param bIndexEvaluationReceive 协同平台---指标管理--指标任务接收单位
     * @return 结果
     */
    public int insertBIndexEvaluationReceive(BIndexEvaluationReceive bIndexEvaluationReceive);

    /**
     * 修改协同平台---指标管理--指标任务接收单位
     * 
     * @param bIndexEvaluationReceive 协同平台---指标管理--指标任务接收单位
     * @return 结果
     */
    public int updateBIndexEvaluationReceive(BIndexEvaluationReceive bIndexEvaluationReceive);

    /**
     * 删除协同平台---指标管理--指标任务接收单位
     * 
     * @param receiveId 协同平台---指标管理--指标任务接收单位主键
     * @return 结果
     */
    public int deleteBIndexEvaluationReceiveByReceiveId(Long receiveId);

    /**
     * 批量删除协同平台---指标管理--指标任务接收单位
     * 
     * @param receiveIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBIndexEvaluationReceiveByReceiveIds(Long[] receiveIds);

    int insertBatchBIndexEvaluationReceive(List<BIndexEvaluationReceive> evaluationReceives);
}
