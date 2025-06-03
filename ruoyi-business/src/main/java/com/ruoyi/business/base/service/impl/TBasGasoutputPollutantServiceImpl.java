package com.ruoyi.business.base.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.business.base.domain.MonFactorInfo;
import com.ruoyi.business.base.domain.OutputPollutantAutoHead;
import com.ruoyi.business.base.domain.TBasGasoutPutInfo;
import com.ruoyi.business.base.domain.TBasGasoutputPollutant;
import com.ruoyi.business.base.mapper.TBasGasoutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasGasoutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasGasoutputPollutantService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 基础信息--企业--废气排口污染物基本信息Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasGasoutputPollutantServiceImpl implements ITBasGasoutputPollutantService {
    @Autowired
    private TBasGasoutputPollutantMapper tBasGasoutputPollutantMapper;

    @Resource
    private TBasGasoutPutInfoMapper gasoutputPollutantMapper;

    /**
     * 查询基础信息--企业--废气排口污染物基本信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 基础信息--企业--废气排口污染物基本信息
     */
    @Override
    public TBasGasoutputPollutant selectTBasGasoutputPollutantById(Long id) {
        return tBasGasoutputPollutantMapper.selectTBasGasoutputPollutantById(id);
    }

    /**
     * 查询基础信息--企业--废气排口污染物基本信息列表
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 基础信息--企业--废气排口污染物基本信息
     */
    @Override
    public List<TBasGasoutputPollutant> selectTBasGasoutputPollutantList(TBasGasoutputPollutant tBasGasoutputPollutant) {
        return tBasGasoutputPollutantMapper.selectTBasGasoutputPollutantList(tBasGasoutputPollutant);
    }

    /**
     * 查询基础信息--企业--废气排口污染物基本信息自动表头列表
     */
    @Override
    public List<OutputPollutantAutoHead> selectOutputPollutantAutoHead(String entCode, String outPutCode) {
        List<OutputPollutantAutoHead> headList = tBasGasoutputPollutantMapper.selectOutputPollutantAutoHead(entCode, outPutCode);
        headList.forEach( e -> {
            List<MonFactorInfo> monFactor = new ArrayList<>();
            e.setMonFactor(monFactor);
            // 未配置监测因子，先按默认来
            if (StringUtils.isEmpty(e.getMonFactorStr()) || StringUtils.isEmpty(e.getBaseMonFactorStr())) {
                MonFactorInfo sub;
                if ("a00000".equals(e.getPollutantCode())) { // 废气流量
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("volumeAvgFlow");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("volumeTotalFlow");
                    monFactor.add(sub);
                } else if ("a34013".equals(e.getPollutantCode())) { // 烟尘
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("ycAvgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("zsAvg");
                    sub.setDesc("折算平均值");
                    sub.setField("ycZsavgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("ycEmissions");
                    monFactor.add(sub);
                } else if ("a21026".equals(e.getPollutantCode())) { // 二氧化硫
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("so2AvgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("zsAvg");
                    sub.setDesc("折算平均值");
                    sub.setField("so2ZsavgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("so2Emissions");
                    monFactor.add(sub);
                } else if ("a21002".equals(e.getPollutantCode())) { // 氮氧化物
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("noAvgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("zsAvg");
                    sub.setDesc("折算平均值");
                    sub.setField("noZsavgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("noEmissions");
                    monFactor.add(sub);
                } else if ("a19001".equals(e.getPollutantCode())) { // 氧气含量
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("oxygenContent");
                    monFactor.add(sub);
                } else if ("a01012".equals(e.getPollutantCode())) { // 烟气温度
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("yqTemperature");
                    monFactor.add(sub);
                } else if ("a01014".equals(e.getPollutantCode())) { // 烟气湿度
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("yqHumidity");
                    monFactor.add(sub);
                } else if ("a01013".equals(e.getPollutantCode())) { // 烟气压力
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("yqPressure");
                    monFactor.add(sub);
                } else if ("a01011".equals(e.getPollutantCode())) { // 烟气流速
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("velocityFlow");
                    monFactor.add(sub);
                }
            } else {
                List<MonFactorInfo> monFactorStr = JSONArray.parseArray(e.getMonFactorStr(), MonFactorInfo.class);
                Map<String, String> baseMonFactor = JSONArray.parseArray(e.getBaseMonFactorStr(), MonFactorInfo.class).stream()
                        .collect(Collectors.toMap(MonFactorInfo::getName, MonFactorInfo::getDesc, (v1, v2) -> v1));
                for (MonFactorInfo factor : monFactorStr) {
                    String name = factor.getName();
                    factor.setDesc(baseMonFactor.get(name));
                    // 判断是否选中，1选中
                    if (null == factor.getValue() || factor.getValue() != 1) {
                        continue;
                    }
                    monFactor.add(factor);
                    if ("a00000".equals(e.getPollutantCode())) { // 废气流量
                        if ("avg".equals(name)) {
                            factor.setField("volumeAvgFlow");
                        } else if ("cou".equals(name)) {
                            factor.setField("volumeTotalFlow");
                        }
                    } else if ("a34013".equals(e.getPollutantCode())) { // 烟尘
                        if ("avg".equals(name)) {
                            factor.setField("ycAvgValue");
                        } else if ("zsAvg".equals(name)) {
                            factor.setField("ycZsavgValue");
                        } else if ("cou".equals(name)) {
                            factor.setField("ycEmissions");
                        }
                    } else if ("a21026".equals(e.getPollutantCode())) { // 二氧化硫
                        if ("avg".equals(name)) {
                            factor.setField("so2AvgValue");
                        } else if ("zsAvg".equals(name)) {
                            factor.setField("so2ZsavgValue");
                        } else if ("cou".equals(name)) {
                            factor.setField("so2Emissions");
                        }
                    } else if ("a21002".equals(e.getPollutantCode())) { // 氮氧化物
                        if ("avg".equals(name)) {
                            factor.setField("noAvgValue");
                        } else if ("zsAvg".equals(name)) {
                            factor.setField("noZsavgValue");
                        } else if ("cou".equals(name)) {
                            factor.setField("noEmissions");
                        }
                    } else if ("a19001".equals(e.getPollutantCode())) { // 氧气含量
                        if ("avg".equals(name)) {
                            factor.setField("oxygenContent");
                        }
                    } else if ("a01012".equals(e.getPollutantCode())) { // 烟气温度
                        if ("avg".equals(name)) {
                            factor.setField("yqTemperature");
                        }
                    } else if ("a01014".equals(e.getPollutantCode())) { // 烟气湿度
                        if ("avg".equals(name)) {
                            factor.setField("yqHumidity");
                        }
                    } else if ("a01013".equals(e.getPollutantCode())) { // 烟气压力
                        if ("avg".equals(name)) {
                            factor.setField("yqPressure");
                        }
                    } else if ("a01011".equals(e.getPollutantCode())) { // 烟气流速
                        if ("avg".equals(name)) {
                            factor.setField("velocityFlow");
                        }
                    }
                }
            }
        });
        return headList;
    }

    /**
     * 新增基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    @Override
    public int insertTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant) {
        tBasGasoutputPollutant.setCreateTime(DateUtils.getNowDate());

        //获取排口信息
        TBasGasoutPutInfo tBasGasoutPutInfo = new TBasGasoutPutInfo();
        tBasGasoutPutInfo.setOutPutCode(tBasGasoutputPollutant.getOutPutCode());
        if(StringUtils.isEmpty(tBasGasoutputPollutant.getEntCode()) && (StringUtils.isEmpty(tBasGasoutputPollutant.getEntName()))){
            return 0;
        }
        if (null != tBasGasoutputPollutant.getMonFactor()) {
            tBasGasoutputPollutant.getMonFactor().forEach( e -> {
                e.setField(null);
                e.setDesc(null);
            });
            tBasGasoutputPollutant.setMonFactorStr(JSONArray.toJSONString(tBasGasoutputPollutant.getMonFactor()));
        } else {
            tBasGasoutputPollutant.setMonFactorStr("[]");
        }
        tBasGasoutPutInfo.setEntCode(tBasGasoutputPollutant.getEntCode());
        tBasGasoutPutInfo.setEntName(tBasGasoutputPollutant.getEntName());
        List<TBasGasoutPutInfo> tBasGasoutPutInfos = gasoutputPollutantMapper.selectTBasGasoutPutInfoList(tBasGasoutPutInfo);
        if(ArrayUtil.isNotEmpty(tBasGasoutPutInfos)){
            tBasGasoutputPollutant.setOutPutName(tBasGasoutPutInfos.get(0).getOutPutName());
            tBasGasoutputPollutant.setEntCode(tBasGasoutPutInfos.get(0).getEntCode());
            tBasGasoutputPollutant.setEntName(tBasGasoutPutInfos.get(0).getEntName());
            tBasGasoutputPollutant.setMnNum(tBasGasoutPutInfos.get(0).getMnNum());
            return tBasGasoutputPollutantMapper.insertTBasGasoutputPollutant(tBasGasoutputPollutant);
        }

        return 0;
    }

    /**
     * 修改基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    @Override
    public int updateTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant) {
        tBasGasoutputPollutant.setUpdateTime(DateUtils.getNowDate());
        if (null != tBasGasoutputPollutant.getMonFactor()) {
            tBasGasoutputPollutant.getMonFactor().forEach( e -> {
                e.setField(null);
                e.setDesc(null);
            });
            tBasGasoutputPollutant.setMonFactorStr(JSONArray.toJSONString(tBasGasoutputPollutant.getMonFactor()));
        } else {
            tBasGasoutputPollutant.setMonFactorStr("[]");
        }
        return tBasGasoutputPollutantMapper.updateTBasGasoutputPollutant(tBasGasoutputPollutant);
    }

    /**
     * 批量删除基础信息--企业--废气排口污染物基本信息
     *
     * @param ids 需要删除的基础信息--企业--废气排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutputPollutantByIds(Long[] ids) {
        return tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantByIds(ids);
    }

    /**
     * 删除基础信息--企业--废气排口污染物基本信息信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutputPollutantById(Long id) {
        return tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantById(id);
    }
}
