/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.model.VladDirectorFeedback;

public interface DirectorFeedbackService {
    public VladDirectorFeedback saveDirectorFeedback(VladDirectorFeedback vladDirectorFeedback);
    public Iterable<VladDirectorFeedback> getAllDirectorFeedbacks();
    public VladDirectorFeedback getDirectorFeedback(int id);
    public void deleteDirectorFeedback(int id);
    public void updateDirectorFeedback(VladDirectorFeedback directorFeedback, int id);
}
