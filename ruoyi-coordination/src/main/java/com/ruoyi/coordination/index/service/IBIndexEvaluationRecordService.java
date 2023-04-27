package com.ruoyi.coordination.index.service;

import java.util.List;
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecord;
import com.ruoyi.coordination.index.domain.dto.EvaRecordAndFile;

/**
 * 协同平台---指标管理--指标任务接收单位上报记录Service接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface IBIndexEvaluationRecordService 
{
    /**
     * 查询协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param recordId 协同平台---指标管理--指标任务接收单位上报记录主键
     * @return 协同平台---指标管理--指标任务接收单位上报记录
     */
    public BIndexEvaluationRecord selectBIndexEvaluationRecordByRecordId(Long recordId);

    /**
     * 查询协同平台---指标管理--指标任务接收单位上报记录列表
     * 
     * @param bIndexEvaluationRecord 协同平台---指标管理--指标任务接收单位上报记录
     * @return 协同平台---指标管理--指标任务接收单位上报记录集合
     */
    public List<BIndexEvaluationRecord> selectBIndexEvaluationRecordList(BIndexEvaluationRecord bIndexEvaluationRecord);

    /**
     * 新增协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param bIndexEvaluationRecord 协同平台---指标管理--指标任务接收单位上报记录
     * @return 结果
     */
    public int insertBIndexEvaluationRecord(EvaRecordAndFile bIndexEvaluationRecord);

    /**
     * 修改协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param bIndexEvaluationRecord 协同平台---指标管理--指标任务接收单位上报记录
     * @return 结果
     */
    public int updateBIndexEvaluationRecord(BIndexEvaluationRecord bIndexEvaluationRecord);

    /**
     * 批量删除协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param recordIds 需要删除的协同平台---指标管理--指标任务接收单位上报记录主键集合
     * @return 结果
     */
    public int deleteBIndexEvaluationRecordByRecordIds(Long[] recordIds);

    /**
     * 删除协同平台---指标管理--指标任务接收单位上报记录信息
     * 
     * @param recordId 协同平台---指标管理--指标任务接收单位上报记录主键
     * @return 结果
     */
    public int deleteBIndexEvaluationRecordByRecordId(Long recordId);

    List<EvaRecordAndFile> selectBIndexEvaluationRecords(BIndexEvaluationRecord bIndexEvaluationRecord);
}
