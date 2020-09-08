package com.dxc.HelloSpringEx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/message")
public ModelAndView  message() {
		
		
		return new ModelAndView("message","greet","Good Evening...");
	}
	@RequestMapping("/Hello")
	public ModelAndView  sayHello() {
		
		
		return new ModelAndView("result");
	}

}
