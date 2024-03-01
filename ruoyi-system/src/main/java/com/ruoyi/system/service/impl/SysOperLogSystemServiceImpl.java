package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.ip.AddressUtils;
import com.ruoyi.common.utils.ip.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysOperLogSystemMapper;
import com.ruoyi.system.domain.SysOperLogSystem;
import com.ruoyi.system.service.ISysOperLogSystemService;

/**
 * 访问日志Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-01
 */
@Service
public class SysOperLogSystemServiceImpl implements ISysOperLogSystemService
{
    @Autowired
    private SysOperLogSystemMapper sysOperLogSystemMapper;

    /**
     * 查询访问日志
     *
     * @param operId 访问日志主键
     * @return 访问日志
     */
    @Override
    public SysOperLogSystem selectSysOperLogSystemByOperId(Long operId)
    {
        return sysOperLogSystemMapper.selectSysOperLogSystemByOperId(operId);
    }

    /**
     * 查询访问日志列表
     *
     * @param sysOperLogSystem 访问日志
     * @return 访问日志
     */
    @Override
    public List<SysOperLogSystem> selectSysOperLogSystemList(SysOperLogSystem sysOperLogSystem)
    {
        return sysOperLogSystemMapper.selectSysOperLogSystemList(sysOperLogSystem);
    }

    /**
     * 新增访问日志
     *
     * @param sysOperLogSystem 访问日志
     * @return 结果
     */
    @Override
    public int insertSysOperLogSystem(SysOperLogSystem sysOperLogSystem){
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        // 判断保存日志时是否登录
        if (loginUser != null){
            sysOperLogSystem.setOperNameId(loginUser.getUserId());
            sysOperLogSystem.setOperName(loginUser.getUser().getNickName());
            sysOperLogSystem.setDeptId(loginUser.getDeptId());
            sysOperLogSystem.setDeptName(loginUser.getUser().getDept().getDeptName());
        }
        // 前端传入接口来源为空时默认为 0 其它来源
        if(sysOperLogSystem.getOperatorType()==null) sysOperLogSystem.setOperatorType(0L);
        sysOperLogSystem.setOperIp(IpUtils.getIpAddr());
        sysOperLogSystem.setOperUrl(StringUtils.substring(ServletUtils.getRequest().getRequestURI(), 0, 255));
        // 当前端请求传参为空时，默认操作类型为 10 查询操作
        if(sysOperLogSystem.getBusinessType() == null)sysOperLogSystem.setBusinessType(10L);
        sysOperLogSystem.setRequestMethod(ServletUtils.getRequest().getMethod());
        sysOperLogSystem.setOperTime(DateUtils.getNowDate());
        sysOperLogSystem.setOperLocation(AddressUtils.getRealAddressByIP(sysOperLogSystem.getOperIp()));
        return sysOperLogSystemMapper.insertSysOperLogSystem(sysOperLogSystem);
    }

    /**
     * 修改访问日志
     *
     * @param sysOperLogSystem 访问日志
     * @return 结果
     */
    @Override
    public int updateSysOperLogSystem(SysOperLogSystem sysOperLogSystem)
    {
        return sysOperLogSystemMapper.updateSysOperLogSystem(sysOperLogSystem);
    }

    /**
     * 批量删除访问日志
     *
     * @param operIds 需要删除的访问日志主键
     * @return 结果
     */
    @Override
    public int deleteSysOperLogSystemByOperIds(Long[] operIds)
    {
        return sysOperLogSystemMapper.deleteSysOperLogSystemByOperIds(operIds);
    }

    /**
     * 删除访问日志信息
     *
     * @param operId 访问日志主键
     * @return 结果
     */
    @Override
    public int deleteSysOperLogSystemByOperId(Long operId)
    {
        return sysOperLogSystemMapper.deleteSysOperLogSystemByOperId(operId);
    }
}
