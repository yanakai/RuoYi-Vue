package com.ruoyi.business.base.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.business.base.domain.MonFactorInfo;
import com.ruoyi.business.base.domain.OutputPollutantAutoHead;
import com.ruoyi.business.base.domain.TBasWateroutPutInfo;
import com.ruoyi.business.base.domain.TBasWateroutputPollutant;
import com.ruoyi.business.base.mapper.TBasWateroutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasWateroutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasWateroutputPollutantService;
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
 * 基础信息--企业--废水排口污染物基本信息Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasWateroutputPollutantServiceImpl implements ITBasWateroutputPollutantService {
    @Autowired
    private TBasWateroutputPollutantMapper tBasWateroutputPollutantMapper;

    @Resource
    private TBasWateroutPutInfoMapper waterOutputPollutantMapper;

    /**
     * 查询基础信息--企业--废水排口污染物基本信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    @Override
    public TBasWateroutputPollutant selectTBasWateroutputPollutantById(Long id) {
        TBasWateroutputPollutant info = tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantById(id);
        info.setMonFactor(JSONArray.parseArray(info.getMonFactorStr(), MonFactorInfo.class));
        return info;
    }

    /**
     * 查询基础信息--企业--废水排口污染物基本信息自动表头列表
     */
    @Override
    public List<OutputPollutantAutoHead> selectOutputPollutantAutoHead(String entCode, String outPutCode, String dataEnum) {
        List<OutputPollutantAutoHead> headList = tBasWateroutputPollutantMapper.selectOutputPollutantAutoHead(entCode, outPutCode);
        headList.forEach( e -> {
            List<MonFactorInfo> monFactor = new ArrayList<>();
            e.setMonFactor(monFactor);
            // 未配置监测因子，先按默认来
            if (StringUtils.isEmpty(e.getMonFactorStr()) || StringUtils.isEmpty(e.getBaseMonFactorStr())) {
                if (DataEnum.real.name().equals(dataEnum)) {
                    if ("w00000".equals(e.getPollutantCode())) { // 污水流量
                        addFactor("rtd", "实测值", "volumeAvgFlow", monFactor);
                    } else if ("w01001".equals(e.getPollutantCode())) { // pH值
                        addFactor("rtd", "实测值", "phValue", monFactor);
                    } else if ("w01018".equals(e.getPollutantCode())) { // 化学需氧量
                        addFactor("rtd", "实测值", "codAvgValue", monFactor);
                    } else if ("w21003".equals(e.getPollutantCode())) { // 氨氮
                        addFactor("rtd", "实测值", "anAvgValue", monFactor);
                    } else if ("w21011".equals(e.getPollutantCode())) { // 总磷
                        addFactor("rtd", "实测值", "tpAvgValue", monFactor);
                    } else if ("w21001".equals(e.getPollutantCode())) { // 总氮
                        addFactor("rtd", "实测值", "tnAvgValue", monFactor);
                    }
                } else {
                    if ("w00000".equals(e.getPollutantCode())) { // 污水流量
                        addFactor("avg", "平均值", "volumeAvgFlow", monFactor);
                        addFactor("cou", "累计值", "volumeTotalFlow", monFactor);
                    } else if ("w01001".equals(e.getPollutantCode())) { // pH值
                        addFactor("avg", "平均值", "phValue", monFactor);
                    } else if ("w01018".equals(e.getPollutantCode())) { // 化学需氧量
                        addFactor("avg", "平均值", "codAvgValue", monFactor);
                        addFactor("cou", "累计值", "codEmissions", monFactor);
                    } else if ("w21003".equals(e.getPollutantCode())) { // 氨氮
                        addFactor("avg", "平均值", "anAvgValue", monFactor);
                        addFactor("cou", "累计值", "anEmissions", monFactor);
                    } else if ("w21011".equals(e.getPollutantCode())) { // 总磷
                        addFactor("avg", "平均值", "tpAvgValue", monFactor);
                        addFactor("cou", "累计值", "tpEmissions", monFactor);
                    } else if ("w21001".equals(e.getPollutantCode())) { // 总氮
                        addFactor("avg", "平均值", "tnAvgValue", monFactor);
                        addFactor("cou", "累计值", "tnEmissions", monFactor);
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
                        if ("w00000".equals(e.getPollutantCode())) { // 污水流量
                            if ("rtd".equals(name)) {
                                factor.setField("volumeAvgFlow");
                            }
                        } else if ("w01001".equals(e.getPollutantCode())) { // pH值
                            if ("rtd".equals(name)) {
                                factor.setField("phValue");
                            }
                        } else if ("w01018".equals(e.getPollutantCode())) { // 化学需氧量
                            if ("rtd".equals(name)) {
                                factor.setField("codAvgValue");
                            }
                        } else if ("w21003".equals(e.getPollutantCode())) { // 氨氮
                            if ("rtd".equals(name)) {
                                factor.setField("anAvgValue");
                            }
                        } else if ("w21011".equals(e.getPollutantCode())) { // 总磷
                            if ("rtd".equals(name)) {
                                factor.setField("tpAvgValue");
                            }
                        } else if ("w21001".equals(e.getPollutantCode())) { // 总氮
                            if ("rtd".equals(name)) {
                                factor.setField("tnAvgValue");
                            }
                        }
                    } else {
                        if ("w00000".equals(e.getPollutantCode())) { // 污水流量
                            if ("avg".equals(name)) {
                                factor.setField("volumeAvgFlow");
                            } else if ("cou".equals(name)) {
                                factor.setField("volumeTotalFlow");
                            }
                        } else if ("w01001".equals(e.getPollutantCode())) { // pH值
                            if ("rtd".equals(name)) {
                                factor.setField("phValue");
                            }
                        } else if ("w01018".equals(e.getPollutantCode())) { // 化学需氧量
                            if ("avg".equals(name)) {
                                factor.setField("codAvgValue");
                            } else if ("cou".equals(name)) {
                                factor.setField("codEmissions");
                            }
                        } else if ("w21003".equals(e.getPollutantCode())) { // 氨氮
                            if ("avg".equals(name)) {
                                factor.setField("anAvgValue");
                            } else if ("cou".equals(name)) {
                                factor.setField("anEmissions");
                            }
                        } else if ("w21011".equals(e.getPollutantCode())) { // 总磷
                            if ("avg".equals(name)) {
                                factor.setField("tpAvgValue");
                            } else if ("cou".equals(name)) {
                                factor.setField("tpEmissions");
                            }
                        } else if ("w21001".equals(e.getPollutantCode())) { // 总氮
                            if ("avg".equals(name)) {
                                factor.setField("tnAvgValue");
                            } else if ("cou".equals(name)) {
                                factor.setField("tnEmissions");
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
     * 查询基础信息--企业--废水排口污染物基本信息列表
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    @Override
    public List<TBasWateroutputPollutant> selectTBasWateroutputPollutantList(TBasWateroutputPollutant tBasWateroutputPollutant) {
        List<TBasWateroutputPollutant> list = tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantList(tBasWateroutputPollutant);
        list.forEach( e -> e.setMonFactor(JSONArray.parseArray(e.getMonFactorStr(), MonFactorInfo.class)));
        return list;
    }

    /**
     * 新增基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    @Override
    public int insertTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setCreateTime(DateUtils.getNowDate());
        //获取排口信息
        TBasWateroutPutInfo tBasWateroutPutInfo = new TBasWateroutPutInfo();
        tBasWateroutPutInfo.setOutPutCode(tBasWateroutputPollutant.getOutPutCode());
        if(StringUtils.isEmpty(tBasWateroutputPollutant.getEntCode()) && (StringUtils.isEmpty(tBasWateroutputPollutant.getEntName()))){
            return 0;
        }
        if (null != tBasWateroutputPollutant.getMonFactor()) {
            tBasWateroutputPollutant.getMonFactor().forEach( e -> {
                e.setField(null);
                e.setDesc(null);
            });
            tBasWateroutputPollutant.setMonFactorStr(JSONArray.toJSONString(tBasWateroutputPollutant.getMonFactor()));
        } else {
            tBasWateroutputPollutant.setMonFactorStr("[]");
        }
        tBasWateroutPutInfo.setEntCode(tBasWateroutputPollutant.getEntCode());
        tBasWateroutPutInfo.setEntName(tBasWateroutputPollutant.getEntName());
        List<TBasWateroutPutInfo> list = waterOutputPollutantMapper.selectTBasWateroutPutInfoList(tBasWateroutPutInfo);
        if(ArrayUtil.isNotEmpty(list)){
            tBasWateroutputPollutant.setOutPutName(list.get(0).getOutPutName());
            tBasWateroutputPollutant.setEntCode(list.get(0).getEntCode());
            tBasWateroutputPollutant.setEntName(list.get(0).getEntName());
            tBasWateroutputPollutant.setMnNum(list.get(0).getMnNum());
            return tBasWateroutputPollutantMapper.insertTBasWateroutputPollutant(tBasWateroutputPollutant);
        }
        return 0;
    }

    /**
     * 修改基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    @Override
    public int updateTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setUpdateTime(DateUtils.getNowDate());
        if (null != tBasWateroutputPollutant.getMonFactor()) {
            tBasWateroutputPollutant.getMonFactor().forEach( e -> {
                e.setField(null);
                e.setDesc(null);
            });
            tBasWateroutputPollutant.setMonFactorStr(JSONArray.toJSONString(tBasWateroutputPollutant.getMonFactor()));
        } else {
            tBasWateroutputPollutant.setMonFactorStr("[]");
        }
        return tBasWateroutputPollutantMapper.updateTBasWateroutputPollutant(tBasWateroutputPollutant);
    }

    /**
     * 批量删除基础信息--企业--废水排口污染物基本信息
     *
     * @param ids 需要删除的基础信息--企业--废水排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantByIds(Long[] ids) {
        return tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantByIds(ids);
    }

    /**
     * 删除基础信息--企业--废水排口污染物基本信息信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantById(Long id) {
        return tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantById(id);
    }
}
