package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.mapper.VOutPutInfoMapper;
import com.ruoyi.business.base.service.IVOutPutInfoService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<VOutPutInfo> selectVOutPutInfoList(VOutPutInfo vOutPutInfo) {
        return vOutPutInfoMapper.selectVOutPutInfoList(vOutPutInfo);
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
