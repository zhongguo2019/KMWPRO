package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmJsnxodsTableall;
import java.util.List;

/**
 * ODS列Service接口
 * 
 * @author kmw
 * @date 2020-02-06
 */
public interface ICdmJsnxodsTableallService 
{
    /**
     * 查询ODS列
     * 
     * @param id ODS列ID
     * @return ODS列
     */
    public CdmJsnxodsTableall selectCdmJsnxodsTableallById(Long id);

    /**
     * 查询ODS列列表
     * 
     * @param cdmJsnxodsTableall ODS列
     * @return ODS列集合
     */
    public List<CdmJsnxodsTableall> selectCdmJsnxodsTableallList(CdmJsnxodsTableall cdmJsnxodsTableall);

    /**
     * 新增ODS列
     * 
     * @param cdmJsnxodsTableall ODS列
     * @return 结果
     */
    public int insertCdmJsnxodsTableall(CdmJsnxodsTableall cdmJsnxodsTableall);

    /**
     * 修改ODS列
     * 
     * @param cdmJsnxodsTableall ODS列
     * @return 结果
     */
    public int updateCdmJsnxodsTableall(CdmJsnxodsTableall cdmJsnxodsTableall);

    /**
     * 批量删除ODS列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmJsnxodsTableallByIds(String ids);

    /**
     * 删除ODS列信息
     * 
     * @param id ODS列ID
     * @return 结果
     */
    public int deleteCdmJsnxodsTableallById(Long id);
}
