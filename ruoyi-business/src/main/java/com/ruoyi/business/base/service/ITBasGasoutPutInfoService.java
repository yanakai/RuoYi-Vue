package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.TBasGasoutPutInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 基础信息--企业--废气排口Service接口
 *
 * @author lx
 * @date 2024-06-27
 */
public interface ITBasGasoutPutInfoService {
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
     * 批量删除基础信息--企业--废气排口
     *
     * @param ids 需要删除的基础信息--企业--废气排口主键集合
     * @return 结果
     */
    @Transactional
    int deleteTBasGasoutPutInfoByIds(Long[] ids);

    /**
     * 删除基础信息--企业--废气排口信息
     *
     * @param id 基础信息--企业--废气排口主键
     * @return 结果
     */
    @Transactional
    int deleteTBasGasoutPutInfoById(Long id);
}
