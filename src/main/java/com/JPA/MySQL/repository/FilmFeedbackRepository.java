/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladFilmFeedback;
import org.springframework.data.repository.CrudRepository;

/*
The film feedback repository
 */

public interface FilmFeedbackRepository extends CrudRepository<VladFilmFeedback, Integer> {
}
