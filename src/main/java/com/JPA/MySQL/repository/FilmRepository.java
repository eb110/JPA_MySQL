package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladFilm;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<VladFilm, Integer> {
}
