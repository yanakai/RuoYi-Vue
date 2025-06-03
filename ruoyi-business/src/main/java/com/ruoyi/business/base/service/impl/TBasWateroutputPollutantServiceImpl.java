package com.ruoyi.business.base.service.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            JSONArray monFactor = new JSONArray();
            e.setMonFactor(monFactor);
            // 未配置监测因子，先按默认来
            if (StringUtils.isEmpty(e.getMonFactorStr()) || StringUtils.isEmpty(e.getBaseMonFactorStr())) {
                if ("w00000".equals(e.getPollutantCode())) { // 污水流量
                    JSONObject sub = new JSONObject();
                    sub.put("name", "avg");
                    sub.put("desc", "平均值");
                    sub.put("field", "volumeAvgFlow");
                    monFactor.add(sub);
                    sub = new JSONObject();
                    sub.put("name", "cou");
                    sub.put("desc", "累计值");
                    sub.put("field", "volumeTotalFlow");
                    monFactor.add(sub);
                } else if ("w01001".equals(e.getPollutantCode())) { // pH值
                    JSONObject sub = new JSONObject();
                    sub.put("name", "rtd");
                    sub.put("desc", "实测值");
                    sub.put("field", "phValue");
                    monFactor.add(sub);
                } else if ("w01018".equals(e.getPollutantCode())) { // 化学需氧量
                    JSONObject sub = new JSONObject();
                    sub.put("name", "avg");
                    sub.put("desc", "平均值");
                    sub.put("field", "codAvgValue");
                    monFactor.add(sub);
                    sub = new JSONObject();
                    sub.put("name", "cou");
                    sub.put("desc", "累计值");
                    sub.put("field", "codEmissions");
                    monFactor.add(sub);
                } else if ("w21003".equals(e.getPollutantCode())) { // 氨氮
                    JSONObject sub = new JSONObject();
                    sub.put("name", "avg");
                    sub.put("desc", "平均值");
                    sub.put("field", "anAvgValue");
                    monFactor.add(sub);
                    sub = new JSONObject();
                    sub.put("name", "cou");
                    sub.put("desc", "累计值");
                    sub.put("field", "anEmissions");
                    monFactor.add(sub);
                } else if ("w21011".equals(e.getPollutantCode())) { // 总磷
                    JSONObject sub = new JSONObject();
                    sub.put("name", "avg");
                    sub.put("desc", "平均值");
                    sub.put("field", "tpAvgValue");
                    monFactor.add(sub);
                    sub = new JSONObject();
                    sub.put("name", "cou");
                    sub.put("desc", "累计值");
                    sub.put("field", "tpEmissions");
                    monFactor.add(sub);
                } else if ("w21001".equals(e.getPollutantCode())) { // 总氮
                    JSONObject sub = new JSONObject();
                    sub.put("name", "avg");
                    sub.put("desc", "平均值");
                    sub.put("field", "tnAvgValue");
                    monFactor.add(sub);
                    sub = new JSONObject();
                    sub.put("name", "cou");
                    sub.put("desc", "累计值");
                    sub.put("field", "tnEmissions");
                    monFactor.add(sub);
                }
            } else {
                JSONArray monFactorStr = JSONArray.parse(e.getMonFactorStr());
                JSONArray baseMonFactorStr = JSONArray.parse(e.getBaseMonFactorStr());
                Map<String, String> baseMonFactor = new HashMap<>();
                for (int i = 0; i < baseMonFactorStr.size(); i++) {
                    JSONObject factor = baseMonFactorStr.getJSONObject(i);
                    baseMonFactor.put(factor.getString("name"), factor.getString("desc"));
                }
                for (int i = 0; i < monFactorStr.size(); i++) {
                    JSONObject factor = monFactorStr.getJSONObject(i);
                    String name = factor.getString("name");
                    factor.put("desc", baseMonFactor.get(name));
                    monFactor.add(factor);
                    if ("w00000".equals(e.getPollutantCode())) { // 污水流量
                        if ("avg".equals(name)) {
                            factor.put("field", "volumeAvgFlow");
                        } else if ("cou".equals(name)) {
                            factor.put("field", "volumeTotalFlow");
                        }
                    } else if ("w01001".equals(e.getPollutantCode())) { // pH值
                        if ("rtd".equals(name)) {
                            factor.put("field", "phValue");
                        }
                    } else if ("w01018".equals(e.getPollutantCode())) { // 化学需氧量
                        if ("avg".equals(name)) {
                            factor.put("field", "codAvgValue");
                        } else if ("cou".equals(name)) {
                            factor.put("field", "codEmissions");
                        }
                    } else if ("w21003".equals(e.getPollutantCode())) { // 氨氮
                        if ("avg".equals(name)) {
                            factor.put("field", "anAvgValue");
                        } else if ("cou".equals(name)) {
                            factor.put("field", "anEmissions");
                        }
                    } else if ("w21011".equals(e.getPollutantCode())) { // 总磷
                        if ("avg".equals(name)) {
                            factor.put("field", "tpAvgValue");
                        } else if ("cou".equals(name)) {
                            factor.put("field", "tpEmissions");
                        }
                    } else if ("w21001".equals(e.getPollutantCode())) { // 总氮
                        if ("avg".equals(name)) {
                            factor.put("field", "tnAvgValue");
                        } else if ("cou".equals(name)) {
                            factor.put("field", "tnEmissions");
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
