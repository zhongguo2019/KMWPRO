package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.DataSource;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 数据源管理Mapper接口
 * 
 * @author 赵祖龙
 * @date 2020-03-24
 */
public interface DataSourceMapper 
{
    /**
     * 查询数据源管理
     * 
     * @param id 数据源管理ID
     * @return 数据源管理
     */
    public DataSource selectDataSourceById(String id);

    /**
     * 查询数据源管理列表
     * 
     * @param dataSource 数据源管理
     * @return 数据源管理集合
     */
    public List<DataSource> selectDataSourceList(DataSource dataSource);

    /**
     * 新增数据源管理
     * 
     * @param dataSource 数据源管理
     * @return 结果
     */
    public int insertDataSource(DataSource dataSource);

    /**
     * 修改数据源管理
     * 
     * @param dataSource 数据源管理
     * @return 结果
     */
    public int updateDataSource(DataSource dataSource);

    /**
     * 删除数据源管理
     * 
     * @param id 数据源管理ID
     * @return 结果
     */
    public int deleteDataSourceById(String id);

    /**
     * 批量删除数据源管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDataSourceByIds(String[] ids);
    
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
	public int insertBatch(List<DataSource> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<DataSource> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	public int updateBatchEntity( List<DataSource> list);	
	
		/**
	 * 删除所有表里数据
	 */
	 public int deleteDataSourceAll();
}
