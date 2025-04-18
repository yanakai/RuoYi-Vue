package com.ruoyi.business.statistics.mapper;

import com.ruoyi.business.onlineMonitoring.dto.GasOutUnDTO;
import com.ruoyi.business.statistics.dto.PollutantInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 废气无组织排口--统计数据Mapper接口
 */
public interface TDataGasOutUnDayStatisticsMapper {

    /**
     * 获取排口的污染物列表
     * @param entCode 企业编码
     * @param outPutCode 废气排放口编码
     * @return 污染物code列表
     */
    List<PollutantInfo> selectPollutantCodes(@Param("entCode") String entCode, @Param("outPutCode") String outPutCode);

    /**
     * 查询废气排口--统计数据列表
     * 年、月、日查询日表
     * 小时查询时表
     * 分钟查询分表
     * 实时查询实时表
     * @param gasOutUnDTO 废气无组织查询参数
     * @return 废气排口--统计数据集合
     */
    List<Map<String, Object>> selectTDataGasOutUnStatisticsList(GasOutUnDTO gasOutUnDTO);
}