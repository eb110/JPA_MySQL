/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilmActors;
import com.JPA.MySQL.repository.FilmActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
The film and actor crud operations
 */

@Service
public class FilmActorsServiceImpl implements FilmActorsService{

    @Autowired
    FilmActorsRepository filmActorsRepository;

    @Override
    public VladFilmActors saveFilmActors(VladFilmActors vladFilmActors) {
        return filmActorsRepository.save(vladFilmActors);
    }

    @Override
    public Iterable<VladFilmActors> getAllFilmActors() {
        return filmActorsRepository.findAll();
    }

    @Override
    public VladFilmActors getFilmActors(int id) {
        return filmActorsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFilmActors(int id) {
        filmActorsRepository.deleteById(id);
    }
}
