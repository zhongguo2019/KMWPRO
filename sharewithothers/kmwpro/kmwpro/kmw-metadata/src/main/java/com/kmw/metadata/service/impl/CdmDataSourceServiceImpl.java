package com.kmw.metadata.service.impl;

import java.util.List;
import java.util.Map;


import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmDataSourceMapper;
import com.kmw.metadata.domain.CdmDataSource;
import com.kmw.metadata.service.ICdmDataSourceService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 数据源管理Service业务层处理
 * 
 * @author kmw
 * @date 2020-03-23
 */
@Service
public class CdmDataSourceServiceImpl implements ICdmDataSourceService 
{
    @Autowired
    private CdmDataSourceMapper cdmDataSourceMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询数据源管理
     * 
     * @param id 数据源管理ID
     * @return 数据源管理
     */
    @Override
    public CdmDataSource selectCdmDataSourceById(String id)
    {
        return cdmDataSourceMapper.selectCdmDataSourceById(id);
    }

    /**
     * 查询数据源管理列表
     * 
     * @param cdmDataSource 数据源管理
     * @return 数据源管理
     */
    @Override
    public List<CdmDataSource> selectCdmDataSourceList(CdmDataSource cdmDataSource)
    {
        return cdmDataSourceMapper.selectCdmDataSourceList(cdmDataSource);
    }

    /**
     * 新增数据源管理
     * 
     * @param cdmDataSource 数据源管理
     * @return 结果
     */
    @Override
    public int insertCdmDataSource(CdmDataSource cdmDataSource)
    {
        cdmDataSource.setCreateTime(DateUtils.getNowDate());
        return cdmDataSourceMapper.insertCdmDataSource(cdmDataSource);
    }

    /**
     * 修改数据源管理
     * 
     * @param cdmDataSource 数据源管理
     * @return 结果
     */
    @Override
    public int updateCdmDataSource(CdmDataSource cdmDataSource)
    {
        cdmDataSource.setUpdateTime(DateUtils.getNowDate());
        return cdmDataSourceMapper.updateCdmDataSource(cdmDataSource);
    }

    /**
     * 删除数据源管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmDataSourceByIds(String ids)
    {
        return cdmDataSourceMapper.deleteCdmDataSourceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据源管理信息
     * 
     * @param id 数据源管理ID
     * @return 结果
     */
    @Override
    public int deleteCdmDataSourceById(String id)
    {
        return cdmDataSourceMapper.deleteCdmDataSourceById(id);
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
			list = cdmDataSourceMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = cdmDataSourceMapper.queryPageInfo(params);
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
		List<CommonEntity> list = cdmDataSourceMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 数据源管理信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【数据源管理】数据，返回实体对象========================#");
	
		return cdmDataSourceMapper.queryOneCommon(params);

	}
        
  	/**
	 * 更新操作
	 * @param CdmDataSource
	 * @return
	 */
	public int updateBatch(List<CdmDataSource> list){
		logger.info("#=================开始传入的实体列表更新【数据源管理】数据========================#");
		return cdmDataSourceMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【数据源管理】数据========================#");
		return  cdmDataSourceMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<CdmDataSource> list){
		return  cdmDataSourceMapper.insertBatch(list);
	}
    /**
	 * 删除表中所有数据
	 *  
	 * @return int
	 */
	public int deleteAll(){
		logger.info("#=================删除表【数据源管理】所有数据========================#");
		return  cdmDataSourceMapper.deleteCdmDataSourceAll();
	}
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<cdmDataSource>
	 */
	public List<CdmDataSource> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【数据源管理】列表数据，返回通用对象========================#");
		List<CdmDataSource> list =  cdmDataSourceMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
