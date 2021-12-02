package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.model.VladDirectorFeedback;
import com.JPA.MySQL.repository.DirectorFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorFeedbackServiceImpl implements DirectorFeedbackService {

    @Autowired
    DirectorFeedbackRepository directorFeedbackRepository;

    @Override
    public VladDirectorFeedback saveDirectorFeedback(VladDirectorFeedback vladDirectorFeedback) {
        return directorFeedbackRepository.save(vladDirectorFeedback);
    }

    @Override
    public Iterable<VladDirectorFeedback> getAllDirectorFeedbacks() {
        return directorFeedbackRepository.findAll();
    }

    @Override
    public VladDirectorFeedback getDirectorFeedback(int id) {
        return directorFeedbackRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDirectorFeedback(int id) {
        directorFeedbackRepository.deleteById(id);
    }

    @Override
    public void updateDirectorFeedback(VladDirectorFeedback directorFeedback, int id) {
        VladDirectorFeedback updateFeedback = directorFeedbackRepository.findById(id).orElse(null);
        updateFeedback.setId(id);
        updateFeedback.setFeedback(directorFeedback.getFeedback());
        directorFeedbackRepository.save(updateFeedback);
    }
}
