package com.kmw.qywx.service;

import com.kmw.qywx.domain.WxUserGroupRelation;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 分组信息与用户对应关系Service接口
 * 
 * @author kmw
 * @date 2020-02-27
 */
public interface IWxUserGroupRelationService 
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
     * 批量删除分组信息与用户对应关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserGroupRelationByIds(String ids);

    /**
     * 删除分组信息与用户对应关系信息
     * 
     * @param id 分组信息与用户对应关系ID
     * @return 结果
     */
    public int deleteWxUserGroupRelationById(String id);
    
    /**
	 * 分页展示(可带条件查询) 分组信息与用户对应关系
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  分组信息与用户对应关系
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 分组信息与用户对应关系
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 分组信息与用户对应关系
	 * @param Map<String, Object> params
	 * @return List<WxUserGroupRelation> 
	 */
	public List<WxUserGroupRelation> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 分组信息与用户对应关系
	 * @param Map<String, Object> params
	 * @return int
	 */
	public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量保存操作 List<WxUserGroupRelation>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<WxUserGroupRelation> list);

  	/**
	 * 更新操作
	 * @param List<WxUserGroupRelation>
	 * @return
	 */
	public int updateBatch(List<WxUserGroupRelation> list);
    
}
