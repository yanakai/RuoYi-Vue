package com.ruoyi.coordination.index.service;

import java.util.List;
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecordFile;

/**
 * 协同平台---指标管理--上报记录关联的附件Service接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface IBIndexEvaluationRecordFileService 
{
    /**
     * 查询协同平台---指标管理--上报记录关联的附件
     * 
     * @param fileId 协同平台---指标管理--上报记录关联的附件主键
     * @return 协同平台---指标管理--上报记录关联的附件
     */
    public BIndexEvaluationRecordFile selectBIndexEvaluationRecordFileByFileId(Long fileId);

    /**
     * 查询协同平台---指标管理--上报记录关联的附件列表
     * 
     * @param bIndexEvaluationRecordFile 协同平台---指标管理--上报记录关联的附件
     * @return 协同平台---指标管理--上报记录关联的附件集合
     */
    public List<BIndexEvaluationRecordFile> selectBIndexEvaluationRecordFileList(BIndexEvaluationRecordFile bIndexEvaluationRecordFile);

    /**
     * 新增协同平台---指标管理--上报记录关联的附件
     * 
     * @param bIndexEvaluationRecordFile 协同平台---指标管理--上报记录关联的附件
     * @return 结果
     */
    public int insertBIndexEvaluationRecordFile(BIndexEvaluationRecordFile bIndexEvaluationRecordFile);

    /**
     * 修改协同平台---指标管理--上报记录关联的附件
     * 
     * @param bIndexEvaluationRecordFile 协同平台---指标管理--上报记录关联的附件
     * @return 结果
     */
    public int updateBIndexEvaluationRecordFile(BIndexEvaluationRecordFile bIndexEvaluationRecordFile);

    /**
     * 批量删除协同平台---指标管理--上报记录关联的附件
     * 
     * @param fileIds 需要删除的协同平台---指标管理--上报记录关联的附件主键集合
     * @return 结果
     */
    public int deleteBIndexEvaluationRecordFileByFileIds(Long[] fileIds);

    /**
     * 删除协同平台---指标管理--上报记录关联的附件信息
     * 
     * @param fileId 协同平台---指标管理--上报记录关联的附件主键
     * @return 结果
     */
    public int deleteBIndexEvaluationRecordFileByFileId(Long fileId);
}
