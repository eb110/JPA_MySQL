package com.JPA.MySQL.service;

import com.JPA.MySQL.model.DirectorFeedback;
import com.JPA.MySQL.repository.DirectorFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorFeedbackServiceImpl implements DirectorFeedbackService {

    @Autowired
    DirectorFeedbackRepository directorFeedbackRepository;

    @Override
    public DirectorFeedback saveDirectorFeedback(DirectorFeedback directorFeedback) {
        return directorFeedbackRepository.save(directorFeedback);
    }

    @Override
    public Iterable<DirectorFeedback> getAllDirectorFeedbacks() {
        return directorFeedbackRepository.findAll();
    }

    @Override
    public String getDirectorFeedback(int id) {
        return directorFeedbackRepository.findById(id).toString();
    }

    @Override
    public void deleteDirectorFeedback(int id) {
        directorFeedbackRepository.deleteById(id);
    }
}