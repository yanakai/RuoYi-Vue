package com.ruoyi.business.statisticsAlarm.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum OutPutEnum {
    GASOUT("gasout","废气"),WATEROUT("waterout","废水");
    //gasout,waterout;
    private String code;
    private String name;
    OutPutEnum(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
