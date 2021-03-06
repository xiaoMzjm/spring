package com.wisely.hightlight_spring4.ch3.fortest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>4.1.8.RELEASE</version>
		</dependency>
		
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
 * 
 */

// 在junit环境下提供spring功能
@RunWith(SpringJUnit4ClassRunner.class)

// spring配置类
@ContextConfiguration(classes = {TestConfig.class})

// 生命环境
@ActiveProfiles("prod")
public class Main {
	
	@Autowired
	private TestBean testBean;
	
	@Test
	public void test(){
		System.out.println(testBean.getContent());
	}

}
