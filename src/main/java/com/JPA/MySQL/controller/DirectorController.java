package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.Director;
import com.JPA.MySQL.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @PostMapping("/add")
    private String add(@RequestBody Director director){
        directorService.saveDirector(director);
        return "New director is added";
    }

    @GetMapping("/getAll")
    public Iterable<Director> getAllDirectors(){
        return directorService.getAllDirectors();
    }
}
