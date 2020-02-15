package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhsubjecttrMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjecttr;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjecttrService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准事件主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhsubjecttrServiceImpl implements ICdmZsyhstdZsyhsubjecttrService 
{
    @Autowired
    private CdmZsyhstdZsyhsubjecttrMapper cdmZsyhstdZsyhsubjecttrMapper;

    /**
     * 查询数据标准事件主题
     * 
     * @param id 数据标准事件主题ID
     * @return 数据标准事件主题
     */
    @Override
    public CdmZsyhstdZsyhsubjecttr selectCdmZsyhstdZsyhsubjecttrById(Long id)
    {
        return cdmZsyhstdZsyhsubjecttrMapper.selectCdmZsyhstdZsyhsubjecttrById(id);
    }

    /**
     * 查询数据标准事件主题列表
     * 
     * @param cdmZsyhstdZsyhsubjecttr 数据标准事件主题
     * @return 数据标准事件主题
     */
    @Override
    public List<CdmZsyhstdZsyhsubjecttr> selectCdmZsyhstdZsyhsubjecttrList(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr)
    {
        return cdmZsyhstdZsyhsubjecttrMapper.selectCdmZsyhstdZsyhsubjecttrList(cdmZsyhstdZsyhsubjecttr);
    }

    /**
     * 新增数据标准事件主题
     * 
     * @param cdmZsyhstdZsyhsubjecttr 数据标准事件主题
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhsubjecttr(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr)
    {
        return cdmZsyhstdZsyhsubjecttrMapper.insertCdmZsyhstdZsyhsubjecttr(cdmZsyhstdZsyhsubjecttr);
    }

    /**
     * 修改数据标准事件主题
     * 
     * @param cdmZsyhstdZsyhsubjecttr 数据标准事件主题
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhsubjecttr(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr)
    {
        return cdmZsyhstdZsyhsubjecttrMapper.updateCdmZsyhstdZsyhsubjecttr(cdmZsyhstdZsyhsubjecttr);
    }

    /**
     * 删除数据标准事件主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjecttrByIds(String ids)
    {
        return cdmZsyhstdZsyhsubjecttrMapper.deleteCdmZsyhstdZsyhsubjecttrByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准事件主题信息
     * 
     * @param id 数据标准事件主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjecttrById(Long id)
    {
        return cdmZsyhstdZsyhsubjecttrMapper.deleteCdmZsyhstdZsyhsubjecttrById(id);
    }
}
