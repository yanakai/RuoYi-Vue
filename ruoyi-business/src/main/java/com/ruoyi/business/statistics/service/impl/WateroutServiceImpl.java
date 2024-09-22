package com.ruoyi.business.statistics.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.mapper.VOutPutInfoMapper;
import com.ruoyi.business.onlineMonitoring.dto.WateroutDTO;
import com.ruoyi.business.statistics.domain.TDataWateroutDayStatistics;
import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;
import com.ruoyi.business.statistics.dto.*;
import com.ruoyi.business.statistics.service.ITDataWateroutDayStatisticsService;
import com.ruoyi.business.statistics.service.ITDataWateroutHourStatisticsService;
import com.ruoyi.business.statistics.service.IWateroutService;
import com.ruoyi.common.annotation.DataEntScope;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WateroutServiceImpl implements IWateroutService {
    @Resource
    private ITDataWateroutHourStatisticsService tDataWateroutHourStatisticsService;
    @Resource
    private ITDataWateroutDayStatisticsService tDataWateroutDayStatisticsService;
    @Autowired
    private VOutPutInfoMapper vOutPutInfoMapper;
    /**
     * 查询废水排口--在线监测数据列表
     *
     * @param wateroutDTO 废水排口--在线监测数据列表
     * @return 废水排口--数据集合
     */
    @Override
    @DataEntScope
    public TableDataInfo selectDataList(WateroutDTO wateroutDTO) {
        log.info("查询废水排口--在线监测数据列表:{}", wateroutDTO);
        String dataEnumName = wateroutDTO.getDataEnum().name();
        if (StrUtil.equals(dataEnumName,"hour")) {
            TDataWateroutHourStatistics tDataWateroutHourStatistics = new TDataWateroutHourStatistics();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutHourStatistics);
            PageUtils.startPage();
            List<TDataWateroutHourStatistics> list = tDataWateroutHourStatisticsService.selectTDataWateroutHourStatisticsList(tDataWateroutHourStatistics);
            return getDataTable(list);
        } else if (StrUtil.equals(dataEnumName,"day")) {
            TDataWateroutDayStatistics tDataWateroutDayStatistics = new TDataWateroutDayStatistics();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutDayStatistics);
            PageUtils.startPage();
            List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutDayStatisticsList(tDataWateroutDayStatistics);
            return getDataTable(list);
        } else if (StrUtil.equals(dataEnumName,"month")) {
            TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
            PageUtils.startPage();
            List<TDataWateroutMonthStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutMonthStatisticsList(tDataWateroutStatisticsDTO);
            return getDataTable(list);
        } else if (StrUtil.equals(dataEnumName,"year")) {
            TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
            PageUtils.startPage();
            List<TDataWateroutYearStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutYearStatisticsList(tDataWateroutStatisticsDTO);
            return getDataTable(list);
        }else if (StrUtil.equalsAny(dataEnumName, true,"real", "minute")){
            Map<String, Object> params = wateroutDTO.getParams();
            //实时或者分钟数据需要查询原始表
            String tableName = getTableName(wateroutDTO);
            if(StrUtil.isNotBlank(tableName)){
                TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
                BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
                PageUtils.startPage();
                if(MapUtil.isEmpty(params)){
                    params = new HashMap<>();
                }
                params.put("tableName",tableName);
                tDataWateroutStatisticsDTO.setParams(params);
                List<TDataWateroutRealOrMinuteStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutMinuteOrRealStatisticsList(tDataWateroutStatisticsDTO);
                return getDataTable(list);
            }
        }

        return getDataTable(null);
    }
    @Override
    public void export(HttpServletResponse response, WateroutDTO wateroutDTO) {
        String dataEnumName = wateroutDTO.getDataEnum().name();
        if (StrUtil.equals(dataEnumName,"hour")) {
            TDataWateroutHourStatistics tDataWateroutHourStatistics = new TDataWateroutHourStatistics();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutHourStatistics);
            PageUtils.startPage();
            List<TDataWateroutHourStatistics> list = tDataWateroutHourStatisticsService.selectTDataWateroutHourStatisticsList(tDataWateroutHourStatistics);
            ExcelUtil<TDataWateroutHourStatistics> util = new ExcelUtil<>(TDataWateroutHourStatistics.class);
            util.exportExcel(response, list, "废水排口在线监测导出");
        } else if (StrUtil.equals(dataEnumName,"day")) {
            TDataWateroutDayStatistics tDataWateroutDayStatistics = new TDataWateroutDayStatistics();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutDayStatistics);
            PageUtils.startPage();
            List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutDayStatisticsList(tDataWateroutDayStatistics);
            ExcelUtil<TDataWateroutDayStatistics> util = new ExcelUtil<>(TDataWateroutDayStatistics.class);
            util.exportExcel(response, list, "废水排口在线监测导出");
        } else if (StrUtil.equals(dataEnumName,"month")) {
            TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
            PageUtils.startPage();
            List<TDataWateroutMonthStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutMonthStatisticsList(tDataWateroutStatisticsDTO);
            ExcelUtil<TDataWateroutMonthStatistics> util = new ExcelUtil<>(TDataWateroutMonthStatistics.class);
            util.exportExcel(response, list, "废水排口在线监测导出");
        } else if (StrUtil.equals(dataEnumName,"year")) {
            TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
            BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
            PageUtils.startPage();
            List<TDataWateroutYearStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutYearStatisticsList(tDataWateroutStatisticsDTO);
            ExcelUtil<TDataWateroutYearStatistics> util = new ExcelUtil<>(TDataWateroutYearStatistics.class);
            util.exportExcel(response, list, "废水排口在线监测导出");
        }else if (StrUtil.equalsAny(dataEnumName, true,"real", "minute")){
            //实时或者分钟数据需要查询原始表
            String tableName = getTableName(wateroutDTO);
            if(StrUtil.isNotBlank(tableName)){
                TDataWateroutStatisticsDTO tDataWateroutStatisticsDTO = new TDataWateroutStatisticsDTO();
                BeanUtil.copyProperties(wateroutDTO, tDataWateroutStatisticsDTO);
                PageUtils.startPage();
                tDataWateroutStatisticsDTO.getParams().put("tableName",tableName);
                List<TDataWateroutRealOrMinuteStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutMinuteOrRealStatisticsList(tDataWateroutStatisticsDTO);
                ExcelUtil<TDataWateroutRealOrMinuteStatistics> util = new ExcelUtil<>(TDataWateroutRealOrMinuteStatistics.class);
                util.exportExcel(response, list, "废水排口在线监测导出");
            }
        }
    }


    private String getTableName(WateroutDTO wateroutDTO){
        if(StrUtil.isNotBlank(wateroutDTO.getOutPutCode())){
            String dataEnumName = wateroutDTO.getDataEnum().name();
            String tableName = "";
            if(StrUtil.equals(dataEnumName,"real")){
                tableName = "t_data_waterout_real_";
            }else if (StrUtil.equals(dataEnumName,"minute")){
                tableName = "t_data_waterout_minute_";
            }
            //获取排口信息
            VOutPutInfo vOutPutInfo = new VOutPutInfo();
            vOutPutInfo.setOutPutCode(wateroutDTO.getOutPutCode());
            List<VOutPutInfo> list = vOutPutInfoMapper.selectVOutPutInfoList(vOutPutInfo);
            if(ArrayUtil.isNotEmpty(list)){
                vOutPutInfo = list.get(0);
                tableName = tableName+vOutPutInfo.getMnNum();
            }
            return tableName;
        }else{
            return null;
        }
    }
    private String getTableName(String tableName, WateroutDTO wateroutDTO){
        if(StrUtil.isNotBlank(wateroutDTO.getOutPutCode())){
            //获取排口信息
            VOutPutInfo vOutPutInfo = new VOutPutInfo();
            vOutPutInfo.setOutPutCode(wateroutDTO.getOutPutCode());
            List<VOutPutInfo> list = vOutPutInfoMapper.selectVOutPutInfoList(vOutPutInfo);
            if(ArrayUtil.isNotEmpty(list)){
                vOutPutInfo = list.get(0);
                tableName = tableName+vOutPutInfo.getMnNum();
            }
            return tableName;
        }else{
            return null;
        }
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
