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
    public Actor getActor(int id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteActor(int id) {
        actorRepository.deleteById(id);
    }


    /*
    @EventListener
    public void seed(ContextRefreshedEvent event){
        String[] names = {"Zenon", "Romek", "Janek", "Stefan", "Enrike"};
        String[] surname = {"Plech", "Jankowski", "Kmiecik", "Kulczak", "Wazowsky"};
        for(int i = 0; i < 5; i++) {
            Actor actor = new Actor();
            actor.setName(names[i]);
            actor.setSurname(surname[i]);
            actorRepository.save(actor);
        }
    }
    */
}
