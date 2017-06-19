package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

// 生命一个控制器建言，其组合了@Component注解，所以自动注册成spring 的 bean
@ControllerAdvice
public class ExceptionHandlerAdvice {

	/**
	 * 定义全局页面错误处理 
	 */
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception , WebRequest reuest) {
		ModelAndView andView = new ModelAndView("error");
		System.out.println("@ExceptionHandler ... ");
		System.out.println(exception.getMessage());
		andView.addObject("errorMessage", "error:" + exception.getMessage());
		return andView;
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("msg" , "额外信息");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		// 忽略请求中的id字段
		webDataBinder.setDisallowedFields("id");
	}
}
