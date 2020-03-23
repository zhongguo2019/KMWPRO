package com.kmw.qywx.mapper;

import com.kmw.qywx.domain.KrmEmployees;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 员工信息KRMMapper接口
 * 
 * @author kmw
 * @date 2020-03-20
 */
public interface KrmEmployeesMapper 
{
    /**
     * 查询员工信息KRM
     * 
     * @param id 员工信息KRMID
     * @return 员工信息KRM
     */
    public KrmEmployees selectKrmEmployeesById(String id);

    /**
     * 查询员工信息KRM列表
     * 
     * @param krmEmployees 员工信息KRM
     * @return 员工信息KRM集合
     */
    public List<KrmEmployees> selectKrmEmployeesList(KrmEmployees krmEmployees);

    /**
     * 新增员工信息KRM
     * 
     * @param krmEmployees 员工信息KRM
     * @return 结果
     */
    public int insertKrmEmployees(KrmEmployees krmEmployees);

    /**
     * 修改员工信息KRM
     * 
     * @param krmEmployees 员工信息KRM
     * @return 结果
     */
    public int updateKrmEmployees(KrmEmployees krmEmployees);

    /**
     * 删除员工信息KRM
     * 
     * @param id 员工信息KRMID
     * @return 结果
     */
    public int deleteKrmEmployeesById(String id);

    /**
     * 批量删除员工信息KRM
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteKrmEmployeesByIds(String[] ids);
    
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
	public int insertBatch(List<KrmEmployees> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<KrmEmployees> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	public int updateBatchEntity( List<KrmEmployees> list);	
	
		/**
	 * 删除所有表里数据
	 */
	 public int deleteKrmEmployeesAll();
}
