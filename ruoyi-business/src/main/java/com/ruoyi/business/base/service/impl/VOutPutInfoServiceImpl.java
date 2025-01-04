package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.mapper.VOutPutInfoMapper;
import com.ruoyi.business.base.service.IVOutPutInfoService;
import com.ruoyi.common.annotation.DataEntScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 污染排口信息Service业务层处理
 *
 * @author lx
 * @date 2024-07-13
 */
@Service
public class VOutPutInfoServiceImpl implements IVOutPutInfoService {
    @Autowired
    private VOutPutInfoMapper vOutPutInfoMapper;

    /**
     * 查询污染排口信息
     *
     * @param id 污染排口信息主键
     * @return 污染排口信息
     */
    @Override
    public VOutPutInfo selectVOutPutInfoById(Long id) {
        return vOutPutInfoMapper.selectVOutPutInfoById(id);
    }

    /**
     * 查询污染排口信息列表
     *
     * @param vOutPutInfo 污染排口信息
     * @return 污染排口信息
     */
    @Override
    @DataEntScope
    public List<VOutPutInfo> selectVOutPutInfoList(VOutPutInfo vOutPutInfo, LoginUser loginUser) {
        List<VOutPutInfo> vOutPutInfos = vOutPutInfoMapper.selectVOutPutInfoList(vOutPutInfo);
        vOutPutInfos.forEach(vOutPutInfo1 -> {
            Map<String, Object> map =  new HashMap<>();
            map.put("userId", loginUser.getUser().getUserId());
            map.put("entCode", vOutPutInfo1.getEntCode());
            map.put("monitoringPointType", vOutPutInfo1.getMonitoringPointType());
            map.put("outPutCode", vOutPutInfo1.getOutPutCode());
            int count = vOutPutInfoMapper.selectTBasUserPutInfoList(map);
            vOutPutInfo1.setAttention(count > 0);
        });
        return vOutPutInfos;
//        return vOutPutInfoMapper.selectVOutPutInfoList(vOutPutInfo);
    }

    /**
     * 新增污染排口信息
     *
     * @param vOutPutInfo 污染排口信息
     * @return 结果
     */
    @Override
    public int insertVOutPutInfo(VOutPutInfo vOutPutInfo) {
        vOutPutInfo.setCreateTime(DateUtils.getNowDate());
        return vOutPutInfoMapper.insertVOutPutInfo(vOutPutInfo);
    }

    /**
     * 修改污染排口信息
     *
     * @param vOutPutInfo 污染排口信息
     * @return 结果
     */
    @Override
    public int updateVOutPutInfo(VOutPutInfo vOutPutInfo) {
        return vOutPutInfoMapper.updateVOutPutInfo(vOutPutInfo);
    }

    /**
     * 批量删除污染排口信息
     *
     * @param ids 需要删除的污染排口信息主键
     * @return 结果
     */
    @Override
    public int deleteVOutPutInfoByIds(Long[] ids) {
        return vOutPutInfoMapper.deleteVOutPutInfoByIds(ids);
    }

    /**
     * 删除污染排口信息信息
     *
     * @param id 污染排口信息主键
     * @return 结果
     */
    @Override
    public int deleteVOutPutInfoById(Long id) {
        return vOutPutInfoMapper.deleteVOutPutInfoById(id);
    }
}
