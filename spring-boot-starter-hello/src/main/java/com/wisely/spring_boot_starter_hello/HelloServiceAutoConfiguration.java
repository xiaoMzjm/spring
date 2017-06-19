package com.wisely.spring_boot_starter_hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个配置类,其实不会被spring自动发现的，要在src/main/resource/META-INF/spring.factories下把这个类配置进去后，当这个项目作为三方包被引入其他项目时，才会被springboot发现。
 * @author 黑绝
 *
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)				// 注入HelloServiceProperties这个bean
@ConditionalOnClass(HelloService.class)										// 当HelloService在类路径的条件下
@ConditionalOnProperty(prefix="hello",value="enabled",matchIfMissing=true)	// 当hello=enabled的情况下，如果没有设置则默认为true，即条件符合
public class HelloServiceAutoConfiguration {

	/**
	 * 注入配置类
	 */
	@Autowired
	private HelloServiceProperties helloServiceProperties;
	
	/**
	 * 创建功能类，这个功能类的属性，应该从配置类中获取
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(HelloService.class)				// 当容器中没有这个Bean的时候新建Bean
	public HelloService helloService(){
		HelloService helloService = new HelloService();
		helloService.setMsg(helloServiceProperties.getMsgBig());
		return helloService;
	}
}
