package com.kmw.etlsqlparase.service;

import com.kmw.etlsqlparase.domain.ParaseEtlsql;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 解析ETL加工过程的SQL语法得到中文解释Service接口
 * 
 * @author kmw
 * @date 2020-03-02
 */
public interface IParaseEtlsqlService 
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
     * 批量删除解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteParaseEtlsqlByIds(String ids);

    /**
     * 删除解析ETL加工过程的SQL语法得到中文解释信息
     * 
     * @param id 解析ETL加工过程的SQL语法得到中文解释ID
     * @return 结果
     */
    public int deleteParaseEtlsqlById(String id);
    
    /**
	 * 分页展示(可带条件查询) 解析ETL加工过程的SQL语法得到中文解释
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  解析ETL加工过程的SQL语法得到中文解释
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 解析ETL加工过程的SQL语法得到中文解释
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 解析ETL加工过程的SQL语法得到中文解释
	 * @param Map<String, Object> params
	 * @return List<ParaseEtlsql> 
	 */
	public List<ParaseEtlsql> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 解析ETL加工过程的SQL语法得到中文解释
	 * @param Map<String, Object> params
	 * @return int
	 */
	public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量保存操作 List<ParaseEtlsql>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<ParaseEtlsql> list);

  	/**
	 * 更新操作
	 * @param List<ParaseEtlsql>
	 * @return
	 */
	public int updateBatch(List<ParaseEtlsql> list);
    
}
