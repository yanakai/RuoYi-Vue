package com.ruoyi.coordination.pollution.service;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecordFile;

/**
 * 协同平台---污染防治目标--上报记录关联的附件Service接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface IBPollutionPreventionRecordFileService 
{
    /**
     * 查询协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param fileId 协同平台---污染防治目标--上报记录关联的附件主键
     * @return 协同平台---污染防治目标--上报记录关联的附件
     */
    public BPollutionPreventionRecordFile selectBPollutionPreventionRecordFileByFileId(Long fileId);

    /**
     * 查询协同平台---污染防治目标--上报记录关联的附件列表
     * 
     * @param bPollutionPreventionRecordFile 协同平台---污染防治目标--上报记录关联的附件
     * @return 协同平台---污染防治目标--上报记录关联的附件集合
     */
    public List<BPollutionPreventionRecordFile> selectBPollutionPreventionRecordFileList(BPollutionPreventionRecordFile bPollutionPreventionRecordFile);

    /**
     * 新增协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param bPollutionPreventionRecordFile 协同平台---污染防治目标--上报记录关联的附件
     * @return 结果
     */
    public int insertBPollutionPreventionRecordFile(BPollutionPreventionRecordFile bPollutionPreventionRecordFile);

    /**
     * 修改协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param bPollutionPreventionRecordFile 协同平台---污染防治目标--上报记录关联的附件
     * @return 结果
     */
    public int updateBPollutionPreventionRecordFile(BPollutionPreventionRecordFile bPollutionPreventionRecordFile);

    /**
     * 批量删除协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param fileIds 需要删除的协同平台---污染防治目标--上报记录关联的附件主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionRecordFileByFileIds(Long[] fileIds);

    /**
     * 删除协同平台---污染防治目标--上报记录关联的附件信息
     * 
     * @param fileId 协同平台---污染防治目标--上报记录关联的附件主键
     * @return 结果
     */
    public int deleteBPollutionPreventionRecordFileByFileId(Long fileId);
}
