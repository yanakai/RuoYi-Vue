package com.ruoyi.coordination.pollution.domain.enums;

public enum BPPTaskTypeEnum {
    AIR("0","大气"),
    WATER("1","水质");
    private String name;
    private String code;
    private BPPTaskTypeEnum(String code,String name) {
        this.code=code;
        this.name = name;
    }
    
    public String getname() {
        return name;
    }
    public void setname(String code,String name) {
        this.code=code;
        this.name = name;
    }
    
    public String operation(){
        return this.name;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public static String getByValue(String code) {
        for (BPPTaskTypeEnum BPPTaskTypeEnum : values()) {
            if (BPPTaskTypeEnum.getCode().equals(code)) {
                return BPPTaskTypeEnum.getname();
            }
        }
        return null;
    }
}
