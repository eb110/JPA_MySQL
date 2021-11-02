package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Test;

public interface TestService {
    public Test saveTest(Test test);
    public Iterable<Test> getAllTests();
    public String getTest(int id);
    public void deleteTest(int id);
}
