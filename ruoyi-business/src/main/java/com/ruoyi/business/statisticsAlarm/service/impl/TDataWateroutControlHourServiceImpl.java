package com.ruoyi.business.statisticsAlarm.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.ruoyi.business.statisticsAlarm.domain.TDataWateroutControlHour;
import com.ruoyi.business.statisticsAlarm.dto.OutControlHourDto;
import com.ruoyi.business.statisticsAlarm.mapper.TDataWateroutControlHourMapper;
import com.ruoyi.business.statisticsAlarm.service.ITDataWateroutControlHourService;
import com.ruoyi.common.annotation.DataEntScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @DataEntScope
    public List<TDataWateroutControlHour> selectTDataWateroutControlHourList(OutControlHourDto outControlHourDto, LoginUser user) {
        StringBuilder dataScopSqlString = new StringBuilder();
        String entCode = user.getUser().getEntCode();
        if(StringUtils.isNotEmpty(entCode)){
            dataScopSqlString.append(StringUtils.format(" and  ent_code = '{}' ", entCode));
        }
        if(ObjUtil.isNotEmpty(outControlHourDto.getParams())){
            outControlHourDto.getParams().put("dataEntScope", " AND (" + dataScopSqlString.substring(5) + ")");
        }else{
            Map<String,Object> params = new HashMap<>();
            if(!user.getUser().isAdmin() && StringUtils.isNotEmpty(entCode)){
                params.put("dataEntScope", " AND (" + StringUtils.format(" ent_code = '{}' ", entCode) + ")");
                outControlHourDto.setParams(params);
            }
        }
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
