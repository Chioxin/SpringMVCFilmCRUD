package com.skilldistillery.mvcfilmsite.controllers.info;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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
	@RequestMapping(path = "search.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView idSearch(@RequestParam(value = "filmId") int id) {
		ModelAndView mv = new ModelAndView();
		Film f = null;
		String failedSearch = "";
		f = dao.findFilmById(id);
		if (f != null) {
			mv.addObject("film", f);
			mv.addObject("updatedFilm", f); // we want to update the film separately from the original film.
			mv.setViewName("WEB-INF/Views/display.jsp");
		} else {
			mv.setViewName("WEB-INF/Views/index.jsp");
			failedSearch = "" + id;
			mv.addObject("failedSearch", failedSearch);
		}
	return mv;

	}

//	search by param keyWord
	@RequestMapping(path = "search.do", params = "keyWord", method = RequestMethod.GET)
	public ModelAndView keyWordSearch(@RequestParam(value = "keyWord") String keyWord) {
		ModelAndView mv = new ModelAndView();

		List<Film> films = new ArrayList<Film>(dao.findFilmByKeyWord(keyWord));
		mv.addObject("filmList", films);
		mv.setViewName("WEB-INF/Views/display.jsp");
		return mv;
	}

//	Add film from index
	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public ModelAndView addFilmForm() {
		Film f = new Film();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/Views/filmForm.jsp");
		mv.addObject("film", f);
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilmToDB(@Valid Film f, Errors e) {
		ModelAndView mv = new ModelAndView();
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + e.getErrorCount());
		if (e.hasErrors()) {
			mv.setViewName("WEB-INF/Views/filmForm.jsp");
		} else {
			Film insertedFilm = dao.insertFilm(f);
			mv.addObject("film", insertedFilm);
			mv.setViewName("WEB-INF/Views/display.jsp");
		}
		return mv;
	}

//		post delete
	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam(value = "filmId") int id) {
		ModelAndView mv = new ModelAndView();
		Film filmToDelete = dao.findFilmById(id);

		if (dao.deleteFilm(filmToDelete)) {
			mv.setViewName("WEB-INF/Views/index.jsp");
		} else {
			mv.setViewName("WEB-INF/Views/display.jsp");
			mv.addObject("filmNotDeleted", id);
			mv.addObject("film", filmToDelete);
		}
		return mv;
	}

//		update button controller
	//Denise or WHOMEVER, I can't figure out why the @Valid annotation isn't
	//working on the fields in the JSP. Would really love a pointer. -GMK
	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(@Valid Film updatedFilm, Errors e) {
		Film originalFilm = null;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/Views/display.jsp");
		mv.addObject("updatedFilm", updatedFilm);
		
		if (e.hasErrors()) {
			mv.addObject("updateFailure", true);
		} else {
			if (!dao.updateFilm(updatedFilm)) {
				mv.addObject("updateFailure", true);
			}
		}
		
		if (updatedFilm != null) {
			originalFilm = dao.findFilmById(updatedFilm.getId());
			mv.addObject("film", originalFilm);
		}
		return mv;
	}

}
