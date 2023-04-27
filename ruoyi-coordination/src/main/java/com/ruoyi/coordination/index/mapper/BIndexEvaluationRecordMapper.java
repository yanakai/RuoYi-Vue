package com.ruoyi.coordination.index.mapper;

import java.util.List;
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecord;
import com.ruoyi.coordination.index.domain.dto.EvaRecordAndFile;

/**
 * 协同平台---指标管理--指标任务接收单位上报记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface BIndexEvaluationRecordMapper 
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
    public int insertBIndexEvaluationRecord(BIndexEvaluationRecord bIndexEvaluationRecord);

    /**
     * 修改协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param bIndexEvaluationRecord 协同平台---指标管理--指标任务接收单位上报记录
     * @return 结果
     */
    public int updateBIndexEvaluationRecord(BIndexEvaluationRecord bIndexEvaluationRecord);

    /**
     * 删除协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param recordId 协同平台---指标管理--指标任务接收单位上报记录主键
     * @return 结果
     */
    public int deleteBIndexEvaluationRecordByRecordId(Long recordId);

    /**
     * 批量删除协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBIndexEvaluationRecordByRecordIds(Long[] recordIds);

    List<EvaRecordAndFile> selectBIndexEvaluationRecords(BIndexEvaluationRecord bIndexEvaluationRecord);
}
