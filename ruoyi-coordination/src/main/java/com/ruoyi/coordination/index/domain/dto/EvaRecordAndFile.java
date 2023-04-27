package com.ruoyi.coordination.index.domain.dto;

import com.ruoyi.coordination.index.domain.BIndexEvaluationRecord;
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecordFile;

import java.util.List;

public class EvaRecordAndFile extends BIndexEvaluationRecord {

    private static final long serialVersionUID = 1L;

    List<BIndexEvaluationRecordFile> fileList;

    public List<BIndexEvaluationRecordFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BIndexEvaluationRecordFile> fileList) {
        this.fileList = fileList;
    }
}
