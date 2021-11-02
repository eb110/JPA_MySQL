package com.JPA.MySQL.service;

import com.JPA.MySQL.model.FilmFeedback;

public interface FilmFeedbackService {
    public FilmFeedback saveFilmFeedback(FilmFeedback filmFeedback);
    public Iterable<FilmFeedback> getAllFilmFeedback();
    public String getFilmFeedback(int id);
    public void deleteFilmFeedback(int id);
}
