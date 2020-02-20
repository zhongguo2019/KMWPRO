package com.kmw.qywx.service;

import com.kmw.qywx.domain.WxUser;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 企业微信用户信息Service接口
 * 
 * @author kmw
 * @date 2020-02-20
 */
public interface IWxUserService 
{
    /**
     * 查询企业微信用户信息
     * 
     * @param name 企业微信用户信息ID
     * @return 企业微信用户信息
     */
    public WxUser selectWxUserById(String name);

    /**
     * 查询企业微信用户信息列表
     * 
     * @param wxUser 企业微信用户信息
     * @return 企业微信用户信息集合
     */
    public List<WxUser> selectWxUserList(WxUser wxUser);

    /**
     * 新增企业微信用户信息
     * 
     * @param wxUser 企业微信用户信息
     * @return 结果
     */
    public int insertWxUser(WxUser wxUser);

    /**
     * 修改企业微信用户信息
     * 
     * @param wxUser 企业微信用户信息
     * @return 结果
     */
    public int updateWxUser(WxUser wxUser);

    /**
     * 批量删除企业微信用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserByIds(String ids);

    /**
     * 删除企业微信用户信息信息
     * 
     * @param name 企业微信用户信息ID
     * @return 结果
     */
    public int deleteWxUserById(String name);
    
    /**
	 * 分页展示(可带条件查询) 企业微信用户信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
    
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  企业微信用户信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	
	public List<CommonEntity> commonList(Map<String, Object> params);
	
	/**
	 * 根据不同条件查询一条数据 企业微信用户信息
	 * @param params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	
	public WxUser verifyWxLogin(Map<String, Object> userInfo);
    public WxUser selectWxUserByName(Map<String, Object> params);
	public String getWxProjectGroupId(Map<String, Object> userInfo);
	public WxUser queryOneWxUser(Map<String, Object> params);
    
}
