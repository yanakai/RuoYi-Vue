package com.ruoyi.coordination.pollution.service;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;
import com.ruoyi.coordination.pollution.domain.dto.BPPReceive;

/**
 * 协同平台---污染防治目标--任务接收单位Service接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface IBPollutionPreventionReceiveService 
{
    /**
     * 查询协同平台---污染防治目标--任务接收单位
     * 
     * @param receiveId 协同平台---污染防治目标--任务接收单位主键
     * @return 协同平台---污染防治目标--任务接收单位
     */
    public BPollutionPreventionReceive selectBPollutionPreventionReceiveByReceiveId(Long receiveId);

    /**
     * 查询协同平台---污染防治目标--任务接收单位列表
     * 
     * @param bPollutionPreventionReceive 协同平台---污染防治目标--任务接收单位
     * @return 协同平台---污染防治目标--任务接收单位集合
     */
    public List<BPollutionPreventionReceive> selectBPollutionPreventionReceiveList(BPollutionPreventionReceive bPollutionPreventionReceive);

    /**
     * 新增协同平台---污染防治目标--任务接收单位
     * 
     * @param bPollutionPreventionReceive 协同平台---污染防治目标--任务接收单位
     * @return 结果
     */
    public int insertBPollutionPreventionReceive(BPPReceive bPollutionPreventionReceive);

    /**
     * 修改协同平台---污染防治目标--任务接收单位
     * 
     * @param bPollutionPreventionReceive 协同平台---污染防治目标--任务接收单位
     * @return 结果
     */
    public int updateBPollutionPreventionReceive(BPollutionPreventionReceive bPollutionPreventionReceive);

    /**
     * 批量删除协同平台---污染防治目标--任务接收单位
     * 
     * @param receiveIds 需要删除的协同平台---污染防治目标--任务接收单位主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionReceiveByReceiveIds(Long[] receiveIds);

    /**
     * 删除协同平台---污染防治目标--任务接收单位信息
     * 
     * @param receiveId 协同平台---污染防治目标--任务接收单位主键
     * @return 结果
     */
    public int deleteBPollutionPreventionReceiveByReceiveId(Long receiveId);

    public int insertReceiveList(Long[] deptIds, BPollutionPreventionTask bPollutionPreventionTask);
}
