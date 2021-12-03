/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.model.VladFilmFeedback;
import com.JPA.MySQL.service.FilmFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
The film feedback rest API controller
 */

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filmFeedback")
public class FilmFeedbackController {
    @Autowired
    private FilmFeedbackService filmFeedbackService;

    @PostMapping("/add")
    private String add(@RequestBody VladFilmFeedback vladFilmFeedback){
        filmFeedbackService.saveFilmFeedback(vladFilmFeedback);
        return "New film feedback is added";
    }

    @GetMapping("/getAll")
    public Iterable<VladFilmFeedback> getAllFilmFeedback(){
        return filmFeedbackService.getAllFilmFeedback();
    }

    @GetMapping("/getById/{id}")
    public VladFilmFeedback getFilmFeedback(@PathVariable("id") int id){
        return filmFeedbackService.getFilmFeedback(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        filmFeedbackService.deleteFilmFeedback(id);
    }

    @PutMapping("/add/{id}")
    public String updateFeedback(@RequestBody VladFilmFeedback filmFeedback, @PathVariable("id") int id){
        System.out.println(filmFeedback.getFeedback());
        filmFeedbackService.updateFilmFeedback(filmFeedback, id);
        return "film feedback updated";
    }
}
