package com.kmw.etlsqlparase.service.impl;

import java.util.List;
import java.util.Map;


import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.etlsqlparase.mapper.ParaseSqlEtlsqlMapper;
import com.kmw.etlsqlparase.domain.ParaseSqlEtlsql;
import com.kmw.etlsqlparase.service.IParaseSqlEtlsqlService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 解析ETLService业务层处理
 * 
 * @author kmw
 * @date 2020-03-15
 */
@Service
public class ParaseSqlEtlsqlServiceImpl implements IParaseSqlEtlsqlService 
{
    @Autowired
    private ParaseSqlEtlsqlMapper paraseSqlEtlsqlMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询解析ETL
     * 
     * @param id 解析ETLID
     * @return 解析ETL
     */
    @Override
    public ParaseSqlEtlsql selectParaseSqlEtlsqlById(String id)
    {
        return paraseSqlEtlsqlMapper.selectParaseSqlEtlsqlById(id);
    }

    /**
     * 查询解析ETL列表
     * 
     * @param paraseSqlEtlsql 解析ETL
     * @return 解析ETL
     */
    @Override
    public List<ParaseSqlEtlsql> selectParaseSqlEtlsqlList(ParaseSqlEtlsql paraseSqlEtlsql)
    {
        return paraseSqlEtlsqlMapper.selectParaseSqlEtlsqlList(paraseSqlEtlsql);
    }

    /**
     * 新增解析ETL
     * 
     * @param paraseSqlEtlsql 解析ETL
     * @return 结果
     */
    @Override
    public int insertParaseSqlEtlsql(ParaseSqlEtlsql paraseSqlEtlsql)
    {
        paraseSqlEtlsql.setCreateTime(DateUtils.getNowDate());
        return paraseSqlEtlsqlMapper.insertParaseSqlEtlsql(paraseSqlEtlsql);
    }

    /**
     * 修改解析ETL
     * 
     * @param paraseSqlEtlsql 解析ETL
     * @return 结果
     */
    @Override
    public int updateParaseSqlEtlsql(ParaseSqlEtlsql paraseSqlEtlsql)
    {
        paraseSqlEtlsql.setUpdateTime(DateUtils.getNowDate());
        return paraseSqlEtlsqlMapper.updateParaseSqlEtlsql(paraseSqlEtlsql);
    }

    /**
     * 删除解析ETL对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteParaseSqlEtlsqlByIds(String ids)
    {
        return paraseSqlEtlsqlMapper.deleteParaseSqlEtlsqlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除解析ETL信息
     * 
     * @param id 解析ETLID
     * @return 结果
     */
    @Override
    public int deleteParaseSqlEtlsqlById(String id)
    {
        return paraseSqlEtlsqlMapper.deleteParaseSqlEtlsqlById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 解析ETL信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【解析ETL】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = paraseSqlEtlsqlMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = paraseSqlEtlsqlMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 解析ETL信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【解析ETL】列表数据，返回通用对象========================#");
		List<CommonEntity> list = paraseSqlEtlsqlMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 解析ETL信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【解析ETL】数据，返回实体对象========================#");
	
		return paraseSqlEtlsqlMapper.queryOneCommon(params);

	}
        
  	/**
	 * 更新操作
	 * @param ParaseSqlEtlsql
	 * @return
	 */
	public int updateBatch(List<ParaseSqlEtlsql> list){
		logger.info("#=================开始传入的实体列表更新【解析ETL】数据========================#");
		return paraseSqlEtlsqlMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【解析ETL】数据========================#");
		return  paraseSqlEtlsqlMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<ParaseSqlEtlsql> list){
		return  paraseSqlEtlsqlMapper.insertBatch(list);
	}
    /**
	 * 删除表中所有数据
	 *  
	 * @return int
	 */
	public int deleteAll(){
		logger.info("#=================删除表【解析ETL】所有数据========================#");
		return  paraseSqlEtlsqlMapper.deleteParaseSqlEtlsqlAll();
	}
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<paraseSqlEtlsql>
	 */
	public List<ParaseSqlEtlsql> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【解析ETL】列表数据，返回通用对象========================#");
		List<ParaseSqlEtlsql> list =  paraseSqlEtlsqlMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
