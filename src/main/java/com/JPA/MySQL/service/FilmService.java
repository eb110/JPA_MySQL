package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Film;

public interface FilmService {
    public Film saveFilm(Film film);
    public Iterable<Film> getAllFilms();
    public String getFilm(int id);
    public void deleteFilm(int id);
}
