package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasWateroutPutInfo;

import java.util.List;

/**
 * 基础信息--企业--废水排口Mapper接口
 *
 * @author lx
 * @date 2024-06-27
 */
public interface TBasWateroutPutInfoMapper {
    /**
     * 查询基础信息--企业--废水排口
     *
     * @param id 基础信息--企业--废水排口主键
     * @return 基础信息--企业--废水排口
     */
    TBasWateroutPutInfo selectTBasWateroutPutInfoById(Long id);

    /**
     * 查询基础信息--企业--废水排口列表
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 基础信息--企业--废水排口集合
     */
    List<TBasWateroutPutInfo> selectTBasWateroutPutInfoList(TBasWateroutPutInfo tBasWateroutPutInfo);

    /**
     * 新增基础信息--企业--废水排口
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 结果
     */
    int insertTBasWateroutPutInfo(TBasWateroutPutInfo tBasWateroutPutInfo);

    /**
     * 修改基础信息--企业--废水排口
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 结果
     */
    int updateTBasWateroutPutInfo(TBasWateroutPutInfo tBasWateroutPutInfo);

    /**
     * 删除基础信息--企业--废水排口
     *
     * @param id 基础信息--企业--废水排口主键
     * @return 结果
     */
    int deleteTBasWateroutPutInfoById(Long id);

    /**
     * 批量删除基础信息--企业--废水排口
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasWateroutPutInfoByIds(Long[] ids);

    int createTableReal(TBasWateroutPutInfo tBasWateroutPutInfo);
    int createTableMin(TBasWateroutPutInfo tBasWateroutPutInfo);
    int createTableHour(TBasWateroutPutInfo tBasWateroutPutInfo);
    int createTableDay(TBasWateroutPutInfo tBasWateroutPutInfo);
}
