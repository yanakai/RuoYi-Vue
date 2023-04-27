package com.ruoyi.coordination.index.service;

import java.util.List;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTaskFile;

/**
 * 协同平台---指标管理--主任务关联的附件Service接口
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public interface IBIndexEvaluationTaskFileService 
{
    /**
     * 查询协同平台---指标管理--主任务关联的附件
     * 
     * @param fileId 协同平台---指标管理--主任务关联的附件主键
     * @return 协同平台---指标管理--主任务关联的附件
     */
    public BIndexEvaluationTaskFile selectBIndexEvaluationTaskFileByFileId(Long fileId);

    /**
     * 查询协同平台---指标管理--主任务关联的附件列表
     * 
     * @param bIndexEvaluationTaskFile 协同平台---指标管理--主任务关联的附件
     * @return 协同平台---指标管理--主任务关联的附件集合
     */
    public List<BIndexEvaluationTaskFile> selectBIndexEvaluationTaskFileList(BIndexEvaluationTaskFile bIndexEvaluationTaskFile);

    /**
     * 新增协同平台---指标管理--主任务关联的附件
     * 
     * @param bIndexEvaluationTaskFile 协同平台---指标管理--主任务关联的附件
     * @return 结果
     */
    public int insertBIndexEvaluationTaskFile(BIndexEvaluationTaskFile bIndexEvaluationTaskFile);

    /**
     * 修改协同平台---指标管理--主任务关联的附件
     * 
     * @param bIndexEvaluationTaskFile 协同平台---指标管理--主任务关联的附件
     * @return 结果
     */
    public int updateBIndexEvaluationTaskFile(BIndexEvaluationTaskFile bIndexEvaluationTaskFile);

    /**
     * 批量删除协同平台---指标管理--主任务关联的附件
     * 
     * @param fileIds 需要删除的协同平台---指标管理--主任务关联的附件主键集合
     * @return 结果
     */
    public int deleteBIndexEvaluationTaskFileByFileIds(Long[] fileIds);

    /**
     * 删除协同平台---指标管理--主任务关联的附件信息
     * 
     * @param fileId 协同平台---指标管理--主任务关联的附件主键
     * @return 结果
     */
    public int deleteBIndexEvaluationTaskFileByFileId(Long fileId);
}
