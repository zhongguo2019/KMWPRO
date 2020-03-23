package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmKfpDataqualify;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 数据质量检核配置Mapper接口
 * 
 * @author kmw
 * @date 2020-03-13
 */
public interface CdmKfpDataqualifyMapper 
{
    /**
     * 查询数据质量检核配置
     * 
     * @param id 数据质量检核配置ID
     * @return 数据质量检核配置
     */
    public CdmKfpDataqualify selectCdmKfpDataqualifyById(String id);

    /**
     * 查询数据质量检核配置列表
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 数据质量检核配置集合
     */
    public List<CdmKfpDataqualify> selectCdmKfpDataqualifyList(CdmKfpDataqualify cdmKfpDataqualify);

    /**
     * 新增数据质量检核配置
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 结果
     */
    public int insertCdmKfpDataqualify(CdmKfpDataqualify cdmKfpDataqualify);

    /**
     * 修改数据质量检核配置
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 结果
     */
    public int updateCdmKfpDataqualify(CdmKfpDataqualify cdmKfpDataqualify);

    /**
     * 删除数据质量检核配置
     * 
     * @param id 数据质量检核配置ID
     * @return 结果
     */
    public int deleteCdmKfpDataqualifyById(String id);

    /**
     * 批量删除数据质量检核配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmKfpDataqualifyByIds(String[] ids);
    
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
    
    /**
	 * 批量插入数据
	 */
	public int insertBatch(List<CdmKfpDataqualify> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<CdmKfpDataqualify> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	public int updateBatchEntity( List<CdmKfpDataqualify> list);	
	
		/**
	 * 删除所有表里数据
	 */
	 public int deleteCdmKfpDataqualifyAll();
}
