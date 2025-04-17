package com.ruoyi.business.statistics.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.ruoyi.business.onlineMonitoring.dto.GasOutUnDTO;
import com.ruoyi.business.statistics.dto.*;
import com.ruoyi.business.statistics.mapper.TDataGasOutUnDayStatisticsMapper;
import com.ruoyi.business.statistics.service.*;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GasOutUnServiceImpl implements IGasOutUnService {

    private TDataGasOutUnDayStatisticsMapper tDataGasOutUnDayStatisticsMapper;
    @Autowired
    public void setTDataGasOutUnDayStatisticsMapper(TDataGasOutUnDayStatisticsMapper tDataGasOutUnDayStatisticsMapper) {
        this.tDataGasOutUnDayStatisticsMapper = tDataGasOutUnDayStatisticsMapper;
    }

    /**
     * 查询废气无组织排口--在线监测数据列表
     */
    @Override
    public TableDataInfo selectDataList(GasOutUnDTO gasOutUnDTO) {
        log.info("查询废气无组织排口--在线监测数据列表:{}", gasOutUnDTO);
        // 整理请求参数
        getQueryParam(gasOutUnDTO);
        List<TDataGasOutUnPoll> list = tDataGasOutUnDayStatisticsMapper.selectTDataGasOutUnStatisticsListTest(gasOutUnDTO);
        Map<String, Map<String, Object>> map = new HashMap<>();
        List<Map<String, Object>> rl = new ArrayList<>();
        list.forEach(e -> {
            Map<String, Object> r;
            if (map.containsKey(e.getMonitorTime())) {
                r = map.get(e.getMonitorTime());
            } else {
                r = new HashMap<>();
                r.put("monitorTime", e.getMonitorTime());
                rl.add(r);
                map.put(e.getMonitorTime(), r);
            }
            r.put(e.getPollutantCode(), e.getTotalValue());
        });
        rl.sort((o1, o2) -> MapUtil.getStr(o2, "monitorTime").compareTo(MapUtil.getStr(o1, "monitorTime")));
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(rl);
        rspData.setTotal(list.size() > 0 ? list.get(0).getTotals() : 0);
        return rspData;
    }

    @Override
    public void export(HttpServletResponse response, GasOutUnDTO gasOutUnDTO) {
        log.info("查询废气排口--导出在线监测数据列表:{}", gasOutUnDTO);
        // 整理请求参数
        getQueryParam(gasOutUnDTO);
        // 执行请求
        List<TDataGasOutUnStatistics> list = tDataGasOutUnDayStatisticsMapper.selectTDataGasOutUnStatisticsList(gasOutUnDTO);
        ExcelUtil<TDataGasOutUnStatistics> util = new ExcelUtil<>(TDataGasOutUnStatistics.class);
        util.exportExcel(response, list, "废气排口在线监测导出");
    }

    private void getQueryParam(GasOutUnDTO gasOutUnDTO) {
        String dataEnumName = gasOutUnDTO.getDataEnum().name();
        // 实时或者分钟数据需要查询原始表
        String tableName = getTableName(dataEnumName, gasOutUnDTO.getMnNum());
        if (null == tableName) {
            throw new RuntimeException("未知的查询条件");
        }
        if (null == gasOutUnDTO.getPageNum() || gasOutUnDTO.getPageNum() < 1) {
            gasOutUnDTO.setPageNum(1);
        }
        if (null == gasOutUnDTO.getPageSize() || gasOutUnDTO.getPageSize() < 1) {
            gasOutUnDTO.setPageSize(10);
        }
        gasOutUnDTO.setStart((gasOutUnDTO.getPageNum() - 1) * gasOutUnDTO.getPageSize() + 1);
        gasOutUnDTO.setEnd(gasOutUnDTO.getPageNum() * gasOutUnDTO.getPageSize());
        gasOutUnDTO.setPageNum(null);
        gasOutUnDTO.setPageSize(null);
        Map<String, Object> params = gasOutUnDTO.getParams();
        if (null == params) {
            params = new HashMap<>();
            gasOutUnDTO.setParams(params);
        }
        params.put("tableName", tableName);
        // 请求类型
        params.put("queryType", dataEnumName);
        // 查询起止时间格式调整，都改为年月日时分秒格式
        String beginTime = MapUtil.getStr(params, "beginTime");
        String endTime = MapUtil.getStr(params, "endTime");
        /*
            小时2025-04-14 00
            日2025-04-01
            月2025-01
            年2025
            分钟2025-04-14 00:00
            实时2025-04-14 00:00:00
         */
        if (null != beginTime) {
            switch (dataEnumName) {
                case "year":
                    beginTime = beginTime + "-01-01 00:00:00";
                    break;
                case "month":
                    beginTime = beginTime + "-01 00:00:00";
                    break;
                case "day":
                    beginTime = beginTime + " 00:00:00";
                    break;
                case "hour":
                    beginTime = beginTime + ":00:00";
                    break;
                case "minute":
                    beginTime = beginTime + ":00";
                    break;
            }
            params.put("beginTime", beginTime);
        }
        if (null != endTime) {
            switch (dataEnumName) {
                case "year":
                    endTime = endTime + "-12-31 23:59:59";
                    break;
                case "month":
                    endTime = endTime + lastDayOfTime(endTime, "yyyy-MM") + " 23:59:59";
                    break;
                case "day":
                    endTime = endTime + " 23:59:59";
                    break;
                case "hour":
                    endTime = endTime + ":59:59";
                    break;
                case "minute":
                    endTime = endTime + ":59";
                    break;
            }
            params.put("endTime", endTime);
        }
    }

    private String getTableName(String dataEnumName, String mnNum){
        String tableName = null;
        switch (dataEnumName) {
            case "year":
            case "month":
            case "day":
                tableName = "t_data_gasout_unorganized_day_";
                break;
            case "hour":
                tableName = "t_data_gasout_unorganized_hour_";
                break;
            case "minute":
                tableName = "t_data_gasout_unorganized_minute_";
                break;
            case "real":
                tableName = "t_data_gasout_unorganized_real_";
                break;
        }
        return null == tableName ? null : (tableName + mnNum);
    }

    private String lastDayOfTime(String time, String format) {
        DateTime date = DateUtil.parse(time, format);
        int last = date.getLastDayOfMonth();
        if (last < 10) {
            return "-0" + date.getLastDayOfMonth();
        } else {
            return "-" + date.getLastDayOfMonth();
        }
    }
}
