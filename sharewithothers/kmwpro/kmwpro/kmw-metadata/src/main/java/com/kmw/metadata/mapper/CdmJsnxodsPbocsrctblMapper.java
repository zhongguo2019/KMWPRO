package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmJsnxodsPbocsrctbl;
import java.util.List;

/**
 * 人行报送报来源分析Mapper接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface CdmJsnxodsPbocsrctblMapper 
{
    /**
     * 查询人行报送报来源分析
     * 
     * @param orderno 人行报送报来源分析ID
     * @return 人行报送报来源分析
     */
    public CdmJsnxodsPbocsrctbl selectCdmJsnxodsPbocsrctblById(Long orderno);

    /**
     * 查询人行报送报来源分析列表
     * 
     * @param cdmJsnxodsPbocsrctbl 人行报送报来源分析
     * @return 人行报送报来源分析集合
     */
    public List<CdmJsnxodsPbocsrctbl> selectCdmJsnxodsPbocsrctblList(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl);

    /**
     * 新增人行报送报来源分析
     * 
     * @param cdmJsnxodsPbocsrctbl 人行报送报来源分析
     * @return 结果
     */
    public int insertCdmJsnxodsPbocsrctbl(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl);

    /**
     * 修改人行报送报来源分析
     * 
     * @param cdmJsnxodsPbocsrctbl 人行报送报来源分析
     * @return 结果
     */
    public int updateCdmJsnxodsPbocsrctbl(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl);

    /**
     * 删除人行报送报来源分析
     * 
     * @param orderno 人行报送报来源分析ID
     * @return 结果
     */
    public int deleteCdmJsnxodsPbocsrctblById(Long orderno);

    /**
     * 批量删除人行报送报来源分析
     * 
     * @param ordernos 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmJsnxodsPbocsrctblByIds(String[] ordernos);
}
