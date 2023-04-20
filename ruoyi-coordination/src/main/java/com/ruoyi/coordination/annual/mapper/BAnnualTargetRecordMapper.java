package com.ruoyi.coordination.annual.mapper;

import java.util.List;
import com.ruoyi.coordination.annual.domain.BAnnualTargetRecord;

/**
 * 协同平台---年度任务目标--任务接收单位上报记录Mapper接口
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
public interface BAnnualTargetRecordMapper
{
    /**
     * 查询协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param recordId 协同平台---年度任务目标--任务接收单位上报记录主键
     * @return 协同平台---年度任务目标--任务接收单位上报记录
     */
    public BAnnualTargetRecord selectBAnnualTargetRecordByRecordId(Long recordId);

    /**
     * 查询协同平台---年度任务目标--任务接收单位上报记录列表
     *
     * @param bAnnualTargetRecord 协同平台---年度任务目标--任务接收单位上报记录
     * @return 协同平台---年度任务目标--任务接收单位上报记录集合
     */
    public List<BAnnualTargetRecord> selectBAnnualTargetRecordList(BAnnualTargetRecord bAnnualTargetRecord);

    /**
     * 新增协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param bAnnualTargetRecord 协同平台---年度任务目标--任务接收单位上报记录
     * @return 结果
     */
    public int insertBAnnualTargetRecord(BAnnualTargetRecord bAnnualTargetRecord);

    /**
     * 修改协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param bAnnualTargetRecord 协同平台---年度任务目标--任务接收单位上报记录
     * @return 结果
     */
    public int updateBAnnualTargetRecord(BAnnualTargetRecord bAnnualTargetRecord);

    /**
     * 删除协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param recordId 协同平台---年度任务目标--任务接收单位上报记录主键
     * @return 结果
     */
    public int deleteBAnnualTargetRecordByRecordId(Long recordId);

    /**
     * 批量删除协同平台---年度任务目标--任务接收单位上报记录
     *
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBAnnualTargetRecordByRecordIds(Long[] recordIds);
}
