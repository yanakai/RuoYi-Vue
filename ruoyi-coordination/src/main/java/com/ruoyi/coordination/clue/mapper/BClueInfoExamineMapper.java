package com.ruoyi.coordination.clue.mapper;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoExamine;
import com.ruoyi.coordination.clue.domain.BClueInfoTask;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndReceive;

/**
 * 协同平台---污染防治目标--任务审核记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-12
 */
public interface BClueInfoExamineMapper 
{
    /**
     * 查询协同平台---污染防治目标--任务审核记录
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 协同平台---污染防治目标--任务审核记录
     */
    public BClueInfoExamine selectBClueInfoExamineByExId(Long exId);

    /**
     * 查询协同平台---污染防治目标--任务审核记录列表
     * 
     * @param bClueInfoExamine 协同平台---污染防治目标--任务审核记录
     * @return 协同平台---污染防治目标--任务审核记录集合
     */
    public List<BClueInfoExamine> selectBClueInfoExamineList(BClueInfoExamine bClueInfoExamine);

    /**
     * 新增协同平台---污染防治目标--任务审核记录
     * 
     * @param bClueInfoExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    public int insertBClueInfoExamine(BClueInfoExamine bClueInfoExamine);

    /**
     * 修改协同平台---污染防治目标--任务审核记录
     * 
     * @param bClueInfoExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    public int updateBClueInfoExamine(BClueInfoExamine bClueInfoExamine);

    /**
     * 删除协同平台---污染防治目标--任务审核记录
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 结果
     */
    public int deleteBClueInfoExamineByExId(Long exId);

    /**
     * 批量删除协同平台---污染防治目标--任务审核记录
     * 
     * @param exIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBClueInfoExamineByExIds(Long[] exIds);

    List<BCITaskAndReceive> selectBClueInfoExamineToDoList(BClueInfoTask bClueInfoExamine);
}
