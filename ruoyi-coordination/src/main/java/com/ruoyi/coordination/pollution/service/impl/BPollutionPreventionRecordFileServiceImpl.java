package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionRecordFileMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecordFile;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionRecordFileService;

/**
 * 协同平台---污染防治目标--上报记录关联的附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@Service
public class BPollutionPreventionRecordFileServiceImpl implements IBPollutionPreventionRecordFileService 
{
    @Autowired
    private BPollutionPreventionRecordFileMapper bPollutionPreventionRecordFileMapper;

    /**
     * 查询协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param fileId 协同平台---污染防治目标--上报记录关联的附件主键
     * @return 协同平台---污染防治目标--上报记录关联的附件
     */
    @Override
    public BPollutionPreventionRecordFile selectBPollutionPreventionRecordFileByFileId(Long fileId)
    {
        return bPollutionPreventionRecordFileMapper.selectBPollutionPreventionRecordFileByFileId(fileId);
    }

    /**
     * 查询协同平台---污染防治目标--上报记录关联的附件列表
     * 
     * @param bPollutionPreventionRecordFile 协同平台---污染防治目标--上报记录关联的附件
     * @return 协同平台---污染防治目标--上报记录关联的附件
     */
    @Override
    public List<BPollutionPreventionRecordFile> selectBPollutionPreventionRecordFileList(BPollutionPreventionRecordFile bPollutionPreventionRecordFile)
    {
        return bPollutionPreventionRecordFileMapper.selectBPollutionPreventionRecordFileList(bPollutionPreventionRecordFile);
    }

    /**
     * 新增协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param bPollutionPreventionRecordFile 协同平台---污染防治目标--上报记录关联的附件
     * @return 结果
     */
    @Override
    public int insertBPollutionPreventionRecordFile(BPollutionPreventionRecordFile bPollutionPreventionRecordFile)
    {
        return bPollutionPreventionRecordFileMapper.insertBPollutionPreventionRecordFile(bPollutionPreventionRecordFile);
    }

    /**
     * 修改协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param bPollutionPreventionRecordFile 协同平台---污染防治目标--上报记录关联的附件
     * @return 结果
     */
    @Override
    public int updateBPollutionPreventionRecordFile(BPollutionPreventionRecordFile bPollutionPreventionRecordFile)
    {
        return bPollutionPreventionRecordFileMapper.updateBPollutionPreventionRecordFile(bPollutionPreventionRecordFile);
    }

    /**
     * 批量删除协同平台---污染防治目标--上报记录关联的附件
     * 
     * @param fileIds 需要删除的协同平台---污染防治目标--上报记录关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionRecordFileByFileIds(Long[] fileIds)
    {
        return bPollutionPreventionRecordFileMapper.deleteBPollutionPreventionRecordFileByFileIds(fileIds);
    }

    /**
     * 删除协同平台---污染防治目标--上报记录关联的附件信息
     * 
     * @param fileId 协同平台---污染防治目标--上报记录关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionRecordFileByFileId(Long fileId)
    {
        return bPollutionPreventionRecordFileMapper.deleteBPollutionPreventionRecordFileByFileId(fileId);
    }
}
