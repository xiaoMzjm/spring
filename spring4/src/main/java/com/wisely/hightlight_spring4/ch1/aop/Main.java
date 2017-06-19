package com.wisely.hightlight_spring4.ch1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AopConfig.class);
		
		CopyOfDemoAnnotationService copyOfDemoAnnotationService = context.getBean(CopyOfDemoAnnotationService.class);

		DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
		
		DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
		
		copyOfDemoAnnotationService.add();
		
		demoAnnotationService.add();
		
		demoMethodService.add();
		
		context.close();
	}
}
