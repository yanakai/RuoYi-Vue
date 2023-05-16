package com.ruoyi.coordination.pollution.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台--污染防治目标--主任务对象 b_pollution_prevention_task
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
public class BPollutionPreventionTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long taskId;

    /** 任务所属考核文件id */
    @Excel(name = "任务所属考核文件id")
    private Long examineFileId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务级别；关联字典表 */
    @Excel(name = "任务级别；关联字典表")
    private String taskLevel;
    private String taskLevelName;

    /** 任务类型：关联字典表 */
    @Excel(name = "任务类型：关联字典表")
    private String taskType;

    private String taskTypeName;

    /** 任务提醒类型：关联字典表 */
    @Excel(name = "任务提醒类型：关联字典表")
    private String taskRemindType;

    /** 任务提醒时限：关联字典表 */
    @Excel(name = "任务提醒时限：关联字典表")
    private String taskTimeLimit;

    /** 任务来源：关联字典表 */
    @Excel(name = "任务来源：关联字典表")
    private String taskSource;

    /** 状态：关联字典表 */
    @Excel(name = "状态：关联字典表")
    private String taskState;

    /** 任务要求 */
    @Excel(name = "任务要求")
    private String taskAsk;

    /** 任务内容 */
    @Excel(name = "任务内容")
    private String taskContent;

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
    public void setExamineFileId(Long examineFileId) 
    {
        this.examineFileId = examineFileId;
    }

    public Long getExamineFileId() 
    {
        return examineFileId;
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

    public String getTaskLevelName() {
        return taskLevelName;
    }

    public void setTaskLevelName(String taskLevelName) {
        this.taskLevelName = taskLevelName;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
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

    public String getTaskRemindType() {
        return taskRemindType;
    }

    public void setTaskRemindType(String taskRemindType) {
        this.taskRemindType = taskRemindType;
    }

    public String getTaskTimeLimit() {
        return taskTimeLimit;
    }

    public void setTaskTimeLimit(String taskTimeLimit) {
        this.taskTimeLimit = taskTimeLimit;
    }

    public String getTaskSource()
    {
        return taskSource;
    }
    public void setTaskState(String taskState) 
    {
        this.taskState = taskState;
    }

    public String getTaskState() 
    {
        return taskState;
    }
    public void setTaskAsk(String taskAsk) 
    {
        this.taskAsk = taskAsk;
    }

    public String getTaskAsk() 
    {
        return taskAsk;
    }
    public void setTaskContent(String taskContent) 
    {
        this.taskContent = taskContent;
    }

    public String getTaskContent() 
    {
        return taskContent;
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
        return "BPollutionPreventionTask{" +
                "taskId=" + taskId +
                ", examineFileId=" + examineFileId +
                ", taskName='" + taskName + '\'' +
                ", taskLevel='" + taskLevel + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskRemindType='" + taskRemindType + '\'' +
                ", taskTimeLimit='" + taskTimeLimit + '\'' +
                ", taskSource='" + taskSource + '\'' +
                ", taskState='" + taskState + '\'' +
                ", taskAsk='" + taskAsk + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createDeptId=" + createDeptId +
                ", createDeptName='" + createDeptName + '\'' +
                ", createUserId=" + createUserId +
                ", createUserName='" + createUserName + '\'' +
                '}';
    }
}
