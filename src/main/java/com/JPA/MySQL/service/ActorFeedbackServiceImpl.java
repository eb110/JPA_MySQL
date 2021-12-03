/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.repository.ActorFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
The actor feedback crud operations
 */

@Service
public class ActorFeedbackServiceImpl implements ActorFeedbackService{

    @Autowired
    ActorFeedbackRepository actorFeedbackRepository;

    @Override
    public VladActorFeedback saveActorFeedback(VladActorFeedback actorFeedback) {
        return actorFeedbackRepository.save(actorFeedback);
    }

    @Override
    public Iterable<VladActorFeedback> getAllActorFeedbacks() {
        return actorFeedbackRepository.findAll();
    }

    @Override
    public VladActorFeedback getActorFeedback(int id) {
        return actorFeedbackRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteActorFeedback(int id) {
        actorFeedbackRepository.deleteById(id);
    }

    @Override
    public void updateActorFeedback(VladActorFeedback actorFeedback, int id) {
        VladActorFeedback updateFeedback = actorFeedbackRepository.findById(id).orElse(null);
        updateFeedback.setId(id);
        updateFeedback.setFeedback(actorFeedback.getFeedback());
        actorFeedbackRepository.save(updateFeedback);
    }
}
