package com.ruoyi.coordination.annual.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTask;

import java.util.Date;
import java.util.List;

public class ReceiveAndTask extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long receiveId;

    /** 主任务id */
    @Excel(name = "主任务id")
    private Long taskId;

    /** 应完成任务数（数据来源主任务） */
    @Excel(name = "应完成任务数", readConverterExp = "数=据来源主任务")
    private Long answerTaskNum;

    /** 实完成任务数 */
    @Excel(name = "实完成任务数")
    private Long realityTaskNum;

    /** 接收状态：0:未接收；1：已接收 */
    @Excel(name = "接收状态：0:未接收；1：已接收")
    private String receiveState;

    /** 接收单位id */
    @Excel(name = "接收单位id")
    private Long receiveDeptId;

    /** 接收单位名称 */
    @Excel(name = "接收单位名称")
    private String receiveDeptName;

    /** 接收时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接收时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiveTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completeTime;

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

    /** 主键id */
    private Long recordId;

    /** 上报内容 */
    @Excel(name = "上报内容")
    private String recordContent;

    /** 应上报时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date answerTime;

    private List<BAnnualTargetTask> taskList;

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public String getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState;
    }

    public Long getReceiveDeptId() {
        return receiveDeptId;
    }

    public void setReceiveDeptId(Long receiveDeptId) {
        this.receiveDeptId = receiveDeptId;
    }

    public String getReceiveDeptName() {
        return receiveDeptName;
    }

    public void setReceiveDeptName(String receiveDeptName) {
        this.receiveDeptName = receiveDeptName;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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

    public List<BAnnualTargetTask> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<BAnnualTargetTask> taskList) {
        this.taskList = taskList;
    }
}
