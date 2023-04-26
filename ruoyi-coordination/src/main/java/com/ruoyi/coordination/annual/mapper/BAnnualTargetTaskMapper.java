package com.ruoyi.coordination.annual.mapper;

import java.util.List;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTask;
import com.ruoyi.coordination.annual.domain.dto.TaskAndFile;
import org.apache.ibatis.annotations.Param;

/**
 * @description:  协同平台--年度目标任务--任务主Mapper接口
 * @author: yanakai@126.com 
 * @date: 2023/4/20 14:55
 **/
public interface BAnnualTargetTaskMapper {
    /**
     * 查询协同平台--年度目标任务--任务主
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 协同平台--年度目标任务--任务主
     */
    public BAnnualTargetTask selectBAnnualTargetTaskByTaskId(Long taskId);

    /**
     * 查询协同平台--年度目标任务--任务主列表
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 协同平台--年度目标任务--任务主集合
     */
    public List<BAnnualTargetTask> selectBAnnualTargetTaskList(BAnnualTargetTask bAnnualTargetTask);

    public List<TaskAndFile> selectBAnnualTargetTaskListAndFile(BAnnualTargetTask bAnnualTargetTask);


    /**
     * 新增协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    public int insertBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask);

    /**
     * 修改协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    public int updateBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask);

    /**
     * 删除协同平台--年度目标任务--任务主
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 结果
     */
    public int deleteBAnnualTargetTaskByTaskId(Long taskId);

    /**
     * 批量删除协同平台--年度目标任务--任务主
     *
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBAnnualTargetTaskByTaskIds(Long[] taskIds);

    List<TaskAndFile> selectBAnnualTargetTaskListAndFileByDept(@Param("bat") BAnnualTargetTask bAnnualTargetTask,@Param("deptId") Long deptId);
}
