package com.ruoyi.coordination.clue.domain.dto;

import com.ruoyi.coordination.clue.domain.BClueInfoReceive;

public class BCIReceive extends BClueInfoReceive {

    private Long[] deptIds;

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }
}
