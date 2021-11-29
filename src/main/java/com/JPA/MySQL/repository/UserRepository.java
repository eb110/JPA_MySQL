package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.VladUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<VladUser, Integer> {

}
