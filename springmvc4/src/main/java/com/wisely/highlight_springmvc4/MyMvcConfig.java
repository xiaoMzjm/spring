package com.wisely.highlight_springmvc4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.wisely.highlight_springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * ����ӳ��·����ʵ��ҳ���λ��
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
//		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		
		return viewResolver;
	}
	
	/**
	 * ָ����̬��Դλ��
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// addResourceHandler��ָ�����ļ����õ�Ŀ¼
		// addResourceLocations��ָ���Ƕ��Ⱪ¶�ķ���·��
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
	
	
	/**
	 * ע��������������ҳ��Żᱻ���أ��������ݲ���
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	
	// ������
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	// �ļ��ϴ���������һ��Ҫ��multipartResolver
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(1000000);
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		return commonsMultipartResolver;
	}
}
