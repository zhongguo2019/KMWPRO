package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnsassubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnsassubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsassubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 资产主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnsassubjectServiceImpl implements ICdmBhnsstdBhnsassubjectService 
{
    @Autowired
    private CdmBhnsstdBhnsassubjectMapper cdmBhnsstdBhnsassubjectMapper;

    /**
     * 查询资产主题
     * 
     * @param id 资产主题ID
     * @return 资产主题
     */
    @Override
    public CdmBhnsstdBhnsassubject selectCdmBhnsstdBhnsassubjectById(Long id)
    {
        return cdmBhnsstdBhnsassubjectMapper.selectCdmBhnsstdBhnsassubjectById(id);
    }

    /**
     * 查询资产主题列表
     * 
     * @param cdmBhnsstdBhnsassubject 资产主题
     * @return 资产主题
     */
    @Override
    public List<CdmBhnsstdBhnsassubject> selectCdmBhnsstdBhnsassubjectList(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject)
    {
        return cdmBhnsstdBhnsassubjectMapper.selectCdmBhnsstdBhnsassubjectList(cdmBhnsstdBhnsassubject);
    }

    /**
     * 新增资产主题
     * 
     * @param cdmBhnsstdBhnsassubject 资产主题
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnsassubject(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject)
    {
        return cdmBhnsstdBhnsassubjectMapper.insertCdmBhnsstdBhnsassubject(cdmBhnsstdBhnsassubject);
    }

    /**
     * 修改资产主题
     * 
     * @param cdmBhnsstdBhnsassubject 资产主题
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnsassubject(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject)
    {
        return cdmBhnsstdBhnsassubjectMapper.updateCdmBhnsstdBhnsassubject(cdmBhnsstdBhnsassubject);
    }

    /**
     * 删除资产主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsassubjectByIds(String ids)
    {
        return cdmBhnsstdBhnsassubjectMapper.deleteCdmBhnsstdBhnsassubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资产主题信息
     * 
     * @param id 资产主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsassubjectById(Long id)
    {
        return cdmBhnsstdBhnsassubjectMapper.deleteCdmBhnsstdBhnsassubjectById(id);
    }
}
