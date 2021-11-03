package com.JPA.MySQL.service;

import com.JPA.MySQL.model.FilmFeedback;
import com.JPA.MySQL.repository.FilmFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmFeedbackServiceImpl implements FilmFeedbackService{

    @Autowired
    FilmFeedbackRepository filmFeedbackRepository;

    @Override
    public FilmFeedback saveFilmFeedback(FilmFeedback filmFeedback) {
        return filmFeedbackRepository.save(filmFeedback);
    }

    @Override
    public Iterable<FilmFeedback> getAllFilmFeedback() {
        return filmFeedbackRepository.findAll();
    }

    @Override
    public String getFilmFeedback(int id) {
        return filmFeedbackRepository.findById(id).toString();
    }

    @Override
    public void deleteFilmFeedback(int id) {
        filmFeedbackRepository.deleteById(id);
    }
}
