package com.JPA.MySQL.service;

import com.JPA.MySQL.model.FilmActors;
import com.JPA.MySQL.repository.FilmActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmActorsServiceImpl implements FilmActorsService{

    @Autowired
    FilmActorsRepository filmActorsRepository;

    @Override
    public FilmActors saveFilmActors(FilmActors filmActors) {
        return filmActorsRepository.save(filmActors);
    }

    @Override
    public Iterable<FilmActors> getAllFilmActors() {
        return filmActorsRepository.findAll();
    }

    @Override
    public String getFilmActors(int id) {
        return filmActorsRepository.findById(id).toString();
    }

    @Override
    public void deleteFilmActors(int id) {
        filmActorsRepository.deleteById(id);
    }
}
