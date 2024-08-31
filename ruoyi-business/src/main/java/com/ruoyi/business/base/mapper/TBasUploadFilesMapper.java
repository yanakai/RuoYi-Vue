package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasUploadFiles;

import java.util.List;

public interface TBasUploadFilesMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    TBasUploadFiles selectTBasUploadFilesById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<TBasUploadFiles> selectTBasUploadFilesList(TBasUploadFiles basUploadFiles);

    /**
     * 新增【请填写功能名称】
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 结果
     */
    int insertTBasUploadFiles(TBasUploadFiles basUploadFiles);

    /**
     * 修改【请填写功能名称】
     *
     * @param basUploadFiles 【请填写功能名称】
     * @return 结果
     */
    int updateTBasUploadFiles(TBasUploadFiles basUploadFiles);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    int deleteTBasUploadFilesById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasUploadFilesByIds(Long[] ids);
}
