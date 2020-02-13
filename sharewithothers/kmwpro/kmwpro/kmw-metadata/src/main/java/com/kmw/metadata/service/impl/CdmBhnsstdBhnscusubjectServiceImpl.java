package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnscusubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnscusubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnscusubjectService;
import com.kmw.common.core.text.Convert;

/**
 * VIEWService业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnscusubjectServiceImpl implements ICdmBhnsstdBhnscusubjectService 
{
    @Autowired
    private CdmBhnsstdBhnscusubjectMapper cdmBhnsstdBhnscusubjectMapper;

    /**
     * 查询VIEW
     * 
     * @param id VIEWID
     * @return VIEW
     */
    @Override
    public CdmBhnsstdBhnscusubject selectCdmBhnsstdBhnscusubjectById(Long id)
    {
        return cdmBhnsstdBhnscusubjectMapper.selectCdmBhnsstdBhnscusubjectById(id);
    }

    /**
     * 查询VIEW列表
     * 
     * @param cdmBhnsstdBhnscusubject VIEW
     * @return VIEW
     */
    @Override
    public List<CdmBhnsstdBhnscusubject> selectCdmBhnsstdBhnscusubjectList(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject)
    {
        return cdmBhnsstdBhnscusubjectMapper.selectCdmBhnsstdBhnscusubjectList(cdmBhnsstdBhnscusubject);
    }

    /**
     * 新增VIEW
     * 
     * @param cdmBhnsstdBhnscusubject VIEW
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnscusubject(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject)
    {
        return cdmBhnsstdBhnscusubjectMapper.insertCdmBhnsstdBhnscusubject(cdmBhnsstdBhnscusubject);
    }

    /**
     * 修改VIEW
     * 
     * @param cdmBhnsstdBhnscusubject VIEW
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnscusubject(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject)
    {
        return cdmBhnsstdBhnscusubjectMapper.updateCdmBhnsstdBhnscusubject(cdmBhnsstdBhnscusubject);
    }

    /**
     * 删除VIEW对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnscusubjectByIds(String ids)
    {
        return cdmBhnsstdBhnscusubjectMapper.deleteCdmBhnsstdBhnscusubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除VIEW信息
     * 
     * @param id VIEWID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnscusubjectById(Long id)
    {
        return cdmBhnsstdBhnscusubjectMapper.deleteCdmBhnsstdBhnscusubjectById(id);
    }
}
