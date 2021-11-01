package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
