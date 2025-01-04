package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.common.core.domain.model.LoginUser;

import java.util.List;

/**
 * 污染排口信息Service接口
 *
 * @author lx
 * @date 2024-07-13
 */
public interface IVOutPutInfoService {
    /**
     * 查询污染排口信息
     *
     * @param id 污染排口信息主键
     * @return 污染排口信息
     */
    VOutPutInfo selectVOutPutInfoById(Long id);

    /**
     * 查询污染排口信息列表
     *
     * @param vOutPutInfo 污染排口信息
     * @return 污染排口信息集合
     */
    List<VOutPutInfo> selectVOutPutInfoList(VOutPutInfo vOutPutInfo , LoginUser loginUser);

    /**
     * 新增污染排口信息
     *
     * @param vOutPutInfo 污染排口信息
     * @return 结果
     */
    int insertVOutPutInfo(VOutPutInfo vOutPutInfo);

    /**
     * 修改污染排口信息
     *
     * @param vOutPutInfo 污染排口信息
     * @return 结果
     */
    int updateVOutPutInfo(VOutPutInfo vOutPutInfo);

    /**
     * 批量删除污染排口信息
     *
     * @param ids 需要删除的污染排口信息主键集合
     * @return 结果
     */
    int deleteVOutPutInfoByIds(Long[] ids);

    /**
     * 删除污染排口信息信息
     *
     * @param id 污染排口信息主键
     * @return 结果
     */
    int deleteVOutPutInfoById(Long id);
}
