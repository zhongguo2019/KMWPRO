package com.kmw.qywx.service;

import org.springframework.stereotype.Service;

import com.kmw.qywx.utils.AccessToken;

@Service
public interface  IRedisUtilService {
	public String  getRedisValue(String key );
	public String  setRedisValue(String key,AccessToken accessToken);

}
