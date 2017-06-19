package com.wisely.hightlight_spring4.ch2.scope.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

// 发布者
// 需要由spring管理
@Component
public class DemoPublisher {
	
	@Autowired
	ApplicationContext applicationContext;
	
	public void publish(String msg) {
		applicationContext.publishEvent(new DemoEvent(this,msg));
	}

}
