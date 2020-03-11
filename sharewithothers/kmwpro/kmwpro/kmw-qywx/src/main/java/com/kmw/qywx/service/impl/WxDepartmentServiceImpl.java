package com.kmw.qywx.service.impl;

import java.util.List;
import java.util.Map;


import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.qywx.mapper.WxDepartmentMapper;
import com.kmw.qywx.domain.WxDepartment;
import com.kmw.qywx.service.IWxDepartmentService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 企业微信部门信息Service业务层处理
 * 
 * @author kmw
 * @date 2020-03-07
 */
@Service
public class WxDepartmentServiceImpl implements IWxDepartmentService 
{
    @Autowired
    private WxDepartmentMapper wxDepartmentMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询企业微信部门信息
     * 
     * @param departId 企业微信部门信息ID
     * @return 企业微信部门信息
     */
    @Override
    public WxDepartment selectWxDepartmentById(String departId)
    {
        return wxDepartmentMapper.selectWxDepartmentById(departId);
    }

    /**
     * 查询企业微信部门信息列表
     * 
     * @param wxDepartment 企业微信部门信息
     * @return 企业微信部门信息
     */
    @Override
    public List<WxDepartment> selectWxDepartmentList(WxDepartment wxDepartment)
    {
        return wxDepartmentMapper.selectWxDepartmentList(wxDepartment);
    }

    /**
     * 新增企业微信部门信息
     * 
     * @param wxDepartment 企业微信部门信息
     * @return 结果
     */
    @Override
    public int insertWxDepartment(WxDepartment wxDepartment)
    {
        wxDepartment.setCreateTime(DateUtils.getNowDate());
        return wxDepartmentMapper.insertWxDepartment(wxDepartment);
    }

    /**
     * 修改企业微信部门信息
     * 
     * @param wxDepartment 企业微信部门信息
     * @return 结果
     */
    @Override
    public int updateWxDepartment(WxDepartment wxDepartment)
    {
        wxDepartment.setUpdateTime(DateUtils.getNowDate());
        return wxDepartmentMapper.updateWxDepartment(wxDepartment);
    }

    /**
     * 删除企业微信部门信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxDepartmentByIds(String ids)
    {
        return wxDepartmentMapper.deleteWxDepartmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业微信部门信息信息
     * 
     * @param departId 企业微信部门信息ID
     * @return 结果
     */
    @Override
    public int deleteWxDepartmentById(String departId)
    {
        return wxDepartmentMapper.deleteWxDepartmentById(departId);
    }
    
	/**
	 * 分页展示(可带条件查询) 企业微信部门信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【企业微信部门信息】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = wxDepartmentMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = wxDepartmentMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 企业微信部门信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【企业微信部门信息】列表数据，返回通用对象========================#");
		List<CommonEntity> list = wxDepartmentMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 企业微信部门信息信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【企业微信部门信息】数据，返回实体对象========================#");
		if(params.containsKey("departId")) {
		return wxDepartmentMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询【企业微信部门信息】一条，Map参数中 id不能为空========================#");
	 return null;
		}
	}
        
  	/**
	 * 更新操作
	 * @param WxDepartment
	 * @return
	 */
	public int updateBatch(List<WxDepartment> list){
		logger.info("#=================开始传入的实体列表更新【企业微信部门信息】数据========================#");
		return wxDepartmentMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【企业微信部门信息】数据========================#");
		return  wxDepartmentMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<WxDepartment> list){
		return  wxDepartmentMapper.insertBatch(list);
	}
    /**
	 * 删除表中所有数据
	 *  
	 * @return int
	 */
	public int deleteAll(){
		logger.info("#=================删除表【企业微信部门信息】所有数据========================#");
		return  wxDepartmentMapper.deleteWxDepartmentAll();
	}
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<wxDepartment>
	 */
	public List<WxDepartment> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【企业微信部门信息】列表数据，返回通用对象========================#");
		List<WxDepartment> list =  wxDepartmentMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
