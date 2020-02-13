package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmJsnxodsPbocsrctblMapper;
import com.kmw.metadata.domain.CdmJsnxodsPbocsrctbl;
import com.kmw.metadata.service.ICdmJsnxodsPbocsrctblService;
import com.kmw.common.core.text.Convert;

/**
 * 人行报送报来源分析Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmJsnxodsPbocsrctblServiceImpl implements ICdmJsnxodsPbocsrctblService 
{
    @Autowired
    private CdmJsnxodsPbocsrctblMapper cdmJsnxodsPbocsrctblMapper;

    /**
     * 查询人行报送报来源分析
     * 
     * @param orderno 人行报送报来源分析ID
     * @return 人行报送报来源分析
     */
    @Override
    public CdmJsnxodsPbocsrctbl selectCdmJsnxodsPbocsrctblById(Long orderno)
    {
        return cdmJsnxodsPbocsrctblMapper.selectCdmJsnxodsPbocsrctblById(orderno);
    }

    /**
     * 查询人行报送报来源分析列表
     * 
     * @param cdmJsnxodsPbocsrctbl 人行报送报来源分析
     * @return 人行报送报来源分析
     */
    @Override
    public List<CdmJsnxodsPbocsrctbl> selectCdmJsnxodsPbocsrctblList(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl)
    {
        return cdmJsnxodsPbocsrctblMapper.selectCdmJsnxodsPbocsrctblList(cdmJsnxodsPbocsrctbl);
    }

    /**
     * 新增人行报送报来源分析
     * 
     * @param cdmJsnxodsPbocsrctbl 人行报送报来源分析
     * @return 结果
     */
    @Override
    public int insertCdmJsnxodsPbocsrctbl(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl)
    {
        return cdmJsnxodsPbocsrctblMapper.insertCdmJsnxodsPbocsrctbl(cdmJsnxodsPbocsrctbl);
    }

    /**
     * 修改人行报送报来源分析
     * 
     * @param cdmJsnxodsPbocsrctbl 人行报送报来源分析
     * @return 结果
     */
    @Override
    public int updateCdmJsnxodsPbocsrctbl(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl)
    {
        return cdmJsnxodsPbocsrctblMapper.updateCdmJsnxodsPbocsrctbl(cdmJsnxodsPbocsrctbl);
    }

    /**
     * 删除人行报送报来源分析对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsPbocsrctblByIds(String ids)
    {
        return cdmJsnxodsPbocsrctblMapper.deleteCdmJsnxodsPbocsrctblByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人行报送报来源分析信息
     * 
     * @param orderno 人行报送报来源分析ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsPbocsrctblById(Long orderno)
    {
        return cdmJsnxodsPbocsrctblMapper.deleteCdmJsnxodsPbocsrctblById(orderno);
    }
}
