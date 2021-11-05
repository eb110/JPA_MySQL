package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladUser;

public interface UserService {
    public VladUser saveUser(VladUser user);
    public Iterable<VladUser> getAllUser();
    public String getUser(int id);
    public void deleteUser(int id);
}
