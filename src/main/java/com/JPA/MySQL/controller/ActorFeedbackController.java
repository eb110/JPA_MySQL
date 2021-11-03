package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.ActorFeedback;
import com.JPA.MySQL.service.ActorFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actorFeedback")
public class ActorFeedbackController {
    @Autowired
    private ActorFeedbackService actorFeedbackService;

    @PostMapping("/add")
    private String add(@RequestBody ActorFeedback actorFeedback){
        actorFeedbackService.saveActorFeedback(actorFeedback);
        return "New actor feedback is added";
    }

    @GetMapping("/getAll")
    public Iterable<ActorFeedback> getAllActorFeedback(){
        return actorFeedbackService.getAllActorFeedbacks();
    }

    @GetMapping("/getById/{id}")
    public String getActorFeedback(@PathVariable("id") int id){
        return actorFeedbackService.getActorFeedback(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        actorFeedbackService.deleteActorFeedback(id);
    }
}
