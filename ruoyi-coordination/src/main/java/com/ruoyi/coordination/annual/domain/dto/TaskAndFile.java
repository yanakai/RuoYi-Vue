package com.ruoyi.coordination.annual.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTaskFile;

import java.util.Date;
import java.util.List;

public class TaskAndFile extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 年度目标任务id */
    private Long taskId;

    private Long receiveId;

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

    /** 应完成任务数（数据来源主任务） */
    @Excel(name = "应完成任务数", readConverterExp = "数=据来源主任务")
    private Long answerTaskNum;

    /** 实完成任务数 */
    @Excel(name = "实完成任务数")
    private Long realityTaskNum;

    /** 接收单位名称 */
    @Excel(name = "接收单位名称")
    private String receiveDeptName;

    private List<BAnnualTargetTaskFile> fileList;

    private List<BAnnualTargetReceive> receives;
    private Long[] deptIds;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getReportingCycle() {
        return reportingCycle;
    }

    public void setReportingCycle(String reportingCycle) {
        this.reportingCycle = reportingCycle;
    }

    public String getTaskAsk() {
        return taskAsk;
    }

    public void setTaskAsk(String taskAsk) {
        this.taskAsk = taskAsk;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public String getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(String taskLevel) {
        this.taskLevel = taskLevel;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getCreateDeptId() {
        return createDeptId;
    }

    public void setCreateDeptId(Long createDeptId) {
        this.createDeptId = createDeptId;
    }

    public String getCreateDeptName() {
        return createDeptName;
    }

    public void setCreateDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public List<BAnnualTargetTaskFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BAnnualTargetTaskFile> fileList) {
        this.fileList = fileList;
    }

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }

    public Long getAnswerTaskNum() {
        return answerTaskNum;
    }

    public void setAnswerTaskNum(Long answerTaskNum) {
        this.answerTaskNum = answerTaskNum;
    }

    public Long getRealityTaskNum() {
        return realityTaskNum;
    }

    public void setRealityTaskNum(Long realityTaskNum) {
        this.realityTaskNum = realityTaskNum;
    }

    public String getReceiveDeptName() {
        return receiveDeptName;
    }

    public void setReceiveDeptName(String receiveDeptName) {
        this.receiveDeptName = receiveDeptName;
    }
    public List<BAnnualTargetReceive> getReceives() {
        return receives;
    }

    public void setReceives(List<BAnnualTargetReceive> receives) {
        this.receives = receives;
    }
}
