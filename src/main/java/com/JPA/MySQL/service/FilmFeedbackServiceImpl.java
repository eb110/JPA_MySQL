package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilmFeedback;
import com.JPA.MySQL.repository.FilmFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmFeedbackServiceImpl implements FilmFeedbackService{

    @Autowired
    FilmFeedbackRepository filmFeedbackRepository;

    @Override
    public VladFilmFeedback saveFilmFeedback(VladFilmFeedback vladFilmFeedback) {
        return filmFeedbackRepository.save(vladFilmFeedback);
    }

    @Override
    public Iterable<VladFilmFeedback> getAllFilmFeedback() {
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
