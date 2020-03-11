package com.kmw.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kmw.common.config.Global;
import com.kmw.common.json.JSON;
import com.kmw.common.json.JSONObject;
import com.kmw.common.utils.http.HttpUtils;

/**
 * 获取地址类
 * 
 * @author kmw
 */
public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip)
    {
        String address = "XX XX";

        // 内网不查询
        if (IpUtils.internalIp(ip))
        {
            return "内网IP";
        }
        if (Global.isAddressEnabled())
		{
        	return "ip【"+ ip+"】对应物理地址，暂不获取！";
        	/*
			 * 
			 * String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip); if
			 * (StringUtils.isEmpty(rspStr)) { log.error("获取地理位置异常 {}", ip); return address;
			 * } JSONObject obj; try { obj = JSON.unmarshal(rspStr, JSONObject.class);
			 * JSONObject data = obj.getObj("data"); String region = data.getStr("region");
			 * String city = data.getStr("city"); address = region + " " + city; } catch
			 * (Exception e) { log.error("获取地理位置异常 {}", ip); }
			 */
        }
        return address;
    }
}
