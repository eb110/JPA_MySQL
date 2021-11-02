package com.JPA.MySQL.repository;

import com.JPA.MySQL.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer> {
}
