package com.kmw.qywx.mapper;

import com.kmw.qywx.domain.QywxUserOperatelog;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 保留用户每次提交的消息内容Mapper接口
 * 
 * @author kmw
 * @date 2020-03-04
 */
public interface QywxUserOperatelogMapper 
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
     * 删除保留用户每次提交的消息内容
     * 
     * @param id 保留用户每次提交的消息内容ID
     * @return 结果
     */
    public int deleteQywxUserOperatelogById(String id);

    /**
     * 批量删除保留用户每次提交的消息内容
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQywxUserOperatelogByIds(String[] ids);
    
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
	public int insertBatch(List<QywxUserOperatelog> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	public List<QywxUserOperatelog> entityList(Map<String, Object> params);
	
	/**
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量更新
	 */
	int updateBatchEntity( List<QywxUserOperatelog> list);	
}
