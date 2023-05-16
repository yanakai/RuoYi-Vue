package com.ruoyi.coordination.clue.service;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoRecordFile;

/**
 * 协同平台--污染线索处置--上报记录关联的附件Service接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface IBClueInfoRecordFileService 
{
    /**
     * 查询协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param fileId 协同平台--污染线索处置--上报记录关联的附件主键
     * @return 协同平台--污染线索处置--上报记录关联的附件
     */
    public BClueInfoRecordFile selectBClueInfoRecordFileByFileId(Long fileId);

    /**
     * 查询协同平台--污染线索处置--上报记录关联的附件列表
     * 
     * @param bClueInfoRecordFile 协同平台--污染线索处置--上报记录关联的附件
     * @return 协同平台--污染线索处置--上报记录关联的附件集合
     */
    public List<BClueInfoRecordFile> selectBClueInfoRecordFileList(BClueInfoRecordFile bClueInfoRecordFile);

    /**
     * 新增协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param bClueInfoRecordFile 协同平台--污染线索处置--上报记录关联的附件
     * @return 结果
     */
    public int insertBClueInfoRecordFile(BClueInfoRecordFile bClueInfoRecordFile);

    /**
     * 修改协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param bClueInfoRecordFile 协同平台--污染线索处置--上报记录关联的附件
     * @return 结果
     */
    public int updateBClueInfoRecordFile(BClueInfoRecordFile bClueInfoRecordFile);

    /**
     * 批量删除协同平台--污染线索处置--上报记录关联的附件
     * 
     * @param fileIds 需要删除的协同平台--污染线索处置--上报记录关联的附件主键集合
     * @return 结果
     */
    public int deleteBClueInfoRecordFileByFileIds(Long[] fileIds);

    /**
     * 删除协同平台--污染线索处置--上报记录关联的附件信息
     * 
     * @param fileId 协同平台--污染线索处置--上报记录关联的附件主键
     * @return 结果
     */
    public int deleteBClueInfoRecordFileByFileId(Long fileId);
}
