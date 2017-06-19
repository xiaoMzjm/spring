package com.wisely.hightlight_spring4.ch1.javaconfig;

// 不需要@Service注解
public class FunctionService {

	public String sayHello(String word) {
		return "Hello" + word + " !" ;
	}
}
