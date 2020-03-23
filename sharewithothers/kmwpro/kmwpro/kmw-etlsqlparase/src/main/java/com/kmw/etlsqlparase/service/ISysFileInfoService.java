package com.kmw.etlsqlparase.service;

import com.kmw.etlsqlparase.domain.SysFileInfo;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 文件信息Service接口
 * 
 * @author kmw
 * @date 2020-03-14
 */
public interface ISysFileInfoService 
{
    /**
     * 查询文件信息
     * 
     * @param id 文件信息ID
     * @return 文件信息
     */
    public SysFileInfo selectSysFileInfoById(String id);

    /**
     * 查询文件信息列表
     * 
     * @param sysFileInfo 文件信息
     * @return 文件信息集合
     */
    public List<SysFileInfo> selectSysFileInfoList(SysFileInfo sysFileInfo);

    /**
     * 新增文件信息
     * 
     * @param sysFileInfo 文件信息
     * @return 结果
     */
    public int insertSysFileInfo(SysFileInfo sysFileInfo);

    /**
     * 修改文件信息
     * 
     * @param sysFileInfo 文件信息
     * @return 结果
     */
    public int updateSysFileInfo(SysFileInfo sysFileInfo);

    /**
     * 批量删除文件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFileInfoByIds(String ids);

    /**
     * 删除文件信息信息
     * 
     * @param id 文件信息ID
     * @return 结果
     */
    public int deleteSysFileInfoById(String id);
    
    /**
	 * 分页展示(可带条件查询) 文件信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  文件信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 文件信息
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 文件信息
	 * @param Map<String, Object> params
	 * @return List<SysFileInfo> 
	 */
	public List<SysFileInfo> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 文件信息
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
	 * 批量保存操作 List<SysFileInfo>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<SysFileInfo> list);

  	/**
	 * 更新操作
	 * @param List<SysFileInfo>
	 * @return
	 */
	public int updateBatch(List<SysFileInfo> list);
    
}
