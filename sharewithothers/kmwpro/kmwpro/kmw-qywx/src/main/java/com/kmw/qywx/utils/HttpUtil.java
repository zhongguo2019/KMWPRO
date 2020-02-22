package com.kmw.qywx.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class HttpUtil {
	
	  Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 * <获取参数map>
	 * 
	 * 
	 * 
	 * @return 参数map
	 * 
	 * @throws Exception
	 * 
	 */

	public static Map<String, Object> getParameterMap(HttpServletRequest request) throws Exception {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		Map<String, String[]> tempMap = request.getParameterMap();

		Set<String> keys = tempMap.keySet();

		for (String key : keys) {

			byte source[] = request.getParameter(key).getBytes("iso8859-1");

			String modelname = new String(source, "UTF-8");

			resultMap.put(key, modelname);

		}

		return resultMap;

	}

	public static String getDefaultKeyString(Map<String, Object> mpValue, String key) {
		String strRtn = null;
		if (null == mpValue) {
			return strRtn;
		}

		if (null == mpValue.get(key)) {
			return strRtn;
		} else {
			strRtn = mpValue.get(key).toString();
		}

		return strRtn;
	}

	public static String getPostJsonData(HttpServletRequest request) {
		JSONObject result = null;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = request.getReader();) {
			char[] buff = new char[1024];
			int len;
			while ((len = reader.read(buff)) != -1) {
				sb.append(buff, 0, len);
			}
			result = JSONObject.parseObject(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String strRtn = result.getString("code"); // 拿到微信端传过来的参数
		return strRtn;
	}

	public static String getPostStringData(HttpServletRequest request) throws IOException {
		String result = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader reader=null;   
        char[] buff = new char[1024];
	    int len;
        try
        {
            reader = request.getReader();
			if (null != reader) {
				while ((len = reader.read(buff)) != -1) {
					sb.append(buff, 0, len);
				}
				result = sb.toString();
			}
        } catch (Exception e) {

            e.printStackTrace( );

            // TODO: handle exception

        }finally {

            try {

                //这里关闭流要从大到小关闭

                //fw.close();   

                //bw.close();

                //这样的顺序就是不行，fw流自己关闭了。然后bw流又把

                //fw流关闭一次就会说java.io.IOException: Stream closed

            	reader.close();

            } catch (IOException e)  {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }
      }
		String strRtn = result; // 拿到微信端传过来的参数
		return strRtn;
	}
	/**
	 * @desc ：2.微信上传素材的请求方法,访问指定的地址，上传文件
	 * 
	 * @param requestUrl 微信上传临时素材的接口url
	 * @param file       要上传的文件
	 * @return String 上传成功后，微信服务器返回的消息
	 */
	public static String httpRequest(String requestUrl, File file) {
		StringBuffer buffer = new StringBuffer();

		try {
			// 1.建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection(); // 打开链接
			httpUrlConn.setReadTimeout(1000);
			httpUrlConn.setConnectTimeout(15000);

			// 1.1输入输出设置
			httpUrlConn.setDoInput(true);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setUseCaches(false); // post方式不能使用缓存
			// 1.2设置请求头信息
			httpUrlConn.setRequestProperty("Connection", "Keep-Alive");
			httpUrlConn.setRequestProperty("Charset", "UTF-8");
			// 1.3设置边界
			String BOUNDARY = "----------" + System.currentTimeMillis();
			httpUrlConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

			// 请求正文信息
			// 第一部分：
			// 2.将文件头输出到微信服务器
			StringBuilder sb = new StringBuilder();
			sb.append("--"); // 必须多两道线
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\"media\";filelength=" + file.length() + ";filename=\""
					+ file.getName() + "\"\r\n");
			sb.append("Content-Type:application/octet-stream\r\n\r\n");
			byte[] head = sb.toString().getBytes("utf-8");
		 
			// 获得输出流
			OutputStream outputStream = new DataOutputStream(httpUrlConn.getOutputStream());
			// 将表头写入输出流中：输出表头
			outputStream.write(head);

			// 3.将文件正文部分输出到微信服务器
			// 把文件以流文件的方式 写入到微信服务器中
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				outputStream.write(bufferOut, 0, bytes);
			}
			in.close();
	 
			// 4.将结尾部分输出到微信服务器
			byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
			outputStream.write(foot);
			outputStream.flush();
			outputStream.close();

			// 5.将微信服务器返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
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
 

		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
  
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	
	/**
	 * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public final static String getIpAddress(HttpServletRequest request) throws IOException {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}

}
