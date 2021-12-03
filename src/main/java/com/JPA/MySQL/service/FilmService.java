/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilm;

public interface FilmService {
    public VladFilm saveFilm(VladFilm vladFilm);
    public Iterable<VladFilm> getAllFilms();
    public VladFilm getFilm(int id);
    public void deleteFilm(int id);
}
