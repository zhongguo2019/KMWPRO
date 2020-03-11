package com.kmw.qywx.service;

import com.kmw.qywx.domain.QywxUserOperatelog;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 保留用户每次提交的消息内容Service接口
 * 
 * @author kmw
 * @date 2020-03-04
 */
public interface IQywxUserOperatelogService 
{
    /**
     * 查询保留用户每次提交的消息内容
     * 
     * @param id 保留用户每次提交的消息内容ID
     * @return 保留用户每次提交的消息内容
     */
    public QywxUserOperatelog selectQywxUserOperatelogById(String id);

    /**
     * 查询保留用户每次提交的消息内容列表
     * 
     * @param qywxUserOperatelog 保留用户每次提交的消息内容
     * @return 保留用户每次提交的消息内容集合
     */
    public List<QywxUserOperatelog> selectQywxUserOperatelogList(QywxUserOperatelog qywxUserOperatelog);

    /**
     * 新增保留用户每次提交的消息内容
     * 
     * @param qywxUserOperatelog 保留用户每次提交的消息内容
     * @return 结果
     */
    public int insertQywxUserOperatelog(QywxUserOperatelog qywxUserOperatelog);

    /**
     * 修改保留用户每次提交的消息内容
     * 
     * @param qywxUserOperatelog 保留用户每次提交的消息内容
     * @return 结果
     */
    public int updateQywxUserOperatelog(QywxUserOperatelog qywxUserOperatelog);

    /**
     * 批量删除保留用户每次提交的消息内容
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQywxUserOperatelogByIds(String ids);

    /**
     * 删除保留用户每次提交的消息内容信息
     * 
     * @param id 保留用户每次提交的消息内容ID
     * @return 结果
     */
    public int deleteQywxUserOperatelogById(String id);
    
    /**
	 * 分页展示(可带条件查询) 保留用户每次提交的消息内容
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return
	 */
 	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  保留用户每次提交的消息内容
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param Map<String, Object> params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params);

	/**
	 * 根据不同条件查询一条数据 保留用户每次提交的消息内容
	 * @param Map<String, Object> params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);

	/**
	 * 根据map查询得到实体数据列表 保留用户每次提交的消息内容
	 * @param Map<String, Object> params
	 * @return List<QywxUserOperatelog> 
	 */
	public List<QywxUserOperatelog> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 保留用户每次提交的消息内容
	 * @param Map<String, Object> params
	 * @return int
	 */
	public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量保存操作 List<QywxUserOperatelog>
	 * @param list
	 * @return
	 */
	public int insertBatch(List<QywxUserOperatelog> list);

  	/**
	 * 更新操作
	 * @param List<QywxUserOperatelog>
	 * @return
	 */
	public int updateBatch(List<QywxUserOperatelog> list);
    
}
