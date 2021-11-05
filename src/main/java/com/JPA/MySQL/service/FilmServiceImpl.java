package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilm;
import com.JPA.MySQL.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String getFilm(int id){
        return filmRepository.findById(id).toString();
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }
}
