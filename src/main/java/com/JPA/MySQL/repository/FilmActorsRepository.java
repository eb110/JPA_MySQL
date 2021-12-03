/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladFilmActors;
import org.springframework.data.repository.CrudRepository;

/*
The film actors repository
 */

public interface FilmActorsRepository extends CrudRepository<VladFilmActors, Integer> {
}
