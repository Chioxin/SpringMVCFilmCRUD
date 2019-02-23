package com.skilldistillery.mvcfilmsite.controllers.info;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.mvcfilmsite.data.DatabaseAccessor;

@Controller
public class FilmQueryController {

	@Autowired
	private DatabaseAccessor dao;

	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView landingPage() {
		ModelAndView mv = new ModelAndView("WEB-INF/Views/index.jsp");

		return mv;
	}

//	map request for a search by filmId. 
	@RequestMapping(path = "search.do", params="filmId", method = RequestMethod.GET)
	public ModelAndView idSearch(@RequestParam(value = "filmId") int id) {
		ModelAndView mv = new ModelAndView();
		Film f = dao.findFilmById(id);
		mv.addObject("film", f);
		mv.setViewName("WEB-INF/Views/display.jsp");
		return mv;

	}

//	search by param keyWord
	@RequestMapping(path = "search.do", params="keyWord", method = RequestMethod.GET)
	public ModelAndView keyWordSearch(@RequestParam(value = "keyWord") String keyWord) {
		ModelAndView mv = new ModelAndView();
		List<Film> f = dao.findFilmByKeyWord(keyWord);
		mv.addObject("film", f);
		mv.setViewName("WEB-INF/Views/display.jsp");
		return mv;
	}
//	do we need a seperate displayfilm when clicking links from keyword search?
//	Add film from index
	@RequestMapping(path ="add.do", method = RequestMethod.GET)
	public ModelAndView addFilmForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/Views/addFilm.jsp");
		return mv;
	}
	@RequestMapping(path ="add.do", method = RequestMethod.POST)
	public ModelAndView addFilmToDB() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/Views/addFilm.jsp");
		return mv;
	}
//	add a language to language ID method. 
	
}