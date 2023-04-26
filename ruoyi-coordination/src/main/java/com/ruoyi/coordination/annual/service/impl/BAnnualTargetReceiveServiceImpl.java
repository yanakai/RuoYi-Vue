package com.ruoyi.coordination.annual.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.coordination.annual.domain.dto.ReceiveAndTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetReceiveMapper;
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;
import com.ruoyi.coordination.annual.service.IBAnnualTargetReceiveService;

/**
 * 协同平台---年度任务目标--任务接收单位Service业务层处理
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
@Service
public class BAnnualTargetReceiveServiceImpl implements IBAnnualTargetReceiveService
{
    @Autowired
    private BAnnualTargetReceiveMapper bAnnualTargetReceiveMapper;

    /**
     * 查询协同平台---年度任务目标--任务接收单位
     *
     * @param receiveId 协同平台---年度任务目标--任务接收单位主键
     * @return 协同平台---年度任务目标--任务接收单位
     */
    @Override
    public BAnnualTargetReceive selectBAnnualTargetReceiveByReceiveId(Long receiveId)
    {
        return bAnnualTargetReceiveMapper.selectBAnnualTargetReceiveByReceiveId(receiveId);
    }

    /**
     * 查询协同平台---年度任务目标--任务接收单位列表
     *
     * @param bAnnualTargetReceive 协同平台---年度任务目标--任务接收单位
     * @return 协同平台---年度任务目标--任务接收单位
     */
    @Override
    public List<BAnnualTargetReceive> selectBAnnualTargetReceiveList(BAnnualTargetReceive bAnnualTargetReceive)
    {
        return bAnnualTargetReceiveMapper.selectBAnnualTargetReceiveList(bAnnualTargetReceive);
    }

    /**
     * 新增协同平台---年度任务目标--任务接收单位
     *
     * @param bAnnualTargetReceive 协同平台---年度任务目标--任务接收单位
     * @return 结果
     */
    @Override
    public int insertBAnnualTargetReceive(BAnnualTargetReceive bAnnualTargetReceive)
    {
        bAnnualTargetReceive.setCreateTime(DateUtils.getNowDate());
        return bAnnualTargetReceiveMapper.insertBAnnualTargetReceive(bAnnualTargetReceive);
    }

    @Override
    public int insertBatchTargetReceive(List<BAnnualTargetReceive> bAnnualTargetReceive) {

        return bAnnualTargetReceiveMapper.insertBatchTargetReceive(bAnnualTargetReceive);
    }

    /**
     * 修改协同平台---年度任务目标--任务接收单位
     *
     * @param bAnnualTargetReceive 协同平台---年度任务目标--任务接收单位
     * @return 结果
     */
    @Override
    public int updateBAnnualTargetReceive(BAnnualTargetReceive bAnnualTargetReceive)
    {
        return bAnnualTargetReceiveMapper.updateBAnnualTargetReceive(bAnnualTargetReceive);
    }

    /**
     * 批量删除协同平台---年度任务目标--任务接收单位
     *
     * @param receiveIds 需要删除的协同平台---年度任务目标--任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetReceiveByReceiveIds(Long[] receiveIds)
    {
        return bAnnualTargetReceiveMapper.deleteBAnnualTargetReceiveByReceiveIds(receiveIds);
    }

    /**
     * 删除协同平台---年度任务目标--任务接收单位信息
     *
     * @param receiveId 协同平台---年度任务目标--任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetReceiveByReceiveId(Long receiveId)
    {
        return bAnnualTargetReceiveMapper.deleteBAnnualTargetReceiveByReceiveId(receiveId);
    }


    @Override
    public List<BAnnualTargetReceive> selectBAnnualTargetReceiveAndRecord(Long receiveId) {

        return bAnnualTargetReceiveMapper.selectBAnnualTargetReceiveAndRecord(receiveId);
    }

    @Override
    public List<String> getReceiveDept(BAnnualTargetReceive bAnnualTargetReceive) {

        return bAnnualTargetReceiveMapper.selectBAnnualTargetDept(bAnnualTargetReceive);
    }
}
