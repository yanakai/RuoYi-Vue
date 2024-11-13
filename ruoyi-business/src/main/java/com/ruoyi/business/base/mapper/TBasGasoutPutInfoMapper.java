package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasGasoutPutInfo;

import java.util.List;

/**
 * 基础信息--企业--废气排口Mapper接口
 *
 * @author lx
 * @date 2024-06-27
 */
public interface TBasGasoutPutInfoMapper {
    /**
     * 查询基础信息--企业--废气排口
     *
     * @param id 基础信息--企业--废气排口主键
     * @return 基础信息--企业--废气排口
     */
    TBasGasoutPutInfo selectTBasGasoutPutInfoById(Long id);

    /**
     * 查询基础信息--企业--废气排口列表
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 基础信息--企业--废气排口集合
     */
    List<TBasGasoutPutInfo> selectTBasGasoutPutInfoList(TBasGasoutPutInfo tBasGasoutPutInfo);

    /**
     * 新增基础信息--企业--废气排口
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 结果
     */
    int insertTBasGasoutPutInfo(TBasGasoutPutInfo tBasGasoutPutInfo);

    /**
     * 修改基础信息--企业--废气排口
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 结果
     */
    int updateTBasGasoutPutInfo(TBasGasoutPutInfo tBasGasoutPutInfo);

    /**
     * 删除基础信息--企业--废气排口
     *
     * @param id 基础信息--企业--废气排口主键
     * @return 结果
     */
    int deleteTBasGasoutPutInfoById(Long id);

    /**
     * 批量删除基础信息--企业--废气排口
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasGasoutPutInfoByIds(Long[] ids);

    int createTableMin(TBasGasoutPutInfo tBasGasoutPutInfo);

    int createTableHour(TBasGasoutPutInfo tBasGasoutPutInfo);

    int createTableDay(TBasGasoutPutInfo tBasGasoutPutInfo);
    int createTableReal(TBasGasoutPutInfo tBasGasoutPutInfo);
}
