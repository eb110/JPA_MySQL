package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladDirector;
import com.JPA.MySQL.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public VladDirector saveDirector(VladDirector vladDirector) {
        return directorRepository.save(vladDirector);
    }

    @Override
    public Iterable<VladDirector> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public VladDirector getDirector(int id){
        return directorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDirector(int id) {
        directorRepository.deleteById(id);
    }


}
