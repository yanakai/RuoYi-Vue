package com.yutu.framework.security.handle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import com.alibaba.fastjson2.JSON;
import com.yutu.common.constant.Constants;
import com.yutu.common.core.domain.AjaxResult;
import com.yutu.common.core.domain.model.LoginUser;
import com.yutu.common.utils.MessageUtils;
import com.yutu.common.utils.ServletUtils;
import com.yutu.common.utils.StringUtils;
import com.yutu.framework.manager.AsyncManager;
import com.yutu.framework.manager.factory.AsyncFactory;
import com.yutu.framework.web.service.TokenService;

/**
 * 自定义退出处理类 返回成功
 * 
 * @author yutu
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     * 
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)){
            String systemKey = Constants.SYSTEM_KEY;
            // 判断退出登录方法是否传子系统的key，为空则默认赋后台系统的key
            if(StringUtils.isNotNull(request.getParameter("systemKey"))) systemKey = request.getParameter("systemKey");
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, systemKey, MessageUtils.message("user.logout.success")));
        }
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.success(MessageUtils.message("user.logout.success"))));
    }
}
