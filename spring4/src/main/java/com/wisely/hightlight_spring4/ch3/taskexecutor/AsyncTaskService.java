package com.wisely.hightlight_spring4.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

	// 通过该注解，表名该方法是个异步方法，如果注解在类级别，则表名该类所有的方法都是异步方法
	// 而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
	@Async
	public void executeAsyncTask(Integer i) throws InterruptedException {
		System.out.println("执行异步任务..." + i);
	}
	
	@Async
	public void executeAsyncTaskPlus(Integer i ) {
		System.out.println("执行异步任务+1..." + (i+1));
	}
	
	
}
