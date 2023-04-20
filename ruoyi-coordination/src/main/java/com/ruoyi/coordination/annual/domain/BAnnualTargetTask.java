package com.ruoyi.coordination.annual.domain;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @BelongsProject: RuoYi-Vue
 * @BelongsPackage: com.ruoyi.coordination.annual.domain
 * @Author: yanakai@126.com
 * @CreateTime: 2023-04-20  14:52
 * @Description: 协同平台--年度目标任务--任务主对象 b_annual_target_task
 * @Version: 1.0
 */
public class BAnnualTargetTask extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 年度目标任务id */
    private Long taskId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务类型；关联字典表 */
    @Excel(name = "任务类型；关联字典表")
    private String taskType;

    /** 上报周期：1：日；2：周；3：月；4：季度；5：年；关联字典表 */
    @Excel(name = "上报周期：1：日；2：周；3：月；4：季度；5：年；关联字典表")
    private String reportingCycle;

    /** 任务要求；关联字典表 */
    @Excel(name = "任务要求；关联字典表")
    private String taskAsk;

    /** 任务状态：0：未下发；1：已下发；3：完成；关联字典表 */
    @Excel(name = "任务状态：0：未下发；1：已下发；3：完成；关联字典表")
    private String taskState;

    /** 任务来源；关联字典表 */
    @Excel(name = "任务来源；关联字典表")
    private String taskSource;

    /** 任务级别；关联字典表 */
    @Excel(name = "任务级别；关联字典表")
    private String taskLevel;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 创建单位id */
    @Excel(name = "创建单位id")
    private Long createDeptId;

    /** 创建单位名称 */
    @Excel(name = "创建单位名称")
    private String createDeptName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 创建人名称 */
    @Excel(name = "创建人名称")
    private String createUserName;

    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId()
    {
        return taskId;
    }
    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskName()
    {
        return taskName;
    }
    public void setTaskType(String taskType)
    {
        this.taskType = taskType;
    }

    public String getTaskType()
    {
        return taskType;
    }
    public void setReportingCycle(String reportingCycle)
    {
        this.reportingCycle = reportingCycle;
    }

    public String getReportingCycle()
    {
        return reportingCycle;
    }
    public void setTaskAsk(String taskAsk)
    {
        this.taskAsk = taskAsk;
    }

    public String getTaskAsk()
    {
        return taskAsk;
    }
    public void setTaskState(String taskState)
    {
        this.taskState = taskState;
    }

    public String getTaskState()
    {
        return taskState;
    }
    public void setTaskSource(String taskSource)
    {
        this.taskSource = taskSource;
    }

    public String getTaskSource()
    {
        return taskSource;
    }
    public void setTaskLevel(String taskLevel)
    {
        this.taskLevel = taskLevel;
    }

    public String getTaskLevel()
    {
        return taskLevel;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setCreateDeptId(Long createDeptId)
    {
        this.createDeptId = createDeptId;
    }

    public Long getCreateDeptId()
    {
        return createDeptId;
    }
    public void setCreateDeptName(String createDeptName)
    {
        this.createDeptName = createDeptName;
    }

    public String getCreateDeptName()
    {
        return createDeptName;
    }
    public void setCreateUserId(Long createUserId)
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId()
    {
        return createUserId;
    }
    public void setCreateUserName(String createUserName)
    {
        this.createUserName = createUserName;
    }

    public String getCreateUserName()
    {
        return createUserName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("taskId", getTaskId())
                .append("taskName", getTaskName())
                .append("taskType", getTaskType())
                .append("reportingCycle", getReportingCycle())
                .append("taskAsk", getTaskAsk())
                .append("taskState", getTaskState())
                .append("taskSource", getTaskSource())
                .append("taskLevel", getTaskLevel())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("createDeptId", getCreateDeptId())
                .append("createDeptName", getCreateDeptName())
                .append("createUserId", getCreateUserId())
                .append("createUserName", getCreateUserName())
                .append("createTime", getCreateTime())
                .append("remark", getRemark())
                .toString();
    }
}