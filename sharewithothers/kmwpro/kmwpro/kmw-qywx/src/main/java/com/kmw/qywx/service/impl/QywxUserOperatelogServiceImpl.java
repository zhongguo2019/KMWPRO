package com.kmw.qywx.service.impl;

import java.util.List;
import java.util.Map;


import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.qywx.mapper.QywxUserOperatelogMapper;
import com.kmw.qywx.domain.QywxUserOperatelog;
import com.kmw.qywx.service.IQywxUserOperatelogService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 保留用户每次提交的消息内容Service业务层处理
 * 
 * @author kmw
 * @date 2020-03-04
 */
@Service
public class QywxUserOperatelogServiceImpl implements IQywxUserOperatelogService 
{
    @Autowired
    private QywxUserOperatelogMapper qywxUserOperatelogMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 查询保留用户每次提交的消息内容
     * 
     * @param id 保留用户每次提交的消息内容ID
     * @return 保留用户每次提交的消息内容
     */
    @Override
    public QywxUserOperatelog selectQywxUserOperatelogById(String id)
    {
        return qywxUserOperatelogMapper.selectQywxUserOperatelogById(id);
    }

    /**
     * 查询保留用户每次提交的消息内容列表
     * 
     * @param qywxUserOperatelog 保留用户每次提交的消息内容
     * @return 保留用户每次提交的消息内容
     */
    @Override
    public List<QywxUserOperatelog> selectQywxUserOperatelogList(QywxUserOperatelog qywxUserOperatelog)
    {
        return qywxUserOperatelogMapper.selectQywxUserOperatelogList(qywxUserOperatelog);
    }

    /**
     * 新增保留用户每次提交的消息内容
     * 
     * @param qywxUserOperatelog 保留用户每次提交的消息内容
     * @return 结果
     */
    @Override
    public int insertQywxUserOperatelog(QywxUserOperatelog qywxUserOperatelog)
    {
        qywxUserOperatelog.setCreateTime(DateUtils.getNowDate());
        return qywxUserOperatelogMapper.insertQywxUserOperatelog(qywxUserOperatelog);
    }

    /**
     * 修改保留用户每次提交的消息内容
     * 
     * @param qywxUserOperatelog 保留用户每次提交的消息内容
     * @return 结果
     */
    @Override
    public int updateQywxUserOperatelog(QywxUserOperatelog qywxUserOperatelog)
    {
        qywxUserOperatelog.setUpdateTime(DateUtils.getNowDate());
        return qywxUserOperatelogMapper.updateQywxUserOperatelog(qywxUserOperatelog);
    }

    /**
     * 删除保留用户每次提交的消息内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteQywxUserOperatelogByIds(String ids)
    {
        return qywxUserOperatelogMapper.deleteQywxUserOperatelogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除保留用户每次提交的消息内容信息
     * 
     * @param id 保留用户每次提交的消息内容ID
     * @return 结果
     */
    @Override
    public int deleteQywxUserOperatelogById(String id)
    {
        return qywxUserOperatelogMapper.deleteQywxUserOperatelogById(id);
    }
    
	/**
	 * 分页展示(可带条件查询) 保留用户每次提交的消息内容信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【保留用户每次提交的消息内容】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = qywxUserOperatelogMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = qywxUserOperatelogMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询) 保留用户每次提交的消息内容信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【保留用户每次提交的消息内容】列表数据，返回通用对象========================#");
		List<CommonEntity> list = qywxUserOperatelogMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 保留用户每次提交的消息内容信息
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【保留用户每次提交的消息内容】数据，返回实体对象========================#");
		if(params.containsKey("id")) {
		return qywxUserOperatelogMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询【保留用户每次提交的消息内容】一条，Map参数中 id不能为空========================#");
	 return null;
		}
	}
        
  	/**
	 * 更新操作
	 * @param QywxUserOperatelog
	 * @return
	 */
	public int updateBatch(List<QywxUserOperatelog> list){
		logger.info("#=================开始传入的实体列表更新【保留用户每次提交的消息内容】数据========================#");
		return qywxUserOperatelogMapper.updateBatchEntity(list);
	}	  
    
   
	/**
	 * 根据不同组合条件删除
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params){
		logger.info("#=================开始根据不同条件删除【保留用户每次提交的消息内容】数据========================#");
		return  qywxUserOperatelogMapper.deleteByParams(params);
	}
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<QywxUserOperatelog> list){
		return  qywxUserOperatelogMapper.insertBatch(list);
	}
    
	/**
	 * 列表(可带条件查询) 当天工作记录信息信息
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<qywxUserOperatelog>
	 */
	public List<QywxUserOperatelog> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【保留用户每次提交的消息内容】列表数据，返回通用对象========================#");
		List<QywxUserOperatelog> list =  qywxUserOperatelogMapper.entityList(params);
		return list;
	}
	 
    
    
    
}
