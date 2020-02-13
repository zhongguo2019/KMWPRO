package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmJsnxodsCbrcsrctbl;
import java.util.List;

/**
 * 银监报送报来源分析Mapper接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface CdmJsnxodsCbrcsrctblMapper 
{
    /**
     * 查询银监报送报来源分析
     * 
     * @param orderno 银监报送报来源分析ID
     * @return 银监报送报来源分析
     */
    public CdmJsnxodsCbrcsrctbl selectCdmJsnxodsCbrcsrctblById(Long orderno);

    /**
     * 查询银监报送报来源分析列表
     * 
     * @param cdmJsnxodsCbrcsrctbl 银监报送报来源分析
     * @return 银监报送报来源分析集合
     */
    public List<CdmJsnxodsCbrcsrctbl> selectCdmJsnxodsCbrcsrctblList(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl);

    /**
     * 新增银监报送报来源分析
     * 
     * @param cdmJsnxodsCbrcsrctbl 银监报送报来源分析
     * @return 结果
     */
    public int insertCdmJsnxodsCbrcsrctbl(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl);

    /**
     * 修改银监报送报来源分析
     * 
     * @param cdmJsnxodsCbrcsrctbl 银监报送报来源分析
     * @return 结果
     */
    public int updateCdmJsnxodsCbrcsrctbl(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl);

    /**
     * 删除银监报送报来源分析
     * 
     * @param orderno 银监报送报来源分析ID
     * @return 结果
     */
    public int deleteCdmJsnxodsCbrcsrctblById(Long orderno);

    /**
     * 批量删除银监报送报来源分析
     * 
     * @param ordernos 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmJsnxodsCbrcsrctblByIds(String[] ordernos);
}
