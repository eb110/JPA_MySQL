package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.Actor;
import com.JPA.MySQL.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping("/add")
    public ResponseEntity<Actor> add(@RequestBody Actor actor){
        return new ResponseEntity<>(actorService.saveActor(actor), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Actor>> getAllActor(){
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable("id") int id){
        return new ResponseEntity<>(actorService.getActor(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        actorService.deleteActor(id);
    }
}
