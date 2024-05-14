package com.yutu.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yutu.system.domain.vo.RouterVo;
import com.yutu.common.core.domain.TreeSelect;
import com.yutu.common.core.domain.entity.SysMenu;

/**
 * 菜单 业务层
 * 
 * @author yutu
 */
public interface ISysMenuService
{
    /**
     * 根据用户查询系统菜单列表
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(Long userId);

    /**
     * 根据用户查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId);

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根据角色ID查询权限
     * 
     * @param roleId 角色ID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * 根据用户ID查询菜单树信息
     * 
     * @param userId 用户ID
     * @param systemId 子系统id
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId,Long systemId);

    /**
     * 根据角色ID查询菜单树信息
     * 
     * @param roleId 角色ID
     * @return 选中菜单列表
     */
    public List<Long> selectMenuListByRoleId(Long roleId);

    /**
     * 构建前端路由所需要的菜单
     * 
     * @param menus 菜单列表
     * @param systemId 子系统id
     * @return 路由列表
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus, Long systemId);

    /**
     * 构建前端所需要树结构
     * 
     * @param menus 菜单列表
     * @return 树结构列表
     */
    public List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * 构建前端所需要下拉树结构
     * 
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * 根据菜单ID查询信息
     * 
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * 是否存在菜单子节点
     * 
     * @param menuId 菜单ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean hasChildByMenuId(Long menuId);

    /**
     * 查询菜单是否存在角色
     * 
     * @param menuId 菜单ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkMenuExistRole(Long menuId);

    /**
     * 新增保存菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(SysMenu menu);

    /**
     * 修改保存菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(SysMenu menu);

    /**
     * 删除菜单管理信息
     * 
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(Long menuId);

    /**
     * 校验菜单名称是否唯一
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public boolean checkMenuNameUnique(SysMenu menu);

    /**
     * @title getSystemList
     * @description  获取子系统列表
     * @param params
     * @return java.util.List<com.yutu.common.core.domain.entity.SysMenu>
     * @author yanakai@126.com
     * @date   2024-02-22
     */
    List<SysMenu> getSystemList(Map<String, Object> params);
    /**
     * @title checkMenuKeyUnique
     * @description  校验子系统唯一key是否已存在
     * @param menu
     * @return boolean
     * @author yanakai@126.com
     * @date   2024-02-23
     */
    boolean checkMenuKeyUnique(SysMenu menu);
}