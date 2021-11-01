package com.JPA.MySQL.service;

import com.JPA.MySQL.model.User;

public interface UserService {
    public User saveUser(User user);
    public Iterable<User> getAllUser();
    public String getUser(int id);
    public void deleteUser(int id);
}
