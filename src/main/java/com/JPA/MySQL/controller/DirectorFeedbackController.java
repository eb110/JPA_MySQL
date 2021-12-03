/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.model.VladDirectorFeedback;
import com.JPA.MySQL.model.VladFilmFeedback;
import com.JPA.MySQL.service.DirectorFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
The director feedback rest API controller
 */

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/directorFeedback")
public class DirectorFeedbackController {
    @Autowired
    private DirectorFeedbackService directorFeedbackService;

    @PostMapping("/add")
    private String add(@RequestBody VladDirectorFeedback vladDirectorFeedback){
        directorFeedbackService.saveDirectorFeedback(vladDirectorFeedback);
        return "New director feedback is added";
    }

    @GetMapping("/getAll")
    public Iterable<VladDirectorFeedback> getAllDirectorFeedback(){
        return directorFeedbackService.getAllDirectorFeedbacks();
    }

    @GetMapping("/getById/{id}")
    public VladDirectorFeedback getDirectorFeedback(@PathVariable("id") int id){
        return directorFeedbackService.getDirectorFeedback(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        directorFeedbackService.deleteDirectorFeedback(id);
    }

    @PutMapping("/add/{id}")
    public String updateFeedback(@RequestBody VladDirectorFeedback directorFeedback, @PathVariable("id") int id){
        directorFeedbackService.updateDirectorFeedback(directorFeedback, id);
        return "actor feedback updated";
    }
}
