package com.kmw.etlsqlparase.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.etlsqlparase.mapper.SysFileInfoMapper;
import com.kmw.etlsqlparase.domain.SysFileInfo;
import com.kmw.etlsqlparase.service.ISysFileInfoService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 文件信息Service业务层处理
 * 
 * @author kmw
 * @date 2020-03-14
 */
@Service
public class SysFileInfoServiceImpl implements ISysFileInfoService 
{
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询文件信息
     * 
     * @param id 文件信息ID
     * @return 文件信息
     */
    @Override
    public SysFileInfo selectSysFileInfoById(String id)
    {
        return sysFileInfoMapper.selectSysFileInfoById(id);
    }

    /**
     * 查询文件信息列表
     * 
     * @param sysFileInfo 文件信息
     * @return 文件信息
     */
    @Override
    public List<SysFileInfo> selectSysFileInfoList(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.selectSysFileInfoList(sysFileInfo);
    }

    /**
     * 新增文件信息
     * 
     * @param sysFileInfo 文件信息
     * @return 结果
     */
    @Override
    public int insertSysFileInfo(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.insertSysFileInfo(sysFileInfo);
    }

    /**
     * 修改文件信息
     * 
     * @param sysFileInfo 文件信息
     * @return 结果
     */
    @Override
    public int updateSysFileInfo(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.updateSysFileInfo(sysFileInfo);
    }

    /**
     * 删除文件信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysFileInfoByIds(String ids)
    {
        return sysFileInfoMapper.deleteSysFileInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文件信息信息
     * 
     * @param id 文件信息ID
     * @return 结果
     */
    @Override
    public int deleteSysFileInfoById(String id)
    {
        return sysFileInfoMapper.deleteSysFileInfoById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 文件信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【文件信息】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = sysFileInfoMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = sysFileInfoMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 文件信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【文件信息】列表数据，返回通用对象========================#");
		List<CommonEntity> list = sysFileInfoMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 文件信息信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【文件信息】数据，返回实体对象========================#");
	
		return sysFileInfoMapper.queryOneCommon(params);

	}
        
  	/**
	 * 更新操作
	 * @param SysFileInfo
	 * @return
	 */
	public int updateBatch(List<SysFileInfo> list){
		logger.info("#=================开始传入的实体列表更新【文件信息】数据========================#");
		return sysFileInfoMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【文件信息】数据========================#");
		return  sysFileInfoMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<SysFileInfo> list){
		return  sysFileInfoMapper.insertBatch(list);
	}
    /**
	 * 删除表中所有数据
	 *  
	 * @return int
	 */
	public int deleteAll(){
		logger.info("#=================删除表【文件信息】所有数据========================#");
		return  sysFileInfoMapper.deleteSysFileInfoAll();
	}
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<sysFileInfo>
	 */
	public List<SysFileInfo> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【文件信息】列表数据，返回通用对象========================#");
		List<SysFileInfo> list =  sysFileInfoMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
