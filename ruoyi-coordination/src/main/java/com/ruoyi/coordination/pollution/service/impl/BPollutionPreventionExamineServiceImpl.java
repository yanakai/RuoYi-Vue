package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionReceiveMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionExamineMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionExamine;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionExamineService;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private BPollutionPreventionReceiveMapper receiveMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

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
    @Transactional(rollbackFor = Exception.class)
    public int insertBPollutionPreventionExamine(BPollutionPreventionExamine bPollutionPreventionExamine)
    {
        bPollutionPreventionExamine.setCreateTime(DateUtils.getNowDate());
        bPollutionPreventionExamine.setExUserId(SecurityUtils.getUserId());
        bPollutionPreventionExamine.setExUserName(SecurityUtils.getUsername());
        bPollutionPreventionExamine.setExDeptId(SecurityUtils.getDeptId());
        bPollutionPreventionExamine.setExDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        int num = bPollutionPreventionExamineMapper.insertBPollutionPreventionExamine(bPollutionPreventionExamine);
        BPollutionPreventionReceive receive = new BPollutionPreventionReceive();
        receive.setReceiveId(bPollutionPreventionExamine.getReceiveId());
        if ("0".equals(bPollutionPreventionExamine.getExState())){ // 0 审核通过
            receive.setReceiveState("4"); //新增审核记录后，将接收记录置为已审核
        }else {
            receive.setReceiveState("5"); //审核未通过，状态置为未通过，重新处理
        }

        receiveMapper.updateBPollutionPreventionReceive(receive);
        return num;
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
