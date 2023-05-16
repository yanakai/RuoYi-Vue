package com.ruoyi.coordination.clue.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.coordination.clue.domain.BClueInfoTask;

import java.util.Date;

public class BCITaskAndReceive extends BClueInfoTask {

    private Long receiveId;

    private String receivePid;

    private String receiveState;

    private String urgingState;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issuanceTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date completeTime;

    private Long receiveDeptId;

    private String disseminateComments;

    private String searchCode;

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceivePid() {
        return receivePid;
    }

    public void setReceivePid(String receivePid) {
        this.receivePid = receivePid;
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

    public Date getIssuanceTime() {
        return issuanceTime;
    }

    public void setIssuanceTime(Date issuanceTime) {
        this.issuanceTime = issuanceTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getSearchCode() {
        return searchCode;
    }

    public void setSearchCode(String searchCode) {
        this.searchCode = searchCode;
    }

    public Long getReceiveDeptId() {
        return receiveDeptId;
    }

    public void setReceiveDeptId(Long receiveDeptId) {
        this.receiveDeptId = receiveDeptId;
    }

    public String getDisseminateComments() {
        return disseminateComments;
    }

    public void setDisseminateComments(String disseminateComments) {
        this.disseminateComments = disseminateComments;
    }
}
