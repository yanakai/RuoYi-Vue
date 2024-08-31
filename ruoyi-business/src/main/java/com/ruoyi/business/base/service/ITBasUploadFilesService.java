package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.TBasUploadFiles;

import java.util.List;

public interface ITBasUploadFilesService {

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    TBasUploadFiles selectBasUploadFilesById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<TBasUploadFiles> selectBasUploadFilesList(TBasUploadFiles basUploadFiles);

    /**
     * 新增【请填写功能名称】
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 结果
     */
    int insertBasUploadFiles(TBasUploadFiles basUploadFiles);

    /**
     * 修改【请填写功能名称】
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 结果
     */
    int updateBasUploadFiles(TBasUploadFiles basUploadFiles);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    int deleteBasUploadFilesByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    int deleteBasUploadFilesById(Long id);
}
