package com.ruoyi.business.statistics.service;

import com.ruoyi.business.onlineMonitoring.dto.GasoutDTO;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletResponse;


/**
 * 废气排口--监测数据Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface IGasoutService {

    /**
     * 查询废气排口--在线监测数据列表
     *
     * @param gasoutDTO 废气排口--在线监测数据列表
     * @return 废气排口--数据集合
     */
    TableDataInfo selectDataList(GasoutDTO gasoutDTO);

    void export(HttpServletResponse response, GasoutDTO gasoutDTO);

}
