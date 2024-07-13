package com.ruoyi.business.statisticsAlarm.service.impl;

import com.ruoyi.business.statisticsAlarm.domain.TDataWateroutControlHour;
import com.ruoyi.business.statisticsAlarm.dto.OutControlHourDto;
import com.ruoyi.business.statisticsAlarm.mapper.TDataWateroutControlHourMapper;
import com.ruoyi.business.statisticsAlarm.service.ITDataWateroutControlHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 废水排口--小时剩余排放平均值Service业务层处理
 *
 * @author lx
 * @date 2024-07-13
 */
@Service
public class TDataWateroutControlHourServiceImpl implements ITDataWateroutControlHourService {
    @Autowired
    private TDataWateroutControlHourMapper tDataWateroutControlHourMapper;

    /**
     * 查询废水排口--小时剩余排放平均值
     *
     * @param id 废水排口--小时剩余排放平均值主键
     * @return 废水排口--小时剩余排放平均值
     */
    @Override
    public TDataWateroutControlHour selectTDataWateroutControlHourById(Long id) {
        return tDataWateroutControlHourMapper.selectTDataWateroutControlHourById(id);
    }

    /**
     * 查询废水排口--小时剩余排放平均值列表
     *
     * @param outControlHourDto 废水排口--小时剩余排放平均值
     * @return 废水排口--小时剩余排放平均值
     */
    @Override
    public List<TDataWateroutControlHour> selectTDataWateroutControlHourList(OutControlHourDto outControlHourDto) {
        return tDataWateroutControlHourMapper.selectTDataWateroutControlHourList(outControlHourDto);
    }

    /**
     * 新增废水排口--小时剩余排放平均值
     *
     * @param tDataWateroutControlHour 废水排口--小时剩余排放平均值
     * @return 结果
     */
    @Override
    public int insertTDataWateroutControlHour(TDataWateroutControlHour tDataWateroutControlHour) {
        return tDataWateroutControlHourMapper.insertTDataWateroutControlHour(tDataWateroutControlHour);
    }

    /**
     * 修改废水排口--小时剩余排放平均值
     *
     * @param tDataWateroutControlHour 废水排口--小时剩余排放平均值
     * @return 结果
     */
    @Override
    public int updateTDataWateroutControlHour(TDataWateroutControlHour tDataWateroutControlHour) {
        return tDataWateroutControlHourMapper.updateTDataWateroutControlHour(tDataWateroutControlHour);
    }

    /**
     * 批量删除废水排口--小时剩余排放平均值
     *
     * @param ids 需要删除的废水排口--小时剩余排放平均值主键
     * @return 结果
     */
    @Override
    public int deleteTDataWateroutControlHourByIds(Long[] ids) {
        return tDataWateroutControlHourMapper.deleteTDataWateroutControlHourByIds(ids);
    }

    /**
     * 删除废水排口--小时剩余排放平均值信息
     *
     * @param id 废水排口--小时剩余排放平均值主键
     * @return 结果
     */
    @Override
    public int deleteTDataWateroutControlHourById(Long id) {
        return tDataWateroutControlHourMapper.deleteTDataWateroutControlHourById(id);
    }
}
