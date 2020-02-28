package com.kmw.qywx.mapper;

import com.kmw.qywx.domain.WxUserGroupRelation;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 分组信息与用户对应关系Mapper接口
 * 
 * @author kmw
 * @date 2020-02-27
 */
public interface WxUserGroupRelationMapper 
{
    /**
     * 查询分组信息与用户对应关系
     * 
     * @param id 分组信息与用户对应关系ID
     * @return 分组信息与用户对应关系
     */
    public WxUserGroupRelation selectWxUserGroupRelationById(String id);

    /**
     * 查询分组信息与用户对应关系列表
     * 
     * @param wxUserGroupRelation 分组信息与用户对应关系
     * @return 分组信息与用户对应关系集合
     */
    public List<WxUserGroupRelation> selectWxUserGroupRelationList(WxUserGroupRelation wxUserGroupRelation);

    /**
     * 新增分组信息与用户对应关系
     * 
     * @param wxUserGroupRelation 分组信息与用户对应关系
     * @return 结果
     */
    public int insertWxUserGroupRelation(WxUserGroupRelation wxUserGroupRelation);

    /**
     * 修改分组信息与用户对应关系
     * 
     * @param wxUserGroupRelation 分组信息与用户对应关系
     * @return 结果
     */
    public int updateWxUserGroupRelation(WxUserGroupRelation wxUserGroupRelation);

    /**
     * 删除分组信息与用户对应关系
     * 
     * @param id 分组信息与用户对应关系ID
     * @return 结果
     */
    public int deleteWxUserGroupRelationById(String id);

    /**
     * 批量删除分组信息与用户对应关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserGroupRelationByIds(String[] ids);
    
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
	 * 批量插入数据
	 */
	public int insertBatch(List<WxUserGroupRelation> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<WxUserGroupRelation> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	int updateBatchEntity( List<WxUserGroupRelation> list);	
}
