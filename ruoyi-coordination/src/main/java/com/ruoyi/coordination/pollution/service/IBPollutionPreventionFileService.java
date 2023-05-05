package com.ruoyi.coordination.pollution.service;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionFile;

/**
 * 协同平台---污染防治目标--文件解读Service接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface IBPollutionPreventionFileService 
{
    /**
     * 查询协同平台---污染防治目标--文件解读
     * 
     * @param fileId 协同平台---污染防治目标--文件解读主键
     * @return 协同平台---污染防治目标--文件解读
     */
    public BPollutionPreventionFile selectBPollutionPreventionFileByFileId(Long fileId);

    /**
     * 查询协同平台---污染防治目标--文件解读列表
     * 
     * @param bPollutionPreventionFile 协同平台---污染防治目标--文件解读
     * @return 协同平台---污染防治目标--文件解读集合
     */
    public List<BPollutionPreventionFile> selectBPollutionPreventionFileList(BPollutionPreventionFile bPollutionPreventionFile);

    /**
     * 新增协同平台---污染防治目标--文件解读
     * 
     * @param bPollutionPreventionFile 协同平台---污染防治目标--文件解读
     * @return 结果
     */
    public int insertBPollutionPreventionFile(BPollutionPreventionFile bPollutionPreventionFile);

    /**
     * 修改协同平台---污染防治目标--文件解读
     * 
     * @param bPollutionPreventionFile 协同平台---污染防治目标--文件解读
     * @return 结果
     */
    public int updateBPollutionPreventionFile(BPollutionPreventionFile bPollutionPreventionFile);

    /**
     * 批量删除协同平台---污染防治目标--文件解读
     * 
     * @param fileIds 需要删除的协同平台---污染防治目标--文件解读主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionFileByFileIds(Long[] fileIds);

    /**
     * 删除协同平台---污染防治目标--文件解读信息
     * 
     * @param fileId 协同平台---污染防治目标--文件解读主键
     * @return 结果
     */
    public int deleteBPollutionPreventionFileByFileId(Long fileId);
}
