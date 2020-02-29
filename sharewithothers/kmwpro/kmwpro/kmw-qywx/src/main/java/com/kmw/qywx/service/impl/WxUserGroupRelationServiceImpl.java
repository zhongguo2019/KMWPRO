package com.kmw.qywx.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.qywx.mapper.WxUserGroupRelationMapper;
import com.kmw.qywx.domain.WxUserGroupRelation;
import com.kmw.qywx.service.IWxUserGroupRelationService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 分组信息与用户对应关系Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-29
 */
@Service
public class WxUserGroupRelationServiceImpl implements IWxUserGroupRelationService 
{
    @Autowired
    private WxUserGroupRelationMapper wxUserGroupRelationMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询分组信息与用户对应关系
     * 
     * @param id 分组信息与用户对应关系ID
     * @return 分组信息与用户对应关系
     */
    @Override
    public WxUserGroupRelation selectWxUserGroupRelationById(String id)
    {
        return wxUserGroupRelationMapper.selectWxUserGroupRelationById(id);
    }

    /**
     * 查询分组信息与用户对应关系列表
     * 
     * @param wxUserGroupRelation 分组信息与用户对应关系
     * @return 分组信息与用户对应关系
     */
    @Override
    public List<WxUserGroupRelation> selectWxUserGroupRelationList(WxUserGroupRelation wxUserGroupRelation)
    {
        return wxUserGroupRelationMapper.selectWxUserGroupRelationList(wxUserGroupRelation);
    }

    /**
     * 新增分组信息与用户对应关系
     * 
     * @param wxUserGroupRelation 分组信息与用户对应关系
     * @return 结果
     */
    @Override
    public int insertWxUserGroupRelation(WxUserGroupRelation wxUserGroupRelation)
    {
        return wxUserGroupRelationMapper.insertWxUserGroupRelation(wxUserGroupRelation);
    }

    /**
     * 修改分组信息与用户对应关系
     * 
     * @param wxUserGroupRelation 分组信息与用户对应关系
     * @return 结果
     */
    @Override
    public int updateWxUserGroupRelation(WxUserGroupRelation wxUserGroupRelation)
    {
        return wxUserGroupRelationMapper.updateWxUserGroupRelation(wxUserGroupRelation);
    }

    /**
     * 删除分组信息与用户对应关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxUserGroupRelationByIds(String ids)
    {
        return wxUserGroupRelationMapper.deleteWxUserGroupRelationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分组信息与用户对应关系信息
     * 
     * @param id 分组信息与用户对应关系ID
     * @return 结果
     */
    @Override
    public int deleteWxUserGroupRelationById(String id)
    {
        return wxUserGroupRelationMapper.deleteWxUserGroupRelationById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 分组信息与用户对应关系信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【分组信息与用户对应关系】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = wxUserGroupRelationMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = wxUserGroupRelationMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 分组信息与用户对应关系信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【分组信息与用户对应关系】列表数据，返回通用对象========================#");
		List<CommonEntity> list = wxUserGroupRelationMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 分组信息与用户对应关系信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【分组信息与用户对应关系】数据，返回实体对象========================#");
		if(params.containsKey("id")) {
		return wxUserGroupRelationMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询【分组信息与用户对应关系】一条，Map参数中 id不能为空========================#");
	 return null;
		}
	}
        
  	/**
	 * 更新操作
	 * @param WxUserGroupRelation
	 * @return
	 */
	public int updateBatch(List<WxUserGroupRelation> list){
		logger.info("#=================开始传入的实体列表更新【分组信息与用户对应关系】数据========================#");
		return wxUserGroupRelationMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【分组信息与用户对应关系】数据========================#");
		return  wxUserGroupRelationMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<WxUserGroupRelation> list){
		return  wxUserGroupRelationMapper.insertBatch(list);
	}
    
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<wxUserGroupRelation>
	 */
	public List<WxUserGroupRelation> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【分组信息与用户对应关系】列表数据，返回通用对象========================#");
		List<WxUserGroupRelation> list =  wxUserGroupRelationMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
