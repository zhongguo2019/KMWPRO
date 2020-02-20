package com.kmw.qywx.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;
import com.kmw.common.Constant;
import com.kmw.common.annotation.Log;
import com.kmw.common.enums.BusinessType;
import com.kmw.qywx.domain.DoufuTodayWork;
import com.kmw.qywx.domain.WxUser;
import com.kmw.qywx.service.IDoufuTodayWorkService;
import com.kmw.qywx.utils.WeiXinUtil;
import com.kmw.utils.StringConvert;


import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.DateUtils;

import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 当天工作记录信息Controller
 * 
 * @author kmw
 * @date 2020-02-20
 */
@Controller
@RequestMapping("/qywx/work")
public class DoufuTodayWorkController extends BaseController
{
    private String prefix = "qywx/work";

    @Autowired
    private IDoufuTodayWorkService doufuTodayWorkService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("qywx:work:view")
    @GetMapping()
    public String work()
    {
        return prefix + "/work";
    }

    /**
     * 查询当天工作记录信息列表
     */
    @RequiresPermissions("qywx:work:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DoufuTodayWork doufuTodayWork)
    {
        startPage();
        List<DoufuTodayWork> list = doufuTodayWorkService.selectDoufuTodayWorkList(doufuTodayWork);
        return getDataTable(list);
    }

    /**
     * 导出当天工作记录信息列表
     */
    @RequiresPermissions("qywx:work:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DoufuTodayWork doufuTodayWork)
    {
        List<DoufuTodayWork> list = doufuTodayWorkService.selectDoufuTodayWorkList(doufuTodayWork);
        ExcelUtil<DoufuTodayWork> util = new ExcelUtil<DoufuTodayWork>(DoufuTodayWork.class);
        return util.exportExcel(list, "work");
    }

    /**
     * 新增当天工作记录信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存当天工作记录信息
     */
    @RequiresPermissions("qywx:work:add")
    @Log(title = "当天工作记录信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DoufuTodayWork doufuTodayWork)
    {
        return toAjax(doufuTodayWorkService.insertDoufuTodayWork(doufuTodayWork));
    }

    /**
     * 修改当天工作记录信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        DoufuTodayWork doufuTodayWork = doufuTodayWorkService.selectDoufuTodayWorkById(id);
        mmap.put("doufuTodayWork", doufuTodayWork);
        return prefix + "/edit";
    }

    /**
     * 修改保存当天工作记录信息
     */
    @RequiresPermissions("qywx:work:edit")
    @Log(title = "当天工作记录信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DoufuTodayWork doufuTodayWork)
    {
        return toAjax(doufuTodayWorkService.updateDoufuTodayWork(doufuTodayWork));
    }

	/**
	 *按Map参数据查询，得到公共实体后分页
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "queryPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo PageInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 当天工作记录信息 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		
		
		PageInfo<CommonEntity> page = doufuTodayWorkService.queryPageInfoEntity(params);
		return page;

	}

	/**
	 * 前台分页显示
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "tableDataInfo", method = RequestMethod.POST)
	@ResponseBody
	public TableDataInfo tableDataInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 当天工作记录信息 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = doufuTodayWorkService.commonList(params);
		return getDataTable(listEntity);

	}

	/**
	 * 查询一条记录
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "queryOneEntity", method = RequestMethod.POST)
	@ResponseBody
	public CommonEntity queryOne(@RequestParam Map<String, Object> params, ModelMap mmap) {
		logger.info("【通用实体查询】 当天工作记录信息 ，Map参数：" + params.toString());
		CommonEntity commonEntity = doufuTodayWorkService.queryOne(params);
		return commonEntity;

	}



    /**
     * 删除当天工作记录信息
     */
    @RequiresPermissions("qywx:work:remove")
    @Log(title = "当天工作记录信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(doufuTodayWorkService.deleteDoufuTodayWorkByIds(ids));
    }
    
    /**
	 * 查询个人工作记录
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */

	@RequestMapping(value = "wxWorkQuery", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
 	public String wxWorkQuery(@RequestBody JSONObject jsonParam, HttpServletRequest request)
			throws UnsupportedEncodingException, ParseException {

		JSONObject jsonValue = new JSONObject();
		String returnMsg = "";
		if (jsonParam.isEmpty()) {
			returnMsg = "传入的保存数据内容为空！";
			jsonValue.put("code", 0);
			jsonValue.put("msg", returnMsg);
			jsonValue.put("data", "{}");
			return jsonValue.toString();
		}


		String data = jsonParam.toJSONString();
		logger.info("前台传入的data为【" + data + "】");

		String strUserCode = jsonParam.getString("userCode");
		String queyrStartDate = jsonParam.getString("startdate");
		String queyrEndDate = jsonParam.getString("enddate");
		String queyrName = jsonParam.getString("username");

		if (null == strUserCode || "".equals(strUserCode)) {
			returnMsg = "前台用户信息不合法";

			jsonValue.put("code", 0);
			jsonValue.put("msg", returnMsg);
			jsonValue.put("count", 0);
			jsonValue.put("data", "{}");
			return jsonValue.toString();
		}

		if ("".equals(queyrStartDate) || null == queyrStartDate) {
			queyrStartDate = DateUtils.DateToStr8(new Date(0));
		}

		if ("".equals(queyrEndDate) || null == queyrEndDate) {
			queyrEndDate = DateUtils.DateToStr8(new Date(0));
		}

		WeiXinUtil weiXinUtil = new WeiXinUtil();
		weiXinUtil.userInit(request, strUserCode);

		if (!"".equals(data)) {
			Map<String, Object> queryMap = new HashMap();
			queryMap.put("query_start_date", queyrStartDate);
			queryMap.put("query_end_date", queyrEndDate);
			queryMap.put("query_name", queyrName);
			queryMap.put("pageNum", jsonParam.getString("page"));
			queryMap.put("pageSize", jsonParam.getString("limit"));
			returnMsg = "分页查询成功";
			PageInfo<CommonEntity> pageQuery = queryWebMsgList(request, queryMap);
			jsonValue.put("code", 0);
			jsonValue.put("msg", returnMsg);
			jsonValue.put("count", pageQuery.getTotal());
			jsonValue.put("data", JSON.toJSON(pageQuery.getList()));
			return jsonValue.toString();

		}
		return jsonValue.toString();
	}
	
	
	public PageInfo<CommonEntity>  queryWebMsgList(HttpServletRequest request, Map<String, Object> map)
			throws ParseException {
		String queryResult = null;
		String dynamicSQL = "";

		WxUser wxUser = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);

		
		
		Map<String, Object> queryMap = new HashMap<String, Object>();
		if ("".equals(map.get("query_start_date")) || null == map.get("query_start_date")) {
			return null;
		} 
		if ("".equals(map.get("query_end_date")) || null == map.get("query_end_date")) {
			return null;
		} 

		if ("".equals(map.get("query_end_date")) || null == map.get("query_end_date")) {
			dynamicSQL = "t.REPORT_DATE ='" + map.get("query_start_date") + "'";
		} else {
			if (DateUtils.daysBetween(map.get("query_start_date").toString(), map.get("query_end_date").toString()) > 5)
				logger.info("仅提供五天内查询数据，超出时间查询，请联系管理员！");
			dynamicSQL = "t.REPORT_DATE >='" + map.get("query_start_date") + "' and t.REPORT_DATE <='"
					+map.get("query_end_date") + "'";
		}
		String queryUser = "";

		if ("".equals(map.get("query_name")) || null == map.get("query_name")) {
			queryUser = wxUser.getName();
		} else {
			queryUser = map.get("query_name").toString();
			WeiXinUtil weiXinUtil= new WeiXinUtil();
			 wxUser = weiXinUtil.getUserInfo(queryUser);
			queryUser = wxUser.getName();
		}

		logger.info("要调阅的用户姓名【"+queryUser+"】");
		queryMap.put("reporterName", queryUser);
		queryMap.put("pageNum",  map.get("pageNum"));
		queryMap.put("pageSize",  map.get("pageSize"));
		queryMap.put("dynamicSQL", dynamicSQL);
		queryMap.put("sortC", "create_date,input_order,PRODUCT_NAME");
		queryMap.put("order", "asc");
		PageInfo<CommonEntity> page = doufuTodayWorkService.queryPageInfoEntity(queryMap);
		
		return page;

	}

	/**
	 * 查询个人工作记录
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	@RequestMapping(value = "wxgetRptDList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String wxgetRptDList(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
		
		JSONObject jsonValue = new JSONObject();
		JSONObject jsonValueRtn = new JSONObject();
		String returnMsg = "";
		if (jsonParam.isEmpty()) {
			returnMsg = "传入的参数为空！";
			jsonValue.put("reporterId", 0);
			jsonValue.put("date", "今天");
			jsonValueRtn.put("lists", jsonValue.toString());
			return jsonValueRtn.toString();
		}
		
		String strUserCode = jsonParam.getString("userCode");

		
		if (null == strUserCode || "".equals(strUserCode)) {
			returnMsg = "前台用户信息不合法";
			jsonValue.put("reporterId", 0);
			jsonValue.put("date", "今天");
			jsonValueRtn.put("lists", jsonValue.toString());
			return jsonValueRtn.toString();
		}
		WeiXinUtil weiXinUtil = new WeiXinUtil();
		weiXinUtil.userInit(request, strUserCode);		
		
		Map<String, Object> queryMap = new HashMap();
		queryMap.put("reporterName", strUserCode);
		List<CommonEntity>  lstRptDList = doufuTodayWorkService.getReportDateList(queryMap);
		
		if(lstRptDList==null||lstRptDList.size()==0) {
			returnMsg = "后台没有查到数据";
			jsonValue.put("reporterId", 0);
			jsonValue.put("date", "今天");
			jsonValueRtn.put("lists", jsonValue.toString());
			return jsonValueRtn.toString();	
		}else {
			   List 	ListRptDateList = new ArrayList<>();
			jsonValue.put("reporterId", 0);
			jsonValue.put("date", "今天");
			ListRptDateList.add(jsonValue.toString());
			int i=1;
	        for (Iterator<CommonEntity> iterator = lstRptDList.iterator();iterator.hasNext();) {
	        	
				jsonValue.put("reporterId", i++);
				jsonValue.put("date", iterator.next().get("report_date").toString());
				ListRptDateList.add(jsonValue.toString());
	        }
	        jsonValueRtn.put("lists", JSON.toJSON(ListRptDateList));
			
		}
		
		return jsonValueRtn.toString();
	}
	
	/**
	 * 得到指定日期的某个人的报告列表
	 *
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	@RequestMapping(value = "wxqueryRptList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String wxqueryRptList(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
		JSONObject jsonValue = new JSONObject();
		JSONObject jsonValueRtn = new JSONObject();
		String returnMsg="";
		List   lstJson = new ArrayList<String>();
		if (jsonParam.isEmpty()) {
			returnMsg = "传入的参数为空！";
			jsonValue.put("searchId", 0);
			jsonValue.put("productName", "");
			jsonValue.put("workDetail", "");
			jsonValue.put("returnMsg", returnMsg);
			lstJson.add(jsonValue.toString());
	        jsonValueRtn.put("lists", JSON.toJSON(lstJson));
			return jsonValueRtn.toString();
		}
		String strUserCode = jsonParam.getString("userCode");
		String strqueryDate = jsonParam.getString("queryDate");
		
		if (null == strUserCode || "".equals(strUserCode)) {
			returnMsg = "前台用户信息不合法";
			jsonValue.put("searchId", 0);
			jsonValue.put("productName", "");
			jsonValue.put("workDetail", "");
			jsonValueRtn.put("returnMsg", returnMsg);
			lstJson.add(jsonValue.toString());
	        jsonValueRtn.put("lists", JSON.toJSON(lstJson));
			return jsonValueRtn.toString();
		}
		if (null == strqueryDate || "".equals(strqueryDate)) {
			returnMsg = "前台传入的日期不合法";
			jsonValue.put("searchId", 0);
			jsonValue.put("productName", "");
			jsonValue.put("workDetail", "");
			jsonValueRtn.put("returnMsg", returnMsg);
			lstJson.add(jsonValue.toString());
	        jsonValueRtn.put("lists", JSON.toJSON(lstJson));
			return jsonValueRtn.toString();
		}
		if ("今天".equals(strqueryDate)){
			strqueryDate = DateUtils.DateToStr8(new Date(0));
		}
		WeiXinUtil weiXinUtil = new WeiXinUtil();
		weiXinUtil.userInit(request, strUserCode);		
		
		Map<String, Object> queryMap = new HashMap();
		queryMap.put("reporterName", strUserCode);
		queryMap.put("reportDate", strqueryDate);
		
		queryMap.put("sortC", "report_date,input_order");
		List<DoufuTodayWork> lstRtn = doufuTodayWorkService.entityList(queryMap);
		
		if(lstRtn==null||lstRtn.size()==0) {
			returnMsg = "后台没有查到数据";
			jsonValue.put("searchId", 0);
			jsonValue.put("productName", "");
			jsonValue.put("workDetail", "");
			jsonValueRtn.put("returnMsg", returnMsg);
			lstJson.add(jsonValue.toString());
	        jsonValueRtn.put("lists", JSON.toJSON(lstJson));
			return jsonValueRtn.toString();	
		}else {

			int i=1;

	        for (int ii=0;ii<lstRtn.size();ii++) {
				jsonValue.put("searchId", i++);
				if(null !=lstRtn.get(ii)) {
					DoufuTodayWork doufuTodayWork = lstRtn.get(ii);
				String productName = doufuTodayWork.getProductName();
				String workDetail = doufuTodayWork.getWorkDetail();
				if(null == productName ||"".equals(productName)) {
					productName = "项目名称，提交时内容为空";
				}
				if(null == workDetail ||"".equals(workDetail)) {
					workDetail = "工作内容，提交时内容为空";
				}
				jsonValue.put("productName", productName);
				jsonValue.put("workDetail", workDetail);
				lstJson.add(jsonValue.toString());
	        }
	        }
	        jsonValueRtn.put("lists", JSON.toJSON(lstJson));
	        return jsonValueRtn.toString();
		}
}
}
