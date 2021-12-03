/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilmActors;

public interface FilmActorsService {
    public VladFilmActors saveFilmActors(VladFilmActors vladFilmActors);
    public Iterable<VladFilmActors> getAllFilmActors();
    public VladFilmActors getFilmActors(int id);
    public void deleteFilmActors(int id);
}
