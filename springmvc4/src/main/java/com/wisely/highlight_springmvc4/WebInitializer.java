package com.wisely.highlight_springmvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplicationInitializer��spring�ṩ��������servlet3.0+���õĽӿڣ��Ӷ�ʵ�������web.xml��λ�á�
 * ʵ�ִ˽ӿڽ����Զ���springServletContainerInitializer����������Servlet3.0��������ȡ��
 * @author �ھ�
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	/**
	 * �൱��web.xml����
	 */
	public void onStartup(ServletContext servletContext)throws ServletException {
		
		// ע��spring�����࣬ʹ��java��Ϊ�����࣬���xml
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MyMvcConfig.class);
		context.setServletContext(servletContext);

		// ע��Spring MVC��DispatcherServlet
		Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		System.out.println("init servlet3.0 success...");

	}

}
