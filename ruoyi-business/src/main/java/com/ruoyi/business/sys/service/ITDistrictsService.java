package com.ruoyi.business.sys.service;

import com.ruoyi.business.sys.domain.TDistricts;

import java.util.List;

/**
 * 地区Service接口
 *
 * @author lx
 * @date 2024-07-01
 */
public interface ITDistrictsService {
    /**
     * 查询地区
     *
     * @param id 地区主键
     * @return 地区
     */
    TDistricts selectTDistrictsById(String id);

    /**
     * 查询地区列表
     *
     * @param tDistricts 地区
     * @return 地区集合
     */
    List<TDistricts> selectTDistrictsList(TDistricts tDistricts);

    /**
     * 新增地区
     *
     * @param tDistricts 地区
     * @return 结果
     */
    int insertTDistricts(TDistricts tDistricts);

    /**
     * 修改地区
     *
     * @param tDistricts 地区
     * @return 结果
     */
    int updateTDistricts(TDistricts tDistricts);

    /**
     * 批量删除地区
     *
     * @param ids 需要删除的地区主键集合
     * @return 结果
     */
    int deleteTDistrictsByIds(String[] ids);

    /**
     * 删除地区信息
     *
     * @param id 地区主键
     * @return 结果
     */
    int deleteTDistrictsById(String id);
}
