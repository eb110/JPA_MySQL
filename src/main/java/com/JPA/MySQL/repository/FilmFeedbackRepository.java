package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladFilmFeedback;
import org.springframework.data.repository.CrudRepository;

public interface FilmFeedbackRepository extends CrudRepository<VladFilmFeedback, Integer> {
}
