package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.VOutPutInfo;

import java.util.List;
import java.util.Map;

/**
 * 污染排口信息Mapper接口
 *
 * @author lx
 * @date 2024-07-13
 */
public interface VOutPutInfoMapper {
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
    List<VOutPutInfo> selectVOutPutInfoList(VOutPutInfo vOutPutInfo);

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
     * 删除污染排口信息
     *
     * @param id 污染排口信息主键
     * @return 结果
     */
    int deleteVOutPutInfoById(Long id);

    /**
     * 批量删除污染排口信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteVOutPutInfoByIds(Long[] ids);

    int selectTBasUserPutInfoList(Map<String, Object> map);
}
