package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.FilmFeedback;
import com.JPA.MySQL.service.FilmFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmFeedback")
public class FilmFeedbackController {
    @Autowired
    private FilmFeedbackService filmFeedbackService;

    @PostMapping("/add")
    private String add(@RequestBody FilmFeedback filmFeedback){
        filmFeedbackService.saveFilmFeedback(filmFeedback);
        return "New film feedback is added";
    }

    @GetMapping("/getAll")
    public Iterable<FilmFeedback> getAllFilmFeedback(){
        return filmFeedbackService.getAllFilmFeedback();
    }

    @GetMapping("/getById/{id}")
    public String getFilmFeedback(@PathVariable("id") int id){
        return filmFeedbackService.getFilmFeedback(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        filmFeedbackService.deleteFilmFeedback(id);
    }
}
