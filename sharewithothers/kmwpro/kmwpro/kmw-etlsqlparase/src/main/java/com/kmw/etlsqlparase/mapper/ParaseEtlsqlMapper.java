package com.kmw.etlsqlparase.mapper;

import com.kmw.etlsqlparase.domain.ParaseEtlsql;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 解析ETL加工过程的SQL语法得到中文解释Mapper接口
 * 
 * @author kmw
 * @date 2020-03-02
 */
public interface ParaseEtlsqlMapper 
{
    /**
     * 查询解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param id 解析ETL加工过程的SQL语法得到中文解释ID
     * @return 解析ETL加工过程的SQL语法得到中文解释
     */
    public ParaseEtlsql selectParaseEtlsqlById(String id);

    /**
     * 查询解析ETL加工过程的SQL语法得到中文解释列表
     * 
     * @param paraseEtlsql 解析ETL加工过程的SQL语法得到中文解释
     * @return 解析ETL加工过程的SQL语法得到中文解释集合
     */
    public List<ParaseEtlsql> selectParaseEtlsqlList(ParaseEtlsql paraseEtlsql);

    /**
     * 新增解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param paraseEtlsql 解析ETL加工过程的SQL语法得到中文解释
     * @return 结果
     */
    public int insertParaseEtlsql(ParaseEtlsql paraseEtlsql);

    /**
     * 修改解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param paraseEtlsql 解析ETL加工过程的SQL语法得到中文解释
     * @return 结果
     */
    public int updateParaseEtlsql(ParaseEtlsql paraseEtlsql);

    /**
     * 删除解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param id 解析ETL加工过程的SQL语法得到中文解释ID
     * @return 结果
     */
    public int deleteParaseEtlsqlById(String id);

    /**
     * 批量删除解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteParaseEtlsqlByIds(String[] ids);
    
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
	public int insertBatch(List<ParaseEtlsql> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<ParaseEtlsql> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	int updateBatchEntity( List<ParaseEtlsql> list);	
}
