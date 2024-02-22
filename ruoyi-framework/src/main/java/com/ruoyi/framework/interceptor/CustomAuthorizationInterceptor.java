package com.ruoyi.framework.interceptor;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.TokenService;
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
    private SysLoginService loginService;

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
        if(StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)){
            String token = loginService.login(username, password, UserConstants.FREE_CAPTCHA,"","");
            MagicUser magicUser = new MagicUser("",username,token);
            return magicUser;   // 从token中获取MagicUser对象
        }
        throw new MagicLoginException("用户名或密码不正确");
    }
}
