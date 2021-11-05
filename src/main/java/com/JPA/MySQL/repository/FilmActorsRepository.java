package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladFilmActors;
import org.springframework.data.repository.CrudRepository;

public interface FilmActorsRepository extends CrudRepository<VladFilmActors, Integer> {
}
