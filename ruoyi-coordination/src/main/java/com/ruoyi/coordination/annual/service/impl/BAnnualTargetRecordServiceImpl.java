package com.ruoyi.coordination.annual.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;
import com.ruoyi.coordination.annual.domain.BAnnualTargetRecordFile;
import com.ruoyi.coordination.annual.domain.dto.RecordAndFile;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetRecordFileMapper;
import com.ruoyi.coordination.annual.service.IBAnnualTargetReceiveService;
import org.springframework.beans.BeanUtils;
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
    public RecordAndFile selectBAnnualTargetRecordByRecordId(Long recordId)
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
    public int insertBAnnualTargetRecordAndFile(RecordAndFile bAnnualTargetRecord) {
        BAnnualTargetReceive receive = receiveService.selectBAnnualTargetReceiveByReceiveId(bAnnualTargetRecord.getReceiveId());
        Long realityTaskNum = receive.getRealityTaskNum();
        if (realityTaskNum == null || realityTaskNum == 0){
            realityTaskNum = 1L;
        }else {
            realityTaskNum += 1L;
        }
        receive.setRealityTaskNum(realityTaskNum);
        receiveService.updateBAnnualTargetReceive(receive);
        BAnnualTargetRecord record = new BAnnualTargetRecord();
        BeanUtils.copyProperties(bAnnualTargetRecord,record);
        record.setCreateUserId(SecurityUtils.getUserId());
        record.setCreateUserName(SecurityUtils.getUsername());
        record.setCreateTime(DateUtils.getNowDate());
        record.setCreateDeptId(receive.getCreateDeptId());
        record.setCreateDeptName(receive.getCreateDeptName());
        int num = bAnnualTargetRecordMapper.insertBAnnualTargetRecord(record);
        List<BAnnualTargetRecordFile> fileList = bAnnualTargetRecord.getFileList();
        if (fileList.size() > 0){
            fileList.forEach(f -> f.setRecordId(record.getRecordId()));
            int i = fileMapper.insertListBAnnualTargetRecordFiles(fileList);
        }
        return num;
    }

    @Override
    public List<BAnnualTargetRecordFile> selectBAnnualTargetRecordFileByRecordId(Long recordId) {

        return bAnnualTargetRecordMapper.selectBAnnualTargetRecordFileByRecordId(recordId);
    }
}
