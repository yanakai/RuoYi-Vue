package com.ruoyi.business.envProt.service;

import com.ruoyi.business.envProt.domain.EntOutPollutantPermit;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCount;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCountReq;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitReq;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业排污许可基础Service接口
 */
public interface EntOutPollutantPermitService {

    /**
     * 查询企业排污许可基础列表
     */
    AjaxResult selectEntOutPollutantPermitList(EntOutPollutantPermitReq req);

    /**
     * 导出企业排污许可基础列表
     */
    void exportEntOutPollutantPermit(EntOutPollutantPermitReq req, HttpServletResponse response);

    /**
     * 修改企业排污许可基础
     */
    AjaxResult updateEntOutPollutantPermit(EntOutPollutantPermit permit);

    /**
     * 查询企业排污许可总量数据列表
     */
    AjaxResult selectEntOutPollutantPermitCountList(EntOutPollutantPermitCountReq req);

    /**
     * 导出企业排污许可总量数据列表
     */
    void exportEntOutPollutantPermitCount(EntOutPollutantPermitCountReq req, HttpServletResponse response);

    /**
     * 新增企业排污许可总量数据
     */
    AjaxResult insertEntOutPollutantPermitCount(EntOutPollutantPermitCount permit);

    /**
     * 修改企业排污许可总量数据
     */
    AjaxResult updateEntOutPollutantPermitCount(EntOutPollutantPermitCount permit);

    /**
     * 批量删除企业排污许可总量数据
     */
    AjaxResult deleteEntOutPollutantPermitCountByPollPermitIds(List<String> pollPermitIds);
}
