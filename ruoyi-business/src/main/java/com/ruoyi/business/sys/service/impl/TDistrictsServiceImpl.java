package com.ruoyi.business.sys.service.impl;

import com.ruoyi.business.sys.domain.TDistricts;
import com.ruoyi.business.sys.mapper.TDistrictsMapper;
import com.ruoyi.business.sys.service.ITDistrictsService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地区Service业务层处理
 *
 * @author lx
 * @date 2024-07-01
 */
@Service
public class TDistrictsServiceImpl implements ITDistrictsService {
    @Autowired
    private TDistrictsMapper tDistrictsMapper;

    /**
     * 查询地区
     *
     * @param id 地区主键
     * @return 地区
     */
    @Override
    public TDistricts selectTDistrictsById(String id) {
        return tDistrictsMapper.selectTDistrictsById(id);
    }

    /**
     * 查询地区列表
     *
     * @param tDistricts 地区
     * @return 地区
     */
    @Override
    public List<TDistricts> selectTDistrictsList(TDistricts tDistricts) {
        return tDistrictsMapper.selectTDistrictsList(tDistricts);
    }

    /**
     * 新增地区
     *
     * @param tDistricts 地区
     * @return 结果
     */
    @Override
    public int insertTDistricts(TDistricts tDistricts) {
        tDistricts.setCreateTime(DateUtils.getNowDate());
        return tDistrictsMapper.insertTDistricts(tDistricts);
    }

    /**
     * 修改地区
     *
     * @param tDistricts 地区
     * @return 结果
     */
    @Override
    public int updateTDistricts(TDistricts tDistricts) {
        tDistricts.setUpdateTime(DateUtils.getNowDate());
        return tDistrictsMapper.updateTDistricts(tDistricts);
    }

    /**
     * 批量删除地区
     *
     * @param ids 需要删除的地区主键
     * @return 结果
     */
    @Override
    public int deleteTDistrictsByIds(String[] ids) {
        return tDistrictsMapper.deleteTDistrictsByIds(ids);
    }

    /**
     * 删除地区信息
     *
     * @param id 地区主键
     * @return 结果
     */
    @Override
    public int deleteTDistrictsById(String id) {
        return tDistrictsMapper.deleteTDistrictsById(id);
    }
}
