package com.wisely.hightlight_spring4.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * pom需添加aspect依赖
 * @author 黑绝
 *
 */
@Configuration
@ComponentScan("com.wisely.hightlight_spring4.ch1.aop")
// 开启spring对aspectj支持，使@Action注解有效
@EnableAspectJAutoProxy
public class AopConfig {

}
