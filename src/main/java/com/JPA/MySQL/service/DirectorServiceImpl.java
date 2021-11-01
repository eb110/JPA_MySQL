package com.JPA.MySQL.service;

import com.JPA.MySQL.model.Director;
import com.JPA.MySQL.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Iterable<Director> getAllDirectors() {
        return directorRepository.findAll();
    }
}
