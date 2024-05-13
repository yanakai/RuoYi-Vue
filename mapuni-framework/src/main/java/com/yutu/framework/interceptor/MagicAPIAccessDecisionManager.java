package com.yutu.framework.interceptor;

import com.yutu.common.utils.StringUtils;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.ssssssss.magicapi.core.web.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @Description:
 * @Author: yanakai@126.com
 * @CreateDate: 2023/3/15 15:10
 * @UpdateUser: yanakai@126.com
 * @UpdateDate: 2023/3/15 15:10
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MagicAPIAccessDecisionManager implements AccessDecisionManager {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    public MagicAPIAccessDecisionManager(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        FilterInvocation invocation = (FilterInvocation) object;
        HttpServletRequest request = invocation.getHttpRequest();
        Object handler = null;
        try {
            handler = requestMappingHandlerMapping.getHandler(request).getHandler();
        } catch (Exception ignored) {
        }
        if(handler != null && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 提取处理类，判断是否是`magic-api`的处理器
            if(RequestHandler.class == handlerMethod.getBean().getClass()){
                return;
            }
        }
        String token = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(token)) {
            return;
        }
        if(configAttributes.stream()
                .map(Object::toString)
                .anyMatch(it -> it.equals("permitAll") || it.equals("anonymous"))){
            return;
        }
        throw new AccessDeniedException("Access is denied.");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
