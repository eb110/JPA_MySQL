package com.JPA.MySQL.service;

import com.JPA.MySQL.model.DirectorFeedback;

public interface DirectorFeedbackService {
    public DirectorFeedback saveDirectorFeedback(DirectorFeedback directorFeedback);
    public Iterable<DirectorFeedback> getAllDirectorFeedbacks();
    public String getDirectorFeedback(int id);
    public void deleteDirectorFeedback(int id);
}
