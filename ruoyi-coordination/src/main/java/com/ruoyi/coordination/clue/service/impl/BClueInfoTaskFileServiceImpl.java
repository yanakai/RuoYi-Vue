package com.ruoyi.coordination.clue.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoTaskFileMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoTaskFile;
import com.ruoyi.coordination.clue.service.IBClueInfoTaskFileService;

/**
 * 协同平台--污染线索处置----线索主任务关联的附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@Service
public class BClueInfoTaskFileServiceImpl implements IBClueInfoTaskFileService 
{
    @Autowired
    private BClueInfoTaskFileMapper bClueInfoTaskFileMapper;

    /**
     * 查询协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param fileId 协同平台--污染线索处置----线索主任务关联的附件主键
     * @return 协同平台--污染线索处置----线索主任务关联的附件
     */
    @Override
    public BClueInfoTaskFile selectBClueInfoTaskFileByFileId(Long fileId)
    {
        return bClueInfoTaskFileMapper.selectBClueInfoTaskFileByFileId(fileId);
    }

    /**
     * 查询协同平台--污染线索处置----线索主任务关联的附件列表
     * 
     * @param bClueInfoTaskFile 协同平台--污染线索处置----线索主任务关联的附件
     * @return 协同平台--污染线索处置----线索主任务关联的附件
     */
    @Override
    public List<BClueInfoTaskFile> selectBClueInfoTaskFileList(BClueInfoTaskFile bClueInfoTaskFile)
    {
        return bClueInfoTaskFileMapper.selectBClueInfoTaskFileList(bClueInfoTaskFile);
    }

    /**
     * 新增协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param bClueInfoTaskFile 协同平台--污染线索处置----线索主任务关联的附件
     * @return 结果
     */
    @Override
    public int insertBClueInfoTaskFile(BClueInfoTaskFile bClueInfoTaskFile)
    {
        return bClueInfoTaskFileMapper.insertBClueInfoTaskFile(bClueInfoTaskFile);
    }

    /**
     * 修改协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param bClueInfoTaskFile 协同平台--污染线索处置----线索主任务关联的附件
     * @return 结果
     */
    @Override
    public int updateBClueInfoTaskFile(BClueInfoTaskFile bClueInfoTaskFile)
    {
        return bClueInfoTaskFileMapper.updateBClueInfoTaskFile(bClueInfoTaskFile);
    }

    /**
     * 批量删除协同平台--污染线索处置----线索主任务关联的附件
     * 
     * @param fileIds 需要删除的协同平台--污染线索处置----线索主任务关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoTaskFileByFileIds(Long[] fileIds)
    {
        return bClueInfoTaskFileMapper.deleteBClueInfoTaskFileByFileIds(fileIds);
    }

    /**
     * 删除协同平台--污染线索处置----线索主任务关联的附件信息
     * 
     * @param fileId 协同平台--污染线索处置----线索主任务关联的附件主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoTaskFileByFileId(Long fileId)
    {
        return bClueInfoTaskFileMapper.deleteBClueInfoTaskFileByFileId(fileId);
    }

    @Override
    public int insertTaskFileList(List<BClueInfoTaskFile> fileList) {

        return bClueInfoTaskFileMapper.insertTaskFileList(fileList);
    }
}
