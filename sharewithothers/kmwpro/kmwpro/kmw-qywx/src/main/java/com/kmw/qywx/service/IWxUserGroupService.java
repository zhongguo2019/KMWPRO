package com.kmw.qywx.service;

import com.kmw.qywx.domain.WxUserGroup;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 微信用户分组信息Service接口
 * 
 * @author kmw
 * @date 2020-02-20
 */
public interface IWxUserGroupService 
{
    /**
     * 查询微信用户分组信息
     * 
     * @param id 微信用户分组信息ID
     * @return 微信用户分组信息
     */
    public WxUserGroup selectWxUserGroupById(String id);

    /**
     * 查询微信用户分组信息列表
     * 
     * @param wxUserGroup 微信用户分组信息
     * @return 微信用户分组信息集合
     */
    public List<WxUserGroup> selectWxUserGroupList(WxUserGroup wxUserGroup);

    /**
     * 新增微信用户分组信息
     * 
     * @param wxUserGroup 微信用户分组信息
     * @return 结果
     */
    public int insertWxUserGroup(WxUserGroup wxUserGroup);

    /**
     * 修改微信用户分组信息
     * 
     * @param wxUserGroup 微信用户分组信息
     * @return 结果
     */
    public int updateWxUserGroup(WxUserGroup wxUserGroup);

    /**
     * 批量删除微信用户分组信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserGroupByIds(String ids);

    /**
     * 删除微信用户分组信息信息
     * 
     * @param id 微信用户分组信息ID
     * @return 结果
     */
    public int deleteWxUserGroupById(String id);
    
    /**
	 * 分页展示(可带条件查询) 微信用户分组信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
    
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  微信用户分组信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	
	public List<CommonEntity> commonList(Map<String, Object> params);
	
	/**
	 * 根据不同条件查询一条数据 微信用户分组信息
	 * @param params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	public List<WxUserGroup> entityList(Map<String, Object> params);
}
