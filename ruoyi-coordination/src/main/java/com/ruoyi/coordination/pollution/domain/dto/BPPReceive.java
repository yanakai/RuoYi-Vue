package com.ruoyi.coordination.pollution.domain.dto;

import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;


public class BPPReceive extends BPollutionPreventionReceive {

    private Long[] deptIds;

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }
}
