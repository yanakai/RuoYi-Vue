package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.OutputPollutantAutoHead;
import com.ruoyi.business.base.domain.TBasGasoutputPollutant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础信息--企业--废气排口污染物基本信息Mapper接口
 *
 * @author lx
 * @date 2024-06-27
 */
public interface TBasGasoutputPollutantMapper {
    /**
     * 查询基础信息--企业--废气排口污染物基本信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 基础信息--企业--废气排口污染物基本信息
     */
    TBasGasoutputPollutant selectTBasGasoutputPollutantById(Long id);

    /**
     * 查询基础信息--企业--废水排口污染物基本信息自动表头列表
     */
    List<OutputPollutantAutoHead> selectOutputPollutantAutoHead(@Param("entCode") String entCode, @Param("outPutCode") String outPutCode);

    /**
     * 查询基础信息--企业--废气排口污染物基本信息列表
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 基础信息--企业--废气排口污染物基本信息集合
     */
    List<TBasGasoutputPollutant> selectTBasGasoutputPollutantList(TBasGasoutputPollutant tBasGasoutputPollutant);

    /**
     * 新增基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    int insertTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant);

    /**
     * 修改基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    int updateTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant);

    /**
     * 删除基础信息--企业--废气排口污染物基本信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 结果
     */
    int deleteTBasGasoutputPollutantById(Long id);

    /**
     * 批量删除基础信息--企业--废气排口污染物基本信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasGasoutputPollutantByIds(Long[] ids);

    /**
     * 根据废气排口信息id删除废气排口污染物基本信息
     *
     * @param id
     * @return
     */
    int deleteTBasGasoutputPollutantByInfoId(Long id);

    /**
     * 根据废气排口信息ids删除废气排口污染物基本信息
     *
     * @param ids
     * @return
     */
    int deleteTBasGasoutputPollutantByInfoIds(Long[] ids);
}
