package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhsubjectasMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectas;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectasService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准资产主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhsubjectasServiceImpl implements ICdmZsyhstdZsyhsubjectasService 
{
    @Autowired
    private CdmZsyhstdZsyhsubjectasMapper cdmZsyhstdZsyhsubjectasMapper;

    /**
     * 查询数据标准资产主题
     * 
     * @param id 数据标准资产主题ID
     * @return 数据标准资产主题
     */
    @Override
    public CdmZsyhstdZsyhsubjectas selectCdmZsyhstdZsyhsubjectasById(Long id)
    {
        return cdmZsyhstdZsyhsubjectasMapper.selectCdmZsyhstdZsyhsubjectasById(id);
    }

    /**
     * 查询数据标准资产主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectas 数据标准资产主题
     * @return 数据标准资产主题
     */
    @Override
    public List<CdmZsyhstdZsyhsubjectas> selectCdmZsyhstdZsyhsubjectasList(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas)
    {
        return cdmZsyhstdZsyhsubjectasMapper.selectCdmZsyhstdZsyhsubjectasList(cdmZsyhstdZsyhsubjectas);
    }

    /**
     * 新增数据标准资产主题
     * 
     * @param cdmZsyhstdZsyhsubjectas 数据标准资产主题
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhsubjectas(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas)
    {
        return cdmZsyhstdZsyhsubjectasMapper.insertCdmZsyhstdZsyhsubjectas(cdmZsyhstdZsyhsubjectas);
    }

    /**
     * 修改数据标准资产主题
     * 
     * @param cdmZsyhstdZsyhsubjectas 数据标准资产主题
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhsubjectas(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas)
    {
        return cdmZsyhstdZsyhsubjectasMapper.updateCdmZsyhstdZsyhsubjectas(cdmZsyhstdZsyhsubjectas);
    }

    /**
     * 删除数据标准资产主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectasByIds(String ids)
    {
        return cdmZsyhstdZsyhsubjectasMapper.deleteCdmZsyhstdZsyhsubjectasByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准资产主题信息
     * 
     * @param id 数据标准资产主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectasById(Long id)
    {
        return cdmZsyhstdZsyhsubjectasMapper.deleteCdmZsyhstdZsyhsubjectasById(id);
    }
}
