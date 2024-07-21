package com.ruoyi.business.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.base.mapper.TBasPollutantCodeMapper;
import com.ruoyi.business.base.domain.TBasPollutantCode;
import com.ruoyi.business.base.service.ITBasPollutantCodeService;

/**
 * 数采报文对应的污染因子关系 2017版本和2003版Service业务层处理
 * 
 * @author lx
 * @date 2024-07-21
 */
@Service
public class TBasPollutantCodeServiceImpl implements ITBasPollutantCodeService 
{
    @Autowired
    private TBasPollutantCodeMapper tBasPollutantCodeMapper;

    /**
     * 查询数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param id 数采报文对应的污染因子关系 2017版本和2003版主键
     * @return 数采报文对应的污染因子关系 2017版本和2003版
     */
    @Override
    public TBasPollutantCode selectTBasPollutantCodeById(Long id)
    {
        return tBasPollutantCodeMapper.selectTBasPollutantCodeById(id);
    }

    /**
     * 查询数采报文对应的污染因子关系 2017版本和2003版列表
     * 
     * @param tBasPollutantCode 数采报文对应的污染因子关系 2017版本和2003版
     * @return 数采报文对应的污染因子关系 2017版本和2003版
     */
    @Override
    public List<TBasPollutantCode> selectTBasPollutantCodeList(TBasPollutantCode tBasPollutantCode)
    {
        return tBasPollutantCodeMapper.selectTBasPollutantCodeList(tBasPollutantCode);
    }

    /**
     * 新增数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param tBasPollutantCode 数采报文对应的污染因子关系 2017版本和2003版
     * @return 结果
     */
    @Override
    public int insertTBasPollutantCode(TBasPollutantCode tBasPollutantCode)
    {
        return tBasPollutantCodeMapper.insertTBasPollutantCode(tBasPollutantCode);
    }

    /**
     * 修改数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param tBasPollutantCode 数采报文对应的污染因子关系 2017版本和2003版
     * @return 结果
     */
    @Override
    public int updateTBasPollutantCode(TBasPollutantCode tBasPollutantCode)
    {
        return tBasPollutantCodeMapper.updateTBasPollutantCode(tBasPollutantCode);
    }

    /**
     * 批量删除数采报文对应的污染因子关系 2017版本和2003版
     * 
     * @param ids 需要删除的数采报文对应的污染因子关系 2017版本和2003版主键
     * @return 结果
     */
    @Override
    public int deleteTBasPollutantCodeByIds(Long[] ids)
    {
        return tBasPollutantCodeMapper.deleteTBasPollutantCodeByIds(ids);
    }

    /**
     * 删除数采报文对应的污染因子关系 2017版本和2003版信息
     * 
     * @param id 数采报文对应的污染因子关系 2017版本和2003版主键
     * @return 结果
     */
    @Override
    public int deleteTBasPollutantCodeById(Long id)
    {
        return tBasPollutantCodeMapper.deleteTBasPollutantCodeById(id);
    }
}
