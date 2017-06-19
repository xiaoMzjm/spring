package com.wisely.hightlight_spring4.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		
		ListService listService = context.getBean(ListService.class);
		
		System.out.println(listService.showListCmd());
		
		context.close();
	}
}
