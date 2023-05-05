package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionTaskFileMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTaskFile;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionTaskFileService;

/**
 * 协同平台---污染防治目标--主任务关联的附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@Service
public class BPollutionPreventionTaskFileServiceImpl implements IBPollutionPreventionTaskFileService 
{
    @Autowired
    private BPollutionPreventionTaskFileMapper bPollutionPreventionTaskFileMapper;

    /**
     * 查询协同平台---污染防治目标--主任务关联的附件
     * 
     * @param fileId 协同平台---污染防治目标--主任务关联的附件主键
     * @return 协同平台---污染防治目标--主任务关联的附件
     */
    @Override
    public BPollutionPreventionTaskFile selectBPollutionPreventionTaskFileByFileId(Long fileId)
    {
        return bPollutionPreventionTaskFileMapper.selectBPollutionPreventionTaskFileByFileId(fileId);
    }

    /**
     * 查询协同平台---污染防治目标--主任务关联的附件列表
     * 
     * @param bPollutionPreventionTaskFile 协同平台---污染防治目标--主任务关联的附件
     * @return 协同平台---污染防治目标--主任务关联的附件
     */
    @Override
    public List<BPollutionPreventionTaskFile> selectBPollutionPreventionTaskFileList(BPollutionPreventionTaskFile bPollutionPreventionTaskFile)
    {
        return bPollutionPreventionTaskFileMapper.selectBPollutionPreventionTaskFileList(bPollutionPreventionTaskFile);
    }

    /**
     * 新增协同平台---污染防治目标--主任务关联的附件
     * 
     * @param bPollutionPreventionTaskFile 协同平台---污染防治目标--主任务关联的附件
     * @return 结果
     */
    @Override
    public int insertBPollutionPreventionTaskFile(BPollutionPreventionTaskFile bPollutionPreventionTaskFile)
    {
        return bPollutionPreventionTaskFileMapper.insertBPollutionPreventionTaskFile(bPollutionPreventionTaskFile);
    }

    /**
     * 修改协同平台---污染防治目标--主任务关联的附件
     * 
     * @param bPollutionPreventionTaskFile 协同平台---污染防治目标--主任务关联的附件
     * @return 结果
     */
    @Override
    public int updateBPollutionPreventionTaskFile(BPollutionPreventionTaskFile bPollutionPreventionTaskFile)
    {
        return bPollutionPreventionTaskFileMapper.updateBPollutionPreventionTaskFile(bPollutionPreventionTaskFile);
    }

    /**
     * 批量删除协同平台---污染防治目标--主任务关联的附件
     * 
     * @param fileIds 需要删除的协同平台---污染防治目标--主任务关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionTaskFileByFileIds(Long[] fileIds)
    {
        return bPollutionPreventionTaskFileMapper.deleteBPollutionPreventionTaskFileByFileIds(fileIds);
    }

    /**
     * 删除协同平台---污染防治目标--主任务关联的附件信息
     * 
     * @param fileId 协同平台---污染防治目标--主任务关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionTaskFileByFileId(Long fileId)
    {
        return bPollutionPreventionTaskFileMapper.deleteBPollutionPreventionTaskFileByFileId(fileId);
    }
}
