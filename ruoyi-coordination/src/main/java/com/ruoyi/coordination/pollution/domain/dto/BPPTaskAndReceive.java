package com.ruoyi.coordination.pollution.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;

import java.util.Date;

public class BPPTaskAndReceive extends BPollutionPreventionTask {

    private Long receiveId;
    private String receivePid;
    private String receiveState;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date completeTime;
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

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}
