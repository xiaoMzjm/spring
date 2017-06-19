package com.wisely.hightlight_spring4.ch3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		
		AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
		
		for(int i = 0 ; i < 10 ; i++) {
			asyncTaskService.executeAsyncTask(i);
			asyncTaskService.executeAsyncTaskPlus(i);
		}
		
		context.close();
	}

}
