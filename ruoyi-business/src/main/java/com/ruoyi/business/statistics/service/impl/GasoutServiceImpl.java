package com.ruoyi.business.statistics.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.mapper.VOutPutInfoMapper;
import com.ruoyi.business.onlineMonitoring.dto.GasoutDTO;
import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutMonthStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutRealOrMinuteStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.dto.TDataGasoutYearStatistics;
import com.ruoyi.business.statistics.service.IGasoutService;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.business.statistics.service.ITDataGasoutHourStatisticsService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GasoutServiceImpl implements IGasoutService {
    @Resource
    private ITDataGasoutHourStatisticsService tDataGasoutHourStatisticsService;
    @Resource
    private ITDataGasoutDayStatisticsService tDataGasoutDayStatisticsService;

    @Autowired
    private VOutPutInfoMapper vOutPutInfoMapper;

    /**
     * 查询废气排口--在线监测数据列表
     *
     * @param gasoutDTO 废气排口--在线监测数据列表
     * @return 废气排口--数据集合
     */
    @Override
    @DataEntScope
    public TableDataInfo selectDataList(GasoutDTO gasoutDTO) {
        log.info("查询废气排口--在线监测数据列表:{}", gasoutDTO);
        String dataEnumName = gasoutDTO.getDataEnum().name();
        if (StrUtil.equals(dataEnumName,"hour")) {
            TDataGasoutHourStatistics tDataGasoutHourStatistics = new TDataGasoutHourStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutHourStatistics);
            PageUtils.startPage();
            List<TDataGasoutHourStatistics> list = tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsList(tDataGasoutHourStatistics);
            return getDataTable(list);
        } else if (StrUtil.equals(dataEnumName,"day")) {
            TDataGasoutDayStatistics tDataGasoutDayStatistics = new TDataGasoutDayStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutDayStatistics);
            PageUtils.startPage();
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutDayStatisticsList(tDataGasoutDayStatistics);
            return getDataTable(list);
        } else if (StrUtil.equals(dataEnumName,"month")) {
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            PageUtils.startPage();
            List<TDataGasoutMonthStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
            return getDataTable(list);
        } else if (StrUtil.equals(dataEnumName,"year")) {
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            PageUtils.startPage();
            List<TDataGasoutYearStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
            return getDataTable(list);
        }else if (StrUtil.equalsAny(dataEnumName, true,"real", "minute")){
            Map<String, Object> params = gasoutDTO.getParams();
            //实时或者分钟数据需要查询原始表
            String tableName = getTableName(gasoutDTO);
            if(StrUtil.isNotBlank(tableName)){
                TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
                BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
                if(MapUtil.isEmpty(params)){
                    params = new HashMap<>();
                }
                params.put("tableName",tableName);
                tDataGasoutStatisticsDTO.setParams(params);
                PageUtils.startPage();
                List<TDataGasoutRealOrMinuteStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMinuteOrRealStatisticsList(tDataGasoutStatisticsDTO);
                return getDataTable(list);
            }

        }

        return getDataTable(new ArrayList<>());
    }
    @Override
    public void export(HttpServletResponse response,GasoutDTO gasoutDTO) {
        log.info("查询废气排口--导出在线监测数据列表:{}", gasoutDTO);
        String dataEnumName = gasoutDTO.getDataEnum().name();
        if (StrUtil.equals(dataEnumName,"hour")) {
            TDataGasoutHourStatistics tDataGasoutHourStatistics = new TDataGasoutHourStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutHourStatistics);
            List<TDataGasoutHourStatistics> list = tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsList(tDataGasoutHourStatistics);
            ExcelUtil<TDataGasoutHourStatistics> util = new ExcelUtil<>(TDataGasoutHourStatistics.class);
            util.exportExcel(response, list, "废气排口在线监测导出");
        } else if (StrUtil.equals(dataEnumName,"day")) {
            TDataGasoutDayStatistics tDataGasoutDayStatistics = new TDataGasoutDayStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutDayStatistics);
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutDayStatisticsList(tDataGasoutDayStatistics);
            ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<>(TDataGasoutDayStatistics.class);
            util.exportExcel(response, list, "废气排口在线监测导出");
        } else if (StrUtil.equals(dataEnumName,"month")) {
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            List<TDataGasoutMonthStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
            ExcelUtil<TDataGasoutMonthStatistics> util = new ExcelUtil<>(TDataGasoutMonthStatistics.class);
            util.exportExcel(response, list, "废气排口在线监测导出");
        } else if (StrUtil.equals(dataEnumName,"year")) {
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            List<TDataGasoutYearStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
            ExcelUtil<TDataGasoutYearStatistics> util = new ExcelUtil<>(TDataGasoutYearStatistics.class);
            util.exportExcel(response, list, "废气排口在线监测导出");
        }else if (StrUtil.equalsAny(dataEnumName, true,"real", "minute")){
            //实时或者分钟数据需要查询原始表
            String tableName = getTableName(gasoutDTO);
            if(StrUtil.isNotBlank(tableName)){
                TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
                BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
                tDataGasoutStatisticsDTO.getParams().put("tableName",tableName);
                List<TDataGasoutRealOrMinuteStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMinuteOrRealStatisticsList(tDataGasoutStatisticsDTO);
                ExcelUtil<TDataGasoutRealOrMinuteStatistics> util = new ExcelUtil<>(TDataGasoutRealOrMinuteStatistics.class);
                util.exportExcel(response, list, "废气排口在线监测导出");
            }
        }
    }

    private String getTableName(GasoutDTO gasoutDTO){
        if(StrUtil.isNotBlank(gasoutDTO.getOutPutCode())){
            String dataEnumName = gasoutDTO.getDataEnum().name();
            String tableName = "";
            if(StrUtil.equals(dataEnumName,"real")){
                tableName = "t_data_gasout_real_";
            }else if (StrUtil.equals(dataEnumName,"minute")){
                tableName = "t_data_gasout_minute_";
            }
            //获取排口信息
            VOutPutInfo vOutPutInfo = new VOutPutInfo();
            vOutPutInfo.setOutPutCode(gasoutDTO.getOutPutCode());
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
    private String getTableName(String tableName,GasoutDTO gasoutDTO){
        if(StrUtil.isNotBlank(gasoutDTO.getOutPutCode())){
            //获取排口信息
            VOutPutInfo vOutPutInfo = new VOutPutInfo();
            vOutPutInfo.setOutPutCode(gasoutDTO.getOutPutCode());
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
