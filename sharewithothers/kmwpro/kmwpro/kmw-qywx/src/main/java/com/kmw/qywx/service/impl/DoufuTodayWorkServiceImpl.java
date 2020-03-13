package com.kmw.qywx.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.qywx.mapper.DoufuTodayWorkMapper;
import com.kmw.qywx.domain.DoufuTodayWork;
import com.kmw.qywx.domain.QywxUserOperatelog;
import com.kmw.qywx.service.IDoufuTodayWorkService;
import com.kmw.qywx.service.IQywxUserOperatelogService;
import com.kmw.qywx.utils.ExportExcel;
import com.kmw.qywx.utils.Result;
import com.kmw.qywx.utils.WeiXinParamesUtil;
import com.kmw.qywx.utils.WeiXinUtil;
import com.kmw.common.core.text.Convert;
import com.kmw.common.utils.DateUtils;
import com.kmw.common.utils.StringUtils;
import com.kmw.common.utils.file.FileUtils;
import com.kmw.common.CommonEntity;
import com.kmw.common.Constant;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.kmw.qywx.domain.ReportTmplate;
import com.kmw.qywx.domain.WxUser;

/**
 * 当天工作记录信息Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-20
 */
@Service
public class DoufuTodayWorkServiceImpl implements IDoufuTodayWorkService {
	@Autowired
	private DoufuTodayWorkMapper doufuTodayWorkMapper;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String reportError = "0";
	private String report_date = DateUtils.DateToStr8();
	private String next_date = DateUtils.getNextDateByDate8(report_date);
	private String query_start_date = "";
	private String query_end_date = "";
	private String by_date = "";
	private int iorder = 0;

	@Autowired
	WeiXinUtil weiXinUtil;

	@Autowired
	IQywxUserOperatelogService qywxUserOperatelogService;

	/**
	 * 查询当天工作记录信息
	 * 
	 * @param id 当天工作记录信息ID
	 * @return 当天工作记录信息
	 */
	@Override
	public DoufuTodayWork selectDoufuTodayWorkById(String id) {
		return doufuTodayWorkMapper.selectDoufuTodayWorkById(id);
	}

	/**
	 * 查询当天工作记录信息列表
	 * 
	 * @param doufuTodayWork 当天工作记录信息
	 * @return 当天工作记录信息
	 */
	@Override
	public List<DoufuTodayWork> selectDoufuTodayWorkList(DoufuTodayWork doufuTodayWork) {
		return doufuTodayWorkMapper.selectDoufuTodayWorkList(doufuTodayWork);
	}

	/**
	 * 新增当天工作记录信息
	 * 
	 * @param doufuTodayWork 当天工作记录信息
	 * @return 结果
	 */
	@Override
	public int insertDoufuTodayWork(DoufuTodayWork doufuTodayWork) {
		return doufuTodayWorkMapper.insertDoufuTodayWork(doufuTodayWork);
	}

	/**
	 * 修改当天工作记录信息
	 * 
	 * @param doufuTodayWork 当天工作记录信息
	 * @return 结果
	 */
	@Override
	public int updateDoufuTodayWork(DoufuTodayWork doufuTodayWork) {
		return doufuTodayWorkMapper.updateDoufuTodayWork(doufuTodayWork);
	}

	/**
	 * 删除当天工作记录信息对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteDoufuTodayWorkByIds(String ids) {
		return doufuTodayWorkMapper.deleteDoufuTodayWorkByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除当天工作记录信息信息
	 * 
	 * @param id 当天工作记录信息ID
	 * @return 结果
	 */
	@Override
	public int deleteDoufuTodayWorkById(String id) {
		return doufuTodayWorkMapper.deleteDoufuTodayWorkById(id);
	}

	/**
	 * 分页展示(可带条件查询) 当天工作记录信息信息 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * 
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【当天工作记录信息】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = doufuTodayWorkMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info(
					"#                 2、角色配置不正确                                                                     #");
			logger.info(
					"#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = doufuTodayWorkMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}

	/**
	 * 列表(可带条件查询) 当天工作记录信息信息 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * 
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【当天工作记录信息】列表数据，返回通用对象========================#");
		List<CommonEntity> list = doufuTodayWorkMapper.queryEntityList(params);
		return list;
	}

	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 当天工作记录信息信息
	 * 
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询一条【当天工作记录信息信息】数据，返回实体对象========================#");
		if (params.containsKey("id")) {
			return doufuTodayWorkMapper.queryOneCommon(params);
		} else {
			logger.info("#=================按主键查询【当天工作记录信息信息】一条，Map参数中 id不能为空========================#");
			return null;
		}
	}

	/**
	 * 更新操作
	 * 
	 * @param doufuTodayWork
	 * @return
	 */
	public int updateBatch(List<DoufuTodayWork> list) {
		return doufuTodayWorkMapper.updateBatchEntity(list);
	}

	/**
	 * 根据不同组合条件删除
	 * 
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件删除【当天工作记录信息表】数据========================#");
		return doufuTodayWorkMapper.deleteByParams(params);
	}

	/**
	 * 批量保存操作
	 * 
	 * @param list
	 * @return
	 */
	public int insertBatch(List<DoufuTodayWork> list) {
		return doufuTodayWorkMapper.insertBatch(list);
	}

	/**
	 * 列表(可带条件查询) 当天工作记录信息信息 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * 
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<DoufuTodayWork> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【当天工作记录信息】列表数据，返回通用对象========================#");
		List<DoufuTodayWork> list = doufuTodayWorkMapper.entityList(params);
		return list;
	}

	public String getReportError() {
		return reportError;
	}

	public static ReportTmplate initTemp(Map<String, Map<String, List<String>>> work) {
		ReportTmplate reportTmplate = new ReportTmplate();
		// 遍历 今天 工作内容
		Map<String, List<String>> todayWork = work.get("today");
		// 遍历方式
		Iterator<Entry<String, List<String>>> iter = todayWork.entrySet().iterator();
		List<String> todaywork = new ArrayList<>();

		while (iter.hasNext()) {
			Entry<String, List<String>> entry = iter.next();
			String productName = entry.getKey();
			// System.out.println(productName);
			List<String> productWork = entry.getValue();
			for (String w : productWork) {
				// System.out.println(productName + "|" + w);
				todaywork.add(productName + "|" + w);
			}
		}

		reportTmplate.setLst_today(todaywork);
		reportTmplate.setTodaywork(ListToArray(todaywork));

		// 遍历 今天 工作内容
		Map<String, List<String>> mtowarrowWork = work.get("towarrow");
		// 遍历方式
		Iterator<Entry<String, List<String>>> iter2 = mtowarrowWork.entrySet().iterator();
		List<String> towarrowwork = new ArrayList<>();

		while (iter2.hasNext()) {
			Entry<String, List<String>> entry = iter2.next();
			String productName = entry.getKey();
			// System.out.println(productName);
			List<String> productWork = entry.getValue();
			for (String w : productWork) {
				// System.out.println(productName + "|" + w);
				towarrowwork.add(productName + "|" + w);
			}
		}

		reportTmplate.setLst_tomorrow(towarrowwork);
		reportTmplate.setTmorrowwork(ListToArray(towarrowwork));

		// 遍历 今天 工作内容
		Map<String, List<String>> msummary = work.get("summary");
		// 遍历方式
		Iterator<Entry<String, List<String>>> iter3 = msummary.entrySet().iterator();
		List<String> summarywork = new ArrayList<>();

		while (iter3.hasNext()) {
			Entry<String, List<String>> entry = iter3.next();
			String productName = entry.getKey();
			System.out.println(productName);
			List<String> productWork = entry.getValue();
			for (String w : productWork) {
				System.out.println(productName + "|" + w);
				summarywork.add(productName + "|" + w);
			}
		}

		reportTmplate.setLst_summary(summarywork);
		reportTmplate.setSummary(ListToArray(summarywork));

		return reportTmplate;
	}

	/**
	 * 
	 * 当天日报的提交处理流程
	 * 
	 * @param text
	 * @return
	 */

	public String dealDayReportInsert(HttpServletRequest request, String strMsgContent, String strFromUser) {
		// String strRtnMsgContent = "亲,感谢您一天的努力,辛苦了！";
		String strRtnMsgContent = "";

		// 用户发来的消息放到Map中
		Map<String, Map<String, List<String>>> work = (Map<String, Map<String, List<String>>>) siftWorkContentV2(
				strMsgContent);
		if (reportError.equals("0") && null != work) {
			// 根据用户发的信息内容进行解析
			ReportTmplate reportTmplate = initTemp(work);
			// 初始化全局的发消息的用户信息
//			weiXinUtil.userInit(request, strFromUser);
			// 将用户的消息存入到数据库中
			Result result = saveMsg(request, reportTmplate);
			if (result.getCode() == 1) {
				strRtnMsgContent = "亲,日报提交成功，感谢您一天的努力,辛苦了！\n" + result.getMsg();
			}

		} else {
			strRtnMsgContent = WeiXinParamesUtil.dayReportFormat;
		}
		return strRtnMsgContent;
	}

	/**
	 * 
	 * 补报日报的处理流程
	 * 
	 * @param text
	 * @return
	 */
	public String dealDayReportAdd(HttpServletRequest request, String strMsgContent, String strFromUser) {
		// String strRtnMsgContent = "亲，感谢您一天的努力，辛苦了!";
		String strRtnMsgContent = "";
		by_date = "";
		// siftWorkContent2方法会将补报的时间从报文中得到。
		Map<String, Map<String, List<String>>> work = (Map<String, Map<String, List<String>>>) siftWorkContent2(
				strMsgContent);
		if (!justMsgDateFormat(strMsgContent)) {
			reportError = "1";
		}
		if (reportError.equals("0")) {

			ReportTmplate reportTmplate = initTemp2(work);
//			weiXinUtil.userInit(request, strFromUser);
			Result result = saveMsg(request, reportTmplate);
			if (result.getCode() == 1) {
				strRtnMsgContent = "亲,日报提交成功，感谢您一天的努力,辛苦了！\n" + result.getMsg();
			}
		} else {
			strRtnMsgContent = WeiXinParamesUtil.dayReportFormatAdd;
		}
		return strRtnMsgContent;
	}

	/**
	 * 
	 * 日报的查询处理流程
	 * 
	 * @param text
	 * @return
	 * @throws ParseException
	 */
	public String dealDayReportQuery(HttpServletRequest request, String strMsgContent, String strFromUser)
			throws ParseException {
		String strRtnMsgContent = "亲，没有查到你想要的数据，请重新设置查询条件！";
		query_start_date = "";
		query_end_date = "";
		// siftWorkContent2方法会将补报的时间从报文中得到。
		Map<String, Object> queryDate = siftWorkContent3(strMsgContent);

		if (null == queryDate) {
			reportError = "1";
		} else {

			query_start_date = queryDate.get("query_start_date").toString();
			query_end_date = queryDate.get("query_end_date").toString();
			if ("".equals(query_end_date)) {

			} else {
				int daybetween = DateUtils.daysBetween(query_start_date, query_end_date);
				if (daybetween > 5) {
					return "亲，只能查询五天之内的数据，请重新设置查询条件！";
				}
			}

		}
		if (reportError.equals("0")) {
			try {
				strRtnMsgContent = queryMsg(request, queryDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			strRtnMsgContent = WeiXinParamesUtil.dayReportFormatQuery;
		}
		if (null == strRtnMsgContent) {
			strRtnMsgContent = "亲，没有查到你想要的数据，请重新设置查询条件！";
		}
		return strRtnMsgContent;
	}

	/**
	 * 
	 * 当天日报的下载
	 * 
	 * @param text
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public String dealDayReportDownLoad(HttpServletRequest request, String strMsgContent, String strFromUser)
			throws FileNotFoundException, IOException, ParseException {
		String strRtnMsgContent = "";
		query_start_date = "";
		query_end_date = "";
		String accessTokenString = weiXinUtil.getRedisToken();
		WxUser wxUser = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
		String username = wxUser.getName();
		// siftWorkContent2方法会将补报的时间从报文中得到。
		Map<String, Object> queryDate = siftWorkContent3(strMsgContent);

		if (null == queryDate) {
			reportError = "1";
		}

		if (reportError.equals("0")) {
			List<String> lstHeader = getHeaderListDayReport();
			List<Map<String, Object>> lstData = getDataListDayReportV2(request, queryDate);
			String filename = getDownLoadFilneName(username);
			String createFlag = exportExcel(filename, lstHeader, lstData, username);
			if ("sucuss".equals(createFlag)) {
				String type = "file";
				/*
				 * String accessToken = WeiXinUtil .getAccessToken(WeiXinParamesUtil.corpId,
				 * WeiXinParamesUtil.contactsSecret).getToken();
				 */
				String accessToken = "";

				// 2.调用业务类，上传临时素材
				JSONObject upload = weiXinUtil.uploadTempMaterial(type, filename, accessTokenString);
				String media_id = upload.getString("media_id");
				String errmsg = upload.getString("errmsg");
				if ("ok".equals(errmsg)) {
					weiXinUtil.SendFileMessage(media_id, type, accessToken, strFromUser);
				} else {
					strRtnMsgContent = "下载失败，错误码【" + errmsg + "】";
				}

			}

		} else {
			strRtnMsgContent = WeiXinParamesUtil.dayReportFormatDownload;
		}
		/*
		 * if (null == strRtnMsgContent) { strRtnMsgContent =
		 * "亲，没有查到需要下载的数据，请重新设置查询条件！"; }
		 */

		return strRtnMsgContent;
	}

	/**
	 * 
	 * 调阅成员的日报
	 * 
	 * @param text
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@SuppressWarnings("static-access")
	public String dealQueryDownLoad(HttpServletRequest request, String strMsgContent, String strFromUser)
			throws FileNotFoundException, IOException, ParseException {
		String strRtnMsgContent = "";
		query_start_date = "";
		query_end_date = "";
		String accessTokenString = weiXinUtil.getRedisToken();
		// siftWorkContent2方法会将补报的时间从报文中得到。
		Map<String, Object> queryParam = siftWorkContent4(strMsgContent);

		if (null == queryParam) {
			reportError = "1";
		}

		if (reportError.equals("0")) {
			String username = queryParam.get("query_name").toString();
			String userNameFlag = "全部成员";
			if (!"*".equals(username)) {
				userNameFlag = username;
			}
			String downLoadFilename = getDownLoadFilneName(userNameFlag);

			List<String> lstHeader = getHeaderListDayReport();
			List<Map<String, Object>> lstData = getDataListDayReportV2(request, queryParam);

			String createFlag = exportExcel(downLoadFilename, lstHeader, lstData, userNameFlag);

			if ("sucuss".equals(createFlag)) {
				String type = "file";

				String accessToken = "";
				// logger.info("调阅个人日报，准备向服务器传文件！");

				// 2.调用业务类，上传临时素材
				JSONObject upload = weiXinUtil.uploadTempMaterial(type, downLoadFilename, accessTokenString);
				// logger.info("调阅个人日报，结束向服务器传文件！");

				// logger.info("调阅个人日报，开始根据上传的文件得到服务器上的media_id后推送给前台用户！");
				if ("ok".equals(upload.getString("errmsg"))) {
					weiXinUtil.SendFileMessage(upload.getString("media_id"), type, accessToken, strFromUser);
				} else {
					strRtnMsgContent = "生成后台文件上传到服务器失败，可能原因企业微信网速问题！";
				}
				// logger.info("调阅个人日报，结束根据上传的文件得到服务器上的media_id后推送给前台用户！");

			}

		} else {
			strRtnMsgContent = WeiXinParamesUtil.dayReportQueryDownload;
		}
		/*
		 * if (null == strRtnMsgContent) { strRtnMsgContent =
		 * "亲，没有查到需要下载的数据，请重新设置查询条件！"; }
		 */

		return strRtnMsgContent;
	}

	public String getDownLoadFilneName(String strFromUser) {
		String file_name = null;
		String file_path = System.getProperty("user.dir") + "/download/";
		file_name = file_path + strFromUser + "__" + DateUtils.DateToTimestamp(new Date()) + ".xls";
		logger.info("file_name【" + file_name + "】");
		return file_name;
	}

	public String exportExcel(String fileName, List<String> lstHeader, List<Map<String, Object>> lstData,
			String strFromUser) throws FileNotFoundException, IOException {
		// 保存文件的绝对路径
		FileUtils.createFile(fileName);
		ExportExcel ee = new ExportExcel("个人日报", lstHeader, strFromUser);
		for (int i = 0; i < lstData.size(); i++) {
			Row row = ee.addRow();
			row.setHeightInPoints(100);

			Map<String, Object> mapcolu = lstData.get(i);
			ee.addCell(row, 0, mapcolu.get("order"));
			ee.addCell(row, 1, mapcolu.get("remarks"));
			ee.addCell(row, 2, mapcolu.get("reportDate"));
			ee.addCell(row, 4, mapcolu.get("gzxz"));
			ee.addCell(row, 3, mapcolu.get("yqzt"));
			ee.addCell(row, 5, mapcolu.get("today"));
			ee.addCell(row, 6, mapcolu.get("tomorrow"));
		}
		ee.writeFile(fileName);
		ee.dispose();
		return "sucuss";
	}

	/*
	 * 构造日报的表头
	 * 
	 */
	public List<String> getHeaderListDayReport() {
		List<String> headerList = Lists.newArrayList();

		headerList.add("序号");
		headerList.add("姓名");
		headerList.add("日期");
		headerList.add("工作状态");
		headerList.add("工作性质");
		headerList.add("当天工作");
		headerList.add("次日计划");
		return headerList;
	}

	/*
	 * 构造日报的表头暂未实现 设计：分别定义实体类 1、header 区 posX,posY,starX,startY,data,label,cellstyle
	 * 2、detail 区 3、summary区 4、footer 区 然后EXCEL按顺序分别写这几个区内容
	 */
	public List<Map<String, Object>> buildHeaderListDayReport() {
		List<String> headerList = Lists.newArrayList();
		List<Map<String, Object>> lstmp = new ArrayList();
		Map<String, Object> mp = new HashMap();
		return lstmp;
	}

	/*
	 * 构造日报的数据内容
	 * 
	 */
	public List<Map<String, Object>> getDataListDayReport(HttpServletRequest request, Map<String, Object> map)
			throws ParseException {

		List<DoufuTodayWork> listDayWork = queryMsgList(request, map);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		if (null == listDayWork) {
			return null;
		}
		String oldNameString = "";
		String oldReportDateString = "";
		Map<String, Object> mpOneMsg = new HashMap<String, Object>();
		int ii = 0;
		for (int i = 0; i < listDayWork.size(); i++) {
			DoufuTodayWork dufuTodayWork = listDayWork.get(i);

			if (dufuTodayWork.getReporterName() != oldNameString
					&& dufuTodayWork.getReportDate() != oldReportDateString) {
				if (mpOneMsg != null) {
					dataList.add(mpOneMsg);
				}

				mpOneMsg.put("order", String.valueOf(ii + 1));
				mpOneMsg.clear();
				oldNameString = dufuTodayWork.getReporterName();
				oldReportDateString = dufuTodayWork.getReportDate();
				mpOneMsg.put("reportDate", dufuTodayWork.getReportDate());
				mpOneMsg.put("remarks", dufuTodayWork.getRemarks());
				mpOneMsg.put("workContents", dufuTodayWork.getWorkContents());
			} else {
				mpOneMsg.put("workContents", mpOneMsg.get("workContents") + "\n" + dufuTodayWork.getWorkContents());
			}
		}

		// 遍历所有行。
		for (int i = 0; i < listDayWork.size(); i++) {
			DoufuTodayWork dufuTodayWork = listDayWork.get(i);
			Map<String, Object> mpcolumn = new HashMap<String, Object>();
			mpcolumn.put("order", String.valueOf(i + 1));
			mpcolumn.put("remarks", dufuTodayWork.getRemarks());
			mpcolumn.put("reportDate", dufuTodayWork.getReportDate());
			mpcolumn.put("productName", dufuTodayWork.getProductName());
			mpcolumn.put("workContents", dufuTodayWork.getWorkContents());

			dataList.add(mpcolumn);
		}

		return dataList;
	}

	/**
	 * 
	 * 判断用户请求文本类型是否为[日报]
	 * 
	 * @param text
	 * @return
	 */
	public static boolean justMsgDateFormat(String text) {
		String[] contentArray = text.trim().split("\n");
		int ipos = text.indexOf("[补报]");
		if (ipos == 0) {
		}
		if (contentArray.length != 0) {
			String strline1 = contentArray[1].toString().trim();
			System.out.println("补报报文，第二行为：" + strline1);
			return isValidDate(strline1);
		}

		return false;
	}

	public static boolean isValidDate(String str) {

		Date dateRtnDate=null;
		try {
			dateRtnDate = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (dateRtnDate == null) {
			return false;
		} else {
			return true;
		}
	

	}

	/**
	 * 使用正则表达式提取中括号中的内容
	 * 
	 * @param msg
	 * @return
	 */
	public static List<String> extractMessageByRegular(String msg) {

		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		Pattern p = Pattern.compile("\\[^\\]*\\]");
		Pattern p1 = Pattern.compile("今.*明");

		Matcher m = p.matcher(msg);
		Matcher m1 = p1.matcher(msg);

		while (m.find()) {
			list.add(m.group().substring(1, m.group().length() - 1));
		}
		while (m1.find()) {
			list2.add(m1.group().substring(1, m1.group().length() - 1));
		}
		return list;
	}

	/**
	 * 构建 今天 明天 总结 map
	 * 
	 * @param workContent
	 * @return
	 */
	public static Map<String, List<String>> buildMap(String workContent) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String[] contentArray = workContent.trim().split("\n");
		String productName = null;
		List<String> productWorkContent = null;
		for (String line : contentArray) {
			line = line.trim();
			if (line.startsWith("[") && line.endsWith("]")) {
				productName = line.substring(1, line.length() - 1);
				continue;
			}
			productWorkContent = result.get(productName);
			if (productWorkContent == null) {
				productWorkContent = new ArrayList<String>();
				if (null == productName) {
					productName = "";
				}
				result.put(productName, productWorkContent);
			}
			productWorkContent.add(line);
		}
		return result;
	}

	/**
	 * 查询分拣任务。返回Map
	 * 
	 * @param text
	 * @return
	 */

	public Map<String, Object> siftWorkContent3(String text) {
		Map<String, Object> result = new HashMap<String, Object>();
		String[] contentArray = text.trim().split("\n");

		reportError = "1";
		if (contentArray.length < 2) {
			return null;
		}
		String strQueryDate = contentArray[1].toString().trim();
		if (strQueryDate.indexOf("至") < 0) {
			query_start_date = strQueryDate;
			if (!isValidDate(query_start_date))
				return null;
		} else {
			String[] dateArray = strQueryDate.split("至");
			if (dateArray.length < 2) {
				return null;
			} else {
				query_start_date = dateArray[0].toString();
				query_end_date = dateArray[1].toString();
				if (!isValidDate(query_start_date))
					return null;
				if (!isValidDate(query_end_date))
					return null;
			}
		}

		result.put("query_start_date", query_start_date);
		result.put("query_end_date", query_end_date);
		reportError = "0";
		return result;
	}

	/**
	 * 查询分拣任务。返回Map
	 * 
	 * @param text
	 * @return
	 */

	public Map<String, Object> siftWorkContent4(String text) {
		Map<String, Object> result = new HashMap<String, Object>();
		String[] contentArray = text.trim().split("\n");

		reportError = "1";
		if (contentArray.length < 3) {
			return null;
		}
		String strQueryName = contentArray[1].toString().trim();
		String strQueryDate = contentArray[2].toString().trim();
		if (strQueryDate.indexOf("至") < 0) {
			query_start_date = strQueryDate;
			if (!isValidDate(query_start_date))
				return null;
		} else {
			String[] dateArray = strQueryDate.split("至");
			if (dateArray.length < 2) {
				return null;
			} else {

				query_start_date = dateArray[0].toString();
				query_end_date = dateArray[1].toString();
				if (!isValidDate(query_start_date))
					return null;
				if (!isValidDate(query_end_date))
					return null;
			}
		}

		result.put("query_start_date", query_start_date);
		result.put("query_name", strQueryName);
		result.put("query_end_date", query_end_date);
		reportError = "0";
		return result;
	}

	/**
	 * 分拣任务。返回Map
	 * 
	 * @param text
	 * @return
	 */
	public Map<String, Map<String, List<String>>> siftWorkContentV2(String text) {

		// 把传入的字符串按行解析放到List中
		List<String> lstStrings = StringUtils.readLine(text);
		if (lstStrings == null) {
			logger.info("提交的文本不合法！\n" + text);
			return null;
		}
		if (!lstStrings.get(0).contains("日报")) {
			logger.info("提交的文本不合法！\n" + text);
			return null;
		}

		int iStartToday = 0;
		int iStartTomorrow = 0;
		int iStartSubmit = 0;
		for (int i = 0; i < lstStrings.size(); i++) {
			if (lstStrings.get(i).trim().equals("今天")) {
				iStartToday = i;
			}
			if (lstStrings.get(i).trim().equals("明天")) {
				iStartTomorrow = i;

			}
			if (lstStrings.get(i).trim().equals("总结")) {
				iStartSubmit = i;
			}
		}
		if (iStartTomorrow <= 0 || iStartSubmit <= 0) {
			logger.info("提交的日报格式不符合要求");
			return null;
		}
		// 得到今天到明天之间的位置

		// 得到明天到总结之间的位置
		String stodayString = "";
		String stomorrowString = "";
		String sSubmitString = "";
		if (lstStrings.get(iStartToday++) != null) {
			for (int i = iStartToday; i < iStartTomorrow; i++) {
				stodayString = stodayString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartTomorrow++) != null) {
			for (int i = iStartTomorrow; i < iStartSubmit; i++) {
				stomorrowString = stomorrowString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartSubmit++) != null) {
			for (int i = iStartSubmit; i < lstStrings.size(); i++) {
				sSubmitString = sSubmitString + lstStrings.get(i) + "\n";
			}
		}

		if (stodayString.equals("") || stodayString == null) {
			return null;
		}
		if (stomorrowString.equals("") || stomorrowString == null) {
			return null;
		}
		if (sSubmitString.equals("") || sSubmitString == null) {
			return null;
		}
		if (sSubmitString.contains("老家隔离") || sSubmitString.contains("项目地隔离") || sSubmitString.contains("隔离结束-正常上班")
				|| sSubmitString.contains("隔离结束-等待入场") || sSubmitString.contains("隔离结束-间歇入场")) {

		} else {
			return null;
		}

		if (sSubmitString.contains("工作性质项目") || sSubmitString.contains("工作性质运维") || sSubmitString.contains("工作性质其它")) {

		} else {
			return null;
		}

		Map<String, Map<String, List<String>>> result = new LinkedHashMap<String, Map<String, List<String>>>();
		result.put("today", buildMap(stodayString));
		result.put("towarrow", buildMap(stomorrowString));
		result.put("summary", buildMap(sSubmitString));
		return result;
	}

	/**
	 * 分拣任务。返回Map
	 * 
	 * @param text
	 * @return
	 */
	public Map<String, Map<String, List<String>>> siftWorkContent1(String text) {
		Map<String, Map<String, List<String>>> result = new LinkedHashMap<String, Map<String, List<String>>>();
		String pattern = ".*今天(.*)明天(.*)总结(.*)";
		Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher m = r.matcher(text);
		if (m.find()) {
			result.put("today", buildMap(m.group(1)));
			result.put("towarrow", buildMap(m.group(2)));
			result.put("summary", buildMap(m.group(3)));
			reportError = "0";
		} else {
			reportError = "1";
		}
		return result;
	}

	/**
	 * 分拣任务。返回Map
	 * 
	 * @param text
	 * @return
	 */

	public Map<String, Map<String, List<String>>> siftWorkContent2(String text) {
		Map<String, Map<String, List<String>>> result = new LinkedHashMap<String, Map<String, List<String>>>();
		String[] contentArray = text.trim().split("\n");

		reportError = "1";
		if (contentArray.length < 3) {
			return null;
		}
		if (!isValidDate(contentArray[1].toString())) {
			return null;
		} else {
			by_date = contentArray[1].toString();
		}

		// String sysName = contentArray[2].toString();

		String strSubText = text.substring(text.indexOf(by_date) + 10, text.length());
		result.put("bydate", buildMap(strSubText));
		reportError = "0";
		return result;
	}

	/**
	 * 得到每行录入的内容放到 ReportTmplate 的内容中 参数 Map<String, List<String>>> work
	 * 
	 * @param list
	 * @return
	 */
	public static ReportTmplate initTemp2(Map<String, Map<String, List<String>>> work) {
		ReportTmplate reportTmplate = new ReportTmplate();
		// 遍历 今天 工作内容
		Map<String, List<String>> todayWork = work.get("bydate");
		// 遍历方式
		Iterator<Entry<String, List<String>>> iter = todayWork.entrySet().iterator();
		List<String> lst_bydate = new ArrayList<>();

		while (iter.hasNext()) {
			Entry<String, List<String>> entry = iter.next();
			String productName = entry.getKey();
			// System.out.println(productName);
			List<String> productWork = entry.getValue();
			for (String w : productWork) {
				// System.out.println(productName + "|" + w);
				lst_bydate.add(productName + "|" + w);
			}
		}
		reportTmplate.setLst_bydate(lst_bydate);
		reportTmplate.setBydate(ListToArray(lst_bydate));

		return reportTmplate;
	}

	/**
	 * List to Array
	 * 
	 * @param list
	 * @return
	 */
	public static String[] ListToArray(List<String> list) {
		String[] arr = list.toArray(new String[list.size()]);
		return arr;
	}

	public List<DoufuTodayWork> putString2Enty(String[] strin, WxUser sysuser, String report_datein) {

		List<DoufuTodayWork> listEntyInsert = new ArrayList<DoufuTodayWork>();
		String isAfter = "0";
		if (report_datein.equals(by_date)) {
			isAfter = "1";
		}
		if (report_datein.equals(next_date)) {
			isAfter = "2";
		}
		for (String s1 : strin) {
			int startPos = s1.indexOf("|");
			String productName = s1;
			String workContent = s1;

			// logger.info("startPos【" + startPos + "】");
			// logger.info("s1.length()-1 【" + (s1.length() - 1) + "】");

			if (startPos > 0) {
				productName = s1.substring(0, startPos);
			}
			if (startPos == 0) {
				productName = s1;
			}
			if (startPos != s1.length() - 1 && startPos != 0) {
				workContent = s1.substring(startPos + 1, s1.length());
				// logger.info("workContent【" + workContent + "】");
				// logger.info("s1 【" + s1 + "】");
			}

			String finishRate = "";
			if (s1.indexOf("[") >= 0 && s1.indexOf("]") >= 0) {
				finishRate = s1.substring(s1.indexOf("[") + 1, s1.indexOf("]"));
			}
			if (s1.indexOf("【") >= 0 && s1.indexOf("】") >= 0) {
				finishRate = s1.substring(s1.indexOf("【") + 1, s1.indexOf("】"));
			}

			if (s1.indexOf("［") >= 0 && s1.indexOf("］") >= 0) {
				finishRate = s1.substring(s1.indexOf("［") + 1, s1.indexOf("］"));
			}

			DoufuTodayWork entryDoufuTodayWork = new DoufuTodayWork();
			String uuid = UUID.randomUUID().toString();
			entryDoufuTodayWork.setId(uuid);
			entryDoufuTodayWork.setProjectGroupId(sysuser.getProjectGroupId());
			entryDoufuTodayWork.setProjectId(sysuser.getProjectGroupId());
			entryDoufuTodayWork.setCreateDate(new Date());
			entryDoufuTodayWork.setUpdateDate(new Date());
			entryDoufuTodayWork.setDelFlag(Constant.DEL_FLAG_NORMAL);
			entryDoufuTodayWork.setStatus(Constant.DEL_FLAG_NORMAL);
			entryDoufuTodayWork.setInstId(sysuser.getDept());
			entryDoufuTodayWork.setLoginIp(sysuser.getLoginIp());
			entryDoufuTodayWork.setLoginDate(new Date());
			entryDoufuTodayWork.setCreateBy(sysuser.getAccount());
			entryDoufuTodayWork.setUpdateBy(sysuser.getAccount());
			entryDoufuTodayWork.setReportDate(report_datein);
			entryDoufuTodayWork.setIsEmergency("1");
			entryDoufuTodayWork.setImpoLevel("0");
			entryDoufuTodayWork.setIsImportant("1");
			entryDoufuTodayWork.setFinishPercent(finishRate);
			entryDoufuTodayWork.setWorkContents(workContent);
			entryDoufuTodayWork.setWorkDetail(s1);
			entryDoufuTodayWork.setInputOrder(iorder++);
			entryDoufuTodayWork.setRemarks(sysuser.getName());
			entryDoufuTodayWork.setReporterName(sysuser.getAccount());
			entryDoufuTodayWork.setIsAfter(isAfter);
			entryDoufuTodayWork.setReporterId(sysuser.getId());
			entryDoufuTodayWork.setProductName(productName);

			listEntyInsert.add(entryDoufuTodayWork);
		}
		return listEntyInsert;
	}

	/**
	 * 查询后台已经提交的日报
	 * 
	 * @param msg
	 * @return
	 * @throws ParseException
	 */

	public String queryMsg(HttpServletRequest request, Map<String, Object> map) throws ParseException {
		String queryResult = null;
		String dynamicSQL = "";
		WxUser wxUser = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		if ("".equals(map.get("query_start_date")) || null == map.get("query_start_date")) {
			return null;
		} else {

		}

		if ("".equals(map.get("query_end_date")) || null == map.get("query_end_date")) {
			// queryMap.put("endDate", map.get("query_start_date"));
			dynamicSQL = "t.REPORT_DATE ='" + query_start_date + "'";
		} else {
			if (DateUtils.daysBetween(query_start_date, query_end_date) > 5)
				return "仅提供五天内查询数据，超出时间查询，请联系管理员！";
			dynamicSQL = "t.REPORT_DATE >='" + map.get("query_start_date").toString() + "' and t.REPORT_DATE <='"
					+ map.get("query_end_date").toString() + "'";
		}

		queryMap.put("reporterName", wxUser.getAccount());
		queryMap.put("dynamicSQL", dynamicSQL);
		queryMap.put("sortC", "report_date,input_order");
		queryMap.put("order", "asc");
		List<DoufuTodayWork> lstQuery = entityList(queryMap);
		if (null == lstQuery)
			return null;
		queryResult = formatRtnQueryMsg(lstQuery);
		/*
		 * for (DoufuTodayWork doufuTodayWork : lstQuery) { if (null == queryResult) {
		 * queryResult = "【" + doufuTodayWork.getReportDate() + "】" + "【" +
		 * doufuTodayWork.getProductName() + "】" + doufuTodayWork.getWorkContents(); }
		 * else { queryResult = queryResult + "\n【" + doufuTodayWork.getReportDate() +
		 * "】" + "【" + doufuTodayWork.getProductName() + "】" +
		 * doufuTodayWork.getWorkContents(); }
		 * 
		 * }
		 */
		return queryResult;

	}

	/**
	 * 根据查询出来的日报结果，构造分段显示的字符串
	 * 
	 * @param msg
	 * @return
	 * @throws ParseException
	 */

	public String formatRtnQueryMsg(List<DoufuTodayWork> lstQuery) {
		String queryResult = null;
		String strolddate = null;
		List<Map<String, List<DoufuTodayWork>>> lstMap = new ArrayList<Map<String, List<DoufuTodayWork>>>();
		List<DoufuTodayWork> lstsplit = new ArrayList<DoufuTodayWork>();
		if (null == lstQuery || lstQuery.size() == 0)
			return null;
		Map<String, List<DoufuTodayWork>> mpdayorder = new HashMap<String, List<DoufuTodayWork>>();
		for (DoufuTodayWork doufuTodayWork : lstQuery) {

			logger.info("日期Key" + doufuTodayWork.getReportDate());

			List<DoufuTodayWork> lstExist = (List<DoufuTodayWork>) mpdayorder.get(doufuTodayWork.getReportDate());
			if (null == lstExist) {
				lstExist = new ArrayList<DoufuTodayWork>();
				lstExist.add(doufuTodayWork);
				mpdayorder.put(doufuTodayWork.getReportDate(), lstExist);

			} else {
				lstExist.add(doufuTodayWork);
				mpdayorder.put(doufuTodayWork.getReportDate(), lstExist);
			}

			// strolddate = doufuTodayWork.getReportDate();
		}
		mpdayorder = sortMapByKey(mpdayorder);
		if (null == mpdayorder) {
			return null;
		}
		Set set = mpdayorder.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			List<DoufuTodayWork> lstDou = (List<DoufuTodayWork>) mpdayorder.get(key);
			// System.out.println("MAP中的日期【"+key+"】");
			if (null == queryResult) {
				queryResult = "【" + key + "】\n";
			} else {
				queryResult = queryResult + "【" + key + "】\n";
			}
			for (DoufuTodayWork dtw : lstDou) {
				queryResult = queryResult + "【" + dtw.getProductName() + "】【" + dtw.getWorkContents() + "】\n";
				// System.out.println(dtw.getWorkContents());
			}
		}
		// Iterator<Entry<String, List<DoufuTodayWork>>> iter =
		// mpdayorder.entrySet().iterator();
		logger.info(queryResult);

		return queryResult;
	}

	/**
	 * 
	 * 让 Map按key进行排序
	 * 
	 */

	public static Map<String, List<DoufuTodayWork>> sortMapByKey(Map<String, List<DoufuTodayWork>> map) {

		if (map == null || map.isEmpty()) {

			return null;

		}

		Map<String, List<DoufuTodayWork>> sortMap = new TreeMap<String, List<DoufuTodayWork>>();

		sortMap.putAll(map);

		return sortMap;

	}

	/**
	 * 查询后台已经提交的日报
	 * 
	 * @param msg
	 * @return
	 * @throws ParseException
	 */

	public List<DoufuTodayWork> queryMsgList(HttpServletRequest request, Map<String, Object> map)
			throws ParseException {
		String queryResult = null;
		String dynamicSQL = "";
		WxUser wxUserSession = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		if ("".equals(map.get("query_start_date")) || null == map.get("query_start_date")) {
			return null;
		} else {

		}

		if ("".equals(map.get("query_end_date")) || null == map.get("query_end_date")) {
			dynamicSQL = "t.REPORT_DATE ='" + query_start_date + "'";
		} else {
			dynamicSQL = "t.REPORT_DATE >='" + map.get("query_start_date").toString() + "' and t.REPORT_DATE <='"
					+ map.get("query_end_date").toString() + "'";
		}
		String queryUser = "";

		if ("".equals(map.get("query_name")) || null == map.get("query_name")) {
			queryUser = wxUserSession.getAccount();
		} else {
			if ("*".equals(map.get("query_name"))) {
				queryUser = "all";
			} else {
				WxUser wxUser2Query = weiXinUtil.getUserInfo(map.get("query_name").toString(), "NAME");
				if (null != wxUser2Query) {
					queryUser = wxUser2Query.getAccount();
				} else {
					logger.info("当前查询的用户【" + map.get("query_name").toString() + "】未在用户信息表中注册！");

				}

			}
		}
		queryMap.put("reporterName", queryUser);
		queryMap.put("dynamicSQL", dynamicSQL);
		queryMap.put("sortC", "reporter_name,input_order,create_date");
		queryMap.put("order", "asc");
		List<DoufuTodayWork> lstQuery = entityList(queryMap);
		if (null == lstQuery) {
			return null;
		} else {
			return lstQuery;

		}

	}

	/**
	 * 消息保存到数据库中
	 * 
	 * @param msg
	 * @return
	 */

	public Result saveMsg(HttpServletRequest request, ReportTmplate reportTmplate) {

		int successNumInsert = 0;
		int failureNumInsert = 0;
		WxUser wxUser = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);

		List<DoufuTodayWork> listEntytoday = new ArrayList<DoufuTodayWork>();
		List<DoufuTodayWork> listEntytomorrow = new ArrayList<DoufuTodayWork>();
		List<DoufuTodayWork> listEntysummary = new ArrayList<DoufuTodayWork>();
		List<DoufuTodayWork> listEntybydate = new ArrayList<DoufuTodayWork>();
		List<DoufuTodayWork> listEntyInsert = new ArrayList<DoufuTodayWork>();

		if (null != reportTmplate.getTodaywork() && reportTmplate.getTodaywork().length > 0) {
			logger.info("当天的日报日期【" + report_date + "】");
			listEntytoday = putString2Enty(reportTmplate.getTodaywork(), wxUser, DateUtils.DateToStr8());
		}

		if (null != reportTmplate.getTmorrowwork() && reportTmplate.getTmorrowwork().length > 0) {

			listEntytomorrow = putString2Enty(reportTmplate.getTmorrowwork(), wxUser, DateUtils.getNextDateToStr8());
		}

		if (null != reportTmplate.getSummary() && reportTmplate.getSummary().length > 0) {

			listEntysummary = putString2Enty(reportTmplate.getSummary(), wxUser, DateUtils.DateToStr8());
		}

		if (null != reportTmplate.getBydate() && reportTmplate.getBydate().length > 0) {

			listEntybydate = putString2Enty(reportTmplate.getBydate(), wxUser, by_date);
		}
		listEntyInsert.addAll(listEntytoday);
		listEntyInsert.addAll(listEntytomorrow);
		listEntyInsert.addAll(listEntysummary);
		listEntyInsert.addAll(listEntybydate);
		if (listEntyInsert != null && listEntyInsert.size() > 0) {
			// 判断by_date 是否为空，如果是补报的形式直接插入数据库，否则按当前用户及时间删除后台指定的数据。
			if (by_date.equals("")) {
				Map<String, Object> params = new HashMap();
				params.put("reportDate", DateUtils.DateToStr8());
				params.put("reporterName", wxUser.getAccount());
				deleteByParams(params);
				params.put("reportDate", DateUtils.getNextDateToStr8());
				params.put("reporterName", wxUser.getAccount());
				deleteByParams(params);

			}

			successNumInsert = insertBatch(listEntyInsert);
		}
		return new Result(1, "操作成功！，成功保存" + successNumInsert + "条，失败保存" + failureNumInsert + "条");

	}

	/**
	 * 针对用户前台操作的事件来进行处理
	 * 
	 * @param msg
	 * @return
	 */

	public String dealEvent(HttpServletRequest request, String strEvenKey) {
		String strRtn = null;
		logger.info("#=================用户对小应用进行操作，如删除用户等事件通知：========================#");
		logger.info("#=================事件为：========================#\n" + strEvenKey);

		return strRtn;

	}

	/**
	 * 查询未提交的人员列表
	 * 
	 * @param params
	 * @return
	 */
	public List<CommonEntity> queryNotCommitUser(Map<String, Object> params) {
		logger.info("#=================根据条件查询未提交日报的人员列表========================#");
		return doufuTodayWorkMapper.queryNotCommitUser(params);
	}

	/**
	 * 查询指定人员指定时间段提交的日期列表
	 * 
	 * @param params
	 * @return
	 */
	public List<CommonEntity> getReportDateList(Map<String, Object> params) {
		logger.info("#=================根据条件查询提交日报的日期列表========================#");
		return doufuTodayWorkMapper.getReportDateList(params);
	}

	/**
	 * 补报报文存在日志表中
	 * 
	 * @param params
	 * @return
	 */
	public String saveOperReportLogBB(String msgType, String content, HttpServletRequest request) {

		// 把传入的字符串按行解析放到List中
		String yqztString = ""; // 疫情工作状态
		String isBuBaoFlag = "1";
		String reportDateString = "";
		List<String> lstStrings = StringUtils.readLine(content);
		if (lstStrings == null) {
			logger.info("提交的文本不合法！\n" + content);
			return null;
		}
		if (!lstStrings.get(0).trim().contains("补报")){
			logger.info("提交的文本不合法，未包含[补报]\"！\n" + content);
			return null;
		}

		if (lstStrings.get(1).toString().equals("")) {
			logger.info("提交的文本不合法，第二行没有写上补报的日期！\n" + content);
			return null;
		} else {
			 
			if (!isValidDate(lstStrings.get(1).toString())) {
				logger.info("提交的文本中日期不合法，补报的日期格式不是日期类型！\n" + content);
				return null;
			} else {
				reportDateString = lstStrings.get(1).toString().trim();
			}
		}

		int iStartToday = 1;
		int iStartTomorrow = 0;
		int iStartSubmit = 0;
		for (int i = 0; i < lstStrings.size(); i++) {
			if (lstStrings.get(i).equals("明天")) {
				iStartTomorrow = i;

			}
			if (lstStrings.get(i).trim().equals("总结")) {
				iStartSubmit = i;
			}
		}
		if (iStartTomorrow <= 0 || iStartSubmit <= 0) {
			logger.info("提交的日报格式不符合要求");
			return null;
		}
		// 得到今天到明天之间的位置

		// 得到明天到总结之间的位置
		String stodayString = "";
		String stomorrowString = "";
		String sSubmitString = "";
		if (lstStrings.get(iStartToday++) != null) {
			for (int i = iStartToday; i < iStartTomorrow; i++) {
				stodayString = stodayString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartTomorrow++) != null) {
			for (int i = iStartTomorrow; i < iStartSubmit; i++) {
				stomorrowString = stomorrowString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartSubmit++) != null) {
			for (int i = iStartSubmit; i < lstStrings.size(); i++) {
				sSubmitString = sSubmitString + lstStrings.get(i) + "\n";
			}
		}

		if (stodayString.equals("") || stodayString == null) {
			return null;
		}
		if (stomorrowString.equals("") || stomorrowString == null) {
			return null;
		}
		if (sSubmitString.equals("") || sSubmitString == null) {
			return null;
		}
		if (sSubmitString.contains("老家隔离") || sSubmitString.contains("项目地隔离") || sSubmitString.contains("隔离结束-正常上班")
				|| sSubmitString.contains("隔离结束-等待入场") || sSubmitString.contains("隔离结束-间歇入场")) {

		} else {
			return null;
		}
		if (sSubmitString.contains("工作性质项目") || sSubmitString.contains("工作性质运维") || sSubmitString.contains("工作性质其它")) {

		} else {
			return null;
		}

		if (sSubmitString.contains("老家隔离")) {
			yqztString = "老家隔离";
		}
		if (sSubmitString.contains("项目地隔离")) {
			yqztString = "项目地隔离";
		}
		if (sSubmitString.contains("隔离结束-正常上班")) {
			yqztString = "隔离结束-正常上班";
		}

		if (sSubmitString.contains("隔离结束-等待入场")) {
			yqztString = "隔离结束-等待入场";
		}
		if (sSubmitString.contains("隔离结束-间歇入场")) {
			yqztString = "隔离结束-间歇入场";
		}
		String gzxString = "工作性质其它";
		if (sSubmitString.contains("工作性质项目")) {
			gzxString = "工作性质项目";
		}
		if (sSubmitString.contains("工作性质运维")) {
			gzxString = "工作性质运维";
		}
		if (sSubmitString.contains("工作性质其它")) {
			gzxString = "工作性质其它";
		}
		String rtnString = "";
		QywxUserOperatelog qywxUserOperatelog = new QywxUserOperatelog();
		qywxUserOperatelog.setId(UUID.randomUUID().toString());
		qywxUserOperatelog.setMessType("text");
		WxUser wxUserSession = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
		qywxUserOperatelog.setCreateBy(wxUserSession.getName());
		qywxUserOperatelog.setCreateTime(new Date());
		qywxUserOperatelog.setUpdateBy(wxUserSession.getName());
		qywxUserOperatelog.setMessFromIp(wxUserSession.getLoginIp());
		qywxUserOperatelog.setSubmitText(content);
		qywxUserOperatelog.setUpdateTime(new Date());
		qywxUserOperatelog.setReportDate(reportDateString);
		qywxUserOperatelog.setUserAccount(wxUserSession.getAccount());
		qywxUserOperatelog.setGroupCode(wxUserSession.getProjectGroupId());
		qywxUserOperatelog.setRemark(yqztString + ";" + gzxString);
		qywxUserOperatelog.setOperType("1");
		qywxUserOperatelog.setReportType(isBuBaoFlag);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operType", "1");
		params.put("reportDate", DateUtils.DateToStr8());
		params.put("userAccount", wxUserSession.getAccount());
		params.put("reportType", qywxUserOperatelog.getReportType());
		params.put("submitText", content);
		qywxUserOperatelogService.deleteByParams(params);
		qywxUserOperatelogService.insertQywxUserOperatelog(qywxUserOperatelog);
		return rtnString;

	}

	public String saveOperReportLog(String msgType, String content, HttpServletRequest request) {
		// 把传入的字符串按行解析放到List中
		String yqztString = ""; // 疫情工作状态
		String isBuBaoFlag = "0";
		List<String> lstStrings = StringUtils.readLine(content);
		if (lstStrings == null) {
			logger.info("提交的文本不合法！\n" + content);
			return null;
		}
		if (!lstStrings.get(0).contains("日报")) {
			logger.info("提交的文本不合法！\n" + content);
			return null;
		}

		int iStartToday = 0;
		int iStartTomorrow = 0;
		int iStartSubmit = 0;
		for (int i = 0; i < lstStrings.size(); i++) {
			if (lstStrings.get(i).trim().equals("今天")) {
				iStartToday = i;
			}
			if (lstStrings.get(i).equals("明天")) {
				iStartTomorrow = i;

			}
			if (lstStrings.get(i).trim().equals("总结")) {
				iStartSubmit = i;
			}
		}
		if (iStartTomorrow <= 0 || iStartSubmit <= 0) {
			logger.info("提交的日报格式不符合要求");
			return null;
		}
		// 得到今天到明天之间的位置

		// 得到明天到总结之间的位置
		String stodayString = "";
		String stomorrowString = "";
		String sSubmitString = "";
		if (lstStrings.get(iStartToday++) != null) {
			for (int i = iStartToday; i < iStartTomorrow; i++) {
				stodayString = stodayString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartTomorrow++) != null) {
			for (int i = iStartTomorrow; i < iStartSubmit; i++) {
				stomorrowString = stomorrowString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartSubmit++) != null) {
			for (int i = iStartSubmit; i < lstStrings.size(); i++) {
				sSubmitString = sSubmitString + lstStrings.get(i) + "\n";
			}
		}

		if (stodayString.equals("") || stodayString == null) {
			return null;
		}
		if (stomorrowString.equals("") || stomorrowString == null) {
			return null;
		}
		if (sSubmitString.equals("") || sSubmitString == null) {
			return null;
		}
		if (sSubmitString.contains("老家隔离") || sSubmitString.contains("项目地隔离") || sSubmitString.contains("隔离结束-正常上班")
				|| sSubmitString.contains("隔离结束-等待入场") || sSubmitString.contains("隔离结束-间歇入场")) {

		} else {
			return null;
		}
		if (sSubmitString.contains("工作性质项目") || sSubmitString.contains("工作性质运维") || sSubmitString.contains("工作性质其它")) {

		} else {
			return null;
		}

		if (sSubmitString.contains("老家隔离")) {
			yqztString = "老家隔离";
		}
		if (sSubmitString.contains("项目地隔离")) {
			yqztString = "项目地隔离";
		}
		if (sSubmitString.contains("隔离结束-正常上班")) {
			yqztString = "隔离结束-正常上班";
		}

		if (sSubmitString.contains("隔离结束-等待入场")) {
			yqztString = "隔离结束-等待入场";
		}
		if (sSubmitString.contains("隔离结束-间歇入场")) {
			yqztString = "隔离结束-间歇入场";
		}
		String gzxString = "工作性质其它";
		if (sSubmitString.contains("工作性质项目")) {
			gzxString = "工作性质项目";
		}
		if (sSubmitString.contains("工作性质运维")) {
			gzxString = "工作性质运维";
		}
		if (sSubmitString.contains("工作性质其它")) {
			gzxString = "工作性质其它";
		}
		String rtnString = "";
		QywxUserOperatelog qywxUserOperatelog = new QywxUserOperatelog();
		qywxUserOperatelog.setId(UUID.randomUUID().toString());
		qywxUserOperatelog.setMessType("text");
		WxUser wxUserSession = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
		qywxUserOperatelog.setCreateBy(wxUserSession.getName());
		qywxUserOperatelog.setCreateTime(new Date());
		qywxUserOperatelog.setUpdateBy(wxUserSession.getName());
		qywxUserOperatelog.setMessFromIp(wxUserSession.getLoginIp());
		qywxUserOperatelog.setSubmitText(content);
		qywxUserOperatelog.setUpdateTime(new Date());
		qywxUserOperatelog.setReportDate(DateUtils.DateToStr8());
		qywxUserOperatelog.setUserAccount(wxUserSession.getAccount());
		qywxUserOperatelog.setGroupCode(wxUserSession.getProjectGroupId());
		qywxUserOperatelog.setRemark(yqztString + ";" + gzxString);
		qywxUserOperatelog.setOperType("1");
		qywxUserOperatelog.setReportType(isBuBaoFlag);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operType", "1");
		params.put("reportDate", DateUtils.DateToStr8());
		params.put("userAccount", wxUserSession.getAccount());
		params.put("reportType", qywxUserOperatelog.getReportType());
		params.put("submitText", content);
		qywxUserOperatelogService.deleteByParams(params);
		qywxUserOperatelogService.insertQywxUserOperatelog(qywxUserOperatelog);
		return rtnString;
	}

	/*
	 * 构造日报的数据内容
	 * 
	 */
	public List<Map<String, Object>> getDataListDayReportV2(HttpServletRequest request, Map<String, Object> map)
			throws ParseException {

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		String queryResult = null;
		String dynamicSQL = "";
		WxUser wxUserSession = (WxUser) request.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		if ("".equals(map.get("query_start_date")) || null == map.get("query_start_date")) {
			return null;
		} else {

		}

		if ("".equals(map.get("query_end_date")) || null == map.get("query_end_date")) {
			dynamicSQL = "t.REPORT_DATE ='" + query_start_date + "'";
		} else {
			dynamicSQL = "t.REPORT_DATE >='" + map.get("query_start_date").toString() + "' and t.REPORT_DATE <='"
					+ map.get("query_end_date").toString() + "'";
		}
		String queryUser = "";

		if ("".equals(map.get("query_name")) || null == map.get("query_name")) {
			queryUser = wxUserSession.getAccount();
		} else {
			if ("*".equals(map.get("query_name"))) {
				queryUser = "";
			} else {
				WxUser wxUser2Query = weiXinUtil.getUserInfo(map.get("query_name").toString(), "NAME");
				if (null != wxUser2Query) {
					queryUser = wxUser2Query.getAccount();
				} else {
					logger.info("当前查询的用户【" + map.get("query_name").toString() + "】未在用户信息表中注册！");

				}

			}
		}
		queryMap.put("userAccount", queryUser);
		queryMap.put("operType", "1");
		queryMap.put("dynamicSQL", dynamicSQL);
		queryMap.put("sortC", "create_by,report_date");
		queryMap.put("order", "asc");
		List<QywxUserOperatelog> listDayWork = qywxUserOperatelogService.entityList(queryMap);
		// 遍历所有行。
		for (int i = 0; i < listDayWork.size(); i++) {
			QywxUserOperatelog qywxUserOperatelog = listDayWork.get(i);

			
			Map<String, Object> mpcolumn = new HashMap<String, Object>();
			mpcolumn.put("order", String.valueOf(i + 1));
			mpcolumn.put("remarks", qywxUserOperatelog.getUpdateBy());
			mpcolumn.put("reportDate", qywxUserOperatelog.getReportDate());


			mpcolumn.put("workContents", qywxUserOperatelog.getSubmitText());
			Map<String,Object> mpBlock  = new HashMap<String,Object>();
			if(qywxUserOperatelog.getReportType().equals("0")) {
				mpBlock= getBlockString01( qywxUserOperatelog.getSubmitText().toString());
			}
			if(qywxUserOperatelog.getReportType().equals("1")) {
				mpBlock = getBlockString02( qywxUserOperatelog.getSubmitText().toString() );
			}
			if(mpBlock!=null) {
				mpcolumn.put("today", mpBlock.get("today"));
				mpcolumn.put("tomorrow", mpBlock.get("tomorrow"));
			}else {
				mpcolumn.put("today", qywxUserOperatelog.getSubmitText().toString());
			}
			
			if(qywxUserOperatelog.getRemark()!=null ||!qywxUserOperatelog.getRemark().trim().equals("")) {
			List<String> lstList= listRemark(qywxUserOperatelog.getRemark());
			if(lstList.size()==2) {
			mpcolumn.put("yqzt", lstList.get(0));
			mpcolumn.put("gzxz", lstList.get(1));
			}else {
				mpcolumn.put("yqzt", lstList.get(0));
				mpcolumn.put("gzxz", "");				
			}
			}
			dataList.add(mpcolumn);
		}
		return dataList;
	}
	
public List<String> listRemark(String remarkString){
	String[] strSplitStrings = remarkString.split(";");
	 List<String> list = Arrays.asList(strSplitStrings);
	 return list;
	
}


/**
 * 补报报文分段切割
 * 
 * @param params
 * @return
 */
public Map<String,Object> getBlockString02( String content ) {

 Map<String,Object> mpRtn = new HashMap();
 String reportDateString = "";
	// 把传入的字符串按行解析放到List中
	List<String> lstStrings = StringUtils.readLine(content);
	if (lstStrings == null) {
		logger.info("要分解的报文不合法！\n" + content);
		return null;
	}
	if (!lstStrings.get(0).trim().contains("补报")) {
		logger.info("提交的文本不合法，未包含[补报]\"！\n" + content);
		return null;
	}

	if (lstStrings.get(1).toString().equals("")) {
		logger.info("提交的文本不合法，第二行没有写上补报的日期！\n" + content);
		return null;
	} else {
		if (!isValidDate(lstStrings.get(1).toString())) {
			logger.info("提交的文本中日期不合法，补报的日期格式不是日期类型！\n" + content);
			return null;
		} else {
			reportDateString = lstStrings.get(1).toString().trim();
		}
	}

	int iStartToday = 1;
	int iStartTomorrow = 0;
	int iStartSubmit = 0;
	for (int i = 0; i < lstStrings.size(); i++) {
		if (lstStrings.get(i).equals("明天")) {
			iStartTomorrow = i;

		}
		if (lstStrings.get(i).trim().equals("总结")) {
			iStartSubmit = i;
		}
	}
	if (iStartTomorrow <= 0 || iStartSubmit <= 0) {
		logger.info("提交的日报格式不符合要求");
		return null;
	}
	// 得到今天到明天之间的位置

	// 得到明天到总结之间的位置
	String stodayString = "";
	String stomorrowString = "";
	String sSubmitString = "";
	if (lstStrings.get(iStartToday++) != null) {
		for (int i = iStartToday; i < iStartTomorrow; i++) {
			stodayString = stodayString + lstStrings.get(i) + "\n";
		}
	}
	if (lstStrings.get(iStartTomorrow++) != null) {
		for (int i = iStartTomorrow; i < iStartSubmit; i++) {
			stomorrowString = stomorrowString + lstStrings.get(i) + "\n";
		}
	}
	if (lstStrings.get(iStartSubmit++) != null) {
		for (int i = iStartSubmit; i < lstStrings.size(); i++) {
			sSubmitString = sSubmitString + lstStrings.get(i) + "\n";
		}
	}

	if (stodayString.equals("") || stodayString == null) {
		return null;
	}
	if (stomorrowString.equals("") || stomorrowString == null) {
		return null;
	}
	if (sSubmitString.equals("") || sSubmitString == null) {
		return null;
	}
	mpRtn.put("today", stodayString);
	mpRtn.put("tomorrow", stomorrowString);
	mpRtn.put("submit", sSubmitString);
return mpRtn;
}


/**
 * 补报报文分段切割
 * 
 * @param params
 * @return
 */
public Map<String,Object> getBlockString01( String content ) {

 Map<String,Object> mpRtn = new HashMap();
 String reportDateString = "";
		List<String> lstStrings = StringUtils.readLine(content);
		if (lstStrings == null) {
			logger.info("提交的文本不合法！\n" + content);
			return null;
		}
		if (!lstStrings.get(0).contains("日报")) {
			logger.info("提交的文本不合法,第一行未包含日报！\n" + content);
			return null;
		}

		int iStartToday = 0;
		int iStartTomorrow = 0;
		int iStartSubmit = 0;
		for (int i = 0; i < lstStrings.size(); i++) {
			if (lstStrings.get(i).trim().equals("今天")) {
				iStartToday = i;
			}
			if (lstStrings.get(i).equals("明天")) {
				iStartTomorrow = i;

			}
			if (lstStrings.get(i).trim().equals("总结")) {
				iStartSubmit = i;
			}
		}
		if (iStartTomorrow <= 0 || iStartSubmit <= 0) {
			logger.info("提交的日报格式不符合要求");
			return null;
		}
		// 得到今天到明天之间的位置

		// 得到明天到总结之间的位置
		String stodayString = "";
		String stomorrowString = "";
		String sSubmitString = "";
		if (lstStrings.get(iStartToday++) != null) {
			for (int i = iStartToday; i < iStartTomorrow; i++) {
				stodayString = stodayString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartTomorrow++) != null) {
			for (int i = iStartTomorrow; i < iStartSubmit; i++) {
				stomorrowString = stomorrowString + lstStrings.get(i) + "\n";
			}
		}
		if (lstStrings.get(iStartSubmit++) != null) {
			for (int i = iStartSubmit; i < lstStrings.size(); i++) {
				sSubmitString = sSubmitString + lstStrings.get(i) + "\n";
			}
		}

		if (stodayString.equals("") || stodayString == null) {
			return null;
		}
		if (stomorrowString.equals("") || stomorrowString == null) {
			return null;
		}
		if (sSubmitString.equals("") || sSubmitString == null) {
			return null;
		}

	
	mpRtn.put("today", stodayString);
	mpRtn.put("tomorrow", stomorrowString);
	mpRtn.put("submit", sSubmitString);
return mpRtn;
}


/*
 * 个人工作浏览查看个人提交数据
 * 
 */
public 	 String  getPersonCommit(Map<String, Object> queryMap) {
	List<String> lstJson = new ArrayList<String>();

	JSONObject jsonRJsonObject2= new JSONObject();
	List<QywxUserOperatelog> listDayWork = qywxUserOperatelogService.entityList(queryMap);
	
	if(listDayWork==null||listDayWork.size()==0) {
		return null;
	}
	// 遍历所有行。
	for (int i = 0; i < listDayWork.size(); i++) {
		QywxUserOperatelog qywxUserOperatelog = listDayWork.get(i);
		JSONObject jsonRtnJsonObject = new JSONObject();
		Map<String,Object> mpBlock  = new HashMap<String,Object>();
		if(qywxUserOperatelog.getReportType().equals("0")) {
			mpBlock= getBlockString01( qywxUserOperatelog.getSubmitText().toString());
			jsonRtnJsonObject.put("reporttype", "正常提交");
		}
		if(qywxUserOperatelog.getReportType().equals("1")) {
			mpBlock = getBlockString02( qywxUserOperatelog.getSubmitText().toString() );
			jsonRtnJsonObject.put("reporttype", "补报提交");
		}
		if(mpBlock!=null) {
			jsonRtnJsonObject.put("today", mpBlock.get("today"));
			jsonRtnJsonObject.put("tomorrow",mpBlock.get("tomorrow"));
		}else {
			jsonRtnJsonObject.put("today", qywxUserOperatelog.getSubmitText().toString());
		}
		lstJson.add(jsonRtnJsonObject.toString());
	}
	
	return JSON.toJSON(lstJson).toString();
}

}
