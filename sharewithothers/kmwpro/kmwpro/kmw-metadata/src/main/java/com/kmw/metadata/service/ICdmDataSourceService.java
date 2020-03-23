package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmDataSource;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 数据源管理Service接口
 * 
 * @author kmw
 * @date 2020-03-23
 */
public interface ICdmDataSourceService 
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
     * 批量删除数据源管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmDataSourceByIds(String ids);

    /**
     * 删除数据源管理信息
     * 
     * @param id 数据源管理ID
     * @return 结果
     */
    public int deleteCdmDataSourceById(String id);
    
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
	 * @return List<CdmDataSource> 
	 */
	public List<CdmDataSource> entityList(Map<String, Object> params);

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
	 * 批量保存操作 List<CdmDataSource>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<CdmDataSource> list);

  	/**
	 * 更新操作
	 * @param List<CdmDataSource>
	 * @return
	 */
	public int updateBatch(List<CdmDataSource> list);
    
}
