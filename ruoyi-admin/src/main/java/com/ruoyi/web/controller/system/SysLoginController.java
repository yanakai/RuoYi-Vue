package com.ruoyi.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ruoyi.system.domain.SysOperLog;
import com.ruoyi.system.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private ISysOperLogService operLogService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid(),loginBody.getSystemKey());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *   TODO 由于引入子系统的权限集中管理，重构之前的获取路由信息代码
     * @return 路由信息
     */
    /*@GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }*/

    /**
     * @title getRouters
     * @description  获取路由信息
     * @param systemId   子系统ID
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author yanakai@126.com
     * @date   2024-02-22
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters(Long systemId)
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId,systemId);
        return AjaxResult.success(menuService.buildMenus(menus,systemId));
    }

    /**
     * @title getSystemList
     * @description  获取子系统列表
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author yanakai@126.com
     * @date   2024-02-22
     */
    @GetMapping("/getSystemList")
    public AjaxResult getSystemList(){
        Map<String, Object> params = new HashMap<>();
        return AjaxResult.success(menuService.getSystemList(params));
    }

    /**
     * @title saveSysOperLog
     * @description  保存子系统的传来的操作日志信息
     * @param operLog
     * @return com.ruoyi.common.core.domain.AjaxResult
     * @author yanakai@126.com
     * @date   2024-02-23
     */
    @PostMapping("/saveSysOperLog")
    public AjaxResult saveSysOperLog(@RequestBody SysOperLog operLog){
        return AjaxResult.success(operLogService.insertOperlog(operLog));
    }


}
