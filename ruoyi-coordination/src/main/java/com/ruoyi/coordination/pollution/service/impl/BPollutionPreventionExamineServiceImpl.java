package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionExamineMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionExamine;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionExamineService;

/**
 * 协同平台---污染防治目标--任务审核记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class BPollutionPreventionExamineServiceImpl implements IBPollutionPreventionExamineService 
{
    @Autowired
    private BPollutionPreventionExamineMapper bPollutionPreventionExamineMapper;

    /**
     * 查询协同平台---污染防治目标--任务审核记录
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 协同平台---污染防治目标--任务审核记录
     */
    @Override
    public BPollutionPreventionExamine selectBPollutionPreventionExamineByExId(Long exId)
    {
        return bPollutionPreventionExamineMapper.selectBPollutionPreventionExamineByExId(exId);
    }

    /**
     * 查询协同平台---污染防治目标--任务审核记录列表
     * 
     * @param bPollutionPreventionExamine 协同平台---污染防治目标--任务审核记录
     * @return 协同平台---污染防治目标--任务审核记录
     */
    @Override
    public List<BPollutionPreventionExamine> selectBPollutionPreventionExamineList(BPollutionPreventionExamine bPollutionPreventionExamine)
    {
        return bPollutionPreventionExamineMapper.selectBPollutionPreventionExamineList(bPollutionPreventionExamine);
    }

    /**
     * 新增协同平台---污染防治目标--任务审核记录
     * 
     * @param bPollutionPreventionExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    @Override
    public int insertBPollutionPreventionExamine(BPollutionPreventionExamine bPollutionPreventionExamine)
    {

        bPollutionPreventionExamine.setCreateTime(DateUtils.getNowDate());
        return bPollutionPreventionExamineMapper.insertBPollutionPreventionExamine(bPollutionPreventionExamine);
    }

    /**
     * 修改协同平台---污染防治目标--任务审核记录
     * 
     * @param bPollutionPreventionExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    @Override
    public int updateBPollutionPreventionExamine(BPollutionPreventionExamine bPollutionPreventionExamine)
    {
        return bPollutionPreventionExamineMapper.updateBPollutionPreventionExamine(bPollutionPreventionExamine);
    }

    /**
     * 批量删除协同平台---污染防治目标--任务审核记录
     * 
     * @param exIds 需要删除的协同平台---污染防治目标--任务审核记录主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionExamineByExIds(Long[] exIds)
    {
        return bPollutionPreventionExamineMapper.deleteBPollutionPreventionExamineByExIds(exIds);
    }

    /**
     * 删除协同平台---污染防治目标--任务审核记录信息
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionExamineByExId(Long exId)
    {
        return bPollutionPreventionExamineMapper.deleteBPollutionPreventionExamineByExId(exId);
    }
}
