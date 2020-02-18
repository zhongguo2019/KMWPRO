package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmKfpBussdefine;
import java.util.List;

/**
 * 银行束语定义集Service接口
 * 
 * @author kmw
 * @date 2020-02-17
 */
public interface ICdmKfpBussdefineService 
{
    /**
     * 查询银行束语定义集
     * 
     * @param id 银行束语定义集ID
     * @return 银行束语定义集
     */
    public CdmKfpBussdefine selectCdmKfpBussdefineById(Long id);

    /**
     * 查询银行束语定义集列表
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 银行束语定义集集合
     */
    public List<CdmKfpBussdefine> selectCdmKfpBussdefineList(CdmKfpBussdefine cdmKfpBussdefine);

    /**
     * 新增银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    public int insertCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine);

    /**
     * 修改银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    public int updateCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine);

    /**
     * 批量删除银行束语定义集
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmKfpBussdefineByIds(String ids);

    /**
     * 删除银行束语定义集信息
     * 
     * @param id 银行束语定义集ID
     * @return 结果
     */
    public int deleteCdmKfpBussdefineById(Long id);
}
