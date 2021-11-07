package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.VladDirector;
import com.JPA.MySQL.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @PostMapping("/add")
    private String add(@RequestBody VladDirector vladDirector){
        directorService.saveDirector(vladDirector);
        return "New director is added";
    }

    @GetMapping("/getAll")
    public Iterable<VladDirector> getAllDirectors(){
        return directorService.getAllDirectors();
    }

    @GetMapping("/getById/{id}")
    public VladDirector getDirector(@PathVariable("id") int id){
        return directorService.getDirector(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        directorService.deleteDirector(id);
    }
}
