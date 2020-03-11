package com.kmw.qywx.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kmw.qywx.domain.DoufuTodayWork;
import com.kmw.qywx.domain.WxUser;
import com.kmw.qywx.service.IDoufuTodayWorkService;
import com.kmw.qywx.utils.Result;
import com.kmw.qywx.utils.WeiXinUtil;
import com.kmw.common.utils.StringConvert;

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
public class DoufuTodayWorkController extends BaseController {
	private String prefix = "qywx/work";

	@Autowired
	private IDoufuTodayWorkService doufuTodayWorkService;

	@Autowired
	WeiXinUtil weiXinUtil;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@RequiresPermissions("qywx:work:view")
	@GetMapping()
	public String work() {
		return prefix + "/work";
	}

	/**
	 * 查询当天工作记录信息列表
	 */
	@RequiresPermissions("qywx:work:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(@RequestParam Map<String, Object> params) {
		startPage();
		// List<DoufuTodayWork> list =
		// doufuTodayWorkService.selectDoufuTodayWorkList(doufuTodayWork);
		// Map<String, Object> params = new HashMap<>();
		params.put("sortC", "reporter_Name,report_date");
		params.put("order", "asc");

		List<DoufuTodayWork> list = doufuTodayWorkService.entityList(params);
		return getDataTable(list);
	}

	/**
	 * 导出当天工作记录信息列表
	 */
	@RequiresPermissions("qywx:work:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(@RequestParam Map<String, Object> params) {
		params.put("sortC", "reporter_Name,report_date");
		params.put("order", "desc");
		List<DoufuTodayWork> list = doufuTodayWorkService.entityList(params);
		// List<DoufuTodayWork> list =
		// doufuTodayWorkService.selectDoufuTodayWorkList(doufuTodayWork);
		ExcelUtil<DoufuTodayWork> util = new ExcelUtil<DoufuTodayWork>(DoufuTodayWork.class);
		return util.exportExcel(list, "work");
	}

	/**
	 * 新增当天工作记录信息
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存当天工作记录信息
	 */
	@RequiresPermissions("qywx:work:add")
	@Log(title = "当天工作记录信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DoufuTodayWork doufuTodayWork) {
		return toAjax(doufuTodayWorkService.insertDoufuTodayWork(doufuTodayWork));
	}

	/**
	 * 修改当天工作记录信息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap) {
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
	public AjaxResult editSave(DoufuTodayWork doufuTodayWork) {
		return toAjax(doufuTodayWorkService.updateDoufuTodayWork(doufuTodayWork));
	}

	/**
	 * 按Map参数据查询，得到公共实体后分页
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "queryPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<CommonEntity> PageInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 当天工作记录信息 ，Map参数：" + params.toString());
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
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
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
			queyrStartDate = DateUtils.DateToStr8();
		}

		if ("".equals(queyrEndDate) || null == queyrEndDate) {
			queyrEndDate = DateUtils.DateToStr8();
		}

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

	public PageInfo<CommonEntity> queryWebMsgList(HttpServletRequest request, Map<String, Object> map)
			throws ParseException {
		String queryResult = null;
		String dynamicSQL = "";

		WxUser wxUser = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();

		if ("".equals(map.get("query_start_date")) || null == map.get("query_start_date")) {
			logger.info("查询开始日期为空，不合法！");
			return null;
		}
		if ("".equals(map.get("query_end_date")) || null == map.get("query_end_date")) {
			logger.info("查询结束日期为空，不合法！");
			return null;
		}

		if ("".equals(map.get("query_end_date")) || null == map.get("query_end_date")) {
			dynamicSQL = "t.REPORT_DATE ='" + map.get("query_start_date") + "'";
		} else {
			if (DateUtils.daysBetween(map.get("query_start_date").toString(), map.get("query_end_date").toString()) > 5)
				logger.info("仅提供五天内查询数据，超出时间查询，请联系管理员！");
			dynamicSQL = "t.REPORT_DATE >='" + map.get("query_start_date") + "' and t.REPORT_DATE <='"
					+ map.get("query_end_date") + "'";
		}
		String queryUser = "";

		if ("".equals(map.get("query_name")) || null == map.get("query_name")) {
			queryUser = wxUser.getAccount();
		} else {
			if ("*".equals(map.get("query_name"))) {
				queryUser = "all";
			} else {
				queryUser = weiXinUtil.getUserInfo(queryUser, "ACCOUNT").getAccount();
			}
		}

		logger.info("要调阅的用户姓名【" + queryUser + "】");
		queryMap.put("reporterName", queryUser);
		queryMap.put("pageNum", map.get("pageNum"));
		queryMap.put("pageSize", map.get("pageSize"));
		queryMap.put("dynamicSQL", dynamicSQL);
		queryMap.put("sortC", "REPORTER_NAME,report_date,input_order,PRODUCT_NAME");
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
	public Result wxgetRptDList(@RequestBody JSONObject jsonParam, HttpServletRequest request) {

		Result result = new Result();
		JSONObject jsonValue = new JSONObject();
		JSONObject jsonValueRtn = new JSONObject();
		result.setCode(0);
		if (jsonParam.isEmpty()) {
			result.setMsg("前台传入的查询参数为空！");

			return result;
		}

		if (null == jsonParam.getString("userCode") || "".equals(jsonParam.getString("userCode"))) {

			result.setMsg("前台传入的用户代码为空！");
			return result;
		}

		weiXinUtil.userInit(request, jsonParam.getString("userCode"));

		Map<String, Object> queryMap = new HashMap();
		queryMap.put("reporterName", jsonParam.getString("userCode"));
		List<CommonEntity> lstRptDList = doufuTodayWorkService.getReportDateList(queryMap);

		if (lstRptDList == null || lstRptDList.size() == 0) {
			result.setMsg("没找到用户提交的日报信息！");
			jsonValue.put("reporterId", 0);
			jsonValue.put("date", "今天");
			jsonValueRtn.put("lists", jsonValue.toString());

		} else {
			List ListRptDateList = new ArrayList<>();
			jsonValue.put("reporterId", 0);
			jsonValue.put("date", "今天");
			ListRptDateList.add(jsonValue.toString());
			int i = 1;
			for (Iterator<CommonEntity> iterator = lstRptDList.iterator(); iterator.hasNext();) {

				jsonValue.put("reporterId", i++);
				jsonValue.put("date", iterator.next().get("report_date").toString());
				ListRptDateList.add(jsonValue.toString());
			}
			jsonValueRtn.put("lists", JSON.toJSON(ListRptDateList));

		}
		logger.info(jsonValueRtn.toString());
		return result.successResult(jsonValueRtn.toString());
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
	public Result wxqueryRptList(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
		Result result = new Result();
		result.setCode(0);

		JSONObject jsonValue = new JSONObject();
		JSONObject jsonValueRtn = new JSONObject();
		String returnMsg = "";
		List lstJson = new ArrayList<String>();
		if (jsonParam.isEmpty()) {
			result.setMsg("调用后台方法时，传入的参数为空!");

			return result;

		}
		String strUserCode = jsonParam.getString("userCode");
		String strqueryDate = jsonParam.getString("queryDate");

		if (null == strUserCode || "".equals(strUserCode)) {
			result.setMsg("前台传过来的查询条件：用户代码为空！");
			return result;
		}
		if (null == strqueryDate || "".equals(strqueryDate)) {
			result.setMsg("前台传过来的查询条件：查询时间为空！");
			return result;
		}

		if ("今天".equals(strqueryDate)) {
			strqueryDate = DateUtils.DateToStr8();
		}
		weiXinUtil.userInit(request, strUserCode);

		Map<String, Object> queryMap = new HashMap();
		queryMap.put("reporterName", strUserCode);
		queryMap.put("reportDate", strqueryDate);

		queryMap.put("sortC", "report_date,input_order");
		List<DoufuTodayWork> lstRtn = doufuTodayWorkService.entityList(queryMap);

		if (lstRtn == null || lstRtn.size() == 0) {
			result.setMsg("查询信息：查询到的结果为空！");

			return result;
		} else {

			int i = 1;

			for (int ii = 0; ii < lstRtn.size(); ii++) {
				jsonValue.put("searchId", i++);
				if (null != lstRtn.get(ii)) {
					DoufuTodayWork doufuTodayWork = lstRtn.get(ii);
					String productName = doufuTodayWork.getProductName();
					String workDetail = doufuTodayWork.getWorkDetail();
					if (null == productName || "".equals(productName)) {
						productName = "项目名称，提交时内容为空";
					}
					if (null == workDetail || "".equals(workDetail)) {
						workDetail = "工作内容，提交时内容为空";
					}
					jsonValue.put("productName", productName);
					jsonValue.put("workDetail", workDetail);
					lstJson.add(jsonValue.toString());
				}
			}
			jsonValueRtn.put("lists", JSON.toJSON(lstJson));
			return result.successResult(jsonValueRtn.toString());
		}
	}

	/**
	 * 添加或更新
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "wxworksave", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result wxWorkSave(@RequestBody JSONObject jsonParam, HttpServletRequest request)
			throws UnsupportedEncodingException {

		Result result = new Result();
		logger.info("开始保存当天工作记录信息表");
		int count = 1;
		if (jsonParam.isEmpty()) {
			result.setMsg("传入的保存数据内容为空！");
			return result.errorResult();
		}
		String data = jsonParam.toJSONString();
		logger.info("前台传入的data为【" + data + "】");
		String strSaveMsg = json2String(data);
		if (!"".equals(strSaveMsg)) {
			JSONObject jsonUserInfo = jsonParam.getJSONObject("userIfno");
			String strUserCode = jsonUserInfo.getString("userCode");
			logger.info("前台传入的转换为日报格式后【" + json2String(data) + "】");
			logger.info("根据code得到的用户信息为【" + strUserCode + "】");
			if ("".equals(strUserCode)) {
				result.setMsg("前台传用的用户code为空！");
				return result.errorResult();
			}
			weiXinUtil.userInit(request, strUserCode);
			String strRtnMsg = doufuTodayWorkService.dealDayReportInsert(request, strSaveMsg, strUserCode);
			result.setMsg(strRtnMsg);
		}

		if (count > 0) {
			logger.info("保存当天工作记录信息表成功！");
			return Result.successResult();
		}
		return Result.errorResult();
	}

	/**
	 * json转字符串
	 * 
	 * @param json
	 * @return
	 */
	public String json2String(String json) {
		StringBuffer result = new StringBuffer();
		JSONObject jsonObject = JSONObject.parseObject(json);
		result.append("[日报]\r\n");

		// today
		JSONObject todayObj = jsonObject.getJSONObject("today");
		String todayWorktype = todayObj.getString("worktype");// 这个属性好像没用到...
		result.append("今天\r\n");
		Set<String> projectNums = getProjectCounts(todayObj);
		Iterator<String> iter = projectNums.iterator();
		while (iter.hasNext()) {
			String projectNum = iter.next();
			result.append("[" + todayObj.getString("projectName_" + projectNum) + "]\r\n");// projectName_x
			result.append(todayObj.getString("projectMessage_" + projectNum));// projectMessage_x
			result.append("[" + todayObj.getString("finishPercent_" + projectNum) + "%]\r\n");// finishPercent_x
		}

		// today
		JSONObject tomorrowObj = jsonObject.getJSONObject("tomorrow");
		String tomorrowWorktype = tomorrowObj.getString("worktype");// 这个属性好像没用到...
		result.append("明天\r\n");
		projectNums = getProjectCounts(tomorrowObj);
		iter = projectNums.iterator();
		while (iter.hasNext()) {
			String projectNum = iter.next();
			result.append("[" + tomorrowObj.getString("tomorrow_projectName_" + projectNum) + "]\r\n");// tomorrow_projectName_x
			result.append(tomorrowObj.getString("tomorrow_projectMessage_" + projectNum) + "\r\n");// tomorrow_projectMessage_x
		}

		// submit
		JSONObject submitObj = jsonObject.getJSONObject("submit");
		String submitObjWorktype = submitObj.getString("worktype");// 这个属性好像没用到...
		result.append("总结\r\n");
		result.append(submitObj.getString("projectSummary") + "\r\n");// projectSummary

		return result.toString();
	}

	public Set<String> getProjectCounts(JSONObject obj) {
		Set<String> result = new HashSet<String>();
		Iterator<String> iter = obj.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			int lastIndex = key.lastIndexOf("_");
			if (lastIndex == -1) {
				continue;
			}
			result.add(key.substring(lastIndex + 1));
		}
		return result;
	}

	@PostMapping("/qywxlist")
	@ResponseBody
	public TableDataInfo qywxList(@RequestParam Map<String, Object> params) {
		startPage();
		// List<DoufuTodayWork> list =
		// doufuTodayWorkService.selectDoufuTodayWorkList(doufuTodayWork);
		// Map<String, Object> params = new HashMap<>();
		params.put("sortC", "reporter_Name,report_date");
		params.put("order", "desc");

		List<DoufuTodayWork> list = doufuTodayWorkService.entityList(params);
		return getDataTable(list);
	}

	/**
	 * 添加或更新
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "wxworksaveV2", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result wxWorkSaveV2(@RequestBody JSONObject jsonParam, HttpServletRequest request)
			throws UnsupportedEncodingException {

		Result result = new Result();
		logger.info("开始保存当天工作记录信息表");
		int count = 1;
		if (jsonParam.isEmpty()) {
			result.setMsg("传入的保存数据内容为空！");
			return result.errorResult();
		}
		String data = jsonParam.toJSONString();
		logger.info("前台传入的data为【" + data + "】");

		String strUserCode = jsonParam.getString("userCode");
		if ("".equals(strUserCode)) {
			result.setMsg("前台传用的用户code为空！");
			result.setCode(0);
			return result;
		}
		weiXinUtil.userInit(request, strUserCode);
		JSONArray todayObjectlst = jsonParam.getJSONArray("todaywork");
		JSONArray tomorObjectlst = jsonParam.getJSONArray("tomorrowwork");
		Object submitObject = jsonParam.get("submitwork");

		if (todayObjectlst == null && tomorObjectlst == null && submitObject == null) {
			result.setCode(0);
			result.setMsg("提交的日报内容为空！");
			return result;

		}
		List<String> lstReptList = new ArrayList<>();
		lstReptList.add("[日报]\n");
		if (todayObjectlst == null || todayObjectlst.size() == 0) {
			lstReptList.add("今天\n");
			lstReptList.add("无工作\n");

		} else {
			lstReptList.add("今天\n");

			for (int ii = 0; ii < todayObjectlst.size(); ii++) {

				JSONObject jsonOneJsonObject = todayObjectlst.getJSONObject(ii);

				lstReptList.add("[" + jsonOneJsonObject.get("projectId").toString() + "]\n");
				lstReptList.add(jsonOneJsonObject.get("workcontent").toString() + "["
						+ jsonOneJsonObject.get("finishPercent").toString() + "]\n");
			}
		}

		if (tomorObjectlst == null || tomorObjectlst.size() == 0) {
			lstReptList.add("明天\n");
			lstReptList.add("无工作\n");

		} else {
			lstReptList.add("明天\n");

			for (int ii = 0; ii < tomorObjectlst.size(); ii++) {
				JSONObject jsonOneJsonObject = tomorObjectlst.getJSONObject(ii);

				;
				lstReptList.add("[" + jsonOneJsonObject.get("projectId").toString() + "]\n");
				lstReptList.add(jsonOneJsonObject.get("workcontent").toString() + "["
						+ jsonOneJsonObject.get("finishPercent").toString() + "]\n");
			}
		}

		if (submitObject == null) {
			result.setCode(0);
			result.setMsg("总结内容录入不符合");

		} else {
			lstReptList.add("总结\n");
			lstReptList.add(submitObject.toString());
		}
		String strLastCommitString = "";
		for (int j = 0; j < lstReptList.size(); j++) {
			strLastCommitString = strLastCommitString + lstReptList.get(j);
		}
		logger.info("提交的内容转为报文后:\n" + strLastCommitString);
		doufuTodayWorkService.saveOperReportLog("text", strLastCommitString, request);
		result.setMsg(doufuTodayWorkService.dealDayReportInsert(request, strLastCommitString, strUserCode));
		result.setCode(0);
		return result;
	}

}
