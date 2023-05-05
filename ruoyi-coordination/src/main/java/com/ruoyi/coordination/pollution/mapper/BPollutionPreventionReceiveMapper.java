package com.ruoyi.coordination.pollution.mapper;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;

/**
 * 协同平台---污染防治目标--任务接收单位Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface BPollutionPreventionReceiveMapper 
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
    public int insertBPollutionPreventionReceive(BPollutionPreventionReceive bPollutionPreventionReceive);

    /**
     * 修改协同平台---污染防治目标--任务接收单位
     * 
     * @param bPollutionPreventionReceive 协同平台---污染防治目标--任务接收单位
     * @return 结果
     */
    public int updateBPollutionPreventionReceive(BPollutionPreventionReceive bPollutionPreventionReceive);

    /**
     * 删除协同平台---污染防治目标--任务接收单位
     * 
     * @param receiveId 协同平台---污染防治目标--任务接收单位主键
     * @return 结果
     */
    public int deleteBPollutionPreventionReceiveByReceiveId(Long receiveId);

    /**
     * 批量删除协同平台---污染防治目标--任务接收单位
     * 
     * @param receiveIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionReceiveByReceiveIds(Long[] receiveIds);

    int insertBPollutionPreventionReceiveList(List<BPollutionPreventionReceive> receiveList);
}
