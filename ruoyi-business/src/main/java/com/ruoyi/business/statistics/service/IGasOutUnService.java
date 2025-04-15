package com.ruoyi.business.statistics.service;

import com.ruoyi.business.onlineMonitoring.dto.GasOutUnDTO;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * 废气无组织排口--监测数据Service接口
 */
public interface IGasOutUnService {

    /**
     * 查询废气无组织排口--在线监测数据列表
     * 年、月、日查询日表
     * 小时查询时表
     * 分钟查询分表
     * 实时查询实时表
     */
    TableDataInfo selectDataList(GasOutUnDTO gasOutUnDTO);

    void export(HttpServletResponse response, GasOutUnDTO gasOutUnDTO);

}
