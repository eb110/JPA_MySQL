package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilmFeedback;

public interface FilmFeedbackService {
    public VladFilmFeedback saveFilmFeedback(VladFilmFeedback vladFilmFeedback);
    public Iterable<VladFilmFeedback> getAllFilmFeedback();
    public String getFilmFeedback(int id);
    public void deleteFilmFeedback(int id);
}
