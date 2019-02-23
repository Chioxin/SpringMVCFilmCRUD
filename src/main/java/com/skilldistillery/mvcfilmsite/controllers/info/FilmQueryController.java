package com.skilldistillery.mvcfilmsite.controllers.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvcfilmsite.data.DatabaseAccessor;

@Controller
public class FilmQueryController {
	
	@Autowired
	private DatabaseAccessor filmDB;
	
	@RequestMapping(path="home", method=RequestMethod.GET)
	public ModelAndView landingPage() {
		ModelAndView mv = new ModelAndView("WEB-INF/Views/index.jsp");
		
		return mv;
	}
	
}
