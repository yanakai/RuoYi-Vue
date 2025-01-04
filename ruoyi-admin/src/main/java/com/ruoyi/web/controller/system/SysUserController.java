package com.ruoyi.web.controller.system;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.business.base.service.ITBasEnterpriseService;
import com.ruoyi.system.domain.TBasUserPutInfo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.*;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Api(value = "系统管理-用户管理", tags = "系统管理-用户管理")
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysPostService postService;

    @Resource
    private ITBasEnterpriseService tBasEnterpriseService;

    /**
     * 获取用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user) {
        startPage();
        LoginUser loginUser = getLoginUser();
        user.setEntCode(loginUser.getUser().getEntCode());
        user.setEntName(loginUser.getUser().getEntName());
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUser user) {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = userService.importUser(userList, updateSupport, operName);
        return success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.importTemplateExcel(response, "用户数据");
    }

    /**
     * 根据用户编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = {"/", "/{userId}"})
    public AjaxResult getInfo(@PathVariable(value = "userId", required = false) Long userId) {
        userService.checkUserDataScope(userId);
        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        ajax.put("posts", postService.selectPostAll());
        if (StringUtils.isNotNull(userId)) {
            SysUser sysUser = userService.selectUserById(userId);
            ajax.put(AjaxResult.DATA_TAG, sysUser);
            ajax.put("postIds", postService.selectPostListByUserId(userId));
            ajax.put("roleIds", sysUser.getRoles().stream().map(SysRole::getRoleId).collect(Collectors.toList()));
        }
        return ajax;
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysUser user) {
        deptService.checkDeptDataScope(user.getDeptId());
        roleService.checkRoleDataScope(user.getRoleIds());
        if (!userService.checkUserNameUnique(user)) {
            return error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user)) {
            return error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user)) {
            return error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setCreateBy(getUsername());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));

        if(StringUtils.isNull(user.getEntCode()) && StringUtils.isNull(user.getEntName())){
            LoginUser loginUser = getLoginUser();
            user.setEntCode(loginUser.getUser().getEntCode());
            user.setEntName(loginUser.getUser().getEntName());
            user.setSocialCreditCode(loginUser.getUser().getSocialCreditCode());
        }

//        //获取企业信息
//        TBasEnterpriseBaseInfoDto tBasEnterprise = new TBasEnterpriseBaseInfoDto();
//        tBasEnterprise.setEntCode(user.getEntCode());
//        tBasEnterprise.setEntName(user.getEntName());
//        tBasEnterprise.setSocialCreditCode(user.getSocialCreditCode());
//        List<TBasEnterpriseBaseInfoDto> tBasEnterpriseBaseList = tBasEnterpriseService.selectTBasEnterpriseBaseList(tBasEnterprise);
//        if(ObjectUtil.isNotEmpty(tBasEnterpriseBaseList)){
//            TBasEnterpriseBaseInfoDto tBasEnterpriseBaseInfoDto = tBasEnterpriseBaseList.get(0);
//            user.setEntCode(tBasEnterpriseBaseInfoDto.getEntCode());
//            user.setEntName(tBasEnterpriseBaseInfoDto.getEntName());
//            user.setSocialCreditCode(tBasEnterpriseBaseInfoDto.getSocialCreditCode());
//        }

        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        deptService.checkDeptDataScope(user.getDeptId());
        roleService.checkRoleDataScope(user.getRoleIds());
        if (!userService.checkUserNameUnique(user)) {
            return error("修改用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user)) {
            return error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user)) {
            return error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        if (ArrayUtils.contains(userIds, getUserId())) {
            return error("当前用户不能删除");
        }
        return toAjax(userService.deleteUserByIds(userIds));
    }

    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('system:user:resetPwd')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(getUsername());
        return toAjax(userService.resetPwd(user));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUserStatus(user));
    }

    /**
     * 根据用户编号获取授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/authRole/{userId}")
    public AjaxResult authRole(@PathVariable("userId") Long userId) {
        AjaxResult ajax = AjaxResult.success();
        SysUser user = userService.selectUserById(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        ajax.put("user", user);
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return ajax;
    }

    /**
     * 用户授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.GRANT)
    @PutMapping("/authRole")
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds) {
        userService.checkUserDataScope(userId);
        roleService.checkRoleDataScope(roleIds);
        userService.insertUserAuth(userId, roleIds);
        return success();
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept) {
        return success(deptService.selectDeptTreeList(dept));
    }

    @Resource
    private ITBasUserPutInfoService tBasUserPutInfoService;

    /**
     * 用户关注排口
     */
    @Log(title = "用户关注", businessType = BusinessType.GRANT)
    @PostMapping("/authOutPut")
    public AjaxResult insertAuthPut(String monitorPointType,int outPutId) {
        LoginUser loginUser = getLoginUser();
        TBasUserPutInfo tBasUserPutInfo = new TBasUserPutInfo();
        tBasUserPutInfo.setUserId(loginUser.getUser().getUserId());
        List<TBasUserPutInfo> tBasUserPutInfos = tBasUserPutInfoService.selectTBasUserPutInfoList(tBasUserPutInfo);
        if(tBasUserPutInfos.size() >= 10){
            return error("最多关注10个排口");
        }

        tBasUserPutInfo.setLoginName(loginUser.getUsername());
        tBasUserPutInfo.setMonitorPointType(String.valueOf(monitorPointType));
        tBasUserPutInfo.setOutPutId(outPutId);

        //删除之前关联的排口
        List<TBasUserPutInfo> l = tBasUserPutInfoService.selectTBasUserPutInfoList(tBasUserPutInfo);
        if(ObjUtil.isNotEmpty(l)){
            tBasUserPutInfoService.deleteTBasUserPutInfoById(l.get(0).getId());
        }

        tBasUserPutInfo.setCreateTime(new Date());
        if(StrUtil.equals("1",monitorPointType)){
            //废水
            List<Map<String, Object>> list = tBasUserPutInfoService.selectTBasWaterPutInfo((long) outPutId);
            if (ObjUtil.isNotEmpty(list)) {
                tBasUserPutInfo.setEntCode((String) list.get(0).get("ent_code"));
                tBasUserPutInfo.setEntName((String) list.get(0).get("ent_name"));
                tBasUserPutInfo.setOutPutCode((String) list.get(0).get("out_put_code"));
                tBasUserPutInfo.setOutPutName((String) list.get(0).get("out_put_name"));
            }else {
                return error("排口信息不存在");
            }
        }else if(StrUtil.equals("2",monitorPointType)){
            //废气
            List<Map<String, Object>> list = tBasUserPutInfoService.selectTBasGasoutPutInfo((long) outPutId);
            if (ObjUtil.isNotEmpty(list)) {
                tBasUserPutInfo.setEntCode((String) list.get(0).get("ent_code"));
                tBasUserPutInfo.setEntName((String) list.get(0).get("ent_name"));
                tBasUserPutInfo.setOutPutCode((String) list.get(0).get("out_put_code"));
                tBasUserPutInfo.setOutPutName((String) list.get(0).get("out_put_name"));
            }else {
                return error("排口信息不存在");
            }
        }
        tBasUserPutInfoService.insertTBasUserPutInfo(tBasUserPutInfo);
        return success();
    }

    @Log(title = "用户取消关注", businessType = BusinessType.GRANT)
    @DeleteMapping("/delAuthOutPut")
    public AjaxResult deleteAuthPut(String monitorPointType,int outPutId) {
        LoginUser loginUser = getLoginUser();
        TBasUserPutInfo tBasUserPutInfo = new TBasUserPutInfo();
        tBasUserPutInfo.setUserId(loginUser.getUser().getUserId());
        tBasUserPutInfo.setLoginName(loginUser.getUsername());
        tBasUserPutInfo.setMonitorPointType(String.valueOf(monitorPointType));
        tBasUserPutInfo.setOutPutId(outPutId);
        List<TBasUserPutInfo> list = tBasUserPutInfoService.selectTBasUserPutInfoList(tBasUserPutInfo);
        if(ObjUtil.isEmpty(list)){
            return error("未关注该排口");
        }else{
            tBasUserPutInfoService.deleteTBasUserPutInfoById(list.get(0).getId());
        }
        return success();
    }
}
