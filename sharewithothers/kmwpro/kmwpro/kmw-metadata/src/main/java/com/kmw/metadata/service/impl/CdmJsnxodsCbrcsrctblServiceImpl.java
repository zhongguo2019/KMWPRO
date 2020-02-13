package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmJsnxodsCbrcsrctblMapper;
import com.kmw.metadata.domain.CdmJsnxodsCbrcsrctbl;
import com.kmw.metadata.service.ICdmJsnxodsCbrcsrctblService;
import com.kmw.common.core.text.Convert;

/**
 * 银监报送报来源分析Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmJsnxodsCbrcsrctblServiceImpl implements ICdmJsnxodsCbrcsrctblService 
{
    @Autowired
    private CdmJsnxodsCbrcsrctblMapper cdmJsnxodsCbrcsrctblMapper;

    /**
     * 查询银监报送报来源分析
     * 
     * @param orderno 银监报送报来源分析ID
     * @return 银监报送报来源分析
     */
    @Override
    public CdmJsnxodsCbrcsrctbl selectCdmJsnxodsCbrcsrctblById(Long orderno)
    {
        return cdmJsnxodsCbrcsrctblMapper.selectCdmJsnxodsCbrcsrctblById(orderno);
    }

    /**
     * 查询银监报送报来源分析列表
     * 
     * @param cdmJsnxodsCbrcsrctbl 银监报送报来源分析
     * @return 银监报送报来源分析
     */
    @Override
    public List<CdmJsnxodsCbrcsrctbl> selectCdmJsnxodsCbrcsrctblList(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl)
    {
        return cdmJsnxodsCbrcsrctblMapper.selectCdmJsnxodsCbrcsrctblList(cdmJsnxodsCbrcsrctbl);
    }

    /**
     * 新增银监报送报来源分析
     * 
     * @param cdmJsnxodsCbrcsrctbl 银监报送报来源分析
     * @return 结果
     */
    @Override
    public int insertCdmJsnxodsCbrcsrctbl(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl)
    {
        return cdmJsnxodsCbrcsrctblMapper.insertCdmJsnxodsCbrcsrctbl(cdmJsnxodsCbrcsrctbl);
    }

    /**
     * 修改银监报送报来源分析
     * 
     * @param cdmJsnxodsCbrcsrctbl 银监报送报来源分析
     * @return 结果
     */
    @Override
    public int updateCdmJsnxodsCbrcsrctbl(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl)
    {
        return cdmJsnxodsCbrcsrctblMapper.updateCdmJsnxodsCbrcsrctbl(cdmJsnxodsCbrcsrctbl);
    }

    /**
     * 删除银监报送报来源分析对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsCbrcsrctblByIds(String ids)
    {
        return cdmJsnxodsCbrcsrctblMapper.deleteCdmJsnxodsCbrcsrctblByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除银监报送报来源分析信息
     * 
     * @param orderno 银监报送报来源分析ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsCbrcsrctblById(Long orderno)
    {
        return cdmJsnxodsCbrcsrctblMapper.deleteCdmJsnxodsCbrcsrctblById(orderno);
    }
}
