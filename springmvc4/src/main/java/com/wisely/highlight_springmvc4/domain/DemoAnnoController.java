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
	 * 1���˷���Ϊ��ע·�������ʹ���༶���·��/anno��
	 * 
	 * 2��produces���ɶ��Ʒ��ص�response��ý�����ͺ��ַ��������践��ֵjson����������produces="application/json;charset=UTF-8"
	 * 
	 * 3����ʾ�ɽ���HttpServletRequest��Ϊ��������ȻҲ���Խ���response
	 * 
	 * 4��@ResponseBody�����ط�ҳ������
	 */
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public  @ResponseBody String index(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/anno/pathvar/1
	 * 
	 * 1����ʾ����·�����������ӷ�������ǰ���@PathVariableʹ�ã�����·��Ϊ/anno/pathvar/xx
	 * 
	 */
	@RequestMapping(value="/pathvar/{str}" , produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str , HttpServletRequest request) {
		return "url:" + request.getRequestURL() +" can access , str:" + str;
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/anno/requestParam?id=1
	 * 
	 * 1����ʾ�����request������ȡ
	 */
	@RequestMapping(value="/requestParam" , produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id , HttpServletRequest request) {
		return "url:" + request.getRequestURL() +" can access , id:" + id;
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/anno/obj?id=1&name=heijue
	 * 
	 * 1����ʾ���Ͳ���������
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
	 * 1����ʾ���URL������ͬһ������
	 */
	@RequestMapping(value= {"/name1" , "/name2"} , produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String remove(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}
}
