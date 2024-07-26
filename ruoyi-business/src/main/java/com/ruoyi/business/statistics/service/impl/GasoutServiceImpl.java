package com.ruoyi.business.statistics.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.mapper.VOutPutInfoMapper;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    public TableDataInfo selectDataList(GasoutDTO gasoutDTO) {
        log.info("查询废气排口--在线监测数据列表:{}", gasoutDTO);
        if (gasoutDTO.getDataEnum().name().equals("hour")) {
            TDataGasoutHourStatistics tDataGasoutHourStatistics = new TDataGasoutHourStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutHourStatistics);
            PageUtils.startPage();
            List<TDataGasoutHourStatistics> list = tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsList(tDataGasoutHourStatistics);
            return getDataTable(list);
        } else if (gasoutDTO.getDataEnum().name().equals("day")) {
            TDataGasoutDayStatistics tDataGasoutDayStatistics = new TDataGasoutDayStatistics();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutDayStatistics);
            PageUtils.startPage();
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutDayStatisticsList(tDataGasoutDayStatistics);
            return getDataTable(list);
        } else if (gasoutDTO.getDataEnum().name().equals("month")) {
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            PageUtils.startPage();
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
            return getDataTable(list);
        } else if (gasoutDTO.getDataEnum().name().equals("year")) {
            TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
            BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
            PageUtils.startPage();
            List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
            return getDataTable(list);
        } else if (gasoutDTO.getDataEnum().name().equals("real")) {
            String tableNameReal = getTableName("t_data_gasout_real_",gasoutDTO);
            if(StrUtil.isNotBlank(tableNameReal)){
                TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
                BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
                tDataGasoutStatisticsDTO.getParams().put("tableName",tableNameReal);
                PageUtils.startPage();
                List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMinuteOrRealStatisticsList(tDataGasoutStatisticsDTO);
                return getDataTable(list);
            }
        } else if (gasoutDTO.getDataEnum().name().equals("minute")) {
            String tableNameMin = getTableName("t_data_gasout_minute_",gasoutDTO);
            if(StrUtil.isNotBlank(tableNameMin)){
                TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO = new TDataGasoutStatisticsDTO();
                BeanUtil.copyProperties(gasoutDTO, tDataGasoutStatisticsDTO);
                tDataGasoutStatisticsDTO.getParams().put("tableName",tableNameMin);
                PageUtils.startPage();
                List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMinuteOrRealStatisticsList(tDataGasoutStatisticsDTO);
                return getDataTable(list);
            }
        }

        return getDataTable(new ArrayList<>());
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
