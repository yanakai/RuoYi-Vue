package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.base.domain.TBasWateroutPutInfo;
import com.ruoyi.business.base.mapper.TBasWateroutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasWateroutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasWateroutPutInfoService;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础信息--企业--废水排口Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasWateroutPutInfoServiceImpl implements ITBasWateroutPutInfoService {
    @Autowired
    private TBasWateroutPutInfoMapper tBasWateroutPutInfoMapper;
    @Resource
    private TBasWateroutputPollutantMapper tBasWateroutputPollutantMapper;

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    /**
     * 查询基础信息--企业--废水排口
     *
     * @param id 基础信息--企业--废水排口主键
     * @return 基础信息--企业--废水排口
     */
    @Override
    public TBasWateroutPutInfo selectTBasWateroutPutInfoById(Long id) {
        TBasWateroutPutInfo tBasWateroutPutInfo = tBasWateroutPutInfoMapper.selectTBasWateroutPutInfoById(id);
        // 查询附件信息
        tBasWateroutPutInfo.setAnnexInfoList(annexService.selectAnnexList(tBasWateroutPutInfo.getId().toString(), Constants.ANNEX_WaterOutPut));
        return tBasWateroutPutInfo;
    }

    /**
     * 查询基础信息--企业--废水排口列表
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 基础信息--企业--废水排口
     */
    @Override
    public List<TBasWateroutPutInfo> selectTBasWateroutPutInfoList(TBasWateroutPutInfo tBasWateroutPutInfo) {
        return tBasWateroutPutInfoMapper.selectTBasWateroutPutInfoList(tBasWateroutPutInfo);
    }

    /**
     * 新增基础信息--企业--废水排口
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 结果
     */
    @Override
    public int insertTBasWateroutPutInfo(TBasWateroutPutInfo tBasWateroutPutInfo) {
        tBasWateroutPutInfo.setCreateTime(DateUtils.getNowDate());
        int result = tBasWateroutPutInfoMapper.insertTBasWateroutPutInfo(tBasWateroutPutInfo);
        if (result > 0){
            tBasWateroutPutInfoMapper.createTableReal(tBasWateroutPutInfo);
            tBasWateroutPutInfoMapper.createTableMin(tBasWateroutPutInfo);
            tBasWateroutPutInfoMapper.createTableHour(tBasWateroutPutInfo);
            tBasWateroutPutInfoMapper.createTableDay(tBasWateroutPutInfo);
            // 更新附件
            if (tBasWateroutPutInfo.getAnnexIdList() != null && tBasWateroutPutInfo.getAnnexIdList().size() > 0) {
                annexService.updateAnnex(tBasWateroutPutInfo.getId().toString(), Constants.ANNEX_WaterOutPut, tBasWateroutPutInfo.getAnnexIdList());
            }
        }
        return result;
    }

    /**
     * 修改基础信息--企业--废水排口
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 结果
     */
    @Override
    public int updateTBasWateroutPutInfo(TBasWateroutPutInfo tBasWateroutPutInfo) {
        tBasWateroutPutInfo.setUpdateTime(DateUtils.getNowDate());
        int result = tBasWateroutPutInfoMapper.updateTBasWateroutPutInfo(tBasWateroutPutInfo);
        // 修改附件信息
        if (result > 0) {
            annexService.updateAnnex(tBasWateroutPutInfo.getId().toString(), Constants.ANNEX_WaterOutPut, tBasWateroutPutInfo.getAnnexIdList());
        }
        return result;
    }

    /**
     * 批量删除基础信息--企业--废水排口
     *
     * @param ids 需要删除的基础信息--企业--废水排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutPutInfoByIds(Long[] ids) {
        //删除废水排口污染物基本信息
        tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantByInfoIds(ids);
        int result = tBasWateroutPutInfoMapper.deleteTBasWateroutPutInfoByIds(ids);
        if (result > 0) {
            for (Long id : ids) {
                if (null == id) {
                    continue;
                }
                annexService.updateAnnex(id.toString(), Constants.ANNEX_WaterOutPut, null);
            }
        }
        return result;
    }

    /**
     * 删除基础信息--企业--废水排口信息
     *
     * @param id 基础信息--企业--废水排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutPutInfoById(Long id) {
        //删除废水排口污染物基本信息
        tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantByInfoId(id);
        int result = tBasWateroutPutInfoMapper.deleteTBasWateroutPutInfoById(id);
        if (result > 0) {
            annexService.updateAnnex(id.toString(), Constants.ANNEX_WaterOutPut, null);
        }
        return result;
    }
}
