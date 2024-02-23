package com.ruoyi.framework.interceptor.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.context.MagicUser;
import org.ssssssss.magicapi.core.exception.MagicLoginException;
import org.ssssssss.magicapi.core.interceptor.AuthorizationInterceptor;

/**
 * @Description:
 * @Author: yanakai@126.com
 * @CreateDate: 2023/3/15 17:37
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2023/3/15 17:37
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Component
public class CustomAuthorizationInterceptor implements AuthorizationInterceptor {

    @Autowired
    private TokenService tokenService;


    /**
     * 配置是否需要登录
     */
    @Override
    public boolean requireLogin() {
        return true;
    }

    /**
     * 根据Token获取User
     */
    @Override
    public MagicUser getUserByToken(String token) throws MagicLoginException {
        LoginUser loginUser = tokenService.getLoginUser(token);
        if (loginUser != null) {
            MagicUser magicUser = new MagicUser("",loginUser.getUsername(),loginUser.getToken());
            return magicUser;   // 从token中获取MagicUser对象
        }
        throw new MagicLoginException("token无效");
    }

    @Override
    public MagicUser login(String username, String password) throws MagicLoginException {
        // 根据实际情况进行修改，如查询数据库。。
        if("admin".equals(username) && "admin".equals(password)){
            // 登录成功后 构造MagicUser对象。
            return new MagicUser("1","admin","tokenvalue......");
        }
        throw new MagicLoginException("用户名或密码不正确");
    }
}
