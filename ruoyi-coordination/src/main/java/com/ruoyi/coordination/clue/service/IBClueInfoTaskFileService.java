package com.ruoyi.coordination.clue.service;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoTaskFile;

/**
 * 协同平台--污染线索处置----线索主任务关联的附件Service接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface IBClueInfoTaskFileService 
{
    /**
     * 查询协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param fileId 协同平台--污染线索处置----线索主任务关联的附件主键
     * @return 协同平台--污染线索处置----线索主任务关联的附件
     */
    public BClueInfoTaskFile selectBClueInfoTaskFileByFileId(Long fileId);

    /**
     * 查询协同平台--污染线索处置----线索主任务关联的附件列表
     * 
     * @param bClueInfoTaskFile 协同平台--污染线索处置----线索主任务关联的附件
     * @return 协同平台--污染线索处置----线索主任务关联的附件集合
     */
    public List<BClueInfoTaskFile> selectBClueInfoTaskFileList(BClueInfoTaskFile bClueInfoTaskFile);

    /**
     * 新增协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param bClueInfoTaskFile 协同平台--污染线索处置----线索主任务关联的附件
     * @return 结果
     */
    public int insertBClueInfoTaskFile(BClueInfoTaskFile bClueInfoTaskFile);

    /**
     * 修改协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param bClueInfoTaskFile 协同平台--污染线索处置----线索主任务关联的附件
     * @return 结果
     */
    public int updateBClueInfoTaskFile(BClueInfoTaskFile bClueInfoTaskFile);

    /**
     * 批量删除协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param fileIds 需要删除的协同平台--污染线索处置----线索主任务关联的附件主键集合
     * @return 结果
     */
    public int deleteBClueInfoTaskFileByFileIds(Long[] fileIds);

    /**
     * 删除协同平台--污染线索处置----线索主任务关联的附件信息
     * 
     * @param fileId 协同平台--污染线索处置----线索主任务关联的附件主键
     * @return 结果
     */
    public int deleteBClueInfoTaskFileByFileId(Long fileId);

    int insertTaskFileList(List<BClueInfoTaskFile> fileList);
}
