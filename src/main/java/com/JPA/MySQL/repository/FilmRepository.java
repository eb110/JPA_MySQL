package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
