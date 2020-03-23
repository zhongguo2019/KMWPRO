package com.kmw.metadata.service.impl;

import java.util.List;
import java.util.Map;


import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmKfpDataqualifyMapper;
import com.kmw.metadata.domain.CdmKfpDataqualify;
import com.kmw.metadata.service.ICdmKfpDataqualifyService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 数据质量检核配置Service业务层处理
 * 
 * @author kmw
 * @date 2020-03-13
 */
@Service
public class CdmKfpDataqualifyServiceImpl implements ICdmKfpDataqualifyService 
{
    @Autowired
    private CdmKfpDataqualifyMapper cdmKfpDataqualifyMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询数据质量检核配置
     * 
     * @param id 数据质量检核配置ID
     * @return 数据质量检核配置
     */
    @Override
    public CdmKfpDataqualify selectCdmKfpDataqualifyById(String id)
    {
        return cdmKfpDataqualifyMapper.selectCdmKfpDataqualifyById(id);
    }

    /**
     * 查询数据质量检核配置列表
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 数据质量检核配置
     */
    @Override
    public List<CdmKfpDataqualify> selectCdmKfpDataqualifyList(CdmKfpDataqualify cdmKfpDataqualify)
    {
        return cdmKfpDataqualifyMapper.selectCdmKfpDataqualifyList(cdmKfpDataqualify);
    }

    /**
     * 新增数据质量检核配置
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 结果
     */
    @Override
    public int insertCdmKfpDataqualify(CdmKfpDataqualify cdmKfpDataqualify)
    {
        cdmKfpDataqualify.setCreateTime(DateUtils.getNowDate());
        return cdmKfpDataqualifyMapper.insertCdmKfpDataqualify(cdmKfpDataqualify);
    }

    /**
     * 修改数据质量检核配置
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 结果
     */
    @Override
    public int updateCdmKfpDataqualify(CdmKfpDataqualify cdmKfpDataqualify)
    {
        cdmKfpDataqualify.setUpdateTime(DateUtils.getNowDate());
        return cdmKfpDataqualifyMapper.updateCdmKfpDataqualify(cdmKfpDataqualify);
    }

    /**
     * 删除数据质量检核配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmKfpDataqualifyByIds(String ids)
    {
        return cdmKfpDataqualifyMapper.deleteCdmKfpDataqualifyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据质量检核配置信息
     * 
     * @param id 数据质量检核配置ID
     * @return 结果
     */
    @Override
    public int deleteCdmKfpDataqualifyById(String id)
    {
        return cdmKfpDataqualifyMapper.deleteCdmKfpDataqualifyById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 数据质量检核配置信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【数据质量检核配置】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = cdmKfpDataqualifyMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = cdmKfpDataqualifyMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 数据质量检核配置信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【数据质量检核配置】列表数据，返回通用对象========================#");
		List<CommonEntity> list = cdmKfpDataqualifyMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 数据质量检核配置信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【数据质量检核配置】数据，返回实体对象========================#");
	
		return cdmKfpDataqualifyMapper.queryOneCommon(params);

	}
        
  	/**
	 * 更新操作
	 * @param CdmKfpDataqualify
	 * @return
	 */
	public int updateBatch(List<CdmKfpDataqualify> list){
		logger.info("#=================开始传入的实体列表更新【数据质量检核配置】数据========================#");
		return cdmKfpDataqualifyMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【数据质量检核配置】数据========================#");
		return  cdmKfpDataqualifyMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<CdmKfpDataqualify> list){
		return  cdmKfpDataqualifyMapper.insertBatch(list);
	}
    /**
	 * 删除表中所有数据
	 *  
	 * @return int
	 */
	public int deleteAll(){
		logger.info("#=================删除表【数据质量检核配置】所有数据========================#");
		return  cdmKfpDataqualifyMapper.deleteCdmKfpDataqualifyAll();
	}
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<cdmKfpDataqualify>
	 */
	public List<CdmKfpDataqualify> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【数据质量检核配置】列表数据，返回通用对象========================#");
		List<CdmKfpDataqualify> list =  cdmKfpDataqualifyMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
