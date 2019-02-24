package com.skilldistillery.mvcfilmsite.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws Throwable;
  public Actor findActorById(int actorId);
  public List<Actor> findActorsByFilmId(int filmId);
  public List<Film> findFilmByKeyWord(String key);
  public Film insertFilm(Film inputFilm);
  public void deleteFilm(Film deleteFilm);
  public Film updateFilm(Film modifiedFilm);
}
