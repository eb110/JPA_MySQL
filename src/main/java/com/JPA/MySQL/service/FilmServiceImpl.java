/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilm;
import com.JPA.MySQL.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
The film crud operations
 */

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public VladFilm saveFilm(VladFilm vladFilm) {
        return filmRepository.save(vladFilm);
    }

    @Override
    public Iterable<VladFilm> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public VladFilm getFilm(int id){
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }
}
