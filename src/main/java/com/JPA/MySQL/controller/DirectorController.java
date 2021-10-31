package com.JPA.MySQL.controller;

import com.JPA.MySQL.dto.DirectorRequest;
import com.JPA.MySQL.model.Director;
import com.JPA.MySQL.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    private DirectorRepository directorRepository;

    @PostMapping("/add")
    private String placeDirector(@RequestBody DirectorRequest request){
        directorRepository.save(request.getDirector());
        return "New director is added";
    }

    @GetMapping("/getAll")
    public List<Director> getAllDirectors(){
        return directorRepository.findAll();
    }
}
