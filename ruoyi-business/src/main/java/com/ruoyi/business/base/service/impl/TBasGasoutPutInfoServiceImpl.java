package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.base.domain.TBasGasoutPutInfo;
import com.ruoyi.business.base.domain.TBasUploadFiles;
import com.ruoyi.business.base.mapper.TBasGasoutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasGasoutputPollutantMapper;
import com.ruoyi.business.base.mapper.TBasUploadFilesMapper;
import com.ruoyi.business.base.service.ITBasGasoutPutInfoService;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础信息--企业--废气排口Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasGasoutPutInfoServiceImpl implements ITBasGasoutPutInfoService {
    @Autowired
    private TBasGasoutPutInfoMapper tBasGasoutPutInfoMapper;
    @Resource
    private TBasGasoutputPollutantMapper tBasGasoutputPollutantMapper;

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    /**
     * 查询基础信息--企业--废气排口
     *
     * @param id 基础信息--企业--废气排口主键
     * @return 基础信息--企业--废气排口
     */
    @Override
    public TBasGasoutPutInfo selectTBasGasoutPutInfoById(Long id) {
        TBasGasoutPutInfo tBasGasoutPutInfo = tBasGasoutPutInfoMapper.selectTBasGasoutPutInfoById(id);
        tBasGasoutPutInfo.setAnnexInfoList(annexService.selectAnnexList(tBasGasoutPutInfo.getId().toString(), Constants.ANNEX_GasOutPut));
        return tBasGasoutPutInfo;
    }

    /**
     * 查询基础信息--企业--废气排口列表
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 基础信息--企业--废气排口
     */
    @Override
    public List<TBasGasoutPutInfo> selectTBasGasoutPutInfoList(TBasGasoutPutInfo tBasGasoutPutInfo) {
        return tBasGasoutPutInfoMapper.selectTBasGasoutPutInfoList(tBasGasoutPutInfo);
    }

    /**
     * 新增基础信息--企业--废气排口
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 结果
     */
    @Override
    public int insertTBasGasoutPutInfo(TBasGasoutPutInfo tBasGasoutPutInfo) {
        tBasGasoutPutInfo.setCreateTime(DateUtils.getNowDate());
        int result = tBasGasoutPutInfoMapper.insertTBasGasoutPutInfo(tBasGasoutPutInfo);
        if (result > 0){
            //创建表 分钟表t_data_gasout_minute  小时表t_data_gasout_hour 天表t_data_gasout_day
            tBasGasoutPutInfoMapper.createTableReal(tBasGasoutPutInfo);
            tBasGasoutPutInfoMapper.createTableMin(tBasGasoutPutInfo);
            tBasGasoutPutInfoMapper.createTableHour(tBasGasoutPutInfo);
            tBasGasoutPutInfoMapper.createTableDay(tBasGasoutPutInfo);
            // 设置附件
            if (tBasGasoutPutInfo.getAnnexIdList() != null && tBasGasoutPutInfo.getAnnexIdList().size() > 0) {
                annexService.updateAnnex(tBasGasoutPutInfo.getId().toString(), Constants.ANNEX_GasOutPut, tBasGasoutPutInfo.getAnnexIdList());
            }
        }

        return result;
    }

    /**
     * 修改基础信息--企业--废气排口
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 结果
     */
    @Override
    public int updateTBasGasoutPutInfo(TBasGasoutPutInfo tBasGasoutPutInfo) {
        tBasGasoutPutInfo.setUpdateTime(DateUtils.getNowDate());
        int result = tBasGasoutPutInfoMapper.updateTBasGasoutPutInfo(tBasGasoutPutInfo);
        // 修改附件信息
        if (result > 0) {
            annexService.updateAnnex(tBasGasoutPutInfo.getId().toString(), Constants.ANNEX_GasOutPut, tBasGasoutPutInfo.getAnnexIdList());
        }
        return result;
    }

    /**
     * 批量删除基础信息--企业--废气排口
     *
     * @param ids 需要删除的基础信息--企业--废气排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutPutInfoByIds(Long[] ids) {
        //删除废气排口污染物基本信息
        tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantByInfoIds(ids);
        return tBasGasoutPutInfoMapper.deleteTBasGasoutPutInfoByIds(ids);
    }

    /**
     * 删除基础信息--企业--废气排口信息
     *
     * @param id 基础信息--企业--废气排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutPutInfoById(Long id) {
        //删除废气排口污染物基本信息
        tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantByInfoId(id);
        return tBasGasoutPutInfoMapper.deleteTBasGasoutPutInfoById(id);
    }
}
