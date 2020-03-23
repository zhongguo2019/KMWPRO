package com.kmw.etlsqlparase.mapper;

import com.kmw.etlsqlparase.domain.SysFileInfo;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 文件信息Mapper接口
 * 
 * @author kmw
 * @date 2020-03-14
 */
public interface SysFileInfoMapper 
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
     * 删除文件信息
     * 
     * @param id 文件信息ID
     * @return 结果
     */
    public int deleteSysFileInfoById(String id);

    /**
     * 批量删除文件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFileInfoByIds(String[] ids);
    
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
	public int insertBatch(List<SysFileInfo> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<SysFileInfo> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	public int updateBatchEntity( List<SysFileInfo> list);	
	
		/**
	 * 删除所有表里数据
	 */
	 public int deleteSysFileInfoAll();
}
