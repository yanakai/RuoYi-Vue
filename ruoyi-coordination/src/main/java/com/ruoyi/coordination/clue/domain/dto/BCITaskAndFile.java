package com.ruoyi.coordination.clue.domain.dto;

import com.ruoyi.coordination.clue.domain.BClueInfoTask;
import com.ruoyi.coordination.clue.domain.BClueInfoTaskFile;

import java.util.List;

public class BCITaskAndFile extends BClueInfoTask {

    private Long receiveId;

    private List<BClueInfoTaskFile> fileList;

    private Long[] deptIds;

    private String disseminateComments;

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public List<BClueInfoTaskFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BClueInfoTaskFile> fileList) {
        this.fileList = fileList;
    }

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }

    public String getDisseminateComments() {
        return disseminateComments;
    }

    public void setDisseminateComments(String disseminateComments) {
        this.disseminateComments = disseminateComments;
    }
}
