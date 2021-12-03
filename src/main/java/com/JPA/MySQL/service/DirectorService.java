/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladDirector;

public interface DirectorService {
    public VladDirector saveDirector(VladDirector vladDirector);
    public Iterable<VladDirector> getAllDirectors();
    public VladDirector getDirector(int id);
    public void deleteDirector(int id);
}
