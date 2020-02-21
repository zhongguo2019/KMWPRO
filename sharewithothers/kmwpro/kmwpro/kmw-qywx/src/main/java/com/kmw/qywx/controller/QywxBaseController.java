package com.kmw.qywx.controller;


import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.kmw.common.Constant;
import com.kmw.qywx.utils.HttpUtil;
import com.kmw.qywx.utils.WXBizMsgCrypt;
import com.kmw.qywx.utils.WeiXinParamesUtil;
import com.kmw.qywx.utils.WeiXinUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/*
 * 主界面的所有控制层
 * 
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/base")
public class QywxBaseController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/wxconnect")
	@ResponseBody
	String getWXConnect(HttpServletRequest request) throws Exception {
		WeiXinUtil weiXinUtil = new WeiXinUtil();
		
	//	logger.info("------------------------------企业微信发来调用消息,处理开始------------------------------！");
		WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(WeiXinParamesUtil.token, WeiXinParamesUtil.encodingAESKey,
				WeiXinParamesUtil.corpId);
		
		
		Map<String, Object> paramter = HttpUtil.getParameterMap(request);
		String strMsgSig = HttpUtil.getDefaultKeyString(paramter, "msg_signature");
		String strTimeStamp = HttpUtil.getDefaultKeyString(paramter, "timestamp");
		String strReqNonce = HttpUtil.getDefaultKeyString(paramter, "nonce");
		String strEchostr = HttpUtil.getDefaultKeyString(paramter, "echostr");

		String strRtnEchoStr = ""; // 需要返回的明文
		request.getSession().setAttribute(Constant.SESSION_LOGIN_WXFLAG, "Y");
	
		//后台通过微信登录，得到sys_user表中的用户信息，放到session中。
		if (null != paramter.get("echostr")) {
	//		logger.info("------------------------------验证连接服务器地址,处理开始------------------------------！");
			try {
				strRtnEchoStr = wxcpt.VerifyURL(strMsgSig, strTimeStamp, strReqNonce, strEchostr);
				// System.out.println("服务器验证成功，返回的明文: " + strRtnEchoStr);
				// 验证URL成功，将sEchoStr返回
				// HttpUtils.SetResponse(sEchoStr);
			} catch (Exception e) {
				// 验证URL失败，错误原因请查看异常
				e.printStackTrace();
				strRtnEchoStr = "------------------------------签名验证错误！------------------------------";
			}
		//	logger.info("------------------------------验证连接服务器地址,处理结束------------------------------！");
			return strRtnEchoStr;
		}

		String strReqData = HttpUtil.getPostStringData(request);
		if ("".equals(strReqData) || null != strReqData) {
//			logger.info("------------------------------企业微信发来调用消息, 开处理-------------------");
			strRtnEchoStr = weiXinUtil.msgDeal(wxcpt, strMsgSig, strTimeStamp, strReqNonce, strReqData, request);
		}
		/* logger.info("返回消息内容："+strRtnEchoStr); */
		return strRtnEchoStr;
		

	}

 
	@RequestMapping("/wxgetJSSConfig")
	@ResponseBody
	String wxAppJSAPIgetAppid(HttpServletRequest request) throws UnsupportedEncodingException {
        JSONObject wxConfig = new JSONObject();
		 wxConfig = WeiXinUtil.getWxConfigJSON(request);
		 return  wxConfig.toString();
	}
	
	@RequestMapping("/wxgetJSSUser")
	@ResponseBody
	String wxgetJSSUser(HttpServletRequest request) throws UnsupportedEncodingException {
		
		String data = request.getParameter("data") == null ? "" : request.getParameter("data");
	    String usercode = null;
		String strRtn=null;
		WeiXinUtil weiXinUtil = new WeiXinUtil();
		if (!"".equals(data)) {

			data= URLDecoder.decode(URLDecoder.decode(data, "utf-8"), "utf-8");
			logger.info("前台传入的data【"+data+"】");		
			//List<Map<String, Object>> list = (List<Map<String, Object>>) JsonHelper.decode(data);
			
			strRtn = 	weiXinUtil.getTencentUserInfo(data);
		}else {
			logger.info("前台传入的code为空！");
		}
		return strRtn;
		
	}

	@RequestMapping("/wxCommitForm")
	@ResponseBody
	String wxCommitForm(HttpServletRequest request) throws UnsupportedEncodingException {
		String data = request.getParameter("data") == null ? "" : request.getParameter("data");
		data = URLDecoder.decode(URLDecoder.decode(data, "utf-8"), "utf-8");

		if (!"".equals(data)) {
		
		
			}
	

		return null;
	}
}
