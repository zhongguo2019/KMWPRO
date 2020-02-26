package com.kmw.qywx.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import com.kmw.qywx.utils.Result;
import com.kmw.qywx.utils.SpringContextHolder;
import com.kmw.qywx.domain.DoufuTodayWork;
import com.kmw.qywx.domain.WxUser;
import com.kmw.qywx.service.IDoufuTodayWorkService;
import com.kmw.qywx.service.IRedisUtilService;
import com.kmw.qywx.service.IWxUserService;
import com.kmw.common.Constant;
import com.kmw.common.utils.DateUtils;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.HashMap;

import java.util.Map;

@Component
public class WeiXinUtil {

	private static Logger log = LoggerFactory.getLogger(WeiXinUtil.class);
	// 微信的请求url
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={corpId}&corpsecret={corpsecret}";
	// 获取jsapi_ticket的接口地址（GET） 限200（次/天）
	public final static String jsapi_ticket_url = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?";
	
    @Autowired
    IWxUserService wxUserService;
    
	
	  @Autowired IRedisUtilService redisUtilService;
	 
	//IWxUserService wxUserService  = SpringContextHolder.getBean("wxUserServiceImpl");
	@Autowired
	SendMessageService sendMessageService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
 
	//RedisUtil redisUtil = SpringContextHolder.getBean("redisUtil");
	@Autowired
	IDoufuTodayWorkService doufuTodayWorkService ;
	//IDoufuTodayWorkService doufuTodayWorkService = SpringContextHolder.getBean("doufuTodayWorkServiceImpl");


	/**
	 * 1.发起https请求并获取结果
	 * 
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**
	 * 2.发送https请求之获取临时素材
	 **  从服务器上下载指定的文件
	 * @param requestUrl
	 * @param savePath   文件的保存路径，此时还缺一个扩展名
	 * @return
	 * @throws Exception
	 */
	public static File getFile(String requestUrl, String savePath) throws Exception {
		// String path=System.getProperty("user.dir")+"/img//1.png";

		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();

		URL url = new URL(requestUrl);
		HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
		httpUrlConn.setSSLSocketFactory(ssf);

		httpUrlConn.setDoOutput(true);
		httpUrlConn.setDoInput(true);
		httpUrlConn.setUseCaches(false);
		// 设置请求方式（GET/POST）
		httpUrlConn.setRequestMethod("GET");

		httpUrlConn.connect();

		// 获取文件扩展名
		String ext = getExt(httpUrlConn.getContentType());
		savePath = savePath + ext;
		System.out.println("savePath" + savePath);
		// 下载文件到f文件
		File file = new File(savePath);

		// 获取微信返回的输入流
		InputStream in = httpUrlConn.getInputStream();

		// 输出流，将微信返回的输入流内容写到文件中
		FileOutputStream out = new FileOutputStream(file);

		int length = 100 * 1024;
		byte[] byteBuffer = new byte[length]; // 存储文件内容

		int byteread = 0;
		int bytesum = 0;

		while ((byteread = in.read(byteBuffer)) != -1) {
			bytesum += byteread; // 字节数 文件大小
			out.write(byteBuffer, 0, byteread);

		}
		System.out.println("bytesum: " + bytesum);

		in.close();
		// 释放资源
		out.close();
		in = null;
		out = null;

		httpUrlConn.disconnect();

		return file;
	}

	

	/**
	 * 2.发起http请求获取返回结果
	 * 
	 * 
	 * @param requestUrl 请求地址
	 * @return
	 */
	public static String httpRequest(String requestUrl) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			// InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
			// "utf-8");
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);

			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (Exception e) {
		}
		return buffer.toString();
	}

	/**
	 * 3.获取access_token
	 * 
	 * @param appid     凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("{corpId}", appid).replace("{corpsecret}", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 4. 获取JsapiTicket
	 * 
	 * @param accessToken
	 * @return
	 */
	public static String getJsapiTicket(String accessToken) {

		String requestUrl = jsapi_ticket_url+"access_token="+accessToken;
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		String jsapi_ticket = "";
		// 如果请求成功
		if (null != jsonObject) {
			try {
				jsapi_ticket = jsonObject.getString("ticket");

			} catch (JSONException e) {

				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return jsapi_ticket;
	}

	/**
	 * 3.获取企业微信的JSSDK配置信息
	 * 
	 * @param request
	 * @return
	 */
	public  JSONObject getWxConfigJSON(HttpServletRequest request) {
		JSONObject wxConfig = new JSONObject();
		// 1.准备好参与签名的字段
		String nonceStr = UUID.randomUUID().toString(); // 必填，生成签名的随机串
		// System.out.println("nonceStr:"+nonceStr);
		String accessToken = WeiXinUtil.getAccessToken(WeiXinParamesUtil.corpId, WeiXinParamesUtil.agentSecret)
				.getToken();
		String jsapi_ticket = getJsapiTicket(accessToken);// 必填，生成签名的H5应用调用企业微信JS接口的临时票据
		// System.out.println("jsapi_ticket:"+jsapi_ticket);
		String timestamp = Long.toString(System.currentTimeMillis() / 1000); // 必填，生成签名的时间戳
		// System.out.println("timestamp:"+timestamp);
		String url = request.getRequestURL().toString();
		// System.out.println("url:"+url);

		// 2.字典序 ，注意这里参数名必须全部小写，且必须有序
		String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
				+ url;

		// 3.sha1签名
		String signature = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(sign.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
			// System.out.println("signature:"+signature);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		wxConfig.put("appId", WeiXinParamesUtil.corpId);
		wxConfig.put("timestamp", timestamp);
		wxConfig.put("nonceStr", nonceStr);
		wxConfig.put("signature", signature);
		return wxConfig;
	}

	/**
	 * 3.获取企业微信的JSSDK配置信息
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getWxConfig(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		// 1.准备好参与签名的字段

		String nonceStr = UUID.randomUUID().toString(); // 必填，生成签名的随机串
		// System.out.println("nonceStr:"+nonceStr);
		String accessToken = WeiXinUtil.getAccessToken(WeiXinParamesUtil.corpId, WeiXinParamesUtil.agentSecret)
				.getToken();
		String jsapi_ticket = getJsapiTicket(accessToken);// 必填，生成签名的H5应用调用企业微信JS接口的临时票据
		// System.out.println("jsapi_ticket:"+jsapi_ticket);
		String timestamp = Long.toString(System.currentTimeMillis() / 1000); // 必填，生成签名的时间戳
		// System.out.println("timestamp:"+timestamp);
		String url = request.getRequestURL().toString();
		// System.out.println("url:"+url);

		// 2.字典序 ，注意这里参数名必须全部小写，且必须有序
		String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
				+ url;

		// 3.sha1签名
		String signature = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(sign.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
			// System.out.println("signature:"+signature);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ret.put("appId", WeiXinParamesUtil.corpId);
		ret.put("timestamp", timestamp);
		ret.put("nonceStr", nonceStr);
		ret.put("signature", signature);
		return ret;
	}

	/**
	 * 方法名：byteToHex</br>
	 * 详述：字符串加密辅助方法 </br>
	 * 开发人员：souvc </br>
	 * 创建时间：2016-1-5 </br>
	 * 
	 * @param hash
	 * @return 说明返回值含义
	 * @throws 说明发生此异常的条件
	 */
	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;

	}

	private static String getExt(String contentType) {
		if ("image/jpeg".equals(contentType)) {
			return ".jpg";
		} else if ("image/png".equals(contentType)) {
			return ".png";
		} else if ("image/gif".equals(contentType)) {
			return ".gif";
		}

		return null;
	}

	/*
	 * 
	 * 
	 * 方法名： 收到消息处理的主方法
	 * 
	 * @param
	 * 
	 * @return
	 * 
	 * @throws @throws
	 */
	public String msgDeal(WXBizMsgCrypt wxcpt, String strMsgSig, String strTimeStamp, String strReqNonce,
			String strReqData, HttpServletRequest request) throws AesException {

		String strFromUser = null;
		String strToUser = null;
		String strMsgContent = null;
		String strMsgType = null;
		String strRtnMsg = null;
		Integer strTimStamp = null;

		String strRtnMsgID = UUID.randomUUID().toString();
		// String strRtnMsgID = "1234567890123456";
		String strRtnMsgContent = null;
		strTimStamp = DateUtils.DateToTimestamp(new Date());

		try {
			String sDecMsg = wxcpt.DecryptMsg(strMsgSig, strTimeStamp, strReqNonce, strReqData);
			// System.out.println("after decrypt msg: " + sDecMsg);
			// TODO: 解析出明文xml标签的内容进行处理
			// For example:
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(sDecMsg);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			Element root = document.getDocumentElement();
			strFromUser = root.getElementsByTagName("FromUserName").item(0).getTextContent().toString();
			strToUser = root.getElementsByTagName("ToUserName").item(0).getTextContent().toString();
			strMsgType = root.getElementsByTagName("MsgType").item(0).getTextContent().toString();

			// 后台通过微信登录，得到sys_user表中的用户信息，放到session中。
			userInit(request, strFromUser);

			logger.info("用户操作的类型[" + strMsgType + "]");
			if (strMsgType.equals("event")) {

				String strEventName = root.getElementsByTagName("Event").item(0).getTextContent().toString();
				String strEvenKey = root.getElementsByTagName("EventKey").item(0).getTextContent().toString();
				if(null !=strEvenKey) {
				doufuTodayWorkService.dealEvent(request, strEvenKey);
				}
			}

			if (strMsgType.equals("text")) {

				strRtnMsgContent = WeiXinParamesUtil.msgHelp;
				strMsgContent = root.getElementsByTagName("Content").item(0).getTextContent().toString();
				logger.info("--------------用户提交的消息内容[\n" + strMsgContent + "\n]");
				// 解析文本内容，字符开头以[日报]
				if (justMsgTypeReport(strMsgContent, "[日报]") || justMsgTypeReport(strMsgContent, "【日报】")
						|| justMsgTypeReport(strMsgContent, "日报") || justMsgTypeReport(strMsgContent, "(日报)")
						|| justMsgTypeReport(strMsgContent, "（日报）")) {
					strRtnMsgContent = doufuTodayWorkService.dealDayReportInsert(request, strMsgContent, strFromUser);
				}

				// 解析文本内容，字符开头以[补报]
				if (justMsgTypeReport(strMsgContent, "[补报]") || justMsgTypeReport(strMsgContent, "[补报]")
						|| justMsgTypeReport(strMsgContent, "【补报】") || justMsgTypeReport(strMsgContent, "(补报)")
						|| justMsgTypeReport(strMsgContent, "（补报）") || justMsgTypeReport(strMsgContent, "补报")) {
					strRtnMsgContent = WeiXinParamesUtil.dayReportFormatAdd;
					strRtnMsgContent = doufuTodayWorkService.dealDayReportAdd(request, strMsgContent, strFromUser);
				}

				// 解析文本内容，字符开头以[查询]
				if (justMsgTypeReport(strMsgContent, "[查询]") || justMsgTypeReport(strMsgContent, "【查询】")
						|| justMsgTypeReport(strMsgContent, "（查询）") || justMsgTypeReport(strMsgContent, "［查询］")
						|| justMsgTypeReport(strMsgContent, "(查询)") || justMsgTypeReport(strMsgContent, "查询")) {
					strRtnMsgContent = doufuTodayWorkService.dealDayReportQuery(request, strMsgContent, strFromUser);
				}

				// 解析文本内容，字符开头以[帮助]
				if (justMsgTypeReport(strMsgContent, "[帮助]") || justMsgTypeReport(strMsgContent, "【帮助】")
						|| justMsgTypeReport(strMsgContent, "（帮助）") || justMsgTypeReport(strMsgContent, "［帮助］")
						|| justMsgTypeReport(strMsgContent, "(帮助)") || justMsgTypeReport(strMsgContent, "帮助")) {
					// 提示信息还没有完成
					strRtnMsgContent = WeiXinParamesUtil.helpInfor;
				}

				// 解析文本内容，字符开头以[调阅小组]
				if (justMsgTypeReport(strMsgContent, "[调阅小组]") || justMsgTypeReport(strMsgContent, "【调阅小组】")
						|| justMsgTypeReport(strMsgContent, "（调阅小组）") || justMsgTypeReport(strMsgContent, "［调阅小组］")
						|| justMsgTypeReport(strMsgContent, "(调阅小组)") || justMsgTypeReport(strMsgContent, "调阅小组")) {
					// 提示信息还没有完成
					// strRtnMsgContent=WeiXinParamesUtil.helpInfor;
				}

				// 解析文本内容，字符开头以[调阅成员]
				if (justMsgTypeReport(strMsgContent, "调阅成员]") || justMsgTypeReport(strMsgContent, "【调阅成员】")
						|| justMsgTypeReport(strMsgContent, "（调阅成员）") || justMsgTypeReport(strMsgContent, "［调阅成员］")
						|| justMsgTypeReport(strMsgContent, "(调阅成员)") || justMsgTypeReport(strMsgContent, "调阅成员")) {
					// 提示信息还没有完成
					strRtnMsgContent = doufuTodayWorkService.dealQueryDownLoad(request, strMsgContent, strFromUser);
					// return strRtnMsgContent;

				}

				// 解析文本内容，字符开头以[报告下载]
				if (justMsgTypeReport(strMsgContent, "[报告下载]") || justMsgTypeReport(strMsgContent, "【报告下载】")
						|| justMsgTypeReport(strMsgContent, "（报告下载）") || justMsgTypeReport(strMsgContent, "［报告下载］")
						|| justMsgTypeReport(strMsgContent, "(报告下载)") || justMsgTypeReport(strMsgContent, "报告下载")) {

					strRtnMsgContent = doufuTodayWorkService.dealDayReportDownLoad(request, strMsgContent, strFromUser);
					// 提示信息还没有完成
					// strRtnMsgContent=WeiXinParamesUtil.helpInfor;
					// return strRtnMsgContent;
				}

				strRtnMsg = buildRtnMsg(strFromUser, WeiXinParamesUtil.corpId, strTimStamp, strRtnMsgContent,
						strRtnMsgID, WeiXinParamesUtil.agentId);
			}

		} catch (Exception e) {
			// TODO
			// 解密失败，失败原因请查看异常
			e.printStackTrace();
		}
		String sRespData = strRtnMsg;
//		logger.info("回复串加密前:\n " + sRespData);
		String sEncryptMsg = null;
		if (null != sRespData) {
			sEncryptMsg = wxcpt.EncryptMsg(sRespData, strTimeStamp, strReqNonce);
//			logger.info("回复串加密后:\n " + sEncryptMsg);
		}
		return sEncryptMsg;
	}

	/**
	 * 
	 * 判断用户请求文本类型是否包含指定的字符
	 * 
	 * @param text
	 * @return
	 */
	public static boolean justMsgTypeReport(String text, String findstr) {
		String[] contentArray = text.trim().split("\n");
		int ipos = text.indexOf(findstr);
		if (ipos == 0) {
			return true;

		}

		if (contentArray.length != 0) {
			String strline1 = contentArray[0].toString();
			if (strline1.trim().indexOf(findstr) < 0) {

			} else {
				return true;
			}

		}
		return false;
	}

	public void userInit(HttpServletRequest request, String username) {
		Map<String, Object> userInfo = new HashMap<String, Object>();
		userInfo.put("username", username);
		WxUser wxUserQuery = wxUserService.verifyWxLogin(userInfo);
		if (wxUserQuery != null) {
			String projectGroupId = "";
			projectGroupId = wxUserService.getWxProjectGroupId(userInfo);
			if (null == projectGroupId) {
				projectGroupId = "wx_user_group_not_define";
			}
			wxUserQuery.setProjectGroupId(projectGroupId);
			String remoteIP = "";
			try {
				remoteIP = HttpUtil.getIpAddress(request);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wxUserQuery.setLoginIp(remoteIP);

			request.getSession().setAttribute(Constant.SESSION_LOGIN_USERNAME, username);
			request.getSession().setAttribute(Constant.SESSION_LOGIN_USER, wxUserQuery);

			logger.info("通过微信登录到系统后台，将用户信息存储到全局的session中");

		} else {
			logger.info("用户姓名[" + username + "],没有在用户信息表中找到记录");
		}

	}

	public WxUser getUserInfo(String username,String queryType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		WxUser wxUser = new WxUser();
		if(queryType.equals("ACCOUNT")){
		  wxUser = wxUserService.queryOneWxUser(params);
		}
		if(queryType.equals("NAME")){
			  wxUser = wxUserService.queryOneWxUserByName(params);
			}
			
		
		return wxUser;
		 

	}

	/**
	 * 根据要发送给的用户信息内容组织返回给用户的XML内容
	 * 
	 * @param msg
	 * @return
	 */

	public String buildRtnMsg(String strFromUser, String toUser, Integer strTimStamp, String strRtnMsgContent,
			String strRtnMsgID, int strAgentId) {
		String strRtnMsg = "<xml><ToUserName><![CDATA[" + strFromUser + "]]></ToUserName><FromUserName><![CDATA["
				+ toUser + "]]></FromUserName><CreateTime>" + strTimStamp
				+ "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + strRtnMsgContent
				+ "]]></Content><MsgId>" + strRtnMsgID + "</MsgId><AgentID>" + strAgentId + "</AgentID></xml>";
		return strRtnMsg;

	}

	
	/**
	 * @desc ：上传临时素材
	 * 
	 * @param accessToken 接口访问凭证
	 * @param type        媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
	 * @param fileUrl     本地文件的url。例如 "D/1.img"。
	 * @return JSONObject 上传成功后，微信服务器返回的参数，有type、media_id 、created_at
	 */
	public  JSONObject uploadTempMaterial(String type, String fileUrl,String accessToken ) {

		
		log.info("开始进行向企业微信传文件！");
		
		
		// 1.创建本地文件
		File file = new File(fileUrl);

		// 2.拼接请求url

		String str_uploadurl = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?";
		log.info("uploadTempMaterial上传文件时请求的地址得到的redis token【" + accessToken + "】");
		str_uploadurl = str_uploadurl + "access_token=" + accessToken + "&type=" + "file";
		log.info("uploadTempMaterial上传文件时请求的地址得到的uploadTempMaterial_url【" + str_uploadurl + "");

		// 3.调用接口，发送请求，上传文件到微信服务器
		String result = HttpUtil.httpRequest(str_uploadurl, file);
		// 4.json字符串转对象：解析返回值，json反序列化
		result = result.replaceAll("[\\\\]", "");
		System.out.println("result:" + result);
		JSONObject resultJSON = JSONObject.fromObject(result);
		int errcode = resultJSON.getInt("errcode");

		// 5.返回参数判断
		if (resultJSON != null) {

			if (errcode == 40014) {
				log.info("上传共享文件时，发现token失效，重新调用方法设定redis token" + resultJSON.toString());
				setRedisToken();
			}

			if (resultJSON.get("media_id") != null) {
				System.out.println("上传" + type + "永久素材成功");
				return resultJSON;
			} else {
				System.out.println("上传" + type + "永久素材失败");
			}
		}
		return null;
	}

	// 2.发送文本卡片消息

	public void SendTextcardMessage(String toUser, String toParty,String msgContent) {
		// 0.设置消息内容
		String content = msgContent;

		// 1.创建文本消息对象
		TextMessage message = new TextMessage();
		
		//消息接收者，具体人员为空，则发给指定的部门ID
		if("".equals(toUser)) {
			message.setToparty(toParty);	
		}else {

			message.setTouser(toUser); // 不区分大小写
		}


		// 1.2必需
		message.setMsgtype("text");
		message.setAgentid(WeiXinParamesUtil.agentId);

		Text text = new Text();
		text.setContent(content);
		message.setText(text);

    	// 3.发送消息：调用业务类，发送消息

		sendMessageService.sendMessage(message);

	}

	public  String getTencentUserInfo(String code) {

		// 2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
		String accessToken = getRedisToken();
		String userId = wxAppJSAPIUtil.getTencentUserInfo(code, accessToken);
		return userId;

	}

	public  void SendFileMessage(String media_id, String type, String accessToken, String toUser) {
		// 1.创建文件对象
		FileMessage message = new FileMessage();
		// 1.1非必需
		message.setTouser(toUser); // 不区分大小写
		// textMessage.setToparty("1");
		// txtMsg.setTotag(totag);
		// txtMsg.setSafe(0);
		// String accessTokenlocal= WeiXinUtil.getAccessToken(WeiXinParamesUtil.corpId,
		// WeiXinParamesUtil.agentSecret).getToken();
		String accessTokenlocal = accessToken;
		// 1.2必需
		message.setMsgtype(type);
		message.setAgentid(WeiXinParamesUtil.agentId);

		Media file = new Media();
		file.setMedia_id(media_id);
		message.setFile(file);
		// 3.发送消息：调用业务类，发送消息

		sendMessageService.sendMessage(message);

	}

	public  boolean setRedisToken() {
		AccessToken accessToken = new AccessToken();
		accessToken = WeiXinUtil.getAccessToken(WeiXinParamesUtil.corpId, WeiXinParamesUtil.agentSecret);
		if(accessToken.getToken()==null ||"".equals(accessToken.getToken())) {
			logger.error("未能得到企业微信的token!");
			return false;
		}
		logger.info("向企业微信申请token 放到redis 中【" + accessToken.getToken() + "】 获取时间【" + DateUtils.getDateTime() + "】");
		redisUtilService.setRedisValue("token",  accessToken);
		return true;

	}

	public String getRedisToken() {

		/*
		 * AccessToken accessToken = new AccessToken(); accessToken.setToken(
		 * redisUtilService.getRedisValue("token")); logger.info("从redis中获取 token【" +
		 * accessToken.getToken() + "】"); return accessToken.getToken();
		 */
		
		return redisUtilService.getRedisValue("token");

	}

}