package com.ruoyi.business.statistics.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.onlineMonitoring.dto.WateroutDTO;
import com.ruoyi.business.statistics.domain.TDataWateroutDayStatistics;
import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;
import com.ruoyi.business.statistics.dto.TDataWateroutStatisticsDTO;
import com.ruoyi.business.statistics.service.ITDataWateroutDayStatisticsService;
import com.ruoyi.business.statistics.service.ITDataWateroutHourStatisticsService;
import com.ruoyi.business.statistics.service.IWateroutService;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class WateroutServiceImpl implements IWateroutService {
    @Resource
    private ITDataWateroutHourStatisticsService tDataWateroutHourStatisticsService;
    @Resource
    private ITDataWateroutDayStatisticsService tDataWateroutDayStatisticsService;

    /**
     * 查询废水排口--在线监测数据列表
     *
     * @param wateroutDTO 废水排口--在线监测数据列表
     * @return 废水排口--数据集合
     */
    @Override
    public TableDataInfo selectDataList(WateroutDTO wateroutDTO) {
        log.info("查询废水排口--在线监测数据列表:{}", wateroutDTO);
        if (wateroutDTO.getDataEnum().name().equals("hour")) {
            TDataWateroutHourStatistics tDataWateroutHourStatistics = new TDataWateroutHourStatistics();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutHourStatistics);
            PageUtils.startPage();
            List<TDataWateroutHourStatistics> list = tDataWateroutHourStatisticsService.selectTDataWateroutHourStatisticsList(tDataWateroutHourStatistics);
            return getDataTable(list);
        } else if (wateroutDTO.getDataEnum().name().equals("day")) {
            TDataWateroutDayStatistics tDataWateroutDayStatistics = new TDataWateroutDayStatistics();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutDayStatistics);
            PageUtils.startPage();
            List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutDayStatisticsList(tDataWateroutDayStatistics);
            return getDataTable(list);
        } else if (wateroutDTO.getDataEnum().name().equals("month")) {
            TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
            PageUtils.startPage();
            List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutMonthStatisticsList(tDataWateroutStatisticsDTO);
            return getDataTable(list);
        } else if (wateroutDTO.getDataEnum().name().equals("year")) {
            TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
            PageUtils.startPage();
            List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutYearStatisticsList(tDataWateroutStatisticsDTO);
            return getDataTable(list);
        } else if (wateroutDTO.getDataEnum().name().equals("real")) {
            //TODO
        } else if (wateroutDTO.getDataEnum().name().equals("minute")) {
            //TODO
        }

        return getDataTable(null);
    }

    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }
}
