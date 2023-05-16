package com.ruoyi.coordination.pollution.domain.enums;

public enum BPPTaskLevelEnum {
    FIRST("0","Ⅰ级"),
    SECOND("1","Ⅱ级"),
    THIRD("2","Ⅲ级");
    private String name;
    private String code;
    private BPPTaskLevelEnum(String code,String name) {
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
        for (BPPTaskLevelEnum BPPTaskLevelEnum : values()) {
            if (BPPTaskLevelEnum.getCode().equals(code)) {
                return BPPTaskLevelEnum.getname();
            }
        }
        return null;
    }
}
