package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Director;

import java.util.List;

public interface DirectorService {
    public Director saveDirector(Director director);
    public List<Director> getAllDirectors();
}
