package com.kmw.qywx.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.qywx.mapper.WxUserGroupMapper;
import com.kmw.qywx.domain.WxUserGroup;
import com.kmw.qywx.service.IWxUserGroupService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 微信用户分组信息Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-20
 */
@Service
public class WxUserGroupServiceImpl implements IWxUserGroupService 
{
    @Autowired
    private WxUserGroupMapper wxUserGroupMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询微信用户分组信息
     * 
     * @param id 微信用户分组信息ID
     * @return 微信用户分组信息
     */
    @Override
    public WxUserGroup selectWxUserGroupById(String id)
    {
        return wxUserGroupMapper.selectWxUserGroupById(id);
    }

    /**
     * 查询微信用户分组信息列表
     * 
     * @param wxUserGroup 微信用户分组信息
     * @return 微信用户分组信息
     */
    @Override
    public List<WxUserGroup> selectWxUserGroupList(WxUserGroup wxUserGroup)
    {
        return wxUserGroupMapper.selectWxUserGroupList(wxUserGroup);
    }

    /**
     * 新增微信用户分组信息
     * 
     * @param wxUserGroup 微信用户分组信息
     * @return 结果
     */
    @Override
    public int insertWxUserGroup(WxUserGroup wxUserGroup)
    {
        return wxUserGroupMapper.insertWxUserGroup(wxUserGroup);
    }

    /**
     * 修改微信用户分组信息
     * 
     * @param wxUserGroup 微信用户分组信息
     * @return 结果
     */
    @Override
    public int updateWxUserGroup(WxUserGroup wxUserGroup)
    {
        return wxUserGroupMapper.updateWxUserGroup(wxUserGroup);
    }

    /**
     * 删除微信用户分组信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxUserGroupByIds(String ids)
    {
        return wxUserGroupMapper.deleteWxUserGroupByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信用户分组信息信息
     * 
     * @param id 微信用户分组信息ID
     * @return 结果
     */
    @Override
    public int deleteWxUserGroupById(String id)
    {
        return wxUserGroupMapper.deleteWxUserGroupById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 微信用户分组信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【微信用户分组信息】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = wxUserGroupMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = wxUserGroupMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 微信用户分组信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【微信用户分组信息】列表数据，返回通用对象========================#");
		List<CommonEntity> list = wxUserGroupMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 微信用户分组信息信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【微信用户分组信息信息】数据，返回实体对象========================#");
		if(params.containsKey("id")) {
		return wxUserGroupMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询【微信用户分组信息信息】一条，Map参数中 id不能为空========================#");
	 return null;
		}
	}
        
    
	/**
	 * 列表(可带条件查询)
	 * 返回的是实体list
	 * @param params
	 * @return List<WxUserGroup>
	 */
	public List<WxUserGroup> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【微信用户分组信息表】列表数据，返回实体对象========================#");
		List<WxUserGroup> list = wxUserGroupMapper.entityList(params);
		return list;
	}
	   
    

    
    
}
