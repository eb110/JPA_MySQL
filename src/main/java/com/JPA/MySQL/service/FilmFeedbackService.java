/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.model.VladFilmFeedback;

public interface FilmFeedbackService {
    public VladFilmFeedback saveFilmFeedback(VladFilmFeedback vladFilmFeedback);
    public Iterable<VladFilmFeedback> getAllFilmFeedback();
    public VladFilmFeedback getFilmFeedback(int id);
    public void deleteFilmFeedback(int id);
    public void updateFilmFeedback(VladFilmFeedback filmFeedback, int id);
}
