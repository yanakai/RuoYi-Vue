package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasUploadFiles;
import com.ruoyi.business.base.mapper.TBasUploadFilesMapper;
import com.ruoyi.business.base.service.ITBasUploadFilesService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TBasUploadFilesServiceImpl implements ITBasUploadFilesService {
    @Autowired
    private TBasUploadFilesMapper basUploadFilesMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TBasUploadFiles selectBasUploadFilesById(Long id) {
        return basUploadFilesMapper.selectTBasUploadFilesById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TBasUploadFiles> selectBasUploadFilesList(TBasUploadFiles basUploadFiles) {
        return basUploadFilesMapper.selectTBasUploadFilesList(basUploadFiles);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBasUploadFiles(TBasUploadFiles basUploadFiles) {
        basUploadFiles.setCreateTime(DateUtils.getNowDate());
        return basUploadFilesMapper.insertTBasUploadFiles(basUploadFiles);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBasUploadFiles(TBasUploadFiles basUploadFiles) {
        return basUploadFilesMapper.updateTBasUploadFiles(basUploadFiles);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBasUploadFilesByIds(Long[] ids) {
        return basUploadFilesMapper.deleteTBasUploadFilesByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBasUploadFilesById(Long id) {
        return basUploadFilesMapper.deleteTBasUploadFilesById(id);
    }
}
