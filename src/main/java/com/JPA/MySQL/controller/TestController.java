package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.Film;
import com.JPA.MySQL.model.Test;
import com.JPA.MySQL.service.FilmService;
import com.JPA.MySQL.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/add")
    private String add(@RequestBody Test test){
        testService.saveTest(test);
        return "New test is added";
    }

    @GetMapping("/getAll")
    public Iterable<Test> getAllTests(){
        return testService.getAllTests();
    }

    @GetMapping("/getById/{id}")
    public String getTest(@PathVariable("id") int id){
        return testService.getTest(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        testService.deleteTest(id);
    }
}
