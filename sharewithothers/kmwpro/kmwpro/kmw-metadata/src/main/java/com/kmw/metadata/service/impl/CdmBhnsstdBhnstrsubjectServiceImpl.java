package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnstrsubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnstrsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnstrsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 事件主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnstrsubjectServiceImpl implements ICdmBhnsstdBhnstrsubjectService 
{
    @Autowired
    private CdmBhnsstdBhnstrsubjectMapper cdmBhnsstdBhnstrsubjectMapper;

    /**
     * 查询事件主题
     * 
     * @param id 事件主题ID
     * @return 事件主题
     */
    @Override
    public CdmBhnsstdBhnstrsubject selectCdmBhnsstdBhnstrsubjectById(Long id)
    {
        return cdmBhnsstdBhnstrsubjectMapper.selectCdmBhnsstdBhnstrsubjectById(id);
    }

    /**
     * 查询事件主题列表
     * 
     * @param cdmBhnsstdBhnstrsubject 事件主题
     * @return 事件主题
     */
    @Override
    public List<CdmBhnsstdBhnstrsubject> selectCdmBhnsstdBhnstrsubjectList(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject)
    {
        return cdmBhnsstdBhnstrsubjectMapper.selectCdmBhnsstdBhnstrsubjectList(cdmBhnsstdBhnstrsubject);
    }

    /**
     * 新增事件主题
     * 
     * @param cdmBhnsstdBhnstrsubject 事件主题
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnstrsubject(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject)
    {
        return cdmBhnsstdBhnstrsubjectMapper.insertCdmBhnsstdBhnstrsubject(cdmBhnsstdBhnstrsubject);
    }

    /**
     * 修改事件主题
     * 
     * @param cdmBhnsstdBhnstrsubject 事件主题
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnstrsubject(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject)
    {
        return cdmBhnsstdBhnstrsubjectMapper.updateCdmBhnsstdBhnstrsubject(cdmBhnsstdBhnstrsubject);
    }

    /**
     * 删除事件主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnstrsubjectByIds(String ids)
    {
        return cdmBhnsstdBhnstrsubjectMapper.deleteCdmBhnsstdBhnstrsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除事件主题信息
     * 
     * @param id 事件主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnstrsubjectById(Long id)
    {
        return cdmBhnsstdBhnstrsubjectMapper.deleteCdmBhnsstdBhnstrsubjectById(id);
    }
}
