package com.wisely.spring_boot_starter_hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类,功能类的配置信息应该从这个类获取，而这个类的配置信息从springboot的配置文件获取已，这样使得配置权利可以交给用户。
 * @author 黑绝
 *
 */
@ConfigurationProperties(prefix="hello")
public class HelloServiceProperties {

	private static final String MSG = "world";
	
	private String msgBig = MSG;

	public String getMsgBig() {
		return msgBig;
	}

	public void setMsgBig(String msgBig) {
		this.msgBig = msgBig;
	}

	
	
}
