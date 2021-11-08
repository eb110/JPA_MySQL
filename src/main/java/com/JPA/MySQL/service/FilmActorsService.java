package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilmActors;

public interface FilmActorsService {
    public VladFilmActors saveFilmActors(VladFilmActors vladFilmActors);
    public Iterable<VladFilmActors> getAllFilmActors();
    public VladFilmActors getFilmActors(int id);
    public void deleteFilmActors(int id);
}
