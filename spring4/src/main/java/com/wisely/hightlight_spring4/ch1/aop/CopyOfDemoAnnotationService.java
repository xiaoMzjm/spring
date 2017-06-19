package com.wisely.hightlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class CopyOfDemoAnnotationService {
	
	@Action(name="注解式拦截的add操作2")
	public void add(){
		System.out.println("CopyOfDemoAnnotationService#add");
	}

}
