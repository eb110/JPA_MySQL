package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladFilmFeedback;

public interface FilmFeedbackService {
    public VladFilmFeedback saveFilmFeedback(VladFilmFeedback vladFilmFeedback);
    public Iterable<VladFilmFeedback> getAllFilmFeedback();
    public VladFilmFeedback getFilmFeedback(int id);
    public void deleteFilmFeedback(int id);
}
