package net.main.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greetings", "Welcome to Spring Web MVC");
		return mv;
	}
	
//	@RequestMapping(value = {"/test"})
//	public ModelAndView test(@RequestParam(value="greetings", required=false) String greetingsValue){
//		if(greetingsValue == null) {
//			greetingsValue = "Hello!";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greetings", greetingsValue);
//		return mv;
//	}

//	@RequestMapping(value = {"/test/{greetings}"}) 
//	public ModelAndView test(@PathVariable("greetings") String greetingsValue){
//		if(greetingsValue == null) {
//			greetingsValue = "Hello!";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greetings", greetingsValue);
//		return mv;
//	}


}
