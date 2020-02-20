package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmKfpBussdefine;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 银行束语定义集Mapper接口
 * 
 * @author kmw
 * @date 2020-02-18
 */
public interface CdmKfpBussdefineMapper 
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
     * 删除银行束语定义集
     * 
     * @param id 银行束语定义集ID
     * @return 结果
     */
    public int deleteCdmKfpBussdefineById(Long id);

    /**
     * 批量删除银行束语定义集
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmKfpBussdefineByIds(String[] ids);
    
    /**
     * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
     * 
     * @param Map<String, Object> params  查询条件以map形式
     * @return 结果
     */
    public List<CommonEntity> queryPageInfo(Map<String, Object> params);
        /**
     * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
     * 
     * @param Map<String, Object> params  查询条件以map形式
     * @return 结果
     */
    public List<CommonEntity> queryEntityList(Map<String, Object> params);
        /**
     * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
     * 
     * @param Map<String, Object> params  查询条件以map形式
     * @return 结果
     */
    public CommonEntity queryOneCommon(Map<String, Object> params);
}
