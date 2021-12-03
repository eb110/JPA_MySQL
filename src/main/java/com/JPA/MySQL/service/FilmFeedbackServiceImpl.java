/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.model.VladFilmFeedback;
import com.JPA.MySQL.repository.FilmFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
The film feedback crud operations
 */

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
    public VladFilmFeedback getFilmFeedback(int id) {
        return filmFeedbackRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFilmFeedback(int id) {
        filmFeedbackRepository.deleteById(id);
    }

    @Override
    public void updateFilmFeedback(VladFilmFeedback filmFeedback, int id) {
        VladFilmFeedback updateFeedback = filmFeedbackRepository.findById(id).orElse(null);
        updateFeedback.setId(id);
        updateFeedback.setFeedback(filmFeedback.getFeedback());
        filmFeedbackRepository.save(updateFeedback);
    }
}
