package com.ruoyi.coordination.annual.service;

import java.util.List;
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;

/**
 * 协同平台---年度任务目标--任务接收单位Service接口
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
public interface IBAnnualTargetReceiveService
{
    /**
     * 查询协同平台---年度任务目标--任务接收单位
     *
     * @param receiveId 协同平台---年度任务目标--任务接收单位主键
     * @return 协同平台---年度任务目标--任务接收单位
     */
    public BAnnualTargetReceive selectBAnnualTargetReceiveByReceiveId(Long receiveId);

    /**
     * 查询协同平台---年度任务目标--任务接收单位列表
     *
     * @param bAnnualTargetReceive 协同平台---年度任务目标--任务接收单位
     * @return 协同平台---年度任务目标--任务接收单位集合
     */
    public List<BAnnualTargetReceive> selectBAnnualTargetReceiveList(BAnnualTargetReceive bAnnualTargetReceive);

    /**
     * 新增协同平台---年度任务目标--任务接收单位
     *
     * @param bAnnualTargetReceive 协同平台---年度任务目标--任务接收单位
     * @return 结果
     */
    public int insertBAnnualTargetReceive(BAnnualTargetReceive bAnnualTargetReceive);

    /**
     * 修改协同平台---年度任务目标--任务接收单位
     *
     * @param bAnnualTargetReceive 协同平台---年度任务目标--任务接收单位
     * @return 结果
     */
    public int updateBAnnualTargetReceive(BAnnualTargetReceive bAnnualTargetReceive);

    /**
     * 批量删除协同平台---年度任务目标--任务接收单位
     *
     * @param receiveIds 需要删除的协同平台---年度任务目标--任务接收单位主键集合
     * @return 结果
     */
    public int deleteBAnnualTargetReceiveByReceiveIds(Long[] receiveIds);

    /**
     * 删除协同平台---年度任务目标--任务接收单位信息
     *
     * @param receiveId 协同平台---年度任务目标--任务接收单位主键
     * @return 结果
     */
    public int deleteBAnnualTargetReceiveByReceiveId(Long receiveId);
}
