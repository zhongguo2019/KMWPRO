package com.kmw.qywx.service;

import com.kmw.qywx.domain.KrmEmployees;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 员工信息KRMService接口
 * 
 * @author kmw
 * @date 2020-03-20
 */
public interface IKrmEmployeesService 
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
     * 批量删除员工信息KRM
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteKrmEmployeesByIds(String ids);

    /**
     * 删除员工信息KRM信息
     * 
     * @param id 员工信息KRMID
     * @return 结果
     */
    public int deleteKrmEmployeesById(String id);
    
    /**
	 * 分页展示(可带条件查询) 员工信息KRM
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  员工信息KRM
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 员工信息KRM
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 员工信息KRM
	 * @param Map<String, Object> params
	 * @return List<KrmEmployees> 
	 */
	public List<KrmEmployees> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 员工信息KRM
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
	 * 批量保存操作 List<KrmEmployees>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<KrmEmployees> list);

  	/**
	 * 更新操作
	 * @param List<KrmEmployees>
	 * @return
	 */
	public int updateBatch(List<KrmEmployees> list);
	/**
	 * 导入员工信息
	 * 
	 * @param userList        用户数据列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param operName        操作用户
	 * @return 结果
	 */
	
	public String importKrmEmployees(List<KrmEmployees> krmEmployeesList, Boolean isUpdateSupport, String operName);
}
