package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhallsubjectMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhallsubject;
import com.kmw.metadata.service.ICdmZsyhstdZsyhallsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 案例二数据标准Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-12
 */
@Service
public class CdmZsyhstdZsyhallsubjectServiceImpl implements ICdmZsyhstdZsyhallsubjectService 
{
    @Autowired
    private CdmZsyhstdZsyhallsubjectMapper cdmZsyhstdZsyhallsubjectMapper;

    /**
     * 查询案例二数据标准
     * 
     * @param id 案例二数据标准ID
     * @return 案例二数据标准
     */
    @Override
    public CdmZsyhstdZsyhallsubject selectCdmZsyhstdZsyhallsubjectById(Long id)
    {
        return cdmZsyhstdZsyhallsubjectMapper.selectCdmZsyhstdZsyhallsubjectById(id);
    }

    /**
     * 查询案例二数据标准列表
     * 
     * @param cdmZsyhstdZsyhallsubject 案例二数据标准
     * @return 案例二数据标准
     */
    @Override
    public List<CdmZsyhstdZsyhallsubject> selectCdmZsyhstdZsyhallsubjectList(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject)
    {
        return cdmZsyhstdZsyhallsubjectMapper.selectCdmZsyhstdZsyhallsubjectList(cdmZsyhstdZsyhallsubject);
    }

    /**
     * 新增案例二数据标准
     * 
     * @param cdmZsyhstdZsyhallsubject 案例二数据标准
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhallsubject(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject)
    {
        return cdmZsyhstdZsyhallsubjectMapper.insertCdmZsyhstdZsyhallsubject(cdmZsyhstdZsyhallsubject);
    }

    /**
     * 修改案例二数据标准
     * 
     * @param cdmZsyhstdZsyhallsubject 案例二数据标准
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhallsubject(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject)
    {
        return cdmZsyhstdZsyhallsubjectMapper.updateCdmZsyhstdZsyhallsubject(cdmZsyhstdZsyhallsubject);
    }

    /**
     * 删除案例二数据标准对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhallsubjectByIds(String ids)
    {
        return cdmZsyhstdZsyhallsubjectMapper.deleteCdmZsyhstdZsyhallsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除案例二数据标准信息
     * 
     * @param id 案例二数据标准ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhallsubjectById(Long id)
    {
        return cdmZsyhstdZsyhallsubjectMapper.deleteCdmZsyhstdZsyhallsubjectById(id);
    }
}
