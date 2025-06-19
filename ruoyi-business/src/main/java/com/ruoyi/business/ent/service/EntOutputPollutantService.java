package com.ruoyi.business.ent.service;

import com.ruoyi.business.ent.domain.EntOutputPollutant;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.List;

/**
 * 企业排口污染物信息Service接口
 */
public interface EntOutputPollutantService {

    /**
     * 通过企业排口id查询对应的污染物信息
     */
    List<EntOutputPollutant> selectOutputPollutantByOutPutId(String outPutId);

    /**
     * 新增企业排口污染物信息
     */
    AjaxResult insertOutputPollutant(EntOutputPollutant poll);

    /**
     * 修改企业排口污染物信息
     */
    AjaxResult updateOutputPollutant(EntOutputPollutant poll);

    /**
     * 删除企业排口污染物信息
     */
    AjaxResult deleteOutputPollutantById(String outPutPollId);
}
