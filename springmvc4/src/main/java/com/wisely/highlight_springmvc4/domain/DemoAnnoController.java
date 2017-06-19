package com.wisely.highlight_springmvc4.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

	/**
	 * http://localhost:9080/highlight_springmvc4/anno
	 * 
	 * 1、此方法为标注路径，因此使用类级别的路径/anno；
	 * 
	 * 2、produces：可定制返回的response的媒体类型和字符集，或需返回值json对象，则设置produces="application/json;charset=UTF-8"
	 * 
	 * 3、演示可接受HttpServletRequest作为参数，当然也可以接收response
	 * 
	 * 4、@ResponseBody：返回非页面数据
	 */
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public  @ResponseBody String index(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/anno/pathvar/1
	 * 
	 * 1、演示接收路径参数，并杂方法参数前结合@PathVariable使用，访问路径为/anno/pathvar/xx
	 * 
	 */
	@RequestMapping(value="/pathvar/{str}" , produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str , HttpServletRequest request) {
		return "url:" + request.getRequestURL() +" can access , str:" + str;
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/anno/requestParam?id=1
	 * 
	 * 1、演示常规的request参数获取
	 */
	@RequestMapping(value="/requestParam" , produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id , HttpServletRequest request) {
		return "url:" + request.getRequestURL() +" can access , id:" + id;
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/anno/obj?id=1&name=heijue
	 * 
	 * 1、演示解释参数到对象
	 */
	@RequestMapping(value="/obj" , produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String passObj(DemoObj obj , HttpServletRequest request) {
		return "url:" + request.getRequestURL() +" can access , id:" + obj.getId() + " , name:" + obj.getName();
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/anno/name1
	 * http://localhost:9080/highlight_springmvc4/anno/name2
	 * 
	 * 1、演示多个URL，访问同一个方法
	 */
	@RequestMapping(value= {"/name1" , "/name2"} , produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String remove(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}
}
