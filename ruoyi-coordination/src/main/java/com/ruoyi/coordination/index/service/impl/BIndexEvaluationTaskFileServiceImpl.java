package com.ruoyi.coordination.index.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationTaskFileMapper;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTaskFile;
import com.ruoyi.coordination.index.service.IBIndexEvaluationTaskFileService;

/**
 * 协同平台---指标管理--主任务关联的附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@Service
public class BIndexEvaluationTaskFileServiceImpl implements IBIndexEvaluationTaskFileService 
{
    @Autowired
    private BIndexEvaluationTaskFileMapper bIndexEvaluationTaskFileMapper;

    /**
     * 查询协同平台---指标管理--主任务关联的附件
     * 
     * @param fileId 协同平台---指标管理--主任务关联的附件主键
     * @return 协同平台---指标管理--主任务关联的附件
     */
    @Override
    public BIndexEvaluationTaskFile selectBIndexEvaluationTaskFileByFileId(Long fileId)
    {
        return bIndexEvaluationTaskFileMapper.selectBIndexEvaluationTaskFileByFileId(fileId);
    }

    /**
     * 查询协同平台---指标管理--主任务关联的附件列表
     * 
     * @param bIndexEvaluationTaskFile 协同平台---指标管理--主任务关联的附件
     * @return 协同平台---指标管理--主任务关联的附件
     */
    @Override
    public List<BIndexEvaluationTaskFile> selectBIndexEvaluationTaskFileList(BIndexEvaluationTaskFile bIndexEvaluationTaskFile)
    {
        return bIndexEvaluationTaskFileMapper.selectBIndexEvaluationTaskFileList(bIndexEvaluationTaskFile);
    }

    /**
     * 新增协同平台---指标管理--主任务关联的附件
     * 
     * @param bIndexEvaluationTaskFile 协同平台---指标管理--主任务关联的附件
     * @return 结果
     */
    @Override
    public int insertBIndexEvaluationTaskFile(BIndexEvaluationTaskFile bIndexEvaluationTaskFile)
    {
        return bIndexEvaluationTaskFileMapper.insertBIndexEvaluationTaskFile(bIndexEvaluationTaskFile);
    }

    /**
     * 修改协同平台---指标管理--主任务关联的附件
     * 
     * @param bIndexEvaluationTaskFile 协同平台---指标管理--主任务关联的附件
     * @return 结果
     */
    @Override
    public int updateBIndexEvaluationTaskFile(BIndexEvaluationTaskFile bIndexEvaluationTaskFile)
    {
        return bIndexEvaluationTaskFileMapper.updateBIndexEvaluationTaskFile(bIndexEvaluationTaskFile);
    }

    /**
     * 批量删除协同平台---指标管理--主任务关联的附件
     * 
     * @param fileIds 需要删除的协同平台---指标管理--主任务关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationTaskFileByFileIds(Long[] fileIds)
    {
        return bIndexEvaluationTaskFileMapper.deleteBIndexEvaluationTaskFileByFileIds(fileIds);
    }

    /**
     * 删除协同平台---指标管理--主任务关联的附件信息
     * 
     * @param fileId 协同平台---指标管理--主任务关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationTaskFileByFileId(Long fileId)
    {
        return bIndexEvaluationTaskFileMapper.deleteBIndexEvaluationTaskFileByFileId(fileId);
    }
}
