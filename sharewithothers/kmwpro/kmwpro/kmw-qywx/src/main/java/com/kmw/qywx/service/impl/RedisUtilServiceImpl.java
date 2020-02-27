package com.kmw.qywx.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.stereotype.Service;

import com.kmw.qywx.service.IRedisUtilService;
import com.kmw.qywx.utils.AccessToken;
import com.kmw.qywx.utils.RedisUtil;

import redis.clients.jedis.JedisPool;

@Service
public class RedisUtilServiceImpl implements IRedisUtilService {
	
	/*
	 * @Autowired JedisPool jedisPool;
	 */
	
	@Autowired
	RedisUtil  redisUtil;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String getRedisValue(String key) {

		return redisUtil.get("token").toString();

	}

	@Override
	public String setRedisValue(String key, AccessToken accessToken) {
		

		redisUtil.set("token", accessToken.getToken());
		redisUtil.expire(key, accessToken.getExpiresIn());
		return "success";
		
		/*
		 * // TODO Auto-generated method stu jedisPool.getResource().setex(key, 3600,
		 * accessToken.getToken().toString()); jedisPool.getResource().close(); return
		 * null;
		 */
	}

}
