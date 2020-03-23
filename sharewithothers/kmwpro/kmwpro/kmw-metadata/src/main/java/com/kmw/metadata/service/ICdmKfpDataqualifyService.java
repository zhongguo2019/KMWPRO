package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmKfpDataqualify;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 数据质量检核配置Service接口
 * 
 * @author kmw
 * @date 2020-03-13
 */
public interface ICdmKfpDataqualifyService 
{
    /**
     * 查询数据质量检核配置
     * 
     * @param id 数据质量检核配置ID
     * @return 数据质量检核配置
     */
    public CdmKfpDataqualify selectCdmKfpDataqualifyById(String id);

    /**
     * 查询数据质量检核配置列表
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 数据质量检核配置集合
     */
    public List<CdmKfpDataqualify> selectCdmKfpDataqualifyList(CdmKfpDataqualify cdmKfpDataqualify);

    /**
     * 新增数据质量检核配置
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 结果
     */
    public int insertCdmKfpDataqualify(CdmKfpDataqualify cdmKfpDataqualify);

    /**
     * 修改数据质量检核配置
     * 
     * @param cdmKfpDataqualify 数据质量检核配置
     * @return 结果
     */
    public int updateCdmKfpDataqualify(CdmKfpDataqualify cdmKfpDataqualify);

    /**
     * 批量删除数据质量检核配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmKfpDataqualifyByIds(String ids);

    /**
     * 删除数据质量检核配置信息
     * 
     * @param id 数据质量检核配置ID
     * @return 结果
     */
    public int deleteCdmKfpDataqualifyById(String id);
    
    /**
	 * 分页展示(可带条件查询) 数据质量检核配置
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  数据质量检核配置
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 数据质量检核配置
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 数据质量检核配置
	 * @param Map<String, Object> params
	 * @return List<CdmKfpDataqualify> 
	 */
	public List<CdmKfpDataqualify> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 数据质量检核配置
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
	 * 批量保存操作 List<CdmKfpDataqualify>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<CdmKfpDataqualify> list);

  	/**
	 * 更新操作
	 * @param List<CdmKfpDataqualify>
	 * @return
	 */
	public int updateBatch(List<CdmKfpDataqualify> list);
    
}
