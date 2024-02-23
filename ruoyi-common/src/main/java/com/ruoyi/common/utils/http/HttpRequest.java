package com.ruoyi.common.utils.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @Description: http 请求工具类
 * @Author: yanakai@126.com
 * @CreateDate: 2024-02-23 15:11
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2024-02-23 15:11
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class HttpRequest {
    private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);

    /**
     * @title post
     * @description  http请求 用户参数在body中传参
     * @param httpUrl  请求地址
     * @param paramsObject  参数对象
     * @return java.lang.String
     * @author yanakai@126.com
     * @date   2024-02-23
     */
    public static String post(String httpUrl, String paramsObject,String token) throws IOException {
        URL url = new URL(httpUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization","Bearer "+token);
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = paramsObject.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int code = connection.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed : HTTP error code : " + code + " for URL : " + httpUrl);
        }

        // 如果需要处理响应内容
        try (InputStream is = connection.getInputStream();
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

}
