/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladActorFeedback;
import org.springframework.data.repository.CrudRepository;

/*
The actor feedback repository
 */

public interface ActorFeedbackRepository extends CrudRepository<VladActorFeedback, Integer> {
}
