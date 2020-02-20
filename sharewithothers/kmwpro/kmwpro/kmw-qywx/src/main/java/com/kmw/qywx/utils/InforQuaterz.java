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
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.kmw.common.CommonEntity;
import com.kmw.common.utils.DateUtils;
import com.kmw.qywx.domain.WxUserGroup;
import com.kmw.qywx.service.IDoufuTodayWorkService;
import com.kmw.qywx.service.IWxUserGroupService;
import com.kmw.qywx.service.IWxUserService;
 
 

import org.quartz.Job;

public class InforQuaterz implements Job {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	IDoufuTodayWorkService doufuTodayWorkService = SpringContextHolder.getBean("doufuTodayWorkService");
	IWxUserGroupService wxUserGroupService = SpringContextHolder.getBean("IWxUserGroupService");

	public InforQuaterz() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		String reportToday = DateUtils.DateToStr8(new Date());
		String reportPreday = DateUtils.getPreDateByDate8(reportToday);
		String msgContent = "昨天日报，小组成员都已经提交成功！";
		List<Map<String, Object>> mplist =  getInfoUser();
		
		if(null == mplist) {
			return;
		}
		
		// 发送每天日报的提交情况，查询到未提交的人名单，按部门ID进行通知
		for(int i=0;i<mplist.size();i++) {
			Map<String, Object> mpinfoUser = mplist.get(i);
			String infoUserCode = mpinfoUser.get("userCode").toString();
			String instId = mpinfoUser.get("instid").toString();
		
			List<String> lstGroupName = (List<String>) mpinfoUser.get("groupList");
			 String notCommitInfo = null;
			if(null != lstGroupName) {
				 for(String gname:lstGroupName) {
					 logger.info("拆分后的分组名称【"+gname +"】部门ID【"+instId+"】" );
					 if(notCommitInfo == null) {
					 notCommitInfo = queryNotCommitUser(gname, reportPreday);
					 
					 }else {
					 notCommitInfo = notCommitInfo +"\n"+queryNotCommitUser(gname, reportPreday);
					 }
					 
				 }
				if(null == notCommitInfo) {
				return;	
				}
				WeiXinUtil weiXinUtil = new WeiXinUtil();
				if ("".equals(notCommitInfo)) {
					msgContent =notCommitInfo;
					weiXinUtil.SendTextcardMessage("",instId,msgContent);
				} else {
					msgContent = notCommitInfo;
					weiXinUtil.SendTextcardMessage("",instId, msgContent);
				}
			}
			
		}

	

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
				/*
				 * if (null != lstGroupName) { for (String gname : lstGroupName) {
				 * logger.info("拆分后的分组名称【" + gname + "】"); } }
				 */
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

	public String queryNotCommitUser(String groupname, String reportdate) {
		String strRtn = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupname", groupname);
		params.put("reportdate", reportdate);
		List<CommonEntity> lst = doufuTodayWorkService.queryNotCommitUser(params);
		String userName, userAccount;
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
			if(!"".equals(strRtn)) {
			strRtn ="项目组：【" +groupname+"】日期：【"+reportdate+"】\n未提交日报人员：\n"+strRtn+"\n请及时通知本人，尽快补上！";
			}
		}else {
			strRtn ="项目组：【" +groupname+"】日期：【"+reportdate+"】 日报全部提交！";
		}

		return strRtn;

	}
	
	
	
	
}