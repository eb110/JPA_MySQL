/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladUser;
import com.JPA.MySQL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
The user crud operations
 */

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
    public VladUser getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
