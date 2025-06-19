package com.ruoyi.business.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum OutPutTypeEnum {
    OUT_PUT_FS(1,"废水"),
    OUT_PUT_FQ(2,"废气"),
    OUT_PUT_WZZ(3,"扬尘"),
    OUT_PUT_VOC(4,"VOC"),
    ;

    public final Integer code;
    public final String name;

    // 使用ConcurrentHashMap保证线程安全
    private static final Map<Integer, String> CODE_TO_NAME =
            Arrays.stream(OutPutTypeEnum.values())
                    .collect(Collectors.toConcurrentMap(
                            e -> e.code,
                            e -> e.name
                    ));

    OutPutTypeEnum(Integer code, String name){
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
