package com.ruoyi.framework.utils;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.ruoyi.framework.magicApi.DataCustomFunction.getProductToken;

public class DeAndEn {

    private static final String Authorization = "Basic c2FiZXI6c2FiZXJfc2VjcmV0";
    private static final String Content_Type = "application/x-www-form-urlencoded";

    //解密
    public static JSONObject decrypt(String info){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("data", info);
        String data = HttpRequest.post("http://192.168.4.25:20080/datacenter/api/blade-auth/encrypt")
                .header("Authorization", Authorization)
                .header("Content-Type", Content_Type)
                .header("blade-auth", "bearer "+getProductToken())
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        return JSONObject.parseObject(data);
    }

    //加密
    public static Object encrypt(Map<String, Object> info){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("data", info);
        String data = HttpRequest.post("http://192.168.4.25:20080/datacenter/api/blade-auth/decrypt")
                .header("Authorization", Authorization)
                .header("Content-Type", Content_Type)
                .header("blade-auth", "bearer "+getProductToken())
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        return data;
    }
}
