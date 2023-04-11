package com.ruoyi.framework.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.ruoyi.framework.magicApi.DataCustomFunction.getProductToken;

public class DeAndEn {

    private static final String Authorization = "Basic c2FiZXI6c2FiZXJfc2VjcmV0";
    private static final String Content_Type = "application/x-www-form-urlencoded";

    //解密
    public static JSONObject decrypt(String info,String token){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("data", info);
        String data = HttpRequest.post("http://192.168.4.25:20080/datacenter/api/blade-auth/encrypt")
                .header("Authorization", Authorization)
                .header("Content-Type", Content_Type)
                .header("blade-auth", "bearer "+token)
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        return JSONObject.parseObject(data);
    }

    //加密
    public static Object encrypt(Map<String, Object> info,String token){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("data",JSONUtil.parse(info).toString());
        String data = HttpRequest.post("http://192.168.4.25:20080/datacenter/api/blade-auth/decrypt")
                .header("Authorization", Authorization)
                .header("Content-Type", Content_Type)
                .header("blade-auth", "bearer "+token)
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        params.put("data",data);
        return params;
    }

    public static void main(String[] args) {
        Map<String, Object> params = new LinkedHashMap<>();
        Map<String,Object> info = new HashMap<>();
        info.put("provinceCode", "8ebea7a3eec24b0ba1692380f8f74ce2");
        info.put("cityCodes","3ce09c117a5b4cf7a8eb91eac12aa9d9");
        info.put("type","hour");
        info.put("districtQuery",0);
        info.put("airType",1);
        info.put("futureControl","");
        params.put("data", JSONUtil.parse(info).toString());
        String data = HttpRequest.post("http://192.168.4.25:20080/datacenter/api/blade-auth/decrypt")
                .header("Authorization", Authorization)
                .header("Content-Type", Content_Type)
                .header("blade-auth", "bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJpc3N1c2VyIiwiYXVkIjoiYXVkaWVuY2UiLCJ0ZW5hbnRfaWQiOiIwMDAwMDAiLCJyb2xlX25hbWUiOiJidXRsZXIiLCJwb3N0X2lkIjoiMTEyMzU5ODgxNzczODY3NTIwNiIsInVzZXJfaWQiOiIxNjQxMzYzMjY0MzA0ODE2MTI5Iiwicm9sZV9pZCI6IjE2NDEzNjI1ODM3ODczODA3MzgiLCJ1c2VyX25hbWUiOiJ0ZW1wbyIsIm5pY2tfbmFtZSI6InRlbXBvIiwiZGV0YWlsIjp7InR5cGUiOiJ3ZWIiLCJyZWdpb25MaW1pdCI6MSwicmVnaW9uIjp7ImN1cnJlbnRSZWdpb25LZXkiOiIzY2UwOWMxMTdhNWI0Y2Y3YThlYjkxZWFjMTJhYTlkOSIsInJlZ2lvbkNvZGUiOiIzNDAxMDAiLCJjaXR5V2VhdGhlckNvZGUiOiIxMDEyMjAxMDEiLCJsYXRpdHVkZSI6MzEuODYxMTksImxvbmdpdHVkZSI6MTE3LjI4MzA0MiwiY3VycmVudFJlZ2lvbk5hbWUiOiLlkIjogqXluIIiLCJjdXJyZW50UmVnaW9uTGV2ZWwiOjEsInByb3ZpbmNlS2V5IjoiOGViZWE3YTNlZWMyNGIwYmExNjkyMzgwZjhmNzRjZTIiLCJwcm92aW5jZU5hbWUiOiLlronlvr3nnIEiLCJjaXR5S2V5IjoiM2NlMDljMTE3YTViNGNmN2E4ZWI5MWVhYzEyYWE5ZDkiLCJjaXR5TmFtZSI6IuWQiOiCpeW4giJ9LCJjaXR5Q29kZSI6IjM0MDEwMCIsImluZGV4IjpbXSwiaXNUb3duIjoxLCJzaXR1YXRpb24iOjQsImR1dHlJZCI6IiJ9LCJ0b2tlbl90eXBlIjoiYWNjZXNzX3Rva2VuIiwiZGVwdF9pZCI6IjExMjM1OTg4MTM3Mzg2NzUyMDMiLCJhY2NvdW50IjoidGVtcG8iLCJjbGllbnRfaWQiOiJzYWJlciIsImV4cCI6MTY4MTE5MzA2NSwibmJmIjoxNjgxMTg5NDY1fQ.MysGvr1J6onatpxqTpj13Z5wL7h96dmgcetSnAoR0Ij29B4xWrqGra-MGsw8-ETNSmAqPFe-ZRjAiarBGAWrfA")
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        params.put("data",data);
        System.out.println(params.toString());

    }
}
