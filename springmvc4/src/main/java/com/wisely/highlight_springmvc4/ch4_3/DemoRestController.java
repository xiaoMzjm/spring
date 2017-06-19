package com.wisely.highlight_springmvc4.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.highlight_springmvc4.domain.DemoObj;

// @RestController��ʹ�ø�ע�⣬�����ǿ����������ҷ�������ʱ����Ҫ@ResponseBody
@RestController
@RequestMapping("/rest")
public class DemoRestController {

	/**
	 * http://localhost:9080/highlight_springmvc4/rest/getjson?id=1&name=heijue
	 * 
	 * 1��ָ��producesΪjson���Զ�ת��Ϊjson�����ǰ����Ҫ�������jackson-dataformat-xml
	 */
	// ������������Ϊjson
	@RequestMapping(value="/getjson" , produces = "application/json;charset=UTF-8")
	public DemoObj getJson(DemoObj obj) {
		
		// ֱ�ӷ��ض��󣬻�ת��json
		return new DemoObj(obj.getId() + 1 , obj.getName() + "yy");
		
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/rest/getxml?id=1&name=heijue
	 * 
	 * 1��ָ��producesΪxml���Զ�ת��Ϊxml�����ǰ����Ҫ�������jackson-dataformat-xml
	 */
	@RequestMapping(value="/getxml" , produces = "application/xml;charset=UTF-8")
	public DemoObj getXml(DemoObj obj) {
		
		// ֱ�ӷ��ض��󣬻�ת��json
		return new DemoObj(obj.getId() + 1 , obj.getName() + "yy");
		
	}
}
