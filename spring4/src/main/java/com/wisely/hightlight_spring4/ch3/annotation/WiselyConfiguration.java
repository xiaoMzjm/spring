package com.wisely.hightlight_spring4.ch3.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 以下两个注解式元注解，加在注解类上，就变成组合注解。
@Configuration
@ComponentScan
public @interface WiselyConfiguration {
	
	// 覆盖values参数
	String[] value() default{};

}
