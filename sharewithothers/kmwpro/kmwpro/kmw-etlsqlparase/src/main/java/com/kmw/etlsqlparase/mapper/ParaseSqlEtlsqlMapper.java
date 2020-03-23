package com.kmw.etlsqlparase.mapper;

import com.kmw.etlsqlparase.domain.ParaseSqlEtlsql;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 解析ETLMapper接口
 * 
 * @author kmw
 * @date 2020-03-15
 */
public interface ParaseSqlEtlsqlMapper 
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
     * 删除解析ETL
     * 
     * @param id 解析ETLID
     * @return 结果
     */
    public int deleteParaseSqlEtlsqlById(String id);

    /**
     * 批量删除解析ETL
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteParaseSqlEtlsqlByIds(String[] ids);
    
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
	public int insertBatch(List<ParaseSqlEtlsql> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<ParaseSqlEtlsql> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	public int updateBatchEntity( List<ParaseSqlEtlsql> list);	
	
		/**
	 * 删除所有表里数据
	 */
	 public int deleteParaseSqlEtlsqlAll();
}
