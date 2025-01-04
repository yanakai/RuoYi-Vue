package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.TBasUserPutInfo;

/**
 * 用户收藏关注排口信息Mapper接口
 * 
 * @author liux
 * @date 2025-01-04
 */
public interface TBasUserPutInfoMapper 
{
    /**
     * 查询用户收藏关注排口信息
     * 
     * @param id 用户收藏关注排口信息主键
     * @return 用户收藏关注排口信息
     */
    public TBasUserPutInfo selectTBasUserPutInfoById(Long id);

    /**
     * 查询用户收藏关注排口信息列表
     * 
     * @param tBasUserPutInfo 用户收藏关注排口信息
     * @return 用户收藏关注排口信息集合
     */
    public List<TBasUserPutInfo> selectTBasUserPutInfoList(TBasUserPutInfo tBasUserPutInfo);

    /**
     * 新增用户收藏关注排口信息
     * 
     * @param tBasUserPutInfo 用户收藏关注排口信息
     * @return 结果
     */
    public int insertTBasUserPutInfo(TBasUserPutInfo tBasUserPutInfo);

    /**
     * 修改用户收藏关注排口信息
     * 
     * @param tBasUserPutInfo 用户收藏关注排口信息
     * @return 结果
     */
    public int updateTBasUserPutInfo(TBasUserPutInfo tBasUserPutInfo);

    /**
     * 删除用户收藏关注排口信息
     * 
     * @param id 用户收藏关注排口信息主键
     * @return 结果
     */
    public int deleteTBasUserPutInfoById(Long id);

    /**
     * 批量删除用户收藏关注排口信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBasUserPutInfoByIds(Long[] ids);

    /**
     * 根据ID获取废气排口信息
     * @param id ID
     *
     */
    List<Map<String, Object>> selectTBasGasoutPutInfo(Long id);

    /**
     * 根据ID获取废水排口信息
     * @param id ID
     *
     */
    List<Map<String, Object>> selectTBasWaterPutInfo(Long id);


}
