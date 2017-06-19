package com.wisely.hightlight_spring4.ch3.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.wisely.hightlight_spring4.ch3.taskscheduler")
// 开启计划任务，使@Scheduled注解有效
@EnableScheduling
public class TaskSchedulerConfig {

}
