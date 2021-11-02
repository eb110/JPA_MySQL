package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Test;
import com.JPA.MySQL.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Iterable<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public String getTest(int id) {
        return testRepository.findById(id).toString();
    }

    @Override
    public void deleteTest(int id) {
        testRepository.deleteById(id);
    }
}
