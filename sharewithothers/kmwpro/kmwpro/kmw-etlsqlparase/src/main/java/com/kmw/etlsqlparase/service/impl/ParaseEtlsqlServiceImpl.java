package com.kmw.etlsqlparase.service.impl;

import java.util.List;
import java.util.Map;

import java.util.UUID;
import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.etlsqlparase.mapper.ParaseEtlsqlMapper;
import com.kmw.etlsqlparase.domain.ParaseEtlsql;
import com.kmw.etlsqlparase.service.IParaseEtlsqlService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 解析ETL加工过程的SQL语法得到中文解释Service业务层处理
 * 
 * @author kmw
 * @date 2020-03-02
 */
@Service
public class ParaseEtlsqlServiceImpl implements IParaseEtlsqlService 
{
    @Autowired
    private ParaseEtlsqlMapper paraseEtlsqlMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param id 解析ETL加工过程的SQL语法得到中文解释ID
     * @return 解析ETL加工过程的SQL语法得到中文解释
     */
    @Override
    public ParaseEtlsql selectParaseEtlsqlById(String id)
    {
        return paraseEtlsqlMapper.selectParaseEtlsqlById(id);
    }

    /**
     * 查询解析ETL加工过程的SQL语法得到中文解释列表
     * 
     * @param paraseEtlsql 解析ETL加工过程的SQL语法得到中文解释
     * @return 解析ETL加工过程的SQL语法得到中文解释
     */
    @Override
    public List<ParaseEtlsql> selectParaseEtlsqlList(ParaseEtlsql paraseEtlsql)
    {
        return paraseEtlsqlMapper.selectParaseEtlsqlList(paraseEtlsql);
    }

    /**
     * 新增解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param paraseEtlsql 解析ETL加工过程的SQL语法得到中文解释
     * @return 结果
     */
    @Override
    public int insertParaseEtlsql(ParaseEtlsql paraseEtlsql)
    {
    	paraseEtlsql.setId(UUID.randomUUID().toString());
        paraseEtlsql.setCreateTime(DateUtils.getNowDate());
        return paraseEtlsqlMapper.insertParaseEtlsql(paraseEtlsql);
    }

    /**
     * 修改解析ETL加工过程的SQL语法得到中文解释
     * 
     * @param paraseEtlsql 解析ETL加工过程的SQL语法得到中文解释
     * @return 结果
     */
    @Override
    public int updateParaseEtlsql(ParaseEtlsql paraseEtlsql)
    {
        paraseEtlsql.setUpdateTime(DateUtils.getNowDate());
        return paraseEtlsqlMapper.updateParaseEtlsql(paraseEtlsql);
    }

    /**
     * 删除解析ETL加工过程的SQL语法得到中文解释对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteParaseEtlsqlByIds(String ids)
    {
        return paraseEtlsqlMapper.deleteParaseEtlsqlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除解析ETL加工过程的SQL语法得到中文解释信息
     * 
     * @param id 解析ETL加工过程的SQL语法得到中文解释ID
     * @return 结果
     */
    @Override
    public int deleteParaseEtlsqlById(String id)
    {
        return paraseEtlsqlMapper.deleteParaseEtlsqlById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 解析ETL加工过程的SQL语法得到中文解释信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【解析ETL加工过程的SQL语法得到中文解释】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = paraseEtlsqlMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = paraseEtlsqlMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 解析ETL加工过程的SQL语法得到中文解释信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【解析ETL加工过程的SQL语法得到中文解释】列表数据，返回通用对象========================#");
		List<CommonEntity> list = paraseEtlsqlMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 解析ETL加工过程的SQL语法得到中文解释信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【解析ETL加工过程的SQL语法得到中文解释】数据，返回实体对象========================#");
		if(params.containsKey("id")) {
		return paraseEtlsqlMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询【解析ETL加工过程的SQL语法得到中文解释】一条，Map参数中 id不能为空========================#");
	 return null;
		}
	}
        
  	/**
	 * 更新操作
	 * @param ParaseEtlsql
	 * @return
	 */
	public int updateBatch(List<ParaseEtlsql> list){
		logger.info("#=================开始传入的实体列表更新【解析ETL加工过程的SQL语法得到中文解释】数据========================#");
		return paraseEtlsqlMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【解析ETL加工过程的SQL语法得到中文解释】数据========================#");
		return  paraseEtlsqlMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<ParaseEtlsql> list){
		return  paraseEtlsqlMapper.insertBatch(list);
	}
    
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<paraseEtlsql>
	 */
	public List<ParaseEtlsql> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【解析ETL加工过程的SQL语法得到中文解释】列表数据，返回通用对象========================#");
		List<ParaseEtlsql> list =  paraseEtlsqlMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
