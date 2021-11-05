package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladActor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<VladActor, Integer> {
}
