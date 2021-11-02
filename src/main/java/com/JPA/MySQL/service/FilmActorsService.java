package com.JPA.MySQL.service;

import com.JPA.MySQL.model.FilmActors;

public interface FilmActorsService {
    public FilmActors saveFilmActors(FilmActors filmActors);
    public Iterable<FilmActors> getAllFilmActors();
    public String getFilmActors(int id);
    public void deleteFilmActors(int id);
}
