/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.VladActor;
import com.JPA.MySQL.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
The actor rest API controller
 */

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RequestMapping("/actor")

public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping("/add")
    public ResponseEntity<VladActor> add(@RequestBody VladActor actor){
        return new ResponseEntity<>(actorService.saveActor(actor), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<VladActor>> getAllActor(){
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<VladActor> getActor(@PathVariable("id") int id){
        return new ResponseEntity<>(actorService.getActor(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        actorService.deleteActor(id);
    }
}
