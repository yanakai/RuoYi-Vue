package com.ruoyi.business.statisticsAlarm.mapper;

import com.ruoyi.business.statisticsAlarm.domain.TDataWateroutControlHour;
import com.ruoyi.business.statisticsAlarm.dto.OutControlHourDto;

import java.util.List;

/**
 * 废水排口--小时剩余排放平均值Mapper接口
 *
 * @author lx
 * @date 2024-07-13
 */
public interface TDataWateroutControlHourMapper {
    /**
     * 查询废水排口--小时剩余排放平均值
     *
     * @param id 废水排口--小时剩余排放平均值主键
     * @return 废水排口--小时剩余排放平均值
     */
    TDataWateroutControlHour selectTDataWateroutControlHourById(Long id);

    /**
     * 查询废水排口--小时剩余排放平均值列表
     *
     * @param outControlHourDto 废水排口--小时剩余排放平均值
     * @return 废水排口--小时剩余排放平均值集合
     */
    List<TDataWateroutControlHour> selectTDataWateroutControlHourList(OutControlHourDto outControlHourDto);

    /**
     * 新增废水排口--小时剩余排放平均值
     *
     * @param tDataWateroutControlHour 废水排口--小时剩余排放平均值
     * @return 结果
     */
    int insertTDataWateroutControlHour(TDataWateroutControlHour tDataWateroutControlHour);

    /**
     * 修改废水排口--小时剩余排放平均值
     *
     * @param tDataWateroutControlHour 废水排口--小时剩余排放平均值
     * @return 结果
     */
    int updateTDataWateroutControlHour(TDataWateroutControlHour tDataWateroutControlHour);

    /**
     * 删除废水排口--小时剩余排放平均值
     *
     * @param id 废水排口--小时剩余排放平均值主键
     * @return 结果
     */
    int deleteTDataWateroutControlHourById(Long id);

    /**
     * 批量删除废水排口--小时剩余排放平均值
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTDataWateroutControlHourByIds(Long[] ids);
}