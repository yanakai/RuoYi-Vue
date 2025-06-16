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
import com.ruoyi.business.onlineMonitoring.dto.DataEnum;
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
        TBasGasoutputPollutant info = tBasGasoutputPollutantMapper.selectTBasGasoutputPollutantById(id);
        info.setMonFactor(JSONArray.parseArray(info.getMonFactorStr(), MonFactorInfo.class));
        return info;
    }

    /**
     * 查询基础信息--企业--废气排口污染物基本信息列表
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 基础信息--企业--废气排口污染物基本信息
     */
    @Override
    public List<TBasGasoutputPollutant> selectTBasGasoutputPollutantList(TBasGasoutputPollutant tBasGasoutputPollutant) {
        List<TBasGasoutputPollutant> list = tBasGasoutputPollutantMapper.selectTBasGasoutputPollutantList(tBasGasoutputPollutant);
        list.forEach( e -> e.setMonFactor(JSONArray.parseArray(e.getMonFactorStr(), MonFactorInfo.class)));
        return list;
    }

    /**
     * 查询基础信息--企业--废气排口污染物基本信息自动表头列表
     */
    @Override
    public List<OutputPollutantAutoHead> selectOutputPollutantAutoHead(String entCode, String outPutCode, String dataEnum) {
        List<OutputPollutantAutoHead> headList = tBasGasoutputPollutantMapper.selectOutputPollutantAutoHead(entCode, outPutCode);
        headList.forEach( e -> {
            List<MonFactorInfo> monFactor = new ArrayList<>();
            e.setMonFactor(monFactor);
            // 未配置监测因子，先按默认来
            if (StringUtils.isEmpty(e.getMonFactorStr()) || StringUtils.isEmpty(e.getBaseMonFactorStr())) {
                if (DataEnum.real.name().equals(dataEnum)) {
                    if ("a00000".equals(e.getPollutantCode())) { // 废气流量
                        addFactor("rtd", "实测值", "volumeAvgFlow", monFactor);
                    } else if ("a34013".equals(e.getPollutantCode())) { // 烟尘
                        addFactor("rtd", "实测值", "ycAvgValue", monFactor);
                    } else if ("a21026".equals(e.getPollutantCode())) { // 二氧化硫
                        addFactor("rtd", "实测值", "so2AvgValue", monFactor);
                    } else if ("a21002".equals(e.getPollutantCode())) { // 氮氧化物
                        addFactor("rtd", "实测值", "noAvgValue", monFactor);
                    } else if ("a19001".equals(e.getPollutantCode())) { // 氧气含量
                        addFactor("rtd", "实测值", "oxygenContent", monFactor);
                    } else if ("a01012".equals(e.getPollutantCode())) { // 烟气温度
                        addFactor("rtd", "实测值", "yqTemperature", monFactor);
                    } else if ("a01014".equals(e.getPollutantCode())) { // 烟气湿度
                        addFactor("rtd", "实测值", "yqHumidity", monFactor);
                    } else if ("a01013".equals(e.getPollutantCode())) { // 烟气压力
                        addFactor("rtd", "实测值", "yqPressure", monFactor);
                    } else if ("a01011".equals(e.getPollutantCode())) { // 烟气流速
                        addFactor("rtd", "实测值", "velocityFlow", monFactor);
                    }
                } else {
                    if ("a00000".equals(e.getPollutantCode())) { // 废气流量
                        addFactor("avg", "平均值", "volumeAvgFlow", monFactor);
                        addFactor("cou", "排放量", "volumeTotalFlow", monFactor);
                    } else if ("a34013".equals(e.getPollutantCode())) { // 烟尘
                        addFactor("avg", "平均值", "ycAvgValue", monFactor);
                        addFactor("zsAvg", "折算平均值", "ycZsavgValue", monFactor);
                        addFactor("cou", "排放量", "ycEmissions", monFactor);
                    } else if ("a21026".equals(e.getPollutantCode())) { // 二氧化硫
                        addFactor("avg", "平均值", "so2AvgValue", monFactor);
                        addFactor("zsAvg", "折算平均值", "so2ZsavgValue", monFactor);
                        addFactor("cou", "排放量", "so2Emissions", monFactor);
                    } else if ("a21002".equals(e.getPollutantCode())) { // 氮氧化物
                        addFactor("avg", "平均值", "noAvgValue", monFactor);
                        addFactor("zsAvg", "折算平均值", "noZsavgValue", monFactor);
                        addFactor("cou", "排放量", "noEmissions", monFactor);
                    } else if ("a19001".equals(e.getPollutantCode())) { // 氧气含量
                        addFactor("avg", "平均值", "oxygenContent", monFactor);
                    } else if ("a01012".equals(e.getPollutantCode())) { // 烟气温度
                        addFactor("avg", "平均值", "yqTemperature", monFactor);
                    } else if ("a01014".equals(e.getPollutantCode())) { // 烟气湿度
                        addFactor("avg", "平均值", "yqHumidity", monFactor);
                    } else if ("a01013".equals(e.getPollutantCode())) { // 烟气压力
                        addFactor("avg", "平均值", "yqPressure", monFactor);
                    } else if ("a01011".equals(e.getPollutantCode())) { // 烟气流速
                        addFactor("avg", "平均值", "velocityFlow", monFactor);
                    }
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
                    if (DataEnum.real.name().equals(dataEnum)) {
                        if ("rtd".equals(name)) { // 实时数据只查看实测值
                            monFactor.add(factor);
                        }
                    } else {
                        if (!"rtd".equals(name)) { // 非实时数据不查看实测值
                            monFactor.add(factor);
                        }
                    }
                    if (DataEnum.real.name().equals(dataEnum)) {
                        if ("a00000".equals(e.getPollutantCode())) { // 废气流量
                            if ("rtd".equals(name)) {
                                factor.setField("volumeAvgFlow");
                            }
                        } else if ("a34013".equals(e.getPollutantCode())) { // 烟尘
                            if ("rtd".equals(name)) {
                                factor.setField("ycAvgValue");
                            }
                        } else if ("a21026".equals(e.getPollutantCode())) { // 二氧化硫
                            if ("rtd".equals(name)) {
                                factor.setField("so2AvgValue");
                            }
                        } else if ("a21002".equals(e.getPollutantCode())) { // 氮氧化物
                            if ("rtd".equals(name)) {
                                factor.setField("noAvgValue");
                            }
                        } else if ("a19001".equals(e.getPollutantCode())) { // 氧气含量
                            if ("rtd".equals(name)) {
                                factor.setField("oxygenContent");
                            }
                        } else if ("a01012".equals(e.getPollutantCode())) { // 烟气温度
                            if ("rtd".equals(name)) {
                                factor.setField("yqTemperature");
                            }
                        } else if ("a01014".equals(e.getPollutantCode())) { // 烟气湿度
                            if ("rtd".equals(name)) {
                                factor.setField("yqHumidity");
                            }
                        } else if ("a01013".equals(e.getPollutantCode())) { // 烟气压力
                            if ("rtd".equals(name)) {
                                factor.setField("yqPressure");
                            }
                        } else if ("a01011".equals(e.getPollutantCode())) { // 烟气流速
                            if ("rtd".equals(name)) {
                                factor.setField("velocityFlow");
                            }
                        }
                    } else {
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
            }
        });
        return headList;
    }

    private void addFactor(String name, String desc, String field, List<MonFactorInfo> list) {
        MonFactorInfo info = new MonFactorInfo();
        info.setName(name);
        info.setDesc(desc);
        info.setField(field);
        list.add(info);
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
