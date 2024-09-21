package com.ruoyi.framework.aspectj;

import com.ruoyi.common.annotation.DataEntScope;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * 数据过滤处理
 *
 * @author ruoyi
 */
@Aspect
@Component
public class DataEntScopeAspect {

    /**
     * 根据用户所属企业过滤权限
     */
    public static final String DATA_ENT_SCOPE = "dataEntScope";

    public static void entDataScopeFilter(JoinPoint joinPoint, SysUser user) {
        StringBuilder sqlString = new StringBuilder();
        String entCode = user.getEntCode();
        if(StringUtils.isNotEmpty(entCode)){
            sqlString.append(StringUtils.format(" and  ent_code = '{}' ", entCode));
        }
        String entName = user.getEntName();
        if(StringUtils.isNotEmpty(entName)){
            sqlString.append(StringUtils.format(" and  ent_name = '{}' ", entName));
        }

        Object params = joinPoint.getArgs()[0];
        if (StringUtils.isNotNull(params) && params instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) params;
            baseEntity.getParams().put(DATA_ENT_SCOPE, " AND (" + sqlString.substring(5) + ")");
        }
    }




    @Before("@annotation(controllerDataScope)")
    public void doBefore(JoinPoint point, DataEntScope controllerDataScope) throws Throwable {
        clearDataScope(point);
        handleDataScope(point, controllerDataScope);
    }

    protected void handleDataScope(final JoinPoint joinPoint, DataEntScope controllerDataScope) {
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (StringUtils.isNotNull(loginUser)) {
            SysUser currentUser = loginUser.getUser();
            //用户只能查看当前企业数据权限过滤，超级管理员 不过滤
            if (StringUtils.isNotNull(currentUser) && !currentUser.isAdmin()) {
                entDataScopeFilter(joinPoint, currentUser);
            }
        }
    }

    /**
     * 拼接权限sql前先清空params.dataScope参数防止注入
     */
    private void clearDataScope(final JoinPoint joinPoint) {
        Object params = joinPoint.getArgs()[0];
        if (StringUtils.isNotNull(params) && params instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) params;
            baseEntity.getParams().put(DATA_ENT_SCOPE, "");
        }
    }
}
