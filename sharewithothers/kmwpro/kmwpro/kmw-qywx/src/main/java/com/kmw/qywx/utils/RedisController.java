package com.kmw.qywx.utils;

import com.kmw.common.core.controller.BaseController;
import com.kmw.qywx.utils.AccessToken;
import com.kmw.qywx.utils.WeiXinParamesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: springbootdemo
 * @Date: 2019/2/22 15:03
 * @Author: zjjlive
 * @Description:
 */

@Controller
@RequestMapping("/redis")
public class RedisController  extends BaseController {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Autowired
    private RedisUtil redisUtil;

	/*
	 * @RequestMapping("redisset") public boolean redisset(String key, String
	 * value){ AccessToken accessToken =new AccessToken();
	 * accessToken.setToken(WeiXinParamesUtil.token);
	 * accessToken.setExpiresIn(7200);
	 * 
	 * return redisUtil.set("token",accessToken,accessToken.getExpiresIn());
	 * 
	 * // return redisUtil.set(key,value); }
	 */

    @RequestMapping("redisget")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("redisexpire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }
}
