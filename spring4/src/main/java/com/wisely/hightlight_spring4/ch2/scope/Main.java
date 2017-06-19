package com.wisely.hightlight_spring4.ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ScopeConfig.class);

		DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
		
		DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
		
		System.out.println(p1 == p2);
		
		DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
		
		DemoSingletonService s2 = context.getBean(DemoSingletonService.class);
		
		System.out.println(s1 == s2);

	}
}
