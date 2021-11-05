package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActor;

public interface ActorService {
    public VladActor saveActor(VladActor actor);
    public Iterable<VladActor> getAllActors();
    public VladActor getActor(int id);
    public void deleteActor(int id);
}
