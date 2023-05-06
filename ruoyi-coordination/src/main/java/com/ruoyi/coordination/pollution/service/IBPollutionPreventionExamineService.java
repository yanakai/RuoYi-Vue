package com.ruoyi.coordination.pollution.service;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionExamine;

/**
 * 协同平台---污染防治目标--任务审核记录Service接口
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public interface IBPollutionPreventionExamineService 
{
    /**
     * 查询协同平台---污染防治目标--任务审核记录
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 协同平台---污染防治目标--任务审核记录
     */
    public BPollutionPreventionExamine selectBPollutionPreventionExamineByExId(Long exId);

    /**
     * 查询协同平台---污染防治目标--任务审核记录列表
     * 
     * @param bPollutionPreventionExamine 协同平台---污染防治目标--任务审核记录
     * @return 协同平台---污染防治目标--任务审核记录集合
     */
    public List<BPollutionPreventionExamine> selectBPollutionPreventionExamineList(BPollutionPreventionExamine bPollutionPreventionExamine);

    /**
     * 新增协同平台---污染防治目标--任务审核记录
     * 
     * @param bPollutionPreventionExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    public int insertBPollutionPreventionExamine(BPollutionPreventionExamine bPollutionPreventionExamine);

    /**
     * 修改协同平台---污染防治目标--任务审核记录
     * 
     * @param bPollutionPreventionExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    public int updateBPollutionPreventionExamine(BPollutionPreventionExamine bPollutionPreventionExamine);

    /**
     * 批量删除协同平台---污染防治目标--任务审核记录
     * 
     * @param exIds 需要删除的协同平台---污染防治目标--任务审核记录主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionExamineByExIds(Long[] exIds);

    /**
     * 删除协同平台---污染防治目标--任务审核记录信息
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 结果
     */
    public int deleteBPollutionPreventionExamineByExId(Long exId);
}
