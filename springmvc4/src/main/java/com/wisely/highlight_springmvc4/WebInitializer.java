package com.wisely.highlight_springmvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplicationInitializer是spring提供用来配置servlet3.0+配置的接口，从而实现了替代web.xml的位置。
 * 实现此接口将会自动被springServletContainerInitializer（用来启动Servlet3.0容器）获取到
 * @author 黑绝
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	/**
	 * 相当于web.xml配置
	 */
	public void onStartup(ServletContext servletContext)throws ServletException {
		
		// 注册spring配置类，使用java作为配置类，替代xml
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MyMvcConfig.class);
		context.setServletContext(servletContext);

		// 注册Spring MVC的DispatcherServlet
		Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		System.out.println("init servlet3.0 success...");

	}

}
