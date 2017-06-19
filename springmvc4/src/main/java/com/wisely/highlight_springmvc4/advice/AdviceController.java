package com.wisely.highlight_springmvc4.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wisely.highlight_springmvc4.domain.DemoObj;

@Controller
public class AdviceController {

	/**
	 * http://localhost:9080/highlight_springmvc4/advice?id=1&name=heijue 
	 */
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg , DemoObj obj) {
		System.out.println(obj);
		throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg);
	}
}
