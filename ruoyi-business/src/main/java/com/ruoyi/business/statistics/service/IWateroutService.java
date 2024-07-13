package com.ruoyi.business.statistics.service;

import com.ruoyi.business.onlineMonitoring.dto.WateroutDTO;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * 废水排口--监测数据Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface IWateroutService {

    /**
     * 查询废水排口--在线监测数据列表
     *
     * @param wateroutDTO 废水排口--在线监测数据列表
     * @return 废水排口--数据集合
     */
    TableDataInfo selectDataList(WateroutDTO wateroutDTO);


}
