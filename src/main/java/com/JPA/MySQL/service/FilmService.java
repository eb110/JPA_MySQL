package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilm;

public interface FilmService {
    public VladFilm saveFilm(VladFilm vladFilm);
    public Iterable<VladFilm> getAllFilms();
    public String getFilm(int id);
    public void deleteFilm(int id);
}
