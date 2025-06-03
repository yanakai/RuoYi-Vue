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
        return tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantById(id);
    }

    /**
     * 查询基础信息--企业--废水排口污染物基本信息自动表头列表
     */
    @Override
    public List<OutputPollutantAutoHead> selectOutputPollutantAutoHead(String entCode, String outPutCode) {
        List<OutputPollutantAutoHead> headList = tBasWateroutputPollutantMapper.selectOutputPollutantAutoHead(entCode, outPutCode);
        headList.forEach( e -> {
            List<MonFactorInfo> monFactor = new ArrayList<>();
            e.setMonFactor(monFactor);
            // 未配置监测因子，先按默认来
            if (StringUtils.isEmpty(e.getMonFactorStr()) || StringUtils.isEmpty(e.getBaseMonFactorStr())) {
                MonFactorInfo sub;
                if ("w00000".equals(e.getPollutantCode())) { // 污水流量
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
                } else if ("w01001".equals(e.getPollutantCode())) { // pH值
                    sub = new MonFactorInfo();
                    sub.setName("rtd");
                    sub.setDesc("实测值");
                    sub.setField("phValue");
                    monFactor.add(sub);
                } else if ("w01018".equals(e.getPollutantCode())) { // 化学需氧量
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("codAvgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("codEmissions");
                    monFactor.add(sub);
                } else if ("w21003".equals(e.getPollutantCode())) { // 氨氮
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("anAvgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("anEmissions");
                    monFactor.add(sub);
                } else if ("w21011".equals(e.getPollutantCode())) { // 总磷
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("tpAvgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("tpEmissions");
                    monFactor.add(sub);
                } else if ("w21001".equals(e.getPollutantCode())) { // 总氮
                    sub = new MonFactorInfo();
                    sub.setName("avg");
                    sub.setDesc("平均值");
                    sub.setField("tnAvgValue");
                    monFactor.add(sub);
                    sub = new MonFactorInfo();
                    sub.setName("cou");
                    sub.setDesc("累计值");
                    sub.setField("tnEmissions");
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
        });
        return headList;
    }

    /**
     * 查询基础信息--企业--废水排口污染物基本信息列表
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    @Override
    public List<TBasWateroutputPollutant> selectTBasWateroutputPollutantList(TBasWateroutputPollutant tBasWateroutputPollutant) {
        return tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantList(tBasWateroutputPollutant);
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
