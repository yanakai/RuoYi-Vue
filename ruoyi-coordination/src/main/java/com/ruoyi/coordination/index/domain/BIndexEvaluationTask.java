package com.ruoyi.coordination.index.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台--指标管理--指标主任务对象 b_index_evaluation_task
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
public class BIndexEvaluationTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long taskId;

    /** 指标任务名称 */
    @Excel(name = "指标任务名称")
    private String taskName;

    /** 指标任务级别；关联字典表 */
    @Excel(name = "指标任务级别；关联字典表")
    private String taskLevel;

    /** 指标任务类型：关联字典表 */
    @Excel(name = "指标任务类型：关联字典表")
    private String taskType;

    /** 指标任务来源：关联字典表 */
    @Excel(name = "指标任务来源：关联字典表")
    private String taskSource;

    /** 指标任务目标 */
    @Excel(name = "指标任务目标")
    private String taskTarget;

    /** 指标任务内容 */
    @Excel(name = "指标任务内容")
    private String taskContent;

    /** 指标任务要求 */
    @Excel(name = "指标任务要求")
    private String taskAsk;

    /** 指标状态：关联字典表 */
    @Excel(name = "指标状态：关联字典表")
    private String taskState;

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
    public void setTaskLevel(String taskLevel) 
    {
        this.taskLevel = taskLevel;
    }

    public String getTaskLevel() 
    {
        return taskLevel;
    }
    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    }

    public String getTaskType() 
    {
        return taskType;
    }
    public void setTaskSource(String taskSource) 
    {
        this.taskSource = taskSource;
    }

    public String getTaskSource() 
    {
        return taskSource;
    }
    public void setTaskTarget(String taskTarget) 
    {
        this.taskTarget = taskTarget;
    }

    public String getTaskTarget() 
    {
        return taskTarget;
    }
    public void setTaskContent(String taskContent) 
    {
        this.taskContent = taskContent;
    }

    public String getTaskContent() 
    {
        return taskContent;
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
            .append("taskLevel", getTaskLevel())
            .append("taskType", getTaskType())
            .append("taskSource", getTaskSource())
            .append("taskTarget", getTaskTarget())
            .append("taskContent", getTaskContent())
            .append("taskAsk", getTaskAsk())
            .append("taskState", getTaskState())
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
