package com.ruoyi.coordination.index.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationReceiveMapper;
import com.ruoyi.coordination.index.domain.BIndexEvaluationReceive;
import com.ruoyi.coordination.index.service.IBIndexEvaluationReceiveService;

/**
 * 协同平台---指标管理--指标任务接收单位Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@Service
public class BIndexEvaluationReceiveServiceImpl implements IBIndexEvaluationReceiveService 
{
    @Autowired
    private BIndexEvaluationReceiveMapper bIndexEvaluationReceiveMapper;

    /**
     * 查询协同平台---指标管理--指标任务接收单位
     * 
     * @param receiveId 协同平台---指标管理--指标任务接收单位主键
     * @return 协同平台---指标管理--指标任务接收单位
     */
    @Override
    public BIndexEvaluationReceive selectBIndexEvaluationReceiveByReceiveId(Long receiveId)
    {
        return bIndexEvaluationReceiveMapper.selectBIndexEvaluationReceiveByReceiveId(receiveId);
    }

    /**
     * 查询协同平台---指标管理--指标任务接收单位列表
     * 
     * @param bIndexEvaluationReceive 协同平台---指标管理--指标任务接收单位
     * @return 协同平台---指标管理--指标任务接收单位
     */
    @Override
    public List<BIndexEvaluationReceive> selectBIndexEvaluationReceiveList(BIndexEvaluationReceive bIndexEvaluationReceive)
    {
        return bIndexEvaluationReceiveMapper.selectBIndexEvaluationReceiveList(bIndexEvaluationReceive);
    }

    /**
     * 新增协同平台---指标管理--指标任务接收单位
     * 
     * @param bIndexEvaluationReceive 协同平台---指标管理--指标任务接收单位
     * @return 结果
     */
    @Override
    public int insertBIndexEvaluationReceive(BIndexEvaluationReceive bIndexEvaluationReceive)
    {
        bIndexEvaluationReceive.setCreateTime(DateUtils.getNowDate());
        return bIndexEvaluationReceiveMapper.insertBIndexEvaluationReceive(bIndexEvaluationReceive);
    }

    /**
     * 修改协同平台---指标管理--指标任务接收单位
     * 
     * @param bIndexEvaluationReceive 协同平台---指标管理--指标任务接收单位
     * @return 结果
     */
    @Override
    public int updateBIndexEvaluationReceive(BIndexEvaluationReceive bIndexEvaluationReceive)
    {
        return bIndexEvaluationReceiveMapper.updateBIndexEvaluationReceive(bIndexEvaluationReceive);
    }

    /**
     * 批量删除协同平台---指标管理--指标任务接收单位
     * 
     * @param receiveIds 需要删除的协同平台---指标管理--指标任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationReceiveByReceiveIds(Long[] receiveIds)
    {
        return bIndexEvaluationReceiveMapper.deleteBIndexEvaluationReceiveByReceiveIds(receiveIds);
    }

    /**
     * 删除协同平台---指标管理--指标任务接收单位信息
     * 
     * @param receiveId 协同平台---指标管理--指标任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationReceiveByReceiveId(Long receiveId)
    {
        return bIndexEvaluationReceiveMapper.deleteBIndexEvaluationReceiveByReceiveId(receiveId);
    }
}
