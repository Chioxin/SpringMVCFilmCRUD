package com.skilldistillery.mvcfilmsite.controllers.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping(path="testDisplay.do", method=RequestMethod.GET)
	public ModelAndView displayPage() {
		ModelAndView mv = new ModelAndView("WEB-INF/Views/display.jsp");
		
		return mv;
	}
	@RequestMapping(path="testAdd.do", method=RequestMethod.GET)
	public ModelAndView addFilmPage() {
		ModelAndView mv = new ModelAndView("WEB-INF/Views/addFilm.jsp");
		
		return mv;
	}
}
