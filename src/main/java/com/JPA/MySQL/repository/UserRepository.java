package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
