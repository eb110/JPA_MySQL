package com.JPA.MySQL.service;

import com.JPA.MySQL.model.ActorFeedback;
import com.JPA.MySQL.repository.ActorFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorFeedbackServiceImpl implements ActorFeedbackService{

    @Autowired
    ActorFeedbackRepository actorFeedbackRepository;

    @Override
    public ActorFeedback saveDirector(ActorFeedback actorFeedback) {
        return actorFeedbackRepository.save(actorFeedback);
    }

    @Override
    public Iterable<ActorFeedback> getAllActorFeedbacks() {
        return actorFeedbackRepository.findAll();
    }

    @Override
    public String getActorFeedback(int id) {
        return actorFeedbackRepository.findById(id).toString();
    }

    @Override
    public void deleteActorFeedback(int id) {
        actorFeedbackRepository.deleteById(id);
    }
}
