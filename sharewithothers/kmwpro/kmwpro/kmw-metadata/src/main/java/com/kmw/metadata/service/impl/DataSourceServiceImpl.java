package com.kmw.metadata.service.impl;

import java.util.List;
import java.util.Map;


import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.DataSourceMapper;
import com.kmw.metadata.domain.DataSource;
import com.kmw.metadata.service.IDataSourceService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 数据源管理Service业务层处理
 * 
 * @author 赵祖龙
 * @date 2020-03-24
 */
@Service
public class DataSourceServiceImpl implements IDataSourceService 
{
    @Autowired
    private DataSourceMapper dataSourceMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询数据源管理
     * 
     * @param id 数据源管理ID
     * @return 数据源管理
     */
    @Override
    public DataSource selectDataSourceById(String id)
    {
        return dataSourceMapper.selectDataSourceById(id);
    }

    /**
     * 查询数据源管理列表
     * 
     * @param dataSource 数据源管理
     * @return 数据源管理
     */
    @Override
    public List<DataSource> selectDataSourceList(DataSource dataSource)
    {
        return dataSourceMapper.selectDataSourceList(dataSource);
    }

    /**
     * 新增数据源管理
     * 
     * @param dataSource 数据源管理
     * @return 结果
     */
    @Override
    public int insertDataSource(DataSource dataSource)
    {
        dataSource.setCreateTime(DateUtils.getNowDate());
        return dataSourceMapper.insertDataSource(dataSource);
    }

    /**
     * 修改数据源管理
     * 
     * @param dataSource 数据源管理
     * @return 结果
     */
    @Override
    public int updateDataSource(DataSource dataSource)
    {
        dataSource.setUpdateTime(DateUtils.getNowDate());
        return dataSourceMapper.updateDataSource(dataSource);
    }

    /**
     * 删除数据源管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDataSourceByIds(String ids)
    {
        return dataSourceMapper.deleteDataSourceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据源管理信息
     * 
     * @param id 数据源管理ID
     * @return 结果
     */
    @Override
    public int deleteDataSourceById(String id)
    {
        return dataSourceMapper.deleteDataSourceById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 数据源管理信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【数据源管理】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = dataSourceMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = dataSourceMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 数据源管理信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【数据源管理】列表数据，返回通用对象========================#");
		List<CommonEntity> list = dataSourceMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 数据源管理信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【数据源管理】数据，返回实体对象========================#");
	
		return dataSourceMapper.queryOneCommon(params);

	}
        
  	/**
	 * 更新操作
	 * @param DataSource
	 * @return
	 */
	public int updateBatch(List<DataSource> list){
		logger.info("#=================开始传入的实体列表更新【数据源管理】数据========================#");
		return dataSourceMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【数据源管理】数据========================#");
		return  dataSourceMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<DataSource> list){
		return  dataSourceMapper.insertBatch(list);
	}
    /**
	 * 删除表中所有数据
	 *  
	 * @return int
	 */
	public int deleteAll(){
		logger.info("#=================删除表【数据源管理】所有数据========================#");
		return  dataSourceMapper.deleteDataSourceAll();
	}
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<dataSource>
	 */
	public List<DataSource> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【数据源管理】列表数据，返回通用对象========================#");
		List<DataSource> list =  dataSourceMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
