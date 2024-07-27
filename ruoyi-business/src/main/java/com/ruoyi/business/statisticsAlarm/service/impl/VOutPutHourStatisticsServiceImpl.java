package com.ruoyi.business.statisticsAlarm.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.mapper.VOutPutInfoMapper;
import com.ruoyi.business.statisticsAlarm.domain.VOutPutDayStatistics;
import com.ruoyi.business.statisticsAlarm.domain.VOutPutHourStatistics;
import com.ruoyi.business.statisticsAlarm.dto.AlarmEmissionsDto;
import com.ruoyi.business.statisticsAlarm.dto.DataMissingDto;
import com.ruoyi.business.statisticsAlarm.mapper.VOutPutDayStatisticsMapper;
import com.ruoyi.business.statisticsAlarm.mapper.VOutPutHourStatisticsMapper;
import com.ruoyi.business.statisticsAlarm.service.IVOutPutHourStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 排口小时报警统计视图Service业务层处理
 *
 * @author lx
 * @date 2024-07-19
 */
@Service
public class VOutPutHourStatisticsServiceImpl implements IVOutPutHourStatisticsService {
    @Autowired
    private VOutPutHourStatisticsMapper vOutPutHourStatisticsMapper;
    @Resource
    private VOutPutInfoMapper vOutPutInfoMapper;
    @Resource
    private VOutPutDayStatisticsMapper vOutPutDayStatisticsMapper;



    /**
     * 查询排口小时报警统计视图
     *
     * @param entName 排口小时报警统计视图主键
     * @return 排口小时报警统计视图
     */
    @Override
    public VOutPutHourStatistics selectVOutPutHourStatisticsByEntName(String entName) {
        return vOutPutHourStatisticsMapper.selectVOutPutHourStatisticsByEntName(entName);
    }

    /**
     * 查询排口小时报警统计视图列表
     *
     * @param vOutPutHourStatistics 排口小时报警统计视图
     * @return 排口小时报警统计视图
     */
    @Override
    public List<VOutPutHourStatistics> selectVOutPutHourStatisticsList(VOutPutHourStatistics vOutPutHourStatistics) {
        return vOutPutHourStatisticsMapper.selectVOutPutHourStatisticsList(vOutPutHourStatistics);
    }


    /**
     * 排放量报警
     *
     * @param vOutPutHourStatistics
     * @return
     */
    @Override
    public List<VOutPutHourStatistics> selectVOutPutHourEmissionsList(VOutPutHourStatistics vOutPutHourStatistics) {
        return vOutPutHourStatisticsMapper.selectVOutPutHourEmissionsList(vOutPutHourStatistics);
    }

    @Override
    public List<DataMissingDto> selectDataMissingList(DataMissingDto dataMissingDto) {
        Map<String, Object> params = dataMissingDto.getParams();
        List<String> outPutNames = new ArrayList<>();
        if(StrUtil.isNotBlank(dataMissingDto.getOutPutCode())){
            //DA001
            VOutPutInfo vOutPutInfo = new VOutPutInfo();
            vOutPutInfo.setOutPutCode(dataMissingDto.getOutPutCode());
            List<VOutPutInfo> vOutPutInfos = vOutPutInfoMapper.selectVOutPutInfoList(vOutPutInfo);
            for (VOutPutInfo v:vOutPutInfos) {
                outPutNames.add(v.getOutPutName());
            }
        }else{
            outPutNames = vOutPutHourStatisticsMapper.selectVOutPutHourStatisticsByEntCode(dataMissingDto.getEntCode());
        }
        Date beginTime = MapUtil.getDate(params,"beginTime", new Date());
        Date endTime =  MapUtil.getDate(params,"endTime", new Date());
        String sqlStr = getSqlStr(outPutNames, beginTime, endTime);
        if(ObjUtil.isNotNull(params)){
            params.put("sqlStr", sqlStr);
        }else{
            dataMissingDto.setParams(MapUtil.builder("sqlStr", (Object) sqlStr).build());
        }
        return vOutPutHourStatisticsMapper.selectDataMissingList(dataMissingDto);
    }

    @Override
    public List<AlarmEmissionsDto> selectAlarmEmissionsDtoList(VOutPutDayStatistics vOutPutDayStatistics) {
        return vOutPutDayStatisticsMapper.selectAlarmExceptionDtoList(vOutPutDayStatistics);
    }


    private String getSqlStr(List<String> outPutNames, Date beginTime, Date endTime) {

        List<String> betweenHour = getBetweenHour(DateUtil.format(beginTime, "yyyy-MM-dd")+" 00",
                DateUtil.format(endTime, "yyyy-MM-dd")+" 23");
        String sqlStr = "";
        for (String s : betweenHour) {
            for (String str:outPutNames ) {
                sqlStr += "SELECT '"+str+"' AS out_put_name,  '"+s+"' as tday  " + " UNION ALL ";
            }
        }
        int lastIndexOf = sqlStr.lastIndexOf("UNION ALL");
        return sqlStr.substring(0, lastIndexOf);
    }

    //生成两个日期之间的每天的小时 组装成 yyyy-MM-dd HH
    private List<String> getBetweenHour(String start, String end) {
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        try {
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            while (calendar.getTime().before(endDate)) {
                result.add(sdf.format(calendar.getTime()));
                calendar.add(Calendar.HOUR_OF_DAY, 1);
            }
            result.add(sdf.format(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
