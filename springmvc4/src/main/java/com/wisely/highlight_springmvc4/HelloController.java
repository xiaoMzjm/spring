package com.wisely.highlight_springmvc4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	/**
	 * http://localhost:9080/highlight_springmvc4/hello
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
}
