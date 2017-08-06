package com.wisely.ch5_2_1;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisely.ch5_2_1.config.AuthorSettings;
//import com.wisely.spring_boot_starter_hello.HelloService;

@SpringBootApplication
@Controller
public class Ch521Application {
	
	@Autowired
	private AuthorSettings authorSettings;
	
	@Autowired
	//private HelloService helloService;
	
	public static void main(String[] args) {
		SpringApplication.run(Ch521Application.class, args);
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer(){
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
	}
	
	@Bean
	public Connector httpConnector(){
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}
	
	/**
	 * localhost
	 * @return
	 */
	@RequestMapping("/")
	@ResponseBody
	public String index(){
		System.out.println("come to /");
		//return "Hello Spring Boot , author.anem=" + authorSettings.getName() + " , author.age=" + authorSettings.getAge() + " , helloService="+helloService.sayHello();
		return "Hello Spring Boot , author.anem=" + authorSettings.getName() + " , author.age=" + authorSettings.getAge() + " , helloService=";
	}
	
	/**
	 * localhost/velocity
	 * @return
	 */
	@RequestMapping("/velocity")
	public String velocity(){
		return "velocity";
	}
	
	
}
