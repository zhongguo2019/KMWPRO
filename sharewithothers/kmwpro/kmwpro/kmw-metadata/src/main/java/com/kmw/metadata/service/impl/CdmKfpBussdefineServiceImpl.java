package com.kmw.metadata.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmKfpBussdefineMapper;
import com.kmw.metadata.domain.CdmKfpBussdefine;
import com.kmw.metadata.service.ICdmKfpBussdefineService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 银行束语定义集Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-18
 */
@Service
public class CdmKfpBussdefineServiceImpl implements ICdmKfpBussdefineService 
{
    @Autowired
    private CdmKfpBussdefineMapper cdmKfpBussdefineMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询银行束语定义集
     * 
     * @param id 银行束语定义集ID
     * @return 银行束语定义集
     */
    @Override
    public CdmKfpBussdefine selectCdmKfpBussdefineById(Long id)
    {
        return cdmKfpBussdefineMapper.selectCdmKfpBussdefineById(id);
    }

    /**
     * 查询银行束语定义集列表
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 银行束语定义集
     */
    @Override
    public List<CdmKfpBussdefine> selectCdmKfpBussdefineList(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return cdmKfpBussdefineMapper.selectCdmKfpBussdefineList(cdmKfpBussdefine);
    }

    /**
     * 新增银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    @Override
    public int insertCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return cdmKfpBussdefineMapper.insertCdmKfpBussdefine(cdmKfpBussdefine);
    }

    /**
     * 修改银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    @Override
    public int updateCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return cdmKfpBussdefineMapper.updateCdmKfpBussdefine(cdmKfpBussdefine);
    }

    /**
     * 删除银行束语定义集对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmKfpBussdefineByIds(String ids)
    {
        return cdmKfpBussdefineMapper.deleteCdmKfpBussdefineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除银行束语定义集信息
     * 
     * @param id 银行束语定义集ID
     * @return 结果
     */
    @Override
    public int deleteCdmKfpBussdefineById(Long id)
    {
        return cdmKfpBussdefineMapper.deleteCdmKfpBussdefineById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 银行束语定义集信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【银行束语定义集】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = cdmKfpBussdefineMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = cdmKfpBussdefineMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 银行束语定义集信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【银行束语定义集】列表数据，返回通用对象========================#");
		List<CommonEntity> list = cdmKfpBussdefineMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 银行束语定义集信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【银行束语定义集信息】数据，返回实体对象========================#");
		if(params.containsKey("id")) {
		return cdmKfpBussdefineMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询【银行束语定义集信息】一条，Map参数中 id不能为空========================#");
	 return null;
		}
	}
        
    
    
    
    
    
    
}
