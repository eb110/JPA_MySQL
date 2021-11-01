package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Actor;

public interface ActorService {
    public Actor saveActor(Actor actor);
    public Iterable<Actor> getAllActors();
    public String getActor(int id);
    public void deleteActor(int id);
}
