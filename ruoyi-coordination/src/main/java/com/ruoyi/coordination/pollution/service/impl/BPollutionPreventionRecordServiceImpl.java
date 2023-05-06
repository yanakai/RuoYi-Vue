package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecordFile;
import com.ruoyi.coordination.pollution.domain.dto.BPPRecordAndFile;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionReceiveMapper;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionRecordFileMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionRecordMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecord;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionRecordService;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private BPollutionPreventionRecordFileMapper recordFileMapper;
    @Autowired
    private BPollutionPreventionReceiveMapper receiveMapper;

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
    public List<BPPRecordAndFile> selectBPollutionPreventionRecordList(BPollutionPreventionRecord bPollutionPreventionRecord)
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
    @Transactional(rollbackFor = Exception.class)
    public int insertBPollutionPreventionRecord(BPPRecordAndFile bPollutionPreventionRecord)
    {
        bPollutionPreventionRecord.setCreateTime(DateUtils.getNowDate());
        bPollutionPreventionRecord.setCreateDeptId(SecurityUtils.getDeptId());
        bPollutionPreventionRecord.setCreateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        bPollutionPreventionRecord.setCreateUserId(SecurityUtils.getUserId());
        bPollutionPreventionRecord.setCreateUserName(SecurityUtils.getUsername());
        bPollutionPreventionRecord.setRecordNum(getMaxRecordNum(bPollutionPreventionRecord.getReceiveId())+1);
        BPollutionPreventionRecord record = new BPollutionPreventionRecord();
        BeanUtils.copyProperties(bPollutionPreventionRecord,record);
        int num = bPollutionPreventionRecordMapper.insertBPollutionPreventionRecord(record);

        List<BPollutionPreventionRecordFile> fileList = bPollutionPreventionRecord.getFileList();
        if (fileList.size() > 0){
            fileList.stream().forEach(f -> f.setRecordId(record.getRecordId()));
            recordFileMapper.insertBPollutionPreventionRecordFileList(fileList);
        }

        //更新接收记录状态
        BPollutionPreventionReceive receive = new BPollutionPreventionReceive();
        receive.setReceiveId(bPollutionPreventionRecord.getReceiveId());
        receive.setReceiveState("3");//接收记录状态置为已反馈
        receiveMapper.updateBPollutionPreventionReceive(receive);
        return num;
    }

    private Long getMaxRecordNum(Long receiveId) {
        return bPollutionPreventionRecordMapper.getMaxRecordNum(receiveId);
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
