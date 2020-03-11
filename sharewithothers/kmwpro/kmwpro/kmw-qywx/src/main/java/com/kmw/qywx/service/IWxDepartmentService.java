package com.kmw.qywx.service;

import com.kmw.qywx.domain.WxDepartment;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 企业微信部门信息Service接口
 * 
 * @author kmw
 * @date 2020-03-07
 */
public interface IWxDepartmentService 
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
     * 批量删除企业微信部门信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxDepartmentByIds(String ids);

    /**
     * 删除企业微信部门信息信息
     * 
     * @param departId 企业微信部门信息ID
     * @return 结果
     */
    public int deleteWxDepartmentById(String departId);
    
    /**
	 * 分页展示(可带条件查询) 企业微信部门信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  企业微信部门信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 企业微信部门信息
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 企业微信部门信息
	 * @param Map<String, Object> params
	 * @return List<WxDepartment> 
	 */
	public List<WxDepartment> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 企业微信部门信息
	 * @param Map<String, Object> params
	 * @return int
	 */
	public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 
	 * 删除表中所有数据
	 * @return int
	 */
	public int deleteAll();
	
	/**
	 * 批量保存操作 List<WxDepartment>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<WxDepartment> list);

  	/**
	 * 更新操作
	 * @param List<WxDepartment>
	 * @return
	 */
	public int updateBatch(List<WxDepartment> list);
    
}
