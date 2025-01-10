package com.ruoyi.business.statisticsAlarm.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.ruoyi.business.statisticsAlarm.domain.TDataGasoutControlHour;
import com.ruoyi.business.statisticsAlarm.dto.OutControlHourDto;
import com.ruoyi.business.statisticsAlarm.mapper.TDataGasoutControlHourMapper;
import com.ruoyi.business.statisticsAlarm.service.ITDataGasoutControlHourService;
import com.ruoyi.common.annotation.DataEntScope;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 废气排口--小时剩余排放平均值Service业务层处理
 *
 * @author lx
 * @date 2024-07-13
 */
@Service
public class TDataGasoutControlHourServiceImpl implements ITDataGasoutControlHourService {
    @Autowired
    private TDataGasoutControlHourMapper tDataGasoutControlHourMapper;

    /**
     * 查询废气排口--小时剩余排放平均值
     *
     * @param id 废气排口--小时剩余排放平均值主键
     * @return 废气排口--小时剩余排放平均值
     */
    @Override
    public TDataGasoutControlHour selectTDataGasoutControlHourById(Long id) {
        return tDataGasoutControlHourMapper.selectTDataGasoutControlHourById(id);
    }

    /**
     * 查询废气排口--小时剩余排放平均值列表
     *
     * @param outControlHourDto 废气排口--小时剩余排放平均值
     * @return 废气排口--小时剩余排放平均值
     */
    @Override
    @DataEntScope
    public List<TDataGasoutControlHour> selectTDataGasoutControlHourList(OutControlHourDto outControlHourDto, LoginUser user) {
        StringBuilder dataScopSqlString = new StringBuilder();
        String entCode = user.getUser().getEntCode();
        if(StringUtils.isNotEmpty(entCode)){
            dataScopSqlString.append(StringUtils.format(" and  ent_code = '{}' ", entCode));
        }
        if(ObjUtil.isNotEmpty(outControlHourDto.getParams())){
            outControlHourDto.getParams().put("dataEntScope", " AND (" + dataScopSqlString.substring(5) + ")");
        }else{
            Map<String,Object> params = new HashMap<>();
            params.put("dataEntScope", " AND (" + dataScopSqlString.substring(5) + ")");
            outControlHourDto.setParams(params);
        }
        return tDataGasoutControlHourMapper.selectTDataGasoutControlHourList(outControlHourDto);
    }

    /**
     * 新增废气排口--小时剩余排放平均值
     *
     * @param tDataGasoutControlHour 废气排口--小时剩余排放平均值
     * @return 结果
     */
    @Override
    public int insertTDataGasoutControlHour(TDataGasoutControlHour tDataGasoutControlHour) {
        return tDataGasoutControlHourMapper.insertTDataGasoutControlHour(tDataGasoutControlHour);
    }

    /**
     * 修改废气排口--小时剩余排放平均值
     *
     * @param tDataGasoutControlHour 废气排口--小时剩余排放平均值
     * @return 结果
     */
    @Override
    public int updateTDataGasoutControlHour(TDataGasoutControlHour tDataGasoutControlHour) {
        return tDataGasoutControlHourMapper.updateTDataGasoutControlHour(tDataGasoutControlHour);
    }

    /**
     * 批量删除废气排口--小时剩余排放平均值
     *
     * @param ids 需要删除的废气排口--小时剩余排放平均值主键
     * @return 结果
     */
    @Override
    public int deleteTDataGasoutControlHourByIds(Long[] ids) {
        return tDataGasoutControlHourMapper.deleteTDataGasoutControlHourByIds(ids);
    }

    /**
     * 删除废气排口--小时剩余排放平均值信息
     *
     * @param id 废气排口--小时剩余排放平均值主键
     * @return 结果
     */
    @Override
    public int deleteTDataGasoutControlHourById(Long id) {
        return tDataGasoutControlHourMapper.deleteTDataGasoutControlHourById(id);
    }
}
