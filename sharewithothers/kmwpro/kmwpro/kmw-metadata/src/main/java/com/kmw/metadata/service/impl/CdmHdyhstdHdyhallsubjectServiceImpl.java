package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmHdyhstdHdyhallsubjectMapper;
import com.kmw.metadata.domain.CdmHdyhstdHdyhallsubject;
import com.kmw.metadata.service.ICdmHdyhstdHdyhallsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 商业银行案例三Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-16
 */
@Service
public class CdmHdyhstdHdyhallsubjectServiceImpl implements ICdmHdyhstdHdyhallsubjectService 
{
    @Autowired
    private CdmHdyhstdHdyhallsubjectMapper cdmHdyhstdHdyhallsubjectMapper;

    /**
     * 查询商业银行案例三
     * 
     * @param id 商业银行案例三ID
     * @return 商业银行案例三
     */
    @Override
    public CdmHdyhstdHdyhallsubject selectCdmHdyhstdHdyhallsubjectById(Long id)
    {
        return cdmHdyhstdHdyhallsubjectMapper.selectCdmHdyhstdHdyhallsubjectById(id);
    }

    /**
     * 查询商业银行案例三列表
     * 
     * @param cdmHdyhstdHdyhallsubject 商业银行案例三
     * @return 商业银行案例三
     */
    @Override
    public List<CdmHdyhstdHdyhallsubject> selectCdmHdyhstdHdyhallsubjectList(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject)
    {
        return cdmHdyhstdHdyhallsubjectMapper.selectCdmHdyhstdHdyhallsubjectList(cdmHdyhstdHdyhallsubject);
    }

    /**
     * 新增商业银行案例三
     * 
     * @param cdmHdyhstdHdyhallsubject 商业银行案例三
     * @return 结果
     */
    @Override
    public int insertCdmHdyhstdHdyhallsubject(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject)
    {
        return cdmHdyhstdHdyhallsubjectMapper.insertCdmHdyhstdHdyhallsubject(cdmHdyhstdHdyhallsubject);
    }

    /**
     * 修改商业银行案例三
     * 
     * @param cdmHdyhstdHdyhallsubject 商业银行案例三
     * @return 结果
     */
    @Override
    public int updateCdmHdyhstdHdyhallsubject(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject)
    {
        return cdmHdyhstdHdyhallsubjectMapper.updateCdmHdyhstdHdyhallsubject(cdmHdyhstdHdyhallsubject);
    }

    /**
     * 删除商业银行案例三对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmHdyhstdHdyhallsubjectByIds(String ids)
    {
        return cdmHdyhstdHdyhallsubjectMapper.deleteCdmHdyhstdHdyhallsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商业银行案例三信息
     * 
     * @param id 商业银行案例三ID
     * @return 结果
     */
    @Override
    public int deleteCdmHdyhstdHdyhallsubjectById(Long id)
    {
        return cdmHdyhstdHdyhallsubjectMapper.deleteCdmHdyhstdHdyhallsubjectById(id);
    }
}
