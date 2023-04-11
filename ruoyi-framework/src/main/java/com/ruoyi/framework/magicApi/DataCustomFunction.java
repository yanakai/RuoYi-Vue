package com.ruoyi.framework.magicApi;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.framework.utils.DeAndEn;
import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.config.MagicFunction;
import org.ssssssss.script.annotation.Comment;
import org.ssssssss.script.annotation.Function;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @BelongsProject: RuoYi-Vue
 * @BelongsPackage: com.ruoyi.framework.magicApi
 * @Author: yanakai@126.com
 * @CreateTime: 2023-04-07  15:50
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class DataCustomFunction implements MagicFunction {

    @Resource
    private TokenCustomFunction tokenCustomFunction;

    @Function
    @Comment("查询空气数据公共函数")
    public Object getAirDataFunction(String url, Map<String, Object> params,String userName,String password){
        String data = HttpRequest.post(url)
                .header("blade-auth", "bearer "+tokenCustomFunction.getProductToken(userName,password))
                .header("Authorization", "Basic c2FiZXI6c2FiZXJfc2VjcmV0")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        return JSONObject.parseObject(data).get("data");
    }

    @Function
    @Comment("查询空气质量现状")
    public Object getNowAirDataFunction(String url, Map<String, Object> params,String userName,String password){
        String token = (String) tokenCustomFunction.getProductToken(userName, password);
        Map<String,Object> encrypt = (Map<String, Object>) DeAndEn.encrypt(params, token);

        String data = HttpRequest.post(url)
                .header("blade-auth", "bearer "+token)
                .header("Authorization", "Basic c2FiZXI6c2FiZXJfc2VjcmV0")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .form(encrypt)
                .timeout(2000)
                .execute()
                .body();
        return DeAndEn.decrypt(data,token).get("data");
    }

    public static void main(String[] args) {
        String url= "http://air.mapuni.cn//datacenter/api/v1/data/air/station/general/station/newest/real";
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("cityCodes", "f5136eab");
        params.put("stationClassificat", "S-10");
        params.put("type", 3);
        String data = HttpRequest.post(url)
                .header("blade-auth", "bearer "+getProductToken())
                .header("Authorization", "Basic c2FiZXI6c2FiZXJfc2VjcmV0")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        System.out.println(data);
    }

    public static String getProductToken(){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("username", "hefei");
        params.put("password", "e18484866adbff0e96b6b82942b2650e");
        params.put("grant_type", "password");
        params.put("tenantId", "000000");
        String data = HttpRequest.post("http://air.mapuni.cn/datacenter/api/blade-auth/oauth/token")
                .header("Authorization", "Basic c2FiZXI6c2FiZXJfc2VjcmV0")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .form(params)
                .timeout(2000)
                .execute()
                .body();
        return JSONObject.parseObject(data).get("access_token").toString();
    }
}
