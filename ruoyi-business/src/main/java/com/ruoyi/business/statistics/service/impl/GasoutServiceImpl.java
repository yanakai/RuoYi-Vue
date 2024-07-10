package com.ruoyi.business.statistics.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.onlineMonitoring.dto.GasoutDTO;
import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.service.IGasoutService;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.business.statistics.service.ITDataGasoutHourStatisticsService;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Service
public class GasoutServiceImpl implements IGasoutService {
    @Resource
    private ITDataGasoutHourStatisticsService tDataGasoutHourStatisticsService;
    @Resource
    private ITDataGasoutDayStatisticsService tDataGasoutDayStatisticsService;
    /**
     * 查询废气排口--在线监测数据列表
     *
     * @param gasoutDTO 废气排口--在线监测数据列表
     * @return 废气排口--数据集合
     */
    @Override
    public TableDataInfo selectDataList(GasoutDTO gasoutDTO) {
        log.info("查询废气排口--在线监测数据列表:{}", gasoutDTO);
        if(gasoutDTO.getDataEnum().name().equals("hour")) {
            TDataGasoutHourStatistics tDataGasoutHourStatistics = new TDataGasoutHourStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutHourStatistics);
            PageUtils.startPage();
            List<TDataGasoutHourStatistics> list = tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsList(tDataGasoutHourStatistics);
            return getDataTable(list);
        }else if(gasoutDTO.getDataEnum().name().equals("day")) {
            TDataGasoutDayStatistics tDataGasoutDayStatistics = new TDataGasoutDayStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutDayStatistics);
            PageUtils.startPage();
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutDayStatisticsList(tDataGasoutDayStatistics);
            return getDataTable(list);
        } else if (gasoutDTO.getDataEnum().name().equals("month")){
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            PageUtils.startPage();
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
            return getDataTable(list);
        } else if (gasoutDTO.getDataEnum().name().equals("year")){
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            PageUtils.startPage();
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
            return getDataTable(list);
        } else if (gasoutDTO.getDataEnum().name().equals("real")){
             //TODO
        } else if(gasoutDTO.getDataEnum().name().equals("minute")){
             //TODO
        }

        return getDataTable(null);
    }

    protected TableDataInfo getDataTable(List<?> list){
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }
}
