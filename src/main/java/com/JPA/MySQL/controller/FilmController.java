package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.Director;
import com.JPA.MySQL.model.Film;
import com.JPA.MySQL.service.DirectorService;
import com.JPA.MySQL.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @PostMapping("/add")
    private String add(@RequestBody Film film){
        filmService.saveFilm(film);
        return "New director is added";
    }

    @GetMapping("/getAll")
    public Iterable<Film> getAllDirectors(){
        return filmService.getAllFilms();
    }

    @GetMapping("/getById/{id}")
    public String getFilm(@PathVariable("id") int id){
        return filmService.getFilm(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        filmService.deleteFilm(id);
    }
}
