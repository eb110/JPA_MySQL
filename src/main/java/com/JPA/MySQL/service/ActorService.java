/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActor;

public interface ActorService {
    public VladActor saveActor(VladActor actor);
    public Iterable<VladActor> getAllActors();
    public VladActor getActor(int id);
    public void deleteActor(int id);
}
