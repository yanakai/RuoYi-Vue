package com.ruoyi.business.base.service;

import java.util.List;
import com.ruoyi.business.base.domain.VOutPutInfo;

/**
 * 污染排口信息Service接口
 * 
 * @author lx
 * @date 2024-07-13
 */
public interface IVOutPutInfoService 
{
    /**
     * 查询污染排口信息
     * 
     * @param id 污染排口信息主键
     * @return 污染排口信息
     */
    public VOutPutInfo selectVOutPutInfoById(Long id);

    /**
     * 查询污染排口信息列表
     * 
     * @param vOutPutInfo 污染排口信息
     * @return 污染排口信息集合
     */
    public List<VOutPutInfo> selectVOutPutInfoList(VOutPutInfo vOutPutInfo);

    /**
     * 新增污染排口信息
     * 
     * @param vOutPutInfo 污染排口信息
     * @return 结果
     */
    public int insertVOutPutInfo(VOutPutInfo vOutPutInfo);

    /**
     * 修改污染排口信息
     * 
     * @param vOutPutInfo 污染排口信息
     * @return 结果
     */
    public int updateVOutPutInfo(VOutPutInfo vOutPutInfo);

    /**
     * 批量删除污染排口信息
     * 
     * @param ids 需要删除的污染排口信息主键集合
     * @return 结果
     */
    public int deleteVOutPutInfoByIds(Long[] ids);

    /**
     * 删除污染排口信息信息
     * 
     * @param id 污染排口信息主键
     * @return 结果
     */
    public int deleteVOutPutInfoById(Long id);
}
