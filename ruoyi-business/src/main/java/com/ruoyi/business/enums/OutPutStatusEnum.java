package com.ruoyi.business.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum OutPutStatusEnum {
    STATUS_YX(1,"运行"),
    STATUS_TZ(2,"停止"),
    STATUS_JX(3,"检修"),
    ;
    public final Integer code;
    public final String name;

    // 使用ConcurrentHashMap保证线程安全
    private static final Map<Integer, String> CODE_TO_NAME =
            Arrays.stream(OutPutStatusEnum.values())
                    .collect(Collectors.toConcurrentMap(
                            e -> e.code,
                            e -> e.name
                    ));

    OutPutStatusEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        if (CODE_TO_NAME.containsKey(code)) {
            return CODE_TO_NAME.get(code);
        }
        return "";
    }
}
