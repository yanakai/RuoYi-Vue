package com.ruoyi.coordination.pollution.domain.dto;

import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTaskFile;

import java.util.List;

public class BPPTaskAndFile extends BPollutionPreventionTask {

    private List<BPollutionPreventionTaskFile> fileList;

    private Long[] deptIds;



    public List<BPollutionPreventionTaskFile> getFileList() {
        return fileList;
    }
    public void setFileList(List<BPollutionPreventionTaskFile> fileList) {
        this.fileList = fileList;
    }

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }

}
