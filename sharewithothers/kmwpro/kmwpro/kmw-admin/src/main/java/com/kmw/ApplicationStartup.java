package com.kmw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.kmw.qywx.utils.WeiXinUtil;

/**
 * @author Stone Yuan
 * @create 2017-12-02 21:54
 * @description
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    WeiXinUtil weiXinUtil;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		
		   weiXinUtil.setRedisToken();
    }
}