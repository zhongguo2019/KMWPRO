package com.kmw.qywx.mapper;

import com.kmw.qywx.domain.WxUserGroup;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 微信用户分组信息Mapper接口
 * 
 * @author kmw
 * @date 2020-02-20
 */
public interface WxUserGroupMapper 
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
     * 删除微信用户分组信息
     * 
     * @param id 微信用户分组信息ID
     * @return 结果
     */
    public int deleteWxUserGroupById(String id);

    /**
     * 批量删除微信用户分组信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserGroupByIds(String[] ids);
    
    /**
     * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
     * 
     * @param Map<String, Object> params  查询条件以map形式
     * @return 结果
     */
    public List<CommonEntity> queryPageInfo(Map<String, Object> params);
        /**
     * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
     * 
     * @param Map<String, Object> params  查询条件以map形式
     * @return 结果
     */
    public List<CommonEntity> queryEntityList(Map<String, Object> params);
        /**
     * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
     * 
     * @param Map<String, Object> params  查询条件以map形式
     * @return 结果
     */
  public CommonEntity queryOneCommon(Map<String, Object> params);
    /**
 * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
 * 
 * @param Map<String, Object> params  查询条件以map形式
 * @return 结果
 */
public List<WxUserGroup> entityList(Map<String, Object> params);
}
