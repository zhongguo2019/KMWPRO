package com.kmw.metadata.service;

import com.kmw.metadata.domain.DataSource;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 数据源管理Service接口
 * 
 * @author 赵祖龙
 * @date 2020-03-24
 */
public interface IDataSourceService 
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
     * 批量删除数据源管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDataSourceByIds(String ids);

    /**
     * 删除数据源管理信息
     * 
     * @param id 数据源管理ID
     * @return 结果
     */
    public int deleteDataSourceById(String id);
    
    /**
	 * 分页展示(可带条件查询) 数据源管理
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  数据源管理
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 数据源管理
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 数据源管理
	 * @param Map<String, Object> params
	 * @return List<DataSource> 
	 */
	public List<DataSource> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 数据源管理
	 * @param Map<String, Object> params
	 * @return int
	 */
	public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 
	 * 删除表中所有数据
	 * @return int
	 */
	public int deleteAll();
	
	/**
	 * 批量保存操作 List<DataSource>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<DataSource> list);

  	/**
	 * 更新操作
	 * @param List<DataSource>
	 * @return
	 */
	public int updateBatch(List<DataSource> list);
    
}
