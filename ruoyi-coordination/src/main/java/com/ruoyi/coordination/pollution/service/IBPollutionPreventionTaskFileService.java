package com.ruoyi.coordination.pollution.service;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTaskFile;

/**
 * 协同平台---污染防治目标--主任务关联的附件Service接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface IBPollutionPreventionTaskFileService 
{
    /**
     * 查询协同平台---污染防治目标--主任务关联的附件
     * 
     * @param fileId 协同平台---污染防治目标--主任务关联的附件主键
     * @return 协同平台---污染防治目标--主任务关联的附件
     */
    public BPollutionPreventionTaskFile selectBPollutionPreventionTaskFileByFileId(Long fileId);

    /**
     * 查询协同平台---污染防治目标--主任务关联的附件列表
     * 
     * @param bPollutionPreventionTaskFile 协同平台---污染防治目标--主任务关联的附件
     * @return 协同平台---污染防治目标--主任务关联的附件集合
     */
    public List<BPollutionPreventionTaskFile> selectBPollutionPreventionTaskFileList(BPollutionPreventionTaskFile bPollutionPreventionTaskFile);

    /**
     * 新增协同平台---污染防治目标--主任务关联的附件
     * 
     * @param bPollutionPreventionTaskFile 协同平台---污染防治目标--主任务关联的附件
     * @return 结果
     */
    public int insertBPollutionPreventionTaskFile(BPollutionPreventionTaskFile bPollutionPreventionTaskFile);

    /**
     * 修改协同平台---污染防治目标--主任务关联的附件
     * 
     * @param bPollutionPreventionTaskFile 协同平台---污染防治目标--主任务关联的附件
     * @return 结果
     */
    public int updateBPollutionPreventionTaskFile(BPollutionPreventionTaskFile bPollutionPreventionTaskFile);

    /**
     * 批量删除协同平台---污染防治目标--主任务关联的附件
     * 
     * @param fileIds 需要删除的协同平台---污染防治目标--主任务关联的附件主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionTaskFileByFileIds(Long[] fileIds);

    /**
     * 删除协同平台---污染防治目标--主任务关联的附件信息
     * 
     * @param fileId 协同平台---污染防治目标--主任务关联的附件主键
     * @return 结果
     */
    public int deleteBPollutionPreventionTaskFileByFileId(Long fileId);
}
