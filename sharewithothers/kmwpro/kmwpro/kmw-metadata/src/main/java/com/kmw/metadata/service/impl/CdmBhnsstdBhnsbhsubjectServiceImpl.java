package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnsbhsubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnsbhsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsbhsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 机构主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnsbhsubjectServiceImpl implements ICdmBhnsstdBhnsbhsubjectService 
{
    @Autowired
    private CdmBhnsstdBhnsbhsubjectMapper cdmBhnsstdBhnsbhsubjectMapper;

    /**
     * 查询机构主题
     * 
     * @param id 机构主题ID
     * @return 机构主题
     */
    @Override
    public CdmBhnsstdBhnsbhsubject selectCdmBhnsstdBhnsbhsubjectById(Long id)
    {
        return cdmBhnsstdBhnsbhsubjectMapper.selectCdmBhnsstdBhnsbhsubjectById(id);
    }

    /**
     * 查询机构主题列表
     * 
     * @param cdmBhnsstdBhnsbhsubject 机构主题
     * @return 机构主题
     */
    @Override
    public List<CdmBhnsstdBhnsbhsubject> selectCdmBhnsstdBhnsbhsubjectList(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject)
    {
        return cdmBhnsstdBhnsbhsubjectMapper.selectCdmBhnsstdBhnsbhsubjectList(cdmBhnsstdBhnsbhsubject);
    }

    /**
     * 新增机构主题
     * 
     * @param cdmBhnsstdBhnsbhsubject 机构主题
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnsbhsubject(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject)
    {
        return cdmBhnsstdBhnsbhsubjectMapper.insertCdmBhnsstdBhnsbhsubject(cdmBhnsstdBhnsbhsubject);
    }

    /**
     * 修改机构主题
     * 
     * @param cdmBhnsstdBhnsbhsubject 机构主题
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnsbhsubject(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject)
    {
        return cdmBhnsstdBhnsbhsubjectMapper.updateCdmBhnsstdBhnsbhsubject(cdmBhnsstdBhnsbhsubject);
    }

    /**
     * 删除机构主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsbhsubjectByIds(String ids)
    {
        return cdmBhnsstdBhnsbhsubjectMapper.deleteCdmBhnsstdBhnsbhsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机构主题信息
     * 
     * @param id 机构主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsbhsubjectById(Long id)
    {
        return cdmBhnsstdBhnsbhsubjectMapper.deleteCdmBhnsstdBhnsbhsubjectById(id);
    }
}
