package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladDirectorFeedback;

public interface DirectorFeedbackService {
    public VladDirectorFeedback saveDirectorFeedback(VladDirectorFeedback vladDirectorFeedback);
    public Iterable<VladDirectorFeedback> getAllDirectorFeedbacks();
    public VladDirectorFeedback getDirectorFeedback(int id);
    public void deleteDirectorFeedback(int id);
}
