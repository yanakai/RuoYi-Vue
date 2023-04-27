package com.ruoyi.coordination.index.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationRecordFileMapper;
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecordFile;
import com.ruoyi.coordination.index.service.IBIndexEvaluationRecordFileService;

/**
 * 协同平台---指标管理--上报记录关联的附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@Service
public class BIndexEvaluationRecordFileServiceImpl implements IBIndexEvaluationRecordFileService 
{
    @Autowired
    private BIndexEvaluationRecordFileMapper bIndexEvaluationRecordFileMapper;

    /**
     * 查询协同平台---指标管理--上报记录关联的附件
     * 
     * @param fileId 协同平台---指标管理--上报记录关联的附件主键
     * @return 协同平台---指标管理--上报记录关联的附件
     */
    @Override
    public BIndexEvaluationRecordFile selectBIndexEvaluationRecordFileByFileId(Long fileId)
    {
        return bIndexEvaluationRecordFileMapper.selectBIndexEvaluationRecordFileByFileId(fileId);
    }

    /**
     * 查询协同平台---指标管理--上报记录关联的附件列表
     * 
     * @param bIndexEvaluationRecordFile 协同平台---指标管理--上报记录关联的附件
     * @return 协同平台---指标管理--上报记录关联的附件
     */
    @Override
    public List<BIndexEvaluationRecordFile> selectBIndexEvaluationRecordFileList(BIndexEvaluationRecordFile bIndexEvaluationRecordFile)
    {
        return bIndexEvaluationRecordFileMapper.selectBIndexEvaluationRecordFileList(bIndexEvaluationRecordFile);
    }

    /**
     * 新增协同平台---指标管理--上报记录关联的附件
     * 
     * @param bIndexEvaluationRecordFile 协同平台---指标管理--上报记录关联的附件
     * @return 结果
     */
    @Override
    public int insertBIndexEvaluationRecordFile(BIndexEvaluationRecordFile bIndexEvaluationRecordFile)
    {
        return bIndexEvaluationRecordFileMapper.insertBIndexEvaluationRecordFile(bIndexEvaluationRecordFile);
    }

    /**
     * 修改协同平台---指标管理--上报记录关联的附件
     * 
     * @param bIndexEvaluationRecordFile 协同平台---指标管理--上报记录关联的附件
     * @return 结果
     */
    @Override
    public int updateBIndexEvaluationRecordFile(BIndexEvaluationRecordFile bIndexEvaluationRecordFile)
    {
        return bIndexEvaluationRecordFileMapper.updateBIndexEvaluationRecordFile(bIndexEvaluationRecordFile);
    }

    /**
     * 批量删除协同平台---指标管理--上报记录关联的附件
     * 
     * @param fileIds 需要删除的协同平台---指标管理--上报记录关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationRecordFileByFileIds(Long[] fileIds)
    {
        return bIndexEvaluationRecordFileMapper.deleteBIndexEvaluationRecordFileByFileIds(fileIds);
    }

    /**
     * 删除协同平台---指标管理--上报记录关联的附件信息
     * 
     * @param fileId 协同平台---指标管理--上报记录关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationRecordFileByFileId(Long fileId)
    {
        return bIndexEvaluationRecordFileMapper.deleteBIndexEvaluationRecordFileByFileId(fileId);
    }
}
