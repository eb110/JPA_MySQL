package com.JPA.MySQL.service;

import com.JPA.MySQL.model.ActorFeedback;

public interface ActorFeedbackService {
    public ActorFeedback saveDirector(ActorFeedback actorFeedback);
    public Iterable<ActorFeedback> getAllActorFeedbacks();
    public String getActorFeedback(int id);
    public void deleteActorFeedback(int id);
}
