package com.wisely.hightlight_springmvc4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration

// 开启spring mvc
@EnableWebMvc
@ComponentScan("com.wisely.hightlight_springmvc4")
public class MyMvcConfig {

	/**
	 * 用来映射路径和实际页面的位置
	 * @return
	 */
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/classes/views");
		viewResolver.setSuffix(".html");
		viewResolver.setViewClass(JstlView.class);
		
		return viewResolver;
	}
}
