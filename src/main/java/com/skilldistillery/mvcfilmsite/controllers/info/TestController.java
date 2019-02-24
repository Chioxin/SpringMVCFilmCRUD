package com.skilldistillery.mvcfilmsite.controllers.info;

import java.util.ArrayList;
import java.util.List;

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
	private DatabaseAccessor dao;
	
	@RequestMapping(path="testDisplay.do", method=RequestMethod.GET)
	public ModelAndView displayPage() {
		try {
			Film testFilm = dao.findFilmById(3);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Film testFilm2 = new Film("Dumb Film", 2);
		System.out.println(testFilm2.getCast());
		
		
		ModelAndView mv = new ModelAndView("WEB-INF/Views/display.jsp");
		mv.addObject("film", testFilm2);
		
		return mv;
	}
	
	@RequestMapping(path="testListDisplay.do", method=RequestMethod.GET)
	public ModelAndView displayList() {
		List<Film> myList = new ArrayList();
		myList.add(new Film("Dumb", 1));
		myList.add(new Film("Dumber", 1));
		myList.add(new Film("Just stupid", 1));
		myList.add(new Film("Really?", 1));
		
		
		ModelAndView mv = new ModelAndView("WEB-INF/Views/display.jsp");
		mv.addObject("filmList", myList);
		return mv;
	}
	
	@RequestMapping(path="testAdd.do", method=RequestMethod.GET)
	public ModelAndView addFilmPage() {
		ModelAndView mv = new ModelAndView("WEB-INF/Views/addFilm.jsp");
		
		return mv;
	}
}
