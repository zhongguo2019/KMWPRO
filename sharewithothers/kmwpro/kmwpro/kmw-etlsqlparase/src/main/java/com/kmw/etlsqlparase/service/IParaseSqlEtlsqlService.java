package com.kmw.etlsqlparase.service;

import com.kmw.etlsqlparase.domain.ParaseSqlEtlsql;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 解析ETLService接口
 * 
 * @author kmw
 * @date 2020-03-15
 */
public interface IParaseSqlEtlsqlService 
{
    /**
     * 查询解析ETL
     * 
     * @param id 解析ETLID
     * @return 解析ETL
     */
    public ParaseSqlEtlsql selectParaseSqlEtlsqlById(String id);

    /**
     * 查询解析ETL列表
     * 
     * @param paraseSqlEtlsql 解析ETL
     * @return 解析ETL集合
     */
    public List<ParaseSqlEtlsql> selectParaseSqlEtlsqlList(ParaseSqlEtlsql paraseSqlEtlsql);

    /**
     * 新增解析ETL
     * 
     * @param paraseSqlEtlsql 解析ETL
     * @return 结果
     */
    public int insertParaseSqlEtlsql(ParaseSqlEtlsql paraseSqlEtlsql);

    /**
     * 修改解析ETL
     * 
     * @param paraseSqlEtlsql 解析ETL
     * @return 结果
     */
    public int updateParaseSqlEtlsql(ParaseSqlEtlsql paraseSqlEtlsql);

    /**
     * 批量删除解析ETL
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteParaseSqlEtlsqlByIds(String ids);

    /**
     * 删除解析ETL信息
     * 
     * @param id 解析ETLID
     * @return 结果
     */
    public int deleteParaseSqlEtlsqlById(String id);
    
    /**
	 * 分页展示(可带条件查询) 解析ETL
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  解析ETL
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 解析ETL
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 解析ETL
	 * @param Map<String, Object> params
	 * @return List<ParaseSqlEtlsql> 
	 */
	public List<ParaseSqlEtlsql> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 解析ETL
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
	 * 批量保存操作 List<ParaseSqlEtlsql>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<ParaseSqlEtlsql> list);

  	/**
	 * 更新操作
	 * @param List<ParaseSqlEtlsql>
	 * @return
	 */
	public int updateBatch(List<ParaseSqlEtlsql> list);
    
}
