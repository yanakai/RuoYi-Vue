package com.ruoyi.coordination.clue.service;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoRecord;
import com.ruoyi.coordination.clue.domain.dto.BCIRecordAndFile;

/**
 * 协同平台--污染线索处置--接收单位上报记录
Service接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface IBClueInfoRecordService 
{
    /**
     * 查询协同平台--污染线索处置--接收单位上报记录

     * 
     * @param recordId 协同平台--污染线索处置--接收单位上报记录
主键
     * @return 协同平台--污染线索处置--接收单位上报记录

     */
    public BClueInfoRecord selectBClueInfoRecordByRecordId(Long recordId);

    /**
     * 查询协同平台--污染线索处置--接收单位上报记录
列表
     * 
     * @param bClueInfoRecord 协同平台--污染线索处置--接收单位上报记录

     * @return 协同平台--污染线索处置--接收单位上报记录
集合
     */
    public List<BClueInfoRecord> selectBClueInfoRecordList(BClueInfoRecord bClueInfoRecord);

    /**
     * 新增协同平台--污染线索处置--接收单位上报记录

     * 
     * @param bClueInfoRecord 协同平台--污染线索处置--接收单位上报记录

     * @return 结果
     */
    public int insertBClueInfoRecord(BCIRecordAndFile bClueInfoRecord);

    /**
     * 修改协同平台--污染线索处置--接收单位上报记录

     * 
     * @param bClueInfoRecord 协同平台--污染线索处置--接收单位上报记录

     * @return 结果
     */
    public int updateBClueInfoRecord(BClueInfoRecord bClueInfoRecord);

    /**
     * 批量删除协同平台--污染线索处置--接收单位上报记录

     * 
     * @param recordIds 需要删除的协同平台--污染线索处置--接收单位上报记录
主键集合
     * @return 结果
     */
    public int deleteBClueInfoRecordByRecordIds(Long[] recordIds);

    /**
     * 删除协同平台--污染线索处置--接收单位上报记录
信息
     * 
     * @param recordId 协同平台--污染线索处置--接收单位上报记录
主键
     * @return 结果
     */
    public int deleteBClueInfoRecordByRecordId(Long recordId);

    List<BCIRecordAndFile> selectBClueInfoRecordAndList(BClueInfoRecord bClueInfoRecord);
}
