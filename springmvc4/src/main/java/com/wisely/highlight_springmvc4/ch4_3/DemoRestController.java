package com.wisely.highlight_springmvc4.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.highlight_springmvc4.domain.DemoObj;

// @RestController：使用该注解，声明是控制器，并且返回数据时不需要@ResponseBody
@RestController
@RequestMapping("/rest")
public class DemoRestController {

	/**
	 * http://localhost:9080/highlight_springmvc4/rest/getjson?id=1&name=heijue
	 * 
	 * 1、指定produces为json，自定转化为json输出，前提需要引入包：jackson-dataformat-xml
	 */
	// 返回数据类型为json
	@RequestMapping(value="/getjson" , produces = "application/json;charset=UTF-8")
	public DemoObj getJson(DemoObj obj) {
		
		// 直接返回对象，会转成json
		return new DemoObj(obj.getId() + 1 , obj.getName() + "yy");
		
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/rest/getxml?id=1&name=heijue
	 * 
	 * 1、指定produces为xml，自定转化为xml输出，前提需要引入包：jackson-dataformat-xml
	 */
	@RequestMapping(value="/getxml" , produces = "application/xml;charset=UTF-8")
	public DemoObj getXml(DemoObj obj) {
		
		// 直接返回对象，会转成json
		return new DemoObj(obj.getId() + 1 , obj.getName() + "yy");
		
	}
}
