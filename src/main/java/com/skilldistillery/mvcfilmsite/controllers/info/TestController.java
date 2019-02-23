package com.skilldistillery.mvcfilmsite.controllers.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.mvcfilmsite.data.DatabaseAccessor;

@Controller
public class TestController {
	
	@Autowired
	private DatabaseAccessor filmDB;
	
	@RequestMapping(path="testDisplay.do", method=RequestMethod.GET)
	public ModelAndView displayPage() {
		Film testFilm = filmDB.findFilmById(1);
		
		ModelAndView mv = new ModelAndView("WEB-INF/Views/display.jsp");
		mv.addObject("film", testFilm);
		
		
		return mv;
	}
	@RequestMapping(path="testAdd.do", method=RequestMethod.GET)
	public ModelAndView addFilmPage() {
		ModelAndView mv = new ModelAndView("WEB-INF/Views/addFilm.jsp");
		
		return mv;
	}
}
