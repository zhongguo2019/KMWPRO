package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnschsubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnschsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnschsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 渠道主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnschsubjectServiceImpl implements ICdmBhnsstdBhnschsubjectService 
{
    @Autowired
    private CdmBhnsstdBhnschsubjectMapper cdmBhnsstdBhnschsubjectMapper;

    /**
     * 查询渠道主题
     * 
     * @param id 渠道主题ID
     * @return 渠道主题
     */
    @Override
    public CdmBhnsstdBhnschsubject selectCdmBhnsstdBhnschsubjectById(Long id)
    {
        return cdmBhnsstdBhnschsubjectMapper.selectCdmBhnsstdBhnschsubjectById(id);
    }

    /**
     * 查询渠道主题列表
     * 
     * @param cdmBhnsstdBhnschsubject 渠道主题
     * @return 渠道主题
     */
    @Override
    public List<CdmBhnsstdBhnschsubject> selectCdmBhnsstdBhnschsubjectList(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject)
    {
        return cdmBhnsstdBhnschsubjectMapper.selectCdmBhnsstdBhnschsubjectList(cdmBhnsstdBhnschsubject);
    }

    /**
     * 新增渠道主题
     * 
     * @param cdmBhnsstdBhnschsubject 渠道主题
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnschsubject(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject)
    {
        return cdmBhnsstdBhnschsubjectMapper.insertCdmBhnsstdBhnschsubject(cdmBhnsstdBhnschsubject);
    }

    /**
     * 修改渠道主题
     * 
     * @param cdmBhnsstdBhnschsubject 渠道主题
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnschsubject(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject)
    {
        return cdmBhnsstdBhnschsubjectMapper.updateCdmBhnsstdBhnschsubject(cdmBhnsstdBhnschsubject);
    }

    /**
     * 删除渠道主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnschsubjectByIds(String ids)
    {
        return cdmBhnsstdBhnschsubjectMapper.deleteCdmBhnsstdBhnschsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除渠道主题信息
     * 
     * @param id 渠道主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnschsubjectById(Long id)
    {
        return cdmBhnsstdBhnschsubjectMapper.deleteCdmBhnsstdBhnschsubjectById(id);
    }
}
