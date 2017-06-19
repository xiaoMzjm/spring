package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

// ����һ�����������ԣ��������@Componentע�⣬�����Զ�ע���spring �� bean
@ControllerAdvice
public class ExceptionHandlerAdvice {

	/**
	 * ����ȫ��ҳ������� 
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
		model.addAttribute("msg" , "������Ϣ");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		// ���������е�id�ֶ�
		webDataBinder.setDisallowedFields("id");
	}
}
