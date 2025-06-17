package com.ruoyi.business.statisticsAlarm.mapper;

import com.ruoyi.business.statisticsAlarm.domain.EntAnnualOutputInfo;
import com.ruoyi.business.statisticsAlarm.domain.EntAnnualOutputInfoReq;

import java.util.List;

/**
 * 企业年排量信息记录Mapper接口
 */
public interface EntAnnualOutputInfoMapper {

    /**
     * 查询企业年排量信息记录列表
     */
    List<EntAnnualOutputInfo> selectEntAnnualOutputInfoList(EntAnnualOutputInfoReq req);
}
