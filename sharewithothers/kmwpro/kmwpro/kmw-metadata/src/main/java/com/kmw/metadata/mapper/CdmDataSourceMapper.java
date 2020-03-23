package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmDataSource;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 数据源管理Mapper接口
 * 
 * @author kmw
 * @date 2020-03-23
 */
public interface CdmDataSourceMapper 
{
    /**
     * 查询数据源管理
     * 
     * @param id 数据源管理ID
     * @return 数据源管理
     */
    public CdmDataSource selectCdmDataSourceById(String id);

    /**
     * 查询数据源管理列表
     * 
     * @param cdmDataSource 数据源管理
     * @return 数据源管理集合
     */
    public List<CdmDataSource> selectCdmDataSourceList(CdmDataSource cdmDataSource);

    /**
     * 新增数据源管理
     * 
     * @param cdmDataSource 数据源管理
     * @return 结果
     */
    public int insertCdmDataSource(CdmDataSource cdmDataSource);

    /**
     * 修改数据源管理
     * 
     * @param cdmDataSource 数据源管理
     * @return 结果
     */
    public int updateCdmDataSource(CdmDataSource cdmDataSource);

    /**
     * 删除数据源管理
     * 
     * @param id 数据源管理ID
     * @return 结果
     */
    public int deleteCdmDataSourceById(String id);

    /**
     * 批量删除数据源管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmDataSourceByIds(String[] ids);
    
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
	public int insertBatch(List<CdmDataSource> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<CdmDataSource> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	public int updateBatchEntity( List<CdmDataSource> list);	
	
		/**
	 * 删除所有表里数据
	 */
	 public int deleteCdmDataSourceAll();
}
