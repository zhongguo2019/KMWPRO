package com.kmw.qywx.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.kmw.common.CommonEntity;
import com.kmw.common.utils.DateUtils;
import com.kmw.qywx.domain.WxUser;
import com.kmw.qywx.domain.WxUserGroup;
import com.kmw.qywx.service.IDoufuTodayWorkService;
import com.kmw.qywx.service.IWxUserGroupService;
import com.kmw.qywx.service.IWxUserService;

@Component("inforQuaterz")
public class InforQuaterz {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IDoufuTodayWorkService doufuTodayWorkService;
	@Autowired
	IWxUserGroupService wxUserGroupService;
	@Autowired
	IWxUserService wxUserService;
    @Autowired
    WeiXinUtil weiXinUtil;
	public InforQuaterz() {
	}

	public void queryNotCommitByGroupName() {

		// 得到分组信息表中所有要通知到的小组信息
		List<WxUserGroup> listGroutGroups = queryAllGroup();
		Map<String, Object> mpMap = new HashMap<>();
		if (null == listGroutGroups || listGroutGroups.size() == 0)
			return;
		
		// 得到所有组里的用户信息
		for (int i = 0; i < listGroutGroups.size(); i++) {
			WxUserGroup wxUserGroup = listGroutGroups.get(i);
			WxUser wxUser = new WxUser();
			wxUser.setDept(wxUserGroup.getGroupCname());
			List<WxUser> listWxUsers = wxUserService.selectWxUserList(wxUser);
			mpMap.put(wxUserGroup.getGroupCode(), listWxUsers);
		}

		if (mpMap.size() == 0) {
			return;
		}
		
		// 按组分析日报的未提交情况
		for (String key : mpMap.keySet()) {
			List<WxUser> value = (List<WxUser>) mpMap.get(key);
			System.out.println(key + ":" + value);
		}

	}
//每隔一小时更新一下Redis中的token
	public void changeRedisToken() {
		logger.info("定时更新redis中的token!");
		weiXinUtil.setRedisToken();
		
	}
	
	/**
	 * 根据用户分组通知的INSTID发通知消息
	 */
	public void queryNotCommitByGroupNameV1() {

		String reportToday = DateUtils.DateToStr8();
		String reportPreday = DateUtils.getPreDateByDate8(reportToday);
		
		// 得到分组信息表中所有要通知到的小组信息
		List<WxUserGroup> listGroutGroups = queryAllGroup();
 		if (null == listGroutGroups || listGroutGroups.size() == 0)
			return;
		// 得到所有组里的用户信息
		for (int i = 0; i < listGroutGroups.size(); i++) {
			WxUserGroup wxUserGroup = listGroutGroups.get(i);
			WxUser wxUser = new WxUser();
			wxUser.setDept(wxUserGroup.getGroupCname());
		    String infoMsgString=queryNotCommitUser(wxUserGroup.getGroupCode(),wxUserGroup.getGroupCname(),wxUserGroup.getUserCode(),reportPreday);
		    if(infoMsgString == null ) continue;
		    logger.info("根据各项目组查询后台未提交的用户得到的通知消息：\n"+infoMsgString);
		    weiXinUtil.SendTextcardMessage("",wxUserGroup.getInstId(),infoMsgString);
		}
	}
	
	/**
	 * 根据消息用户接收的人员进行通知
	 */
	public void queryNotCommitByGroupNameV2() {

		String reportToday = DateUtils.DateToStr8();
		String reportPreday = DateUtils.getPreDateByDate8(reportToday);
		
		// 得到分组信息表中所有要通知到的小组信息
		List<WxUserGroup> listGroutGroups = queryAllGroup();
 		if (null == listGroutGroups || listGroutGroups.size() == 0)
			return;
		// 得到所有组里的用户信息
		for (int i = 0; i < listGroutGroups.size(); i++) {
			WxUserGroup wxUserGroup = listGroutGroups.get(i);
			if(wxUserGroup.getGroupCname()==null||wxUserGroup.getGroupCode()==null) continue;
			WxUser wxUser = new WxUser();
			wxUser.setDept(wxUserGroup.getGroupCname());
			
		    String infoMsgString=queryNotCommitUser(wxUserGroup.getGroupCode(),wxUserGroup.getGroupCname(),wxUserGroup.getUserCode(),reportPreday);
		    if(infoMsgString == null ) continue;
		    logger.info("根据各项目组查询后台未提交的用户得到的通知消息：\n"+infoMsgString);
//		    weiXinUtil.SendTextcardMessage("",wxUserGroup.getInstId(),infoMsgString);
		    weiXinUtil.SendTextcardMessage(wxUserGroup.getUserCode(),"",infoMsgString);
		    
		}
	}

	// 所有分组信息
	public List<WxUserGroup> queryAllGroup() {
		Map<String, Object> params = new HashMap<String, Object>();
		/*
		 * WxUserGroup wxUserGroup = new WxUserGroup(); List<WxUserGroup> list =
		 * wxUserGroupService.selectWxUserGroupList(wxUserGroup);
		 */	
		params.put("isMsg", "1");
		List<WxUserGroup> list = wxUserGroupService.entityList(params);
		return list;
	}

	// 根据组的中文名称得到分组表中的一个分组信息
	public WxUserGroup queryOneGroupByName(String groupName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupCname", groupName);
		List<WxUserGroup> list = wxUserGroupService.entityList(params);
		return list.get(0);
	}

	public List<Map<String, Object>> getInfoUser() {
		List<Map<String, Object>> mplist = new ArrayList<Map<String, Object>>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isMsg", "1");

		List<WxUserGroup> lst = wxUserGroupService.entityList(params);
		if (null == lst) {
			return null;
		}
		for (int i = 0; i < lst.size(); i++) {
			WxUserGroup wxUserGroup = lst.get(i);
			logger.info("负责人代码【" + wxUserGroup.getUserCode() + "】" + "负责人姓名【" + wxUserGroup.getUsername() + "】"
					+ "负责小组名称【" + wxUserGroup.getGroupCname() + "】");
			String wxGroupName = wxUserGroup.getGroupCname();
			Map<String, Object> infUser = new HashMap<String, Object>();
			infUser.put("userCode", wxUserGroup.getUserCode());
			infUser.put("instid", wxUserGroup.getInstId());
			if ("".equals(wxGroupName) || null == wxGroupName) {

			} else {
				List<String> lstGroupName = splitGroupName(wxGroupName);
				infUser.put("groupList", lstGroupName);

			}
			mplist.add(infUser);

		}

		return mplist;
	}

	public List<String> splitGroupName(String groupName) {
		String[] strSplit = groupName.split("\\|");

		List<String> lst = Arrays.asList(strSplit);

		return lst;

	}

	public String queryNotCommitUser(String groupCode, String groupName,String reportTo,String reportdate) {
		String strRtn = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupCode", groupCode);
		params.put("reportTo", reportTo);
		params.put("reportDate", reportdate);
		List<CommonEntity> lst = doufuTodayWorkService.queryNotCommitUser(params);
		String userName, userAccount;
		if(lst ==null ) return null;
		
		if (lst.size() != 0) {
			for (int i = 0; i < lst.size(); i++) {
				Map<String, Object> mpGroupName = (Map<String, Object>) lst.get(i);
				userName = mpGroupName.get("name").toString();
				userAccount = mpGroupName.get("account").toString();
				if (i == 0) {
					strRtn = userName;
				} else {
					strRtn = strRtn + "、" + userName;
				}

			}
			if (!"".equals(strRtn)) {
				strRtn = "项目组：【" + groupName + "】日期：【" + reportdate + "】\n未提交日报人员：\n" + strRtn + "\n请及时通知本人，尽快补上！";
			}
		} else {
			strRtn = "项目组：【" + groupName + "】日期：【" + reportdate + "】 日报全部提交！";
		}

		return strRtn;

	}

}