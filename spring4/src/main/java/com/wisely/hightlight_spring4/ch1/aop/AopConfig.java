package com.wisely.hightlight_spring4.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * pom需添加aspect依赖
 * 
 * 		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>1.8.8</version>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.8.8</version>
		</dependency>
 *
 */
@Configuration
@ComponentScan("com.wisely.hightlight_spring4.ch1.aop")
// 开启spring对aspectj支持，使@Action注解有效
@EnableAspectJAutoProxy
public class AopConfig {

}
