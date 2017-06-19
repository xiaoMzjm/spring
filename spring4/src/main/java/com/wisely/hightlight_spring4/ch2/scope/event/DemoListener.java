package com.wisely.hightlight_spring4.ch2.scope.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 监听器
// 需要由spring管理
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	@Override
	public void onApplicationEvent(DemoEvent demoEvent) {
		String msg = demoEvent.getMsg();
		System.out.println("接收到msg : " + msg);
		
	}

}
