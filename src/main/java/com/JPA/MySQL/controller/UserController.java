package com.JPA.MySQL.controller;

import com.JPA.MySQL.model.VladUser;
import com.JPA.MySQL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    private String add(@RequestBody VladUser user){
        userService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/getAll")
    public Iterable<VladUser> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/getById/{id}")
    public VladUser getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
