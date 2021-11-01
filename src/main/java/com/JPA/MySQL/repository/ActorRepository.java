package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
}
