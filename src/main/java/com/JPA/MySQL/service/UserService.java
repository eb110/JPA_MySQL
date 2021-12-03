/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladUser;

public interface UserService {
    public VladUser saveUser(VladUser user);
    public Iterable<VladUser> getAllUser();
    public VladUser getUser(int id);
    public void deleteUser(int id);
}
