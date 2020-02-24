package com.kmw;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Component;

import com.kmw.qywx.utils.WeiXinUtil;

/**
 * 启动程序
 * 
 * @author kmw
 */

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class KmwApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KmwApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KmwApplication.class, args);
	}

	@Autowired
	private ApplicationContext appContext;

	@Override
	public void run(String... args) throws Exception {

		// 开发过程为了可以打印应用启动的所有bean name
		/*
		 * String[] beans = appContext.getBeanDefinitionNames(); Arrays.sort(beans); for
		 * (String bean : beans) { System.out.println(bean + " of Type :: " +
		 * appContext.getBean(bean).getClass()); }
		 */

	}
}