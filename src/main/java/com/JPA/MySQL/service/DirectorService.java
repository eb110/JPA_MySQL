package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Director;

public interface DirectorService {
    public Director saveDirector(Director director);
    public Iterable<Director> getAllDirectors();
}
