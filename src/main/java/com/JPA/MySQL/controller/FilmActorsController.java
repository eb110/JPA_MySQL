package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.VladFilmActors;
import com.JPA.MySQL.service.FilmActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmActors")
public class FilmActorsController {
    @Autowired
    private FilmActorsService filmActorsService;

    @PostMapping("/add")
    private String add(@RequestBody VladFilmActors vladFilmActors){
        filmActorsService.saveFilmActors(vladFilmActors);
        return "New film actors is added";
    }

    @GetMapping("/getAll")
    public Iterable<VladFilmActors> getAllFilmActors(){
        return filmActorsService.getAllFilmActors();
    }

    @GetMapping("/getById/{id}")
    public VladFilmActors getFilmActors(@PathVariable("id") int id){
        return filmActorsService.getFilmActors(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        filmActorsService.deleteFilmActors(id);
    }
}
