package com.kmw.qywx.mapper;

import com.kmw.qywx.domain.WxUser;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 企业微信用户信息Mapper接口
 * 
 * @author kmw
 * @date 2020-02-20
 */
public interface WxUserMapper 
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
     * 删除企业微信用户信息
     * 
     * @param name 企业微信用户信息ID
     * @return 结果
     */
    public int deleteWxUserById(String name);

    /**
     * 批量删除企业微信用户信息
     * 
     * @param names 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserByIds(String[] names);
    
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
    
    
    public WxUser selectWxUser(Map<String, Object> params);    
    public List<CommonEntity>   getWxUserGroup(  @Param("username")  String username  );
    public WxUser queryOneWxUser(Map<String, Object> params);
    public WxUser queryOneWxUserByName(Map<String, Object> params);

}
