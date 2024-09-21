package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasUploadFiles;
import com.ruoyi.business.base.domain.TBasWateroutPutInfo;
import com.ruoyi.business.base.mapper.TBasUploadFilesMapper;
import com.ruoyi.business.base.mapper.TBasWateroutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasWateroutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasWateroutPutInfoService;
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

    @Resource
    private TBasUploadFilesMapper basUploadFilesMapper;

    /**
     * 查询基础信息--企业--废水排口
     *
     * @param id 基础信息--企业--废水排口主键
     * @return 基础信息--企业--废水排口
     */
    @Override
    public TBasWateroutPutInfo selectTBasWateroutPutInfoById(Long id) {
        TBasWateroutPutInfo tBasWateroutPutInfo = tBasWateroutPutInfoMapper.selectTBasWateroutPutInfoById(id);
        //查询附件信息
        TBasUploadFiles basUploadFiles = new TBasUploadFiles();
        basUploadFiles.setBusinessModuleId(tBasWateroutPutInfo.getId().toString());
        tBasWateroutPutInfo.setUploadFilesList(basUploadFilesMapper.selectTBasUploadFilesList(basUploadFiles));

        return tBasWateroutPutInfoMapper.selectTBasWateroutPutInfoById(id);
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
        if (tBasWateroutPutInfo.getUploadFilesList() != null && tBasWateroutPutInfo.getUploadFilesList().size() > 0) {
            for (TBasUploadFiles uploadFiles : tBasWateroutPutInfo.getUploadFilesList()) {
                uploadFiles.setBusinessModuleId(tBasWateroutPutInfo.getId().toString());
                basUploadFilesMapper.updateTBasUploadFiles(uploadFiles);
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
        //重置附件信息
        TBasUploadFiles basUploadFiles = new TBasUploadFiles();
        basUploadFiles.setBusinessModuleId(tBasWateroutPutInfo.getId().toString());
        List<TBasUploadFiles> uploadFilesList = basUploadFilesMapper.selectTBasUploadFilesList(basUploadFiles);
        if (uploadFilesList != null && uploadFilesList.size() > 0) {
            for (TBasUploadFiles uploadFiles : uploadFilesList) {
                uploadFiles.setBusinessModuleId(null);
                basUploadFilesMapper.updateTBasUploadFiles(uploadFiles);
            }
        }

        //新增附件
        if (tBasWateroutPutInfo.getUploadFilesList() != null && tBasWateroutPutInfo.getUploadFilesList().size() > 0) {
            for (TBasUploadFiles uploadFiles : tBasWateroutPutInfo.getUploadFilesList()) {
                uploadFiles.setBusinessModuleId(tBasWateroutPutInfo.getId().toString());
                basUploadFilesMapper.updateTBasUploadFiles(uploadFiles);
            }
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
        return tBasWateroutPutInfoMapper.deleteTBasWateroutPutInfoByIds(ids);
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
        return tBasWateroutPutInfoMapper.deleteTBasWateroutPutInfoById(id);
    }
}
