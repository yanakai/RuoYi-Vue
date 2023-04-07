package com.ruoyi.framework.magicApi;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.config.MagicFunction;
import org.ssssssss.script.annotation.Comment;
import org.ssssssss.script.annotation.Function;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @BelongsProject: RuoYi-Vue
 * @BelongsPackage: com.ruoyi.framework.magicApi
 * @Author: yanakai@126.com
 * @CreateTime: 2023-04-07  13:23
 * @Description: 自定义magic-api的函数
 * @Version: 1.0
 */
@Component
public class TokenCustomFunction implements MagicFunction {

    @Function
    @Comment("获取大气新产品的token值")
    public Object getProductToken(){
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
