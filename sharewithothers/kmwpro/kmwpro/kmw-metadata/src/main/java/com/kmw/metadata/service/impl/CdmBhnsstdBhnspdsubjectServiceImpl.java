package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnspdsubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnspdsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnspdsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 产品主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnspdsubjectServiceImpl implements ICdmBhnsstdBhnspdsubjectService 
{
    @Autowired
    private CdmBhnsstdBhnspdsubjectMapper cdmBhnsstdBhnspdsubjectMapper;

    /**
     * 查询产品主题
     * 
     * @param id 产品主题ID
     * @return 产品主题
     */
    @Override
    public CdmBhnsstdBhnspdsubject selectCdmBhnsstdBhnspdsubjectById(Long id)
    {
        return cdmBhnsstdBhnspdsubjectMapper.selectCdmBhnsstdBhnspdsubjectById(id);
    }

    /**
     * 查询产品主题列表
     * 
     * @param cdmBhnsstdBhnspdsubject 产品主题
     * @return 产品主题
     */
    @Override
    public List<CdmBhnsstdBhnspdsubject> selectCdmBhnsstdBhnspdsubjectList(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject)
    {
        return cdmBhnsstdBhnspdsubjectMapper.selectCdmBhnsstdBhnspdsubjectList(cdmBhnsstdBhnspdsubject);
    }

    /**
     * 新增产品主题
     * 
     * @param cdmBhnsstdBhnspdsubject 产品主题
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnspdsubject(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject)
    {
        return cdmBhnsstdBhnspdsubjectMapper.insertCdmBhnsstdBhnspdsubject(cdmBhnsstdBhnspdsubject);
    }

    /**
     * 修改产品主题
     * 
     * @param cdmBhnsstdBhnspdsubject 产品主题
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnspdsubject(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject)
    {
        return cdmBhnsstdBhnspdsubjectMapper.updateCdmBhnsstdBhnspdsubject(cdmBhnsstdBhnspdsubject);
    }

    /**
     * 删除产品主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnspdsubjectByIds(String ids)
    {
        return cdmBhnsstdBhnspdsubjectMapper.deleteCdmBhnsstdBhnspdsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品主题信息
     * 
     * @param id 产品主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnspdsubjectById(Long id)
    {
        return cdmBhnsstdBhnspdsubjectMapper.deleteCdmBhnsstdBhnspdsubjectById(id);
    }
}
