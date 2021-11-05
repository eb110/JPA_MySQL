package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActorFeedback;

public interface ActorFeedbackService {
    public VladActorFeedback saveActorFeedback(VladActorFeedback actorFeedback);
    public Iterable<VladActorFeedback> getAllActorFeedbacks();
    public String getActorFeedback(int id);
    public void deleteActorFeedback(int id);
}
