package com.ruoyi.business.base.service.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import com.ruoyi.business.base.domain.TBasWateroutPutInfo;
import com.ruoyi.business.base.domain.TBasWateroutputPollutant;
import com.ruoyi.business.base.mapper.TBasWateroutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasWateroutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasWateroutputPollutantService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础信息--企业--废水排口污染物基本信息Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasWateroutputPollutantServiceImpl implements ITBasWateroutputPollutantService {
    @Autowired
    private TBasWateroutputPollutantMapper tBasWateroutputPollutantMapper;

    @Resource
    private TBasWateroutPutInfoMapper waterOutputPollutantMapper;

    /**
     * 查询基础信息--企业--废水排口污染物基本信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    @Override
    public TBasWateroutputPollutant selectTBasWateroutputPollutantById(Long id) {
        return tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantById(id);
    }

    /**
     * 查询基础信息--企业--废水排口污染物基本信息列表
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    @Override
    public List<TBasWateroutputPollutant> selectTBasWateroutputPollutantList(TBasWateroutputPollutant tBasWateroutputPollutant) {
        return tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantList(tBasWateroutputPollutant);
    }

    /**
     * 新增基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    @Override
    public int insertTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setCreateTime(DateUtils.getNowDate());
        //获取排口信息
        TBasWateroutPutInfo tBasWateroutPutInfo = new TBasWateroutPutInfo();
        tBasWateroutPutInfo.setOutPutCode(tBasWateroutputPollutant.getOutPutCode());
        List<TBasWateroutPutInfo> list = waterOutputPollutantMapper.selectTBasWateroutPutInfoList(tBasWateroutPutInfo);
        if(ArrayUtil.isNotEmpty(list)){
            tBasWateroutputPollutant.setOutPutName(list.get(0).getOutPutName());
            tBasWateroutputPollutant.setEntCode(list.get(0).getEntCode());
            tBasWateroutputPollutant.setEntName(list.get(0).getEntName());
            tBasWateroutputPollutant.setMnNum(list.get(0).getMnNum());
            return tBasWateroutputPollutantMapper.insertTBasWateroutputPollutant(tBasWateroutputPollutant);
        }
        return 0;
    }

    /**
     * 修改基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    @Override
    public int updateTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setUpdateTime(DateUtils.getNowDate());
        return tBasWateroutputPollutantMapper.updateTBasWateroutputPollutant(tBasWateroutputPollutant);
    }

    /**
     * 批量删除基础信息--企业--废水排口污染物基本信息
     *
     * @param ids 需要删除的基础信息--企业--废水排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantByIds(Long[] ids) {
        return tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantByIds(ids);
    }

    /**
     * 删除基础信息--企业--废水排口污染物基本信息信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantById(Long id) {
        return tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantById(id);
    }
}
