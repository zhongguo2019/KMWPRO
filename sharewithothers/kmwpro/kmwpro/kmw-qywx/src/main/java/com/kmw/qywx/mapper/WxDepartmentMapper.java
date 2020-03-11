package com.kmw.qywx.mapper;

import com.kmw.qywx.domain.WxDepartment;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 企业微信部门信息Mapper接口
 * 
 * @author kmw
 * @date 2020-03-07
 */
public interface WxDepartmentMapper 
{
    /**
     * 查询企业微信部门信息
     * 
     * @param departId 企业微信部门信息ID
     * @return 企业微信部门信息
     */
    public WxDepartment selectWxDepartmentById(String departId);

    /**
     * 查询企业微信部门信息列表
     * 
     * @param wxDepartment 企业微信部门信息
     * @return 企业微信部门信息集合
     */
    public List<WxDepartment> selectWxDepartmentList(WxDepartment wxDepartment);

    /**
     * 新增企业微信部门信息
     * 
     * @param wxDepartment 企业微信部门信息
     * @return 结果
     */
    public int insertWxDepartment(WxDepartment wxDepartment);

    /**
     * 修改企业微信部门信息
     * 
     * @param wxDepartment 企业微信部门信息
     * @return 结果
     */
    public int updateWxDepartment(WxDepartment wxDepartment);

    /**
     * 删除企业微信部门信息
     * 
     * @param departId 企业微信部门信息ID
     * @return 结果
     */
    public int deleteWxDepartmentById(String departId);

    /**
     * 批量删除企业微信部门信息
     * 
     * @param departIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxDepartmentByIds(String[] departIds);
    
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
	public int insertBatch(List<WxDepartment> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<WxDepartment> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	public int updateBatchEntity( List<WxDepartment> list);	
	
		/**
	 * 删除所有表里数据
	 */
	 public int deleteWxDepartmentAll();
}
