package com.kmw.metadata.service.impl;

import java.util.List;
import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmJsnxodsTableallMapper;
import com.kmw.metadata.domain.CdmJsnxodsTableall;
import com.kmw.metadata.service.ICdmJsnxodsTableallService;
import com.kmw.common.core.text.Convert;

/**
 * ODS列Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-06
 */
@Service
public class CdmJsnxodsTableallServiceImpl implements ICdmJsnxodsTableallService 
{
    @Autowired
    private CdmJsnxodsTableallMapper cdmJsnxodsTableallMapper;

    /**
     * 查询ODS列
     * 
     * @param id ODS列ID
     * @return ODS列
     */
    @Override
    public CdmJsnxodsTableall selectCdmJsnxodsTableallById(Long id)
    {
        return cdmJsnxodsTableallMapper.selectCdmJsnxodsTableallById(id);
    }

    /**
     * 查询ODS列列表
     * 
     * @param cdmJsnxodsTableall ODS列
     * @return ODS列
     */
    @Override
    public List<CdmJsnxodsTableall> selectCdmJsnxodsTableallList(CdmJsnxodsTableall cdmJsnxodsTableall)
    {
        return cdmJsnxodsTableallMapper.selectCdmJsnxodsTableallList(cdmJsnxodsTableall);
    }

    /**
     * 新增ODS列
     * 
     * @param cdmJsnxodsTableall ODS列
     * @return 结果
     */
    @Override
    public int insertCdmJsnxodsTableall(CdmJsnxodsTableall cdmJsnxodsTableall)
    {
        cdmJsnxodsTableall.setCreateTime(DateUtils.getNowDate());
        return cdmJsnxodsTableallMapper.insertCdmJsnxodsTableall(cdmJsnxodsTableall);
    }

    /**
     * 修改ODS列
     * 
     * @param cdmJsnxodsTableall ODS列
     * @return 结果
     */
    @Override
    public int updateCdmJsnxodsTableall(CdmJsnxodsTableall cdmJsnxodsTableall)
    {
        cdmJsnxodsTableall.setUpdateTime(DateUtils.getNowDate());
        return cdmJsnxodsTableallMapper.updateCdmJsnxodsTableall(cdmJsnxodsTableall);
    }

    /**
     * 删除ODS列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsTableallByIds(String ids)
    {
        return cdmJsnxodsTableallMapper.deleteCdmJsnxodsTableallByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除ODS列信息
     * 
     * @param id ODS列ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsTableallById(Long id)
    {
        return cdmJsnxodsTableallMapper.deleteCdmJsnxodsTableallById(id);
    }
}
