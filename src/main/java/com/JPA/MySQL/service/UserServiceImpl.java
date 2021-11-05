package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladUser;
import com.JPA.MySQL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public VladUser saveUser(VladUser user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<VladUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String getUser(int id) {
        return userRepository.findById(id).toString();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
