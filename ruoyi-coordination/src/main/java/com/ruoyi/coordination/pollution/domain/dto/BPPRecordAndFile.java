package com.ruoyi.coordination.pollution.domain.dto;

import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecord;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecordFile;

import java.util.List;

public class BPPRecordAndFile extends BPollutionPreventionRecord {

    private List<BPollutionPreventionRecordFile> fileList;

    public List<BPollutionPreventionRecordFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<BPollutionPreventionRecordFile> fileList) {
        this.fileList = fileList;
    }
}
