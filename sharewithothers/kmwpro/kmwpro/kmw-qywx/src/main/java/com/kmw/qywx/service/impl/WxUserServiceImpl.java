package com.kmw.qywx.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.qywx.mapper.WxUserMapper;
import com.kmw.qywx.domain.WxUser;
import com.kmw.qywx.service.IWxUserService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 企业微信用户信息Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-20
 */
@Service
public class WxUserServiceImpl implements IWxUserService 
{
    @Autowired
    private WxUserMapper wxUserMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询企业微信用户信息
     * 
     * @param name 企业微信用户信息ID
     * @return 企业微信用户信息
     */
    @Override
    public WxUser selectWxUserById(String name)
    {
        return wxUserMapper.selectWxUserById(name);
    }

    /**
     * 查询企业微信用户信息列表
     * 
     * @param wxUser 企业微信用户信息
     * @return 企业微信用户信息
     */
    @Override
    public List<WxUser> selectWxUserList(WxUser wxUser)
    {
        return wxUserMapper.selectWxUserList(wxUser);
    }

    /**
     * 新增企业微信用户信息
     * 
     * @param wxUser 企业微信用户信息
     * @return 结果
     */
    @Override
    public int insertWxUser(WxUser wxUser)
    {
        return wxUserMapper.insertWxUser(wxUser);
    }

    /**
     * 修改企业微信用户信息
     * 
     * @param wxUser 企业微信用户信息
     * @return 结果
     */
    @Override
    public int updateWxUser(WxUser wxUser)
    {
        return wxUserMapper.updateWxUser(wxUser);
    }

    /**
     * 删除企业微信用户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxUserByIds(String ids)
    {
        return wxUserMapper.deleteWxUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业微信用户信息信息
     * 
     * @param name 企业微信用户信息ID
     * @return 结果
     */
    @Override
    public int deleteWxUserById(String name)
    {
        return wxUserMapper.deleteWxUserById(name);
    }
    
	/**
	 * 分页展示(可带条件查询) 企业微信用户信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【企业微信用户信息】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = wxUserMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = wxUserMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 企业微信用户信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【企业微信用户信息】列表数据，返回通用对象========================#");
		List<CommonEntity> list = wxUserMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 企业微信用户信息信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【企业微信用户信息信息】数据，返回实体对象========================#");
		if(params.containsKey("id")) {
		return wxUserMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询【企业微信用户信息信息】一条，Map参数中 id不能为空========================#");
	 return null;
		}
	}
   
	
	   /**
     * 根据登录用户名得到用户信息放到实体中
     * 从单点登录进入到系统中，不再判断用户名称密码
     * 
     *
     */ 
    public WxUser selectWxUserByName(Map<String, Object> params) {
		return wxUserMapper.selectWxUser(params);  
	}
    /**
     * 
     * 验证用户的有效性
     * 
     *
     */ 

	public WxUser verifyWxLogin(Map<String, Object> userInfo) {
		return selectWxUserByName(userInfo);
	}
	
	
	public String getWxProjectGroupId(Map<String, Object> userInfo) {
	String userProjectGroupId="";	
	 List<CommonEntity> list =  wxUserMapper.getWxUserGroup(userInfo.get("username").toString());
	 if(list.size() !=0) {
		Map<String, Object> mpGroupName = (Map<String, Object>) list.get(0);
		userProjectGroupId = mpGroupName.get("group_id").toString();
	 }else {
		 userProjectGroupId="wx_user_group_not_define";
	 }
     return userProjectGroupId;
	}

	public WxUser queryOneWxUser(Map<String, Object> params) {
		return wxUserMapper.queryOneWxUser(params);
	}	

    
    
    
    
    
}