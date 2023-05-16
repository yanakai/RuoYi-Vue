package com.ruoyi.coordination.pollution.domain.dto;

import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecord;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecordFile;

import java.util.Date;
import java.util.List;

public class BPPRecordAndFile extends BPollutionPreventionRecord {

    //审核id
    private Long exId;
    //审核状态
    private String exState;
    //审核内容
    private String exContent;
    //审核人名称
    private String exUserName;
    //审核部门名称
    private String exDeptName;
    //审核时间
    private Date exTime;
    private List<BPollutionPreventionRecordFile> fileList;


    public Long getExId() {
        return exId;
    }

    public void setExId(Long exId) {
        this.exId = exId;
    }

    public String getExState() {
        return exState;
    }

    public void setExState(String exState) {
        this.exState = exState;
    }

    public String getExContent() {
        return exContent;
    }

    public void setExContent(String exContent) {
        this.exContent = exContent;
    }

    public String getExUserName() {
        return exUserName;
    }

    public void setExUserName(String exUserName) {
        this.exUserName = exUserName;
    }

    public String getExDeptName() {
        return exDeptName;
    }

    public void setExDeptName(String exDeptName) {
        this.exDeptName = exDeptName;
    }

    public Date getExTime() {
        return exTime;
    }

    public void setExTime(Date exTime) {
        this.exTime = exTime;
    }

    public List<BPollutionPreventionRecordFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BPollutionPreventionRecordFile> fileList) {
        this.fileList = fileList;
    }
}
