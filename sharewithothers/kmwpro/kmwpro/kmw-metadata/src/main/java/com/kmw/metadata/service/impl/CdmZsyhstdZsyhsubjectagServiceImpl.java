package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhsubjectagMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectag;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectagService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准协议主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhsubjectagServiceImpl implements ICdmZsyhstdZsyhsubjectagService 
{
    @Autowired
    private CdmZsyhstdZsyhsubjectagMapper cdmZsyhstdZsyhsubjectagMapper;

    /**
     * 查询数据标准协议主题
     * 
     * @param id 数据标准协议主题ID
     * @return 数据标准协议主题
     */
    @Override
    public CdmZsyhstdZsyhsubjectag selectCdmZsyhstdZsyhsubjectagById(Long id)
    {
        return cdmZsyhstdZsyhsubjectagMapper.selectCdmZsyhstdZsyhsubjectagById(id);
    }

    /**
     * 查询数据标准协议主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectag 数据标准协议主题
     * @return 数据标准协议主题
     */
    @Override
    public List<CdmZsyhstdZsyhsubjectag> selectCdmZsyhstdZsyhsubjectagList(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag)
    {
        return cdmZsyhstdZsyhsubjectagMapper.selectCdmZsyhstdZsyhsubjectagList(cdmZsyhstdZsyhsubjectag);
    }

    /**
     * 新增数据标准协议主题
     * 
     * @param cdmZsyhstdZsyhsubjectag 数据标准协议主题
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhsubjectag(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag)
    {
        return cdmZsyhstdZsyhsubjectagMapper.insertCdmZsyhstdZsyhsubjectag(cdmZsyhstdZsyhsubjectag);
    }

    /**
     * 修改数据标准协议主题
     * 
     * @param cdmZsyhstdZsyhsubjectag 数据标准协议主题
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhsubjectag(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag)
    {
        return cdmZsyhstdZsyhsubjectagMapper.updateCdmZsyhstdZsyhsubjectag(cdmZsyhstdZsyhsubjectag);
    }

    /**
     * 删除数据标准协议主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectagByIds(String ids)
    {
        return cdmZsyhstdZsyhsubjectagMapper.deleteCdmZsyhstdZsyhsubjectagByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准协议主题信息
     * 
     * @param id 数据标准协议主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectagById(Long id)
    {
        return cdmZsyhstdZsyhsubjectagMapper.deleteCdmZsyhstdZsyhsubjectagById(id);
    }
}
