package com.kmw.qywx.service;

import com.kmw.qywx.domain.DoufuTodayWork;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;


/**
 * 当天工作记录信息Service接口
 * 
 * @author kmw
 * @date 2020-02-20
 */
public interface IDoufuTodayWorkService 
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
     * 批量删除当天工作记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDoufuTodayWorkByIds(String ids);

    /**
     * 删除当天工作记录信息信息
     * 
     * @param id 当天工作记录信息ID
     * @return 结果
     */
    public int deleteDoufuTodayWorkById(String id);
    
    /**
	 * 分页展示(可带条件查询) 当天工作记录信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
    
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)  当天工作记录信息
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	
	public List<CommonEntity> commonList(Map<String, Object> params);
	
	/**
	 * 根据不同条件查询一条数据 当天工作记录信息
	 * @param params
	 * @return CommonEntity
	 */
	public CommonEntity queryOne(Map<String, Object> params);
	/**
	 * 根据map查询得到实体数据列表 当天工作记录信息
	 * @param params
	 * @return List<DoufuTodayWork> 
	 */
	public List<DoufuTodayWork> entityList(Map<String, Object> params);

	/**
	 * 根据map内容删除表中字段与map值对应上的所有数据 当天工作记录信息
	 * @param params
	 * @return int
	 */
	public int deleteByParams(Map<String, Object> params);
	
	/**
	 * 批量保存操作
	 * @param list
	 * @return
	 */
	public int insertBatch(List<DoufuTodayWork> list);
	
	/**
	 * 更新操作
	 * @param doufuTodayWork
	 * @return
	 */
	public int updateBatch(List<DoufuTodayWork> list);
	
	public List<CommonEntity>  queryNotCommitUser(Map<String, Object> params);
	public String dealEvent(HttpServletRequest request, String strEvenKey);

	public String dealDayReportInsert(HttpServletRequest request, String strMsgContent, String strFromUser);
	public String dealDayReportAdd(HttpServletRequest request, String strMsgContent, String strFromUser);
	public String dealDayReportQuery(HttpServletRequest request, String strMsgContent, String strFromUser) throws ParseException;
	public String dealQueryDownLoad(HttpServletRequest request, String strMsgContent, String strFromUser) throws FileNotFoundException, IOException, ParseException;
	public String dealDayReportDownLoad(HttpServletRequest request, String strMsgContent, String strFromUser) throws FileNotFoundException, IOException, ParseException;
	public List<CommonEntity>  getReportDateList(Map<String, Object> params);

}
