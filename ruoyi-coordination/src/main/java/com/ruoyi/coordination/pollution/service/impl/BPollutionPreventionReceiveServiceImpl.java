package com.ruoyi.coordination.pollution.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;
import com.ruoyi.coordination.pollution.domain.dto.BPPReceive;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionReceiveMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionReceiveService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台---污染防治目标--任务接收单位Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@Service
public class BPollutionPreventionReceiveServiceImpl implements IBPollutionPreventionReceiveService 
{
    @Autowired
    private BPollutionPreventionReceiveMapper bPollutionPreventionReceiveMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询协同平台---污染防治目标--任务接收单位
     * 
     * @param receiveId 协同平台---污染防治目标--任务接收单位主键
     * @return 协同平台---污染防治目标--任务接收单位
     */
    @Override
    public BPollutionPreventionReceive selectBPollutionPreventionReceiveByReceiveId(Long receiveId)
    {
        return bPollutionPreventionReceiveMapper.selectBPollutionPreventionReceiveByReceiveId(receiveId);
    }

    /**
     * 查询协同平台---污染防治目标--任务接收单位列表
     * 
     * @param bPollutionPreventionReceive 协同平台---污染防治目标--任务接收单位
     * @return 协同平台---污染防治目标--任务接收单位
     */
    @Override
    public List<BPollutionPreventionReceive> selectBPollutionPreventionReceiveList(BPollutionPreventionReceive bPollutionPreventionReceive)
    {
        return bPollutionPreventionReceiveMapper.selectBPollutionPreventionReceiveList(bPollutionPreventionReceive);
    }

    /**
     * 新增协同平台---污染防治目标--任务接收单位
     * 
     * @param bPollutionPreventionReceive 协同平台---污染防治目标--任务接收单位
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBPollutionPreventionReceive(BPPReceive bPollutionPreventionReceive)
    {
        bPollutionPreventionReceive.setCreateTime(DateUtils.getNowDate());
        bPollutionPreventionReceive.setCreateDeptId(SecurityUtils.getDeptId());
        bPollutionPreventionReceive.setCreateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        bPollutionPreventionReceive.setCreateUserId(SecurityUtils.getUserId());
        bPollutionPreventionReceive.setCreateUserName(SecurityUtils.getUsername());
//        bPollutionPreventionReceive.setCompleteTime();
        bPollutionPreventionReceive.setReceiveState("0");
        bPollutionPreventionReceive.setUrgingState("0");
        Long[] deptIds = bPollutionPreventionReceive.getDeptIds();
        List<BPollutionPreventionReceive> list = new ArrayList<>();
        if (deptIds.length > 0){
            for (Long deptId : deptIds) {
                BPollutionPreventionReceive receive = new BPollutionPreventionReceive();
                BeanUtils.copyProperties(bPollutionPreventionReceive,receive);
                receive.setReceiveDeptId(deptId);
                receive.setReceiveTime(DateUtils.getNowDate());
                receive.setReceiveDeptName(sysDeptMapper.selectDeptById(deptId).getDeptName());
                list.add(receive);
            }
        }
        // 更新父级接收记录的状态
        String receivePid = bPollutionPreventionReceive.getReceivePid();
        BPollutionPreventionReceive receive = new BPollutionPreventionReceive();
        receive.setReceiveId(Long.parseLong(receivePid));
        receive.setReceiveState("2"); //状态改为 已下发
        bPollutionPreventionReceiveMapper.updateBPollutionPreventionReceive(receive);
        return bPollutionPreventionReceiveMapper.insertBPollutionPreventionReceiveList(list);
    }

    /**
     * 修改协同平台---污染防治目标--任务接收单位
     * 
     * @param bPollutionPreventionReceive 协同平台---污染防治目标--任务接收单位
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBPollutionPreventionReceive(BPollutionPreventionReceive bPollutionPreventionReceive)
    {
        bPollutionPreventionReceive.setReceiveUserId(SecurityUtils.getUserId());
        bPollutionPreventionReceive.setReceiveUserName(SecurityUtils.getUsername());
        bPollutionPreventionReceive.setReceiveTime(DateUtils.getNowDate());
        return bPollutionPreventionReceiveMapper.updateBPollutionPreventionReceive(bPollutionPreventionReceive);
    }

    /**
     * 批量删除协同平台---污染防治目标--任务接收单位
     * 
     * @param receiveIds 需要删除的协同平台---污染防治目标--任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionReceiveByReceiveIds(Long[] receiveIds)
    {
        return bPollutionPreventionReceiveMapper.deleteBPollutionPreventionReceiveByReceiveIds(receiveIds);
    }

    /**
     * 删除协同平台---污染防治目标--任务接收单位信息
     * 
     * @param receiveId 协同平台---污染防治目标--任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionReceiveByReceiveId(Long receiveId)
    {
        return bPollutionPreventionReceiveMapper.deleteBPollutionPreventionReceiveByReceiveId(receiveId);
    }
    /*
    * 根据下级单位id新增接收数据
    * */
    @Override
    public int insertReceiveList(Long[] deptIds, BPollutionPreventionTask bPollutionPreventionTask){
        List<BPollutionPreventionReceive> receiveList = null;
        if (deptIds.length > 0){
            receiveList = new ArrayList<>();
            for (Long deptId : deptIds) {
                BPollutionPreventionReceive bPollutionPreventionReceive = new BPollutionPreventionReceive();
                bPollutionPreventionReceive.setCreateTime(DateUtils.getNowDate());
                bPollutionPreventionReceive.setReceiveDeptId(deptId);
                bPollutionPreventionReceive.setReceiveDeptName(sysDeptMapper.selectDeptById(deptId).getDeptName());
                bPollutionPreventionReceive.setTaskId(bPollutionPreventionTask.getTaskId());
//                bPollutionPreventionReceive.setReceiveTime(DateUtils.getNowDate());
                bPollutionPreventionReceive.setCompleteTime(bPollutionPreventionTask.getEndTime());
                bPollutionPreventionReceive.setCreateUserId(SecurityUtils.getUserId());
                bPollutionPreventionReceive.setCreateUserName(SecurityUtils.getUsername());
                bPollutionPreventionReceive.setCreateDeptId(SecurityUtils.getDeptId());
                bPollutionPreventionReceive.setCreateDeptName(bPollutionPreventionTask.getCreateDeptName());
                bPollutionPreventionReceive.setUrgingState("0"); //默认为 未催办
                bPollutionPreventionReceive.setReceiveState("0"); //默认 未接收
                receiveList.add(bPollutionPreventionReceive);
            }
        }
        return bPollutionPreventionReceiveMapper.insertBPollutionPreventionReceiveList(receiveList);
    }
}
