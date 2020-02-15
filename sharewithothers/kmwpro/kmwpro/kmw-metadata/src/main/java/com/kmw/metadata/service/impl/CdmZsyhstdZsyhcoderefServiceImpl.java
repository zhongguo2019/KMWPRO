package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhcoderefMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhcoderef;
import com.kmw.metadata.service.ICdmZsyhstdZsyhcoderefService;
import com.kmw.common.core.text.Convert;

/**
 * VIEWService业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhcoderefServiceImpl implements ICdmZsyhstdZsyhcoderefService 
{
    @Autowired
    private CdmZsyhstdZsyhcoderefMapper cdmZsyhstdZsyhcoderefMapper;

    /**
     * 查询VIEW
     * 
     * @param id VIEWID
     * @return VIEW
     */
    @Override
    public CdmZsyhstdZsyhcoderef selectCdmZsyhstdZsyhcoderefById(Long id)
    {
        return cdmZsyhstdZsyhcoderefMapper.selectCdmZsyhstdZsyhcoderefById(id);
    }

    /**
     * 查询VIEW列表
     * 
     * @param cdmZsyhstdZsyhcoderef VIEW
     * @return VIEW
     */
    @Override
    public List<CdmZsyhstdZsyhcoderef> selectCdmZsyhstdZsyhcoderefList(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef)
    {
        return cdmZsyhstdZsyhcoderefMapper.selectCdmZsyhstdZsyhcoderefList(cdmZsyhstdZsyhcoderef);
    }

    /**
     * 新增VIEW
     * 
     * @param cdmZsyhstdZsyhcoderef VIEW
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhcoderef(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef)
    {
        return cdmZsyhstdZsyhcoderefMapper.insertCdmZsyhstdZsyhcoderef(cdmZsyhstdZsyhcoderef);
    }

    /**
     * 修改VIEW
     * 
     * @param cdmZsyhstdZsyhcoderef VIEW
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhcoderef(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef)
    {
        return cdmZsyhstdZsyhcoderefMapper.updateCdmZsyhstdZsyhcoderef(cdmZsyhstdZsyhcoderef);
    }

    /**
     * 删除VIEW对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhcoderefByIds(String ids)
    {
        return cdmZsyhstdZsyhcoderefMapper.deleteCdmZsyhstdZsyhcoderefByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除VIEW信息
     * 
     * @param id VIEWID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhcoderefById(Long id)
    {
        return cdmZsyhstdZsyhcoderefMapper.deleteCdmZsyhstdZsyhcoderefById(id);
    }
}
