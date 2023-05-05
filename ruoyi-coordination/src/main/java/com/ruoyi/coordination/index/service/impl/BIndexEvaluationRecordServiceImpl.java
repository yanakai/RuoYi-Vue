package com.ruoyi.coordination.index.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecordFile;
import com.ruoyi.coordination.index.domain.dto.EvaRecordAndFile;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationRecordFileMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationRecordMapper;
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecord;
import com.ruoyi.coordination.index.service.IBIndexEvaluationRecordService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台---指标管理--指标任务接收单位上报记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@Service
public class BIndexEvaluationRecordServiceImpl implements IBIndexEvaluationRecordService 
{
    @Autowired
    private BIndexEvaluationRecordMapper bIndexEvaluationRecordMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private BIndexEvaluationRecordFileMapper fileMapper;

    /**
     * 查询协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param recordId 协同平台---指标管理--指标任务接收单位上报记录主键
     * @return 协同平台---指标管理--指标任务接收单位上报记录
     */
    @Override
    public BIndexEvaluationRecord selectBIndexEvaluationRecordByRecordId(Long recordId)
    {
        return bIndexEvaluationRecordMapper.selectBIndexEvaluationRecordByRecordId(recordId);
    }

    /**
     * 查询协同平台---指标管理--指标任务接收单位上报记录列表
     * 
     * @param bIndexEvaluationRecord 协同平台---指标管理--指标任务接收单位上报记录
     * @return 协同平台---指标管理--指标任务接收单位上报记录
     */
    @Override
    public List<BIndexEvaluationRecord> selectBIndexEvaluationRecordList(BIndexEvaluationRecord bIndexEvaluationRecord)
    {
        return bIndexEvaluationRecordMapper.selectBIndexEvaluationRecordList(bIndexEvaluationRecord);
    }

    /**
     * 新增协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param bIndexEvaluationRecord 协同平台---指标管理--指标任务接收单位上报记录
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBIndexEvaluationRecord(EvaRecordAndFile bIndexEvaluationRecord)
    {
        bIndexEvaluationRecord.setCreateTime(DateUtils.getNowDate());
        //创建上报记录
        BIndexEvaluationRecord evaluationRecord = new BIndexEvaluationRecord();
        BeanUtils.copyProperties(bIndexEvaluationRecord,evaluationRecord);
        //添加创建人相关信息
        evaluationRecord.setCreateUserId(SecurityUtils.getUserId());
        evaluationRecord.setCreateUserName(SecurityUtils.getUsername());
        evaluationRecord.setCreateDeptId(SecurityUtils.getDeptId());
        evaluationRecord.setCreateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        evaluationRecord.setCreateTime(DateUtils.getNowDate());
        evaluationRecord.setRecordNum(getMaxRecordNum(bIndexEvaluationRecord.getReceiveId())+1);
        int num = bIndexEvaluationRecordMapper.insertBIndexEvaluationRecord(evaluationRecord);

        //添加附件
        List<BIndexEvaluationRecordFile> fileList = bIndexEvaluationRecord.getFileList();
        fileList.forEach(f -> f.setRecordId(evaluationRecord.getRecordId()));
        //附件批量添加
        fileMapper.insertBatchBIndexEvaluationRecordFile(fileList);


        return num;
    }

    /**
     * 修改协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param bIndexEvaluationRecord 协同平台---指标管理--指标任务接收单位上报记录
     * @return 结果
     */
    @Override
    public int updateBIndexEvaluationRecord(BIndexEvaluationRecord bIndexEvaluationRecord)
    {
        Long deptId = SecurityUtils.getDeptId();
            bIndexEvaluationRecord.setAuditDeptId(deptId);
            bIndexEvaluationRecord.setAuditUserId(SecurityUtils.getUserId());
            bIndexEvaluationRecord.setAuditUserName(SecurityUtils.getUsername());
            bIndexEvaluationRecord.setAuditDeptName(sysDeptMapper.selectDeptById(deptId).getDeptName());
            bIndexEvaluationRecord.setAuditTime(DateUtils.getNowDate());
        return bIndexEvaluationRecordMapper.updateBIndexEvaluationRecord(bIndexEvaluationRecord);
    }
    private synchronized Integer getMaxRecordNum(Long receiveId) {
        return bIndexEvaluationRecordMapper.getMaxRecordNum(receiveId);
    }

    /**
     * 批量删除协同平台---指标管理--指标任务接收单位上报记录
     * 
     * @param recordIds 需要删除的协同平台---指标管理--指标任务接收单位上报记录主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationRecordByRecordIds(Long[] recordIds)
    {
        return bIndexEvaluationRecordMapper.deleteBIndexEvaluationRecordByRecordIds(recordIds);
    }

    /**
     * 删除协同平台---指标管理--指标任务接收单位上报记录信息
     * 
     * @param recordId 协同平台---指标管理--指标任务接收单位上报记录主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationRecordByRecordId(Long recordId)
    {
        return bIndexEvaluationRecordMapper.deleteBIndexEvaluationRecordByRecordId(recordId);
    }

    @Override
    public List<EvaRecordAndFile> selectBIndexEvaluationRecords(BIndexEvaluationRecord bIndexEvaluationRecord) {

        return bIndexEvaluationRecordMapper.selectBIndexEvaluationRecords(bIndexEvaluationRecord);
    }

    @Override
    public EvaRecordAndFile selectBIndexEvaluationRecordByReceiveId(Long receiveId) {

        return bIndexEvaluationRecordMapper.selectBIndexEvaluationRecordsByReceiveId(receiveId);
    }
}
