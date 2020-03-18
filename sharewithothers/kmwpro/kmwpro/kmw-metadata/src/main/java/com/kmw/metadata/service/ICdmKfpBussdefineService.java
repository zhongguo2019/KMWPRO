package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmKfpBussdefine;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 银行束语定义集Service接口
 * 
 * @author kmw
 * @date 2020-03-13
 */
public interface ICdmKfpBussdefineService 
{
    /**
     * 查询银行束语定义集
     * 
     * @param id 银行束语定义集ID
     * @return 银行束语定义集
     */
    public CdmKfpBussdefine selectCdmKfpBussdefineById(String id);

    /**
     * 查询银行束语定义集列表
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 银行束语定义集集合
     */
    public List<CdmKfpBussdefine> selectCdmKfpBussdefineList(CdmKfpBussdefine cdmKfpBussdefine);

    /**
     * 新增银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    public int insertCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine);

    /**
     * 修改银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    public int updateCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine);

    /**
     * 批量删除银行束语定义集
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmKfpBussdefineByIds(String ids);

    /**
     * 删除银行束语定义集信息
     * 
     * @param id 银行束语定义集ID
     * @return 结果
     */
    public int deleteCdmKfpBussdefineById(String id);
    
    /**
	 * 分页展示(可带条件查询) 银行束语定义集
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  银行束语定义集
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 银行束语定义集
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 银行束语定义集
	 * @param Map<String, Object> params
	 * @return List<CdmKfpBussdefine> 
	 */
	public List<CdmKfpBussdefine> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 银行束语定义集
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
	 * 批量保存操作 List<CdmKfpBussdefine>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<CdmKfpBussdefine> list);

  	/**
	 * 更新操作
	 * @param List<CdmKfpBussdefine>
	 * @return
	 */
	public int updateBatch(List<CdmKfpBussdefine> list);
    
}
