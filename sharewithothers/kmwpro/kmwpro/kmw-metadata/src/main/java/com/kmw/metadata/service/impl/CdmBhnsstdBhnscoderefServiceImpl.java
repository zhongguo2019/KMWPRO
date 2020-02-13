package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnscoderefMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnscoderef;
import com.kmw.metadata.service.ICdmBhnsstdBhnscoderefService;
import com.kmw.common.core.text.Convert;

/**
 * 各主题代码参数表Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-12
 */
@Service
public class CdmBhnsstdBhnscoderefServiceImpl implements ICdmBhnsstdBhnscoderefService 
{
    @Autowired
    private CdmBhnsstdBhnscoderefMapper cdmBhnsstdBhnscoderefMapper;

    /**
     * 查询各主题代码参数表
     * 
     * @param id 各主题代码参数表ID
     * @return 各主题代码参数表
     */
    @Override
    public CdmBhnsstdBhnscoderef selectCdmBhnsstdBhnscoderefById(Long id)
    {
        return cdmBhnsstdBhnscoderefMapper.selectCdmBhnsstdBhnscoderefById(id);
    }

    /**
     * 查询各主题代码参数表列表
     * 
     * @param cdmBhnsstdBhnscoderef 各主题代码参数表
     * @return 各主题代码参数表
     */
    @Override
    public List<CdmBhnsstdBhnscoderef> selectCdmBhnsstdBhnscoderefList(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef)
    {
        return cdmBhnsstdBhnscoderefMapper.selectCdmBhnsstdBhnscoderefList(cdmBhnsstdBhnscoderef);
    }

    /**
     * 新增各主题代码参数表
     * 
     * @param cdmBhnsstdBhnscoderef 各主题代码参数表
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnscoderef(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef)
    {
        return cdmBhnsstdBhnscoderefMapper.insertCdmBhnsstdBhnscoderef(cdmBhnsstdBhnscoderef);
    }

    /**
     * 修改各主题代码参数表
     * 
     * @param cdmBhnsstdBhnscoderef 各主题代码参数表
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnscoderef(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef)
    {
        return cdmBhnsstdBhnscoderefMapper.updateCdmBhnsstdBhnscoderef(cdmBhnsstdBhnscoderef);
    }

    /**
     * 删除各主题代码参数表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnscoderefByIds(String ids)
    {
        return cdmBhnsstdBhnscoderefMapper.deleteCdmBhnsstdBhnscoderefByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除各主题代码参数表信息
     * 
     * @param id 各主题代码参数表ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnscoderefById(Long id)
    {
        return cdmBhnsstdBhnscoderefMapper.deleteCdmBhnsstdBhnscoderefById(id);
    }
}
