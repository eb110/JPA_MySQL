package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActor;
import com.JPA.MySQL.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    ActorRepository actorRepository;

    @Override
    public VladActor saveActor(VladActor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Iterable<VladActor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public VladActor getActor(int id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteActor(int id) {
        actorRepository.deleteById(id);
    }

}
