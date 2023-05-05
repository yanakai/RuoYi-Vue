package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionRecordMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecord;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionRecordService;

/**
 * 协同平台---污染防治目标--任务接收单位上报记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@Service
public class BPollutionPreventionRecordServiceImpl implements IBPollutionPreventionRecordService 
{
    @Autowired
    private BPollutionPreventionRecordMapper bPollutionPreventionRecordMapper;

    /**
     * 查询协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param recordId 协同平台---污染防治目标--任务接收单位上报记录主键
     * @return 协同平台---污染防治目标--任务接收单位上报记录
     */
    @Override
    public BPollutionPreventionRecord selectBPollutionPreventionRecordByRecordId(Long recordId)
    {
        return bPollutionPreventionRecordMapper.selectBPollutionPreventionRecordByRecordId(recordId);
    }

    /**
     * 查询协同平台---污染防治目标--任务接收单位上报记录列表
     * 
     * @param bPollutionPreventionRecord 协同平台---污染防治目标--任务接收单位上报记录
     * @return 协同平台---污染防治目标--任务接收单位上报记录
     */
    @Override
    public List<BPollutionPreventionRecord> selectBPollutionPreventionRecordList(BPollutionPreventionRecord bPollutionPreventionRecord)
    {
        return bPollutionPreventionRecordMapper.selectBPollutionPreventionRecordList(bPollutionPreventionRecord);
    }

    /**
     * 新增协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param bPollutionPreventionRecord 协同平台---污染防治目标--任务接收单位上报记录
     * @return 结果
     */
    @Override
    public int insertBPollutionPreventionRecord(BPollutionPreventionRecord bPollutionPreventionRecord)
    {
        bPollutionPreventionRecord.setCreateTime(DateUtils.getNowDate());
        return bPollutionPreventionRecordMapper.insertBPollutionPreventionRecord(bPollutionPreventionRecord);
    }

    /**
     * 修改协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param bPollutionPreventionRecord 协同平台---污染防治目标--任务接收单位上报记录
     * @return 结果
     */
    @Override
    public int updateBPollutionPreventionRecord(BPollutionPreventionRecord bPollutionPreventionRecord)
    {
        return bPollutionPreventionRecordMapper.updateBPollutionPreventionRecord(bPollutionPreventionRecord);
    }

    /**
     * 批量删除协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param recordIds 需要删除的协同平台---污染防治目标--任务接收单位上报记录主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionRecordByRecordIds(Long[] recordIds)
    {
        return bPollutionPreventionRecordMapper.deleteBPollutionPreventionRecordByRecordIds(recordIds);
    }

    /**
     * 删除协同平台---污染防治目标--任务接收单位上报记录信息
     * 
     * @param recordId 协同平台---污染防治目标--任务接收单位上报记录主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionRecordByRecordId(Long recordId)
    {
        return bPollutionPreventionRecordMapper.deleteBPollutionPreventionRecordByRecordId(recordId);
    }
}
