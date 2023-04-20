package com.ruoyi.coordination.annual.mapper;

import java.util.List;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTaskFile;
/**
 * @description: 协同平台---年度任务目标--主任务关联的附件Mapper接口
 * @author: yanakai@126.com
 * @date: 2023/4/20 15:22
 **/
public interface BAnnualTargetTaskFileMapper {
    /**
     * 查询协同平台---年度任务目标--主任务关联的附件
     *
     * @param fileId 协同平台---年度任务目标--主任务关联的附件主键
     * @return 协同平台---年度任务目标--主任务关联的附件
     */
    public BAnnualTargetTaskFile selectBAnnualTargetTaskFileByFileId(Long fileId);

    /**
     * 查询协同平台---年度任务目标--主任务关联的附件列表
     *
     * @param bAnnualTargetTaskFile 协同平台---年度任务目标--主任务关联的附件
     * @return 协同平台---年度任务目标--主任务关联的附件集合
     */
    public List<BAnnualTargetTaskFile> selectBAnnualTargetTaskFileList(BAnnualTargetTaskFile bAnnualTargetTaskFile);

    /**
     * 新增协同平台---年度任务目标--主任务关联的附件
     *
     * @param bAnnualTargetTaskFile 协同平台---年度任务目标--主任务关联的附件
     * @return 结果
     */
    public int insertBAnnualTargetTaskFile(BAnnualTargetTaskFile bAnnualTargetTaskFile);

    /**
     * 修改协同平台---年度任务目标--主任务关联的附件
     *
     * @param bAnnualTargetTaskFile 协同平台---年度任务目标--主任务关联的附件
     * @return 结果
     */
    public int updateBAnnualTargetTaskFile(BAnnualTargetTaskFile bAnnualTargetTaskFile);

    /**
     * 删除协同平台---年度任务目标--主任务关联的附件
     *
     * @param fileId 协同平台---年度任务目标--主任务关联的附件主键
     * @return 结果
     */
    public int deleteBAnnualTargetTaskFileByFileId(Long fileId);

    /**
     * 批量删除协同平台---年度任务目标--主任务关联的附件
     *
     * @param fileIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBAnnualTargetTaskFileByFileIds(Long[] fileIds);
}
