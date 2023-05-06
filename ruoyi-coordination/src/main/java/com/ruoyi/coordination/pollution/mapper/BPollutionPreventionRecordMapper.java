package com.ruoyi.coordination.pollution.mapper;

import java.util.List;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecord;
import com.ruoyi.coordination.pollution.domain.dto.BPPRecordAndFile;

/**
 * 协同平台---污染防治目标--任务接收单位上报记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public interface BPollutionPreventionRecordMapper 
{
    /**
     * 查询协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param recordId 协同平台---污染防治目标--任务接收单位上报记录主键
     * @return 协同平台---污染防治目标--任务接收单位上报记录
     */
    public BPollutionPreventionRecord selectBPollutionPreventionRecordByRecordId(Long recordId);

    /**
     * 查询协同平台---污染防治目标--任务接收单位上报记录列表
     * 
     * @param bPollutionPreventionRecord 协同平台---污染防治目标--任务接收单位上报记录
     * @return 协同平台---污染防治目标--任务接收单位上报记录集合
     */
    public List<BPPRecordAndFile> selectBPollutionPreventionRecordList(BPollutionPreventionRecord bPollutionPreventionRecord);

    /**
     * 新增协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param bPollutionPreventionRecord 协同平台---污染防治目标--任务接收单位上报记录
     * @return 结果
     */
    public int insertBPollutionPreventionRecord(BPollutionPreventionRecord bPollutionPreventionRecord);

    /**
     * 修改协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param bPollutionPreventionRecord 协同平台---污染防治目标--任务接收单位上报记录
     * @return 结果
     */
    public int updateBPollutionPreventionRecord(BPollutionPreventionRecord bPollutionPreventionRecord);

    /**
     * 删除协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param recordId 协同平台---污染防治目标--任务接收单位上报记录主键
     * @return 结果
     */
    public int deleteBPollutionPreventionRecordByRecordId(Long recordId);

    /**
     * 批量删除协同平台---污染防治目标--任务接收单位上报记录
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBPollutionPreventionRecordByRecordIds(Long[] recordIds);

    Long getMaxRecordNum(Long receiveId);
}
