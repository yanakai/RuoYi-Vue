package com.ruoyi.business.base.mapper;

import java.util.List;
import com.ruoyi.business.base.domain.TBasPollutantCode;

/**
 * 数采报文对应的污染因子关系 2017版本和2003版Mapper接口
 * 
 * @author lx
 * @date 2024-07-21
 */
public interface TBasPollutantCodeMapper 
{
    /**
     * 查询数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param id 数采报文对应的污染因子关系 2017版本和2003版主键
     * @return 数采报文对应的污染因子关系 2017版本和2003版
     */
    public TBasPollutantCode selectTBasPollutantCodeById(Long id);

    /**
     * 查询数采报文对应的污染因子关系 2017版本和2003版列表
     * 
     * @param tBasPollutantCode 数采报文对应的污染因子关系 2017版本和2003版
     * @return 数采报文对应的污染因子关系 2017版本和2003版集合
     */
    public List<TBasPollutantCode> selectTBasPollutantCodeList(TBasPollutantCode tBasPollutantCode);

    /**
     * 新增数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param tBasPollutantCode 数采报文对应的污染因子关系 2017版本和2003版
     * @return 结果
     */
    public int insertTBasPollutantCode(TBasPollutantCode tBasPollutantCode);

    /**
     * 修改数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param tBasPollutantCode 数采报文对应的污染因子关系 2017版本和2003版
     * @return 结果
     */
    public int updateTBasPollutantCode(TBasPollutantCode tBasPollutantCode);

    /**
     * 删除数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param id 数采报文对应的污染因子关系 2017版本和2003版主键
     * @return 结果
     */
    public int deleteTBasPollutantCodeById(Long id);

    /**
     * 批量删除数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBasPollutantCodeByIds(Long[] ids);
}
