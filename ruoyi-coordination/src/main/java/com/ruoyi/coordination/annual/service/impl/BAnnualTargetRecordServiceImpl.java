package com.ruoyi.coordination.annual.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;
import com.ruoyi.coordination.annual.domain.BAnnualTargetRecordFile;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetRecordFileMapper;
import com.ruoyi.coordination.annual.service.IBAnnualTargetReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetRecordMapper;
import com.ruoyi.coordination.annual.domain.BAnnualTargetRecord;
import com.ruoyi.coordination.annual.service.IBAnnualTargetRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台---年度任务目标--任务接收单位上报记录Service业务层处理
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
@Service
public class BAnnualTargetRecordServiceImpl implements IBAnnualTargetRecordService
{
    @Autowired
    private BAnnualTargetRecordMapper bAnnualTargetRecordMapper;

    @Autowired
    private IBAnnualTargetReceiveService receiveService;
    @Autowired
    private BAnnualTargetRecordFileMapper fileMapper;

    /**
     * 查询协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param recordId 协同平台---年度任务目标--任务接收单位上报记录主键
     * @return 协同平台---年度任务目标--任务接收单位上报记录
     */
    @Override
    public BAnnualTargetRecord selectBAnnualTargetRecordByRecordId(Long recordId)
    {
        return bAnnualTargetRecordMapper.selectBAnnualTargetRecordByRecordId(recordId);
    }

    /**
     * 查询协同平台---年度任务目标--任务接收单位上报记录列表
     *
     * @param bAnnualTargetRecord 协同平台---年度任务目标--任务接收单位上报记录
     * @return 协同平台---年度任务目标--任务接收单位上报记录
     */
    @Override
    public List<BAnnualTargetRecord> selectBAnnualTargetRecordList(BAnnualTargetRecord bAnnualTargetRecord)
    {
        return bAnnualTargetRecordMapper.selectBAnnualTargetRecordList(bAnnualTargetRecord);
    }

    /**
     * 新增协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param bAnnualTargetRecord 协同平台---年度任务目标--任务接收单位上报记录
     * @return 结果
     */
    @Override
    public int insertBAnnualTargetRecord(BAnnualTargetRecord bAnnualTargetRecord)
    {
        bAnnualTargetRecord.setCreateTime(DateUtils.getNowDate());
        return bAnnualTargetRecordMapper.insertBAnnualTargetRecord(bAnnualTargetRecord);
    }

    /**
     * 修改协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param bAnnualTargetRecord 协同平台---年度任务目标--任务接收单位上报记录
     * @return 结果
     */
    @Override
    public int updateBAnnualTargetRecord(BAnnualTargetRecord bAnnualTargetRecord)
    {
        return bAnnualTargetRecordMapper.updateBAnnualTargetRecord(bAnnualTargetRecord);
    }

    /**
     * 批量删除协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param recordIds 需要删除的协同平台---年度任务目标--任务接收单位上报记录主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetRecordByRecordIds(Long[] recordIds)
    {
        return bAnnualTargetRecordMapper.deleteBAnnualTargetRecordByRecordIds(recordIds);
    }

    /**
     * 删除协同平台---年度任务目标--任务接收单位上报记录信息
     *
     * @param recordId 协同平台---年度任务目标--任务接收单位上报记录主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetRecordByRecordId(Long recordId)
    {
        return bAnnualTargetRecordMapper.deleteBAnnualTargetRecordByRecordId(recordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBAnnualTargetRecordAndFile(BAnnualTargetRecord bAnnualTargetRecord, BAnnualTargetRecordFile file) {
        int recordId = bAnnualTargetRecordMapper.insertBAnnualTargetRecord(bAnnualTargetRecord);
        file.setTaskId(Long.parseLong(String.valueOf(recordId)));
        fileMapper.insertBAnnualTargetRecordFile(file);
        BAnnualTargetRecord targetRecord = bAnnualTargetRecordMapper.selectBAnnualTargetRecordByRecordId(Long.parseLong(String.valueOf(recordId)));
        BAnnualTargetReceive receive = receiveService.selectBAnnualTargetReceiveByReceiveId(targetRecord.getReceiveId());
        receive.setRealityTaskNum(receive.getRealityTaskNum()+1);

        return receiveService.updateBAnnualTargetReceive(receive);
    }
}
