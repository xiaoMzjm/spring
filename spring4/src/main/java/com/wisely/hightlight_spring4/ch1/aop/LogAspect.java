package com.wisely.hightlight_spring4.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

// 注解一个切面
@Aspect
// 被spring容器管理
@Component
public class LogAspect {

	// 声明切点
	@Pointcut("@annotation(com.wisely.hightlight_spring4.ch1.aop.Action)")
	public void annotationPointCut(){};
	
	// 声明建言，使用@PointCut定义的切点
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		// 通过反射可以获取注解上的属性
		System.out.println("注解式拦截" + action.name());
	}
	
	// 生命建言，直接使用拦截规则作为参数
	@Before("execution(* com.wisely.hightlight_spring4.ch1.aop.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方式规则式拦截,"+method.getName());
	}
	
}
