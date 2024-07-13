package com.ruoyi.business.statisticsAlarm.service;

import com.ruoyi.business.statisticsAlarm.domain.TDataGasoutControlHour;
import com.ruoyi.business.statisticsAlarm.dto.OutControlHourDto;

import java.util.List;

/**
 * 废气排口--小时剩余排放平均值Service接口
 *
 * @author lx
 * @date 2024-07-13
 */
public interface ITDataGasoutControlHourService {
    /**
     * 查询废气排口--小时剩余排放平均值
     *
     * @param id 废气排口--小时剩余排放平均值主键
     * @return 废气排口--小时剩余排放平均值
     */
    TDataGasoutControlHour selectTDataGasoutControlHourById(Long id);

    /**
     * 查询废气排口--小时剩余排放平均值列表
     *
     * @param tDataGasoutControlHour 废气排口--小时剩余排放平均值
     * @return 废气排口--小时剩余排放平均值集合
     */
    List<TDataGasoutControlHour> selectTDataGasoutControlHourList(OutControlHourDto outControlHourDto);

    /**
     * 新增废气排口--小时剩余排放平均值
     *
     * @param tDataGasoutControlHour 废气排口--小时剩余排放平均值
     * @return 结果
     */
    int insertTDataGasoutControlHour(TDataGasoutControlHour tDataGasoutControlHour);

    /**
     * 修改废气排口--小时剩余排放平均值
     *
     * @param tDataGasoutControlHour 废气排口--小时剩余排放平均值
     * @return 结果
     */
    int updateTDataGasoutControlHour(TDataGasoutControlHour tDataGasoutControlHour);

    /**
     * 批量删除废气排口--小时剩余排放平均值
     *
     * @param ids 需要删除的废气排口--小时剩余排放平均值主键集合
     * @return 结果
     */
    int deleteTDataGasoutControlHourByIds(Long[] ids);

    /**
     * 删除废气排口--小时剩余排放平均值信息
     *
     * @param id 废气排口--小时剩余排放平均值主键
     * @return 结果
     */
    int deleteTDataGasoutControlHourById(Long id);
}
