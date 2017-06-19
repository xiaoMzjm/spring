package com.wisely.hightlight_spring4.ch2.scope.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件类
 * @author 黑绝
 *
 */
public class DemoEvent extends ApplicationEvent {
	
	private String msg ;

	public DemoEvent(Object source , String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
