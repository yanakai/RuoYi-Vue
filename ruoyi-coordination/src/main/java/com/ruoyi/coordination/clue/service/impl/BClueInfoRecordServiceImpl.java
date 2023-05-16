package com.ruoyi.coordination.clue.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.coordination.clue.domain.BClueInfoReceive;
import com.ruoyi.coordination.clue.domain.BClueInfoRecordFile;
import com.ruoyi.coordination.clue.domain.dto.BCIRecordAndFile;
import com.ruoyi.coordination.clue.mapper.BClueInfoReceiveMapper;
import com.ruoyi.coordination.clue.mapper.BClueInfoRecordFileMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecord;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecordFile;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoRecordMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoRecord;
import com.ruoyi.coordination.clue.service.IBClueInfoRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台--污染线索处置--接收单位上报记录
Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@Service
public class BClueInfoRecordServiceImpl implements IBClueInfoRecordService 
{
    @Autowired
    private BClueInfoRecordMapper bClueInfoRecordMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private BClueInfoReceiveMapper receiveMapper;
    @Autowired
    private BClueInfoRecordFileMapper recordFileMapper;


    /**
     * 查询协同平台--污染线索处置--接收单位上报记录

     * 
     * @param recordId 协同平台--污染线索处置--接收单位上报记录
主键
     * @return 协同平台--污染线索处置--接收单位上报记录

     */
    @Override
    public BClueInfoRecord selectBClueInfoRecordByRecordId(Long recordId)
    {
        return bClueInfoRecordMapper.selectBClueInfoRecordByRecordId(recordId);
    }

    /**
     * 查询协同平台--污染线索处置--接收单位上报记录
列表
     * 
     * @param bClueInfoRecord 协同平台--污染线索处置--接收单位上报记录

     * @return 协同平台--污染线索处置--接收单位上报记录

     */
    @Override
    public List<BClueInfoRecord> selectBClueInfoRecordList(BClueInfoRecord bClueInfoRecord)
    {
        return bClueInfoRecordMapper.selectBClueInfoRecordList(bClueInfoRecord);
    }

    /**
     * 新增协同平台--污染线索处置--接收单位上报记录

     * 
     * @param bClueInfoRecord 协同平台--污染线索处置--接收单位上报记录

     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBClueInfoRecord(BCIRecordAndFile bClueInfoRecord)
    {
        bClueInfoRecord.setCreateTime(DateUtils.getNowDate());
        bClueInfoRecord.setCreateDeptId(SecurityUtils.getDeptId());
        bClueInfoRecord.setCreateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        bClueInfoRecord.setCreateUserId(SecurityUtils.getUserId());
        bClueInfoRecord.setCreateUserName(SecurityUtils.getUsername());
        bClueInfoRecord.setRecordNum(getMaxRecordNum(bClueInfoRecord.getReceiveId())+1);
        BClueInfoRecord record = new BClueInfoRecord();
        BeanUtils.copyProperties(bClueInfoRecord,record);
        int num = bClueInfoRecordMapper.insertBClueInfoRecord(record);

        List<BClueInfoRecordFile> fileList = bClueInfoRecord.getFileList();
        if (fileList != null && fileList.size() > 0){
            fileList.stream().forEach(f -> f.setRecordId(record.getRecordId()));
            recordFileMapper.insertBClueInfoRecordFileList(fileList);
        }

        //更新接收记录状态
        Long receiveId = bClueInfoRecord.getReceiveId();
        if (receiveId != null && receiveId != 0){
            BClueInfoReceive receive = new BClueInfoReceive();
            receive.setReceiveId(receiveId);
            receive.setReceiveState("3");//接收记录状态置为已反馈
            receiveMapper.updateBClueInfoReceive(receive);
        }
        return num;
    }

    private Long getMaxRecordNum(Long receiveId) {
        return bClueInfoRecordMapper.getMaxRecordNum(receiveId);
    }

    /**
     * 修改协同平台--污染线索处置--接收单位上报记录

     * 
     * @param bClueInfoRecord 协同平台--污染线索处置--接收单位上报记录

     * @return 结果
     */
    @Override
    public int updateBClueInfoRecord(BClueInfoRecord bClueInfoRecord)
    {
        return bClueInfoRecordMapper.updateBClueInfoRecord(bClueInfoRecord);
    }

    /**
     * 批量删除协同平台--污染线索处置--接收单位上报记录

     * 
     * @param recordIds 需要删除的协同平台--污染线索处置--接收单位上报记录
主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoRecordByRecordIds(Long[] recordIds)
    {
        return bClueInfoRecordMapper.deleteBClueInfoRecordByRecordIds(recordIds);
    }

    /**
     * 删除协同平台--污染线索处置--接收单位上报记录
信息
     * 
     * @param recordId 协同平台--污染线索处置--接收单位上报记录
主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoRecordByRecordId(Long recordId)
    {
        return bClueInfoRecordMapper.deleteBClueInfoRecordByRecordId(recordId);
    }

    @Override
    public List<BCIRecordAndFile> selectBClueInfoRecordAndList(BClueInfoRecord bClueInfoRecord) {
        return bClueInfoRecordMapper.selectBClueInfoRecordAndList(bClueInfoRecord);
    }
}
