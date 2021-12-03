/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.service.ActorFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
The actor feedback rest API controller
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/actorFeedback")
public class ActorFeedbackController {
    @Autowired
    private ActorFeedbackService actorFeedbackService;

    @PostMapping("/add")
    private String add(@RequestBody VladActorFeedback actorFeedback){
        actorFeedbackService.saveActorFeedback(actorFeedback);
        return "New actor feedback is added";
    }

    @GetMapping("/getAll")
    public Iterable<VladActorFeedback> getAllActorFeedback(){
        return actorFeedbackService.getAllActorFeedbacks();
    }

    @GetMapping("/getById/{id}")
    public VladActorFeedback getActorFeedback(@PathVariable("id") int id){
        return actorFeedbackService.getActorFeedback(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        actorFeedbackService.deleteActorFeedback(id);
    }

    @PutMapping("/add/{id}")
    public String updateFeedback(@RequestBody VladActorFeedback actorFeedback, @PathVariable("id") int id){
        System.out.println(actorFeedback.getFeedback());
        actorFeedbackService.updateActorFeedback(actorFeedback, id);
        return "actor feedback updated";
    }
}
