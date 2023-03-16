package com.ruoyi.framework.interceptor.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.interceptor.RequestInterceptor;
import org.ssssssss.magicapi.core.model.ApiInfo;
import org.ssssssss.magicapi.core.model.JsonBean;
import org.ssssssss.magicapi.core.model.Options;
import org.ssssssss.script.MagicScriptContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: yanakai@126.com
 * @CreateDate: 2023/3/15 10:17
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2023/3/15 10:17
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
//@Component
public class CustomRequestInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomRequestInterceptor.class);
    @Autowired
    private TokenService tokenService;
    /**
     * 接口请求之前
     * @param info	接口信息
     * @param context	脚本变量信息
     */
    public Object preHandle(ApiInfo info, MagicScriptContext context, HttpServletRequest request, HttpServletResponse response) throws Exception{
        SysUser user = SecurityUtils.getLoginUser().getUser(); // = XXXUtils.getUser(request);
        //SysUser user = tokenService.getLoginUser(request).getUser(); // 都可以回去当前登录者的信息
        logger.info("{} 请求接口：{}", user, info.getName());
        // 接口选项配置了需要登录
        if ("true".equals(info.getOptionValue(Options.REQUIRE_LOGIN))) {
            if (user == null) {
                return new JsonBean<>(401, "用户未登录");
            }
        }
        String role = info.getOptionValue(Options.ROLE);
        if (StringUtils.isNotBlank(role) && user.isAdmin()) {
            return new JsonBean<>(403, "用户权限不足");
        }
        String permission = info.getOptionValue(Options.PERMISSION);
        if (StringUtils.isNotBlank(permission) /* && user.hasPermission(permission)*/) {
            return new JsonBean<>(403, "用户权限不足");
        }
        return null;
    }
    /**
     * 接口执行之后
     * @param info	接口信息
     * @param context	变量信息
     * @param value 即将要返回到页面的值
     */
    public Object postHandle(ApiInfo info, MagicScriptContext context, Object value, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("{} 执行完毕，返回结果:{}", info.getName(), value);
        return null;
    }


}
