package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Film;
import com.JPA.MySQL.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService{
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Iterable<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public String getFilm(int id){
        return filmRepository.findById(id).toString();
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }
}
