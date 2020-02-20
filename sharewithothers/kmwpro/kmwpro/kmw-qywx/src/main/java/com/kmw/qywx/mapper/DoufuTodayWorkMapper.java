package com.kmw.qywx.mapper;

import com.kmw.qywx.domain.DoufuTodayWork;
import com.kmw.common.CommonEntity;
import java.util.List;
import java.util.Map;

/**
 * 当天工作记录信息Mapper接口
 * 
 * @author kmw
 * @date 2020-02-20
 */
public interface DoufuTodayWorkMapper 
{
    /**
     * 查询当天工作记录信息
     * 
     * @param id 当天工作记录信息ID
     * @return 当天工作记录信息
     */
    public DoufuTodayWork selectDoufuTodayWorkById(String id);

    /**
     * 查询当天工作记录信息列表
     * 
     * @param doufuTodayWork 当天工作记录信息
     * @return 当天工作记录信息集合
     */
    public List<DoufuTodayWork> selectDoufuTodayWorkList(DoufuTodayWork doufuTodayWork);

    /**
     * 新增当天工作记录信息
     * 
     * @param doufuTodayWork 当天工作记录信息
     * @return 结果
     */
    public int insertDoufuTodayWork(DoufuTodayWork doufuTodayWork);

    /**
     * 修改当天工作记录信息
     * 
     * @param doufuTodayWork 当天工作记录信息
     * @return 结果
     */
    public int updateDoufuTodayWork(DoufuTodayWork doufuTodayWork);

    /**
     * 删除当天工作记录信息
     * 
     * @param id 当天工作记录信息ID
     * @return 结果
     */
    public int deleteDoufuTodayWorkById(String id);

    /**
     * 批量删除当天工作记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDoufuTodayWorkByIds(String[] ids);
    
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
	 * 根据不同条件删除数据，条件可组合
	 */
    public int deleteByParams(Map<String, Object> params);
	/**
	 * 批量插入数据
	 */
	int insertBatch(List<DoufuTodayWork> list);
	
	/**
	 * 列表查询,返回的是实体
	 */
	List<DoufuTodayWork> entityList(Map<String, Object> params);
	
	/**
	 * 查询未提交的用户名称
	 */
	List<CommonEntity>  queryNotCommitUser(Map<String, Object> params);
	
	
	/**
	 * 查询指定时间段内指定的用户的提交日期列表
	 */
	List<CommonEntity>  countCommitTimes(Map<String, Object> params);
	
	/**
	 * 按月统计人员的提交日期次数
	 */	
	List<CommonEntity>  countMonthCommitTimes(Map<String, Object> params);
	
	/**
	 * 得到指定的人员的提交过日报的日期列表
	 */	
	List<CommonEntity>  getReportDateList(Map<String, Object> params);
}
