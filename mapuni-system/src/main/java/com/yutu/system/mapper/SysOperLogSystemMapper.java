package com.yutu.system.mapper;

import java.util.List;
import com.yutu.system.domain.SysOperLogSystem;

/**
 * 访问日志Mapper接口
 *
 * @author yutu
 * @date 2024-03-01
 */
public interface SysOperLogSystemMapper
{
    /**
     * 查询访问日志
     *
     * @param operId 访问日志主键
     * @return 访问日志
     */
    public SysOperLogSystem selectSysOperLogSystemByOperId(Long operId);

    /**
     * 查询访问日志列表
     *
     * @param sysOperLogSystem 访问日志
     * @return 访问日志集合
     */
    public List<SysOperLogSystem> selectSysOperLogSystemList(SysOperLogSystem sysOperLogSystem);

    /**
     * 新增访问日志
     *
     * @param sysOperLogSystem 访问日志
     * @return 结果
     */
    public int insertSysOperLogSystem(SysOperLogSystem sysOperLogSystem);

    /**
     * 修改访问日志
     *
     * @param sysOperLogSystem 访问日志
     * @return 结果
     */
    public int updateSysOperLogSystem(SysOperLogSystem sysOperLogSystem);

    /**
     * 删除访问日志
     *
     * @param operId 访问日志主键
     * @return 结果
     */
    public int deleteSysOperLogSystemByOperId(Long operId);

    /**
     * 批量删除访问日志
     *
     * @param operIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysOperLogSystemByOperIds(Long[] operIds);
}
