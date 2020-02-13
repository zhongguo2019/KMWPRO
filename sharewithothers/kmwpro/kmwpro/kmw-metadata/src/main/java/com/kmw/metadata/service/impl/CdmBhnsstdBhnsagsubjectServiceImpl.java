package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnsagsubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnsagsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsagsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 协议主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnsagsubjectServiceImpl implements ICdmBhnsstdBhnsagsubjectService 
{
    @Autowired
    private CdmBhnsstdBhnsagsubjectMapper cdmBhnsstdBhnsagsubjectMapper;

    /**
     * 查询协议主题
     * 
     * @param id 协议主题ID
     * @return 协议主题
     */
    @Override
    public CdmBhnsstdBhnsagsubject selectCdmBhnsstdBhnsagsubjectById(Long id)
    {
        return cdmBhnsstdBhnsagsubjectMapper.selectCdmBhnsstdBhnsagsubjectById(id);
    }

    /**
     * 查询协议主题列表
     * 
     * @param cdmBhnsstdBhnsagsubject 协议主题
     * @return 协议主题
     */
    @Override
    public List<CdmBhnsstdBhnsagsubject> selectCdmBhnsstdBhnsagsubjectList(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject)
    {
        return cdmBhnsstdBhnsagsubjectMapper.selectCdmBhnsstdBhnsagsubjectList(cdmBhnsstdBhnsagsubject);
    }

    /**
     * 新增协议主题
     * 
     * @param cdmBhnsstdBhnsagsubject 协议主题
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnsagsubject(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject)
    {
        return cdmBhnsstdBhnsagsubjectMapper.insertCdmBhnsstdBhnsagsubject(cdmBhnsstdBhnsagsubject);
    }

    /**
     * 修改协议主题
     * 
     * @param cdmBhnsstdBhnsagsubject 协议主题
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnsagsubject(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject)
    {
        return cdmBhnsstdBhnsagsubjectMapper.updateCdmBhnsstdBhnsagsubject(cdmBhnsstdBhnsagsubject);
    }

    /**
     * 删除协议主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsagsubjectByIds(String ids)
    {
        return cdmBhnsstdBhnsagsubjectMapper.deleteCdmBhnsstdBhnsagsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除协议主题信息
     * 
     * @param id 协议主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsagsubjectById(Long id)
    {
        return cdmBhnsstdBhnsagsubjectMapper.deleteCdmBhnsstdBhnsagsubjectById(id);
    }
}
