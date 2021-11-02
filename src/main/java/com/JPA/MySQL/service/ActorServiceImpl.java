package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Actor;
import com.JPA.MySQL.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    ActorRepository actorRepository;

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Iterable<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public String getActor(int id) {
        return actorRepository.findById(id).toString();
    }

    @Override
    public void deleteActor(int id) {
        actorRepository.deleteById(id);
    }
}
