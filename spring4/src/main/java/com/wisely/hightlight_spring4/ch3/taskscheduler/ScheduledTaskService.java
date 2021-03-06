package com.wisely.hightlight_spring4.ch3.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	// 5秒执行一次
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("每个5秒执行一次" + dateFormat.format(new Date()));
	}
	
	@Scheduled(cron = "10 54 0 ? * *")
	public void fixTimeExecution(){
		System.out.println("在指定时间" + dateFormat.format(new Date()) + " 触发");
	}
}
