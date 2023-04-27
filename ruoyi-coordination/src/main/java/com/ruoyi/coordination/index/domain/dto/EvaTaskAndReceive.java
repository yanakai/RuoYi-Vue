package com.ruoyi.coordination.index.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTask;

import java.util.Date;
import java.util.List;

public class EvaTaskAndReceive extends BIndexEvaluationTask {

    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long receiveId;

    /** 接收状态：0:未完成；1：已完成 */
    @Excel(name = "接收状态：0:未完成；1：已完成")
    private String receiveState;

    /** 催办状态：0：未催办；1：已催办 */
    @Excel(name = "催办状态：0：未催办；1：已催办")
    private String urgingState;

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

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState;
    }

    public String getUrgingState() {
        return urgingState;
    }

    public void setUrgingState(String urgingState) {
        this.urgingState = urgingState;
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
}
