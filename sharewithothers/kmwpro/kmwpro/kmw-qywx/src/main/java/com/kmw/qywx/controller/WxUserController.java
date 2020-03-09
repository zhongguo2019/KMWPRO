package com.kmw.qywx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;
import com.kmw.common.annotation.Log;
import com.kmw.common.enums.BusinessType;
import com.kmw.qywx.domain.WxDepartment;
import com.kmw.qywx.domain.WxUser;
import com.kmw.qywx.service.IWxDepartmentService;
import com.kmw.qywx.service.IWxUserGroupRelationService;
import com.kmw.qywx.service.IWxUserService;
import com.kmw.qywx.service.impl.WxDepartmentServiceImpl;
import com.kmw.qywx.utils.ContactsDepartmentService;
import com.kmw.qywx.utils.ContactsUserService;
import com.kmw.qywx.utils.User;
import com.kmw.qywx.utils.WeiXinParamesUtil;
import com.kmw.qywx.utils.WeiXinUtil;

import net.sf.json.JSONObject;

import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 企业微信用户信息Controller
 * 
 * @author kmw
 * @date 2020-02-20
 */
@Controller
@RequestMapping("/qywx/user")
public class WxUserController extends BaseController {
	private String prefix = "qywx/user";

	@Autowired
	private IWxUserService wxUserService;

	@Autowired
	ContactsUserService contactsUserService;

	@Autowired
	IWxDepartmentService wxDepartmentService;
	
	@Autowired
	IWxUserGroupRelationService wxUserGroupRelationService;

	@Autowired
	ContactsDepartmentService contactsDepartmentService;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@RequiresPermissions("qywx:user:view")
	@GetMapping()
	public String user() {
		return prefix + "/user";
	}

	/**
	 * 查询企业微信用户信息列表
	 */
	@RequiresPermissions("qywx:user:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WxUser wxUser) {
		startPage();
		List<WxUser> list = wxUserService.selectWxUserList(wxUser);
		return getDataTable(list);
	}

	/**
	 * 导出企业微信用户信息列表
	 */
	@RequiresPermissions("qywx:user:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(WxUser wxUser) {
		List<WxUser> list = wxUserService.selectWxUserList(wxUser);
		ExcelUtil<WxUser> util = new ExcelUtil<WxUser>(WxUser.class);
		return util.exportExcel(list, "user");
	}

	/**
	 * 新增企业微信用户信息
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存企业微信用户信息
	 */
	@RequiresPermissions("qywx:user:add")
	@Log(title = "企业微信用户信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WxUser wxUser) {
		return toAjax(wxUserService.insertWxUser(wxUser));
	}

	/**
	 * 修改企业微信用户信息
	 */
	@GetMapping("/edit/{name}")
	public String edit(@PathVariable("name") String name, ModelMap mmap) {
		WxUser wxUser = wxUserService.selectWxUserById(name);
		mmap.put("wxUser", wxUser);
		return prefix + "/edit";
	}

	/**
	 * 修改保存企业微信用户信息
	 */
	@RequiresPermissions("qywx:user:edit")
	@Log(title = "企业微信用户信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WxUser wxUser) {
		return toAjax(wxUserService.updateWxUser(wxUser));
	}

	/**
	 * 按Map参数据查询，得到公共实体后分页
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "queryPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo PageInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 企业微信用户信息 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}

		PageInfo<CommonEntity> page = wxUserService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示 企业微信用户信息 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = wxUserService.commonList(params);
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
		logger.info("【通用实体查询】 企业微信用户信息 ，Map参数：" + params.toString());
		CommonEntity commonEntity = wxUserService.queryOne(params);
		return commonEntity;

	}

	/**
	 * 删除企业微信用户信息
	 */
	@RequiresPermissions("qywx:user:remove")
	@Log(title = "企业微信用户信息", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(wxUserService.deleteWxUserByIds(ids));
	}

	/**
	 * 同步企业微信中的用户信息
	 */
	@PostMapping("/synchronizeQywxUser")
	@ResponseBody
	public AjaxResult synchronizeQywxUser() {
		String accessToken = WeiXinUtil.getAccessToken(WeiXinParamesUtil.corpId, WeiXinParamesUtil.agentSecret)
				.getToken();
		// 得到部门及子部门的人员信息
		String departmentId = "1";
		String fetchChild = "0";

		JSONObject deptJsonObject = contactsDepartmentService.getDepartmentList(accessToken, departmentId);
		if (Integer.parseInt(deptJsonObject.get("errcode").toString()) == 0) {

			JSONArray jsonDeptArray = JSON.parseArray(deptJsonObject.get("department").toString());
			List<WxDepartment> lstWxDepartments = new ArrayList<WxDepartment>();

			for (int i = 0; i < jsonDeptArray.size(); i++) {
				WxDepartment wxDepartment = new WxDepartment();
				Object o = jsonDeptArray.get(i);
				JSONObject jsonObjectDept = JSONObject.fromObject(o);
				wxDepartment.setId(UUID.randomUUID().toString());
				wxDepartment.setDepartOrder(jsonObjectDept.get("order").toString());
				wxDepartment.setDepartId(jsonObjectDept.get("id").toString());
				wxDepartment.setDepartName(jsonObjectDept.get("name").toString());
				wxDepartment.setDepartParentId(jsonObjectDept.get("parentid").toString());
				lstWxDepartments.add(wxDepartment);

			}
			wxDepartmentService.deleteAll();
			wxDepartmentService.insertBatch(lstWxDepartments);
		}

		JSONObject userJsonObject = contactsUserService.getDepartmentUserDetails(accessToken, departmentId, fetchChild);

		if (Integer.parseInt(userJsonObject.get("errcode").toString()) == 0) {

			JSONArray jsonArray = JSON.parseArray(userJsonObject.get("userlist").toString());
			List<WxUser> lstWxUsers = new ArrayList<WxUser>();

			for (int i = 0; i < jsonArray.size(); i++) {
				WxUser wxUser = new WxUser();
				Object o = jsonArray.get(i);
				JSONObject jsonObject2 = JSONObject.fromObject(o);
				Map<String, Object>  params1 = new HashMap<String, Object>();
				params1.put("userUaccount", jsonObject2.get("userid").toString());
			//在企业微信关系表中查到部门相关的信息
			CommonEntity  entityRelationCommonEntity = 	wxUserGroupRelationService.queryOne(params1);
			if(null ==entityRelationCommonEntity ) {
				wxUser.setProjectGroupId("NOTDEFINED");
			}else {
				wxUser.setProjectGroupId(entityRelationCommonEntity.get("GROUP_GCODE").toString());
			}
				wxUser.setAccount(jsonObject2.get("userid").toString());
				wxUser.setName(jsonObject2.get("name").toString());
				wxUser.setEmail(jsonObject2.get("email").toString());
				wxUser.setMobile(jsonObject2.get("mobile").toString());
				wxUser.setSex(jsonObject2.get("gender").toString());
				JSONArray jsonArrayDeptArray = JSON.parseArray(jsonObject2.get("department").toString());
				String deptNameString="";
				for (int ii = 0; ii < jsonArrayDeptArray.size(); ii++) {
					 
					Map<String, Object>  params = new HashMap<String, Object>();
					params.put("departId", jsonArrayDeptArray.get(ii));
					CommonEntity wxDepartmentOne  =  wxDepartmentService.queryOne(params);
					if(wxDepartmentOne !=null) {
						deptNameString = deptNameString+wxDepartmentOne.getString("depart_name")+";";
					}
				}
				wxUser.setDept(deptNameString);
				wxUser.setId(UUID.randomUUID().toString());
				lstWxUsers.add(wxUser);
				
				
			}
			wxUserService.deleteAll();
			wxUserService.insertBatch(lstWxUsers);
		}
		return toAjax(1);
	}

}
