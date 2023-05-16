package com.ruoyi.coordination.clue.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.clue.domain.BClueInfoReceive;
import com.ruoyi.coordination.clue.domain.BClueInfoTask;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndReceive;
import com.ruoyi.coordination.clue.mapper.BClueInfoReceiveMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoExamineMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoExamine;
import com.ruoyi.coordination.clue.service.IBClueInfoExamineService;

/**
 * 协同平台---污染防治目标--任务审核记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-12
 */
@Service
public class BClueInfoExamineServiceImpl implements IBClueInfoExamineService 
{
    @Autowired
    private BClueInfoExamineMapper bClueInfoExamineMapper;
    @Autowired
    private BClueInfoReceiveMapper receiveMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询协同平台---污染防治目标--任务审核记录
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 协同平台---污染防治目标--任务审核记录
     */
    @Override
    public BClueInfoExamine selectBClueInfoExamineByExId(Long exId)
    {
        return bClueInfoExamineMapper.selectBClueInfoExamineByExId(exId);
    }

    /**
     * 查询协同平台---污染防治目标--任务审核记录列表
     * 
     * @param bClueInfoExamine 协同平台---污染防治目标--任务审核记录
     * @return 协同平台---污染防治目标--任务审核记录
     */
    @Override
    public List<BClueInfoExamine> selectBClueInfoExamineList(BClueInfoExamine bClueInfoExamine)
    {
        return bClueInfoExamineMapper.selectBClueInfoExamineList(bClueInfoExamine);
    }

    /**
     * 新增协同平台---污染防治目标--任务审核记录
     * 
     * @param bClueInfoExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    @Override
    public int insertBClueInfoExamine(BClueInfoExamine bClueInfoExamine)
    {
        bClueInfoExamine.setCreateTime(DateUtils.getNowDate());
        bClueInfoExamine.setExDeptId(SecurityUtils.getDeptId());
        bClueInfoExamine.setExDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        bClueInfoExamine.setExTime(DateUtils.getNowDate());
        bClueInfoExamine.setExUserId(SecurityUtils.getUserId());
        bClueInfoExamine.setExUserName(SecurityUtils.getUsername());
        Long receiveId = bClueInfoExamine.getReceiveId();
        String exState = bClueInfoExamine.getExState();
        if (receiveId != null){
            BClueInfoReceive bClueInfoReceive = new BClueInfoReceive();
            bClueInfoReceive.setReceiveId(bClueInfoExamine.getReceiveId());
            if (exState == "0"){ // 0 审核通过   1  审核不通过
                bClueInfoReceive.setReceiveState("4"); // 已完成
            }else {
                bClueInfoReceive.setReceiveState("5"); //审核未通过
            }
            receiveMapper.updateBClueInfoReceive(bClueInfoReceive);
        }
        return bClueInfoExamineMapper.insertBClueInfoExamine(bClueInfoExamine);
    }

    /**
     * 修改协同平台---污染防治目标--任务审核记录
     * 
     * @param bClueInfoExamine 协同平台---污染防治目标--任务审核记录
     * @return 结果
     */
    @Override
    public int updateBClueInfoExamine(BClueInfoExamine bClueInfoExamine)
    {
        return bClueInfoExamineMapper.updateBClueInfoExamine(bClueInfoExamine);
    }

    /**
     * 批量删除协同平台---污染防治目标--任务审核记录
     * 
     * @param exIds 需要删除的协同平台---污染防治目标--任务审核记录主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoExamineByExIds(Long[] exIds)
    {
        return bClueInfoExamineMapper.deleteBClueInfoExamineByExIds(exIds);
    }

    /**
     * 删除协同平台---污染防治目标--任务审核记录信息
     * 
     * @param exId 协同平台---污染防治目标--任务审核记录主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoExamineByExId(Long exId)
    {
        return bClueInfoExamineMapper.deleteBClueInfoExamineByExId(exId);
    }

    @Override
    public List<BCITaskAndReceive> selectBClueInfoExamineToDoList(BCITaskAndReceive bClueInfoExamine) {
        bClueInfoExamine.setCreateDeptId(SecurityUtils.getDeptId());
        return bClueInfoExamineMapper.selectBClueInfoExamineToDoList(bClueInfoExamine);
    }
}
