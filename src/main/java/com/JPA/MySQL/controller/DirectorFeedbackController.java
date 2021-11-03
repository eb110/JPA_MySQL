package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.DirectorFeedback;
import com.JPA.MySQL.service.DirectorFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directorFeedback")
public class DirectorFeedbackController {
    @Autowired
    private DirectorFeedbackService directorFeedbackService;

    @PostMapping("/add")
    private String add(@RequestBody DirectorFeedback directorFeedback){
        directorFeedbackService.saveDirectorFeedback(directorFeedback);
        return "New director feedback is added";
    }

    @GetMapping("/getAll")
    public Iterable<DirectorFeedback> getAllDirectorFeedback(){
        return directorFeedbackService.getAllDirectorFeedbacks();
    }

    @GetMapping("/getById/{id}")
    public String getDirectorFeedback(@PathVariable("id") int id){
        return directorFeedbackService.getDirectorFeedback(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        directorFeedbackService.deleteDirectorFeedback(id);
    }
}
