/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActorFeedback;

public interface ActorFeedbackService {
    public VladActorFeedback saveActorFeedback(VladActorFeedback actorFeedback);
    public Iterable<VladActorFeedback> getAllActorFeedbacks();
    public VladActorFeedback getActorFeedback(int id);
    public void deleteActorFeedback(int id);
    public void updateActorFeedback(VladActorFeedback actorFeedback, int id);
}
