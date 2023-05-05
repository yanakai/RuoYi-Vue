package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionFileMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionFile;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionFileService;

/**
 * 协同平台---污染防治目标--文件解读Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@Service
public class BPollutionPreventionFileServiceImpl implements IBPollutionPreventionFileService 
{
    @Autowired
    private BPollutionPreventionFileMapper bPollutionPreventionFileMapper;

    /**
     * 查询协同平台---污染防治目标--文件解读
     * 
     * @param fileId 协同平台---污染防治目标--文件解读主键
     * @return 协同平台---污染防治目标--文件解读
     */
    @Override
    public BPollutionPreventionFile selectBPollutionPreventionFileByFileId(Long fileId)
    {
        return bPollutionPreventionFileMapper.selectBPollutionPreventionFileByFileId(fileId);
    }

    /**
     * 查询协同平台---污染防治目标--文件解读列表
     * 
     * @param bPollutionPreventionFile 协同平台---污染防治目标--文件解读
     * @return 协同平台---污染防治目标--文件解读
     */
    @Override
    public List<BPollutionPreventionFile> selectBPollutionPreventionFileList(BPollutionPreventionFile bPollutionPreventionFile)
    {
        return bPollutionPreventionFileMapper.selectBPollutionPreventionFileList(bPollutionPreventionFile);
    }

    /**
     * 新增协同平台---污染防治目标--文件解读
     * 
     * @param bPollutionPreventionFile 协同平台---污染防治目标--文件解读
     * @return 结果
     */
    @Override
    public int insertBPollutionPreventionFile(BPollutionPreventionFile bPollutionPreventionFile)
    {
        String kinds = bPollutionPreventionFile.getFileKind();
        bPollutionPreventionFile.setFileKind(kinds.substring(kinds.lastIndexOf(".")));
        bPollutionPreventionFile.setCreateUserName(SecurityUtils.getUsername());
        bPollutionPreventionFile.setCreateTime(DateUtils.getNowDate());
        return bPollutionPreventionFileMapper.insertBPollutionPreventionFile(bPollutionPreventionFile);
    }

    /**
     * 修改协同平台---污染防治目标--文件解读
     * 
     * @param bPollutionPreventionFile 协同平台---污染防治目标--文件解读
     * @return 结果
     */
    @Override
    public int updateBPollutionPreventionFile(BPollutionPreventionFile bPollutionPreventionFile)
    {
        String kinds = bPollutionPreventionFile.getFileKind();
        bPollutionPreventionFile.setFileKind(kinds.substring(kinds.lastIndexOf(".")));
        return bPollutionPreventionFileMapper.updateBPollutionPreventionFile(bPollutionPreventionFile);
    }

    /**
     * 批量删除协同平台---污染防治目标--文件解读
     * 
     * @param fileIds 需要删除的协同平台---污染防治目标--文件解读主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionFileByFileIds(Long[] fileIds)
    {
        return bPollutionPreventionFileMapper.deleteBPollutionPreventionFileByFileIds(fileIds);
    }

    /**
     * 删除协同平台---污染防治目标--文件解读信息
     * 
     * @param fileId 协同平台---污染防治目标--文件解读主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionFileByFileId(Long fileId)
    {
        return bPollutionPreventionFileMapper.deleteBPollutionPreventionFileByFileId(fileId);
    }
}
