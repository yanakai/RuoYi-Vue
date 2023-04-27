package com.ruoyi.coordination.index.domain.dto;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTask;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTaskFile;

import java.util.List;

public class EvaTaskAndFile extends BIndexEvaluationTask {


    private static final long serialVersionUID = 1L;

    private List<BIndexEvaluationTaskFile> fileList;

    private Long[] deptIds;

    public List<BIndexEvaluationTaskFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BIndexEvaluationTaskFile> fileList) {
        this.fileList = fileList;
    }

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }
}
