package com.ruoyi.coordination.clue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoRecordFileMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoRecordFile;
import com.ruoyi.coordination.clue.service.IBClueInfoRecordFileService;

/**
 * 协同平台--污染线索处置--上报记录关联的附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@Service
public class BClueInfoRecordFileServiceImpl implements IBClueInfoRecordFileService 
{
    @Autowired
    private BClueInfoRecordFileMapper bClueInfoRecordFileMapper;

    /**
     * 查询协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param fileId 协同平台--污染线索处置--上报记录关联的附件主键
     * @return 协同平台--污染线索处置--上报记录关联的附件
     */
    @Override
    public BClueInfoRecordFile selectBClueInfoRecordFileByFileId(Long fileId)
    {
        return bClueInfoRecordFileMapper.selectBClueInfoRecordFileByFileId(fileId);
    }

    /**
     * 查询协同平台--污染线索处置--上报记录关联的附件列表
     * 
     * @param bClueInfoRecordFile 协同平台--污染线索处置--上报记录关联的附件
     * @return 协同平台--污染线索处置--上报记录关联的附件
     */
    @Override
    public List<BClueInfoRecordFile> selectBClueInfoRecordFileList(BClueInfoRecordFile bClueInfoRecordFile)
    {
        return bClueInfoRecordFileMapper.selectBClueInfoRecordFileList(bClueInfoRecordFile);
    }

    /**
     * 新增协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param bClueInfoRecordFile 协同平台--污染线索处置--上报记录关联的附件
     * @return 结果
     */
    @Override
    public int insertBClueInfoRecordFile(BClueInfoRecordFile bClueInfoRecordFile)
    {
        return bClueInfoRecordFileMapper.insertBClueInfoRecordFile(bClueInfoRecordFile);
    }

    /**
     * 修改协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param bClueInfoRecordFile 协同平台--污染线索处置--上报记录关联的附件
     * @return 结果
     */
    @Override
    public int updateBClueInfoRecordFile(BClueInfoRecordFile bClueInfoRecordFile)
    {
        return bClueInfoRecordFileMapper.updateBClueInfoRecordFile(bClueInfoRecordFile);
    }

    /**
     * 批量删除协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param fileIds 需要删除的协同平台--污染线索处置--上报记录关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoRecordFileByFileIds(Long[] fileIds)
    {
        return bClueInfoRecordFileMapper.deleteBClueInfoRecordFileByFileIds(fileIds);
    }

    /**
     * 删除协同平台--污染线索处置--上报记录关联的附件信息
     * 
     * @param fileId 协同平台--污染线索处置--上报记录关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoRecordFileByFileId(Long fileId)
    {
        return bClueInfoRecordFileMapper.deleteBClueInfoRecordFileByFileId(fileId);
    }
}
