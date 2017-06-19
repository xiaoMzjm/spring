package com.wisely.hightlight_spring4.ch3.taskexecutor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@ComponentScan("com.wisely.hightlight_spring4.ch3.taskexecutor")
//利用该注解开启异步任务支持，只配置了@Async的方法/类才有效
@EnableAsync
public class MainConfig {

}
