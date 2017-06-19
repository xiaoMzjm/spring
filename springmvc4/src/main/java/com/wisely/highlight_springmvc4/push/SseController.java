package com.wisely.highlight_springmvc4.push;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SseController {

	@RequestMapping(value="/push" , produces="text/event-stream")
	@ResponseBody
	public String push(){
		Random r = new Random();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
	}
	
	/**
	 * http://localhost:9080/highlight_springmvc4/sse
	 * @return
	 */
	@RequestMapping(value="/sse")
	public String sse(){
		return "sse";
	}
}
