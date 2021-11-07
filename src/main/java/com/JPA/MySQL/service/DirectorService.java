package com.JPA.MySQL.service;

import com.JPA.MySQL.model.VladDirector;

public interface DirectorService {
    public VladDirector saveDirector(VladDirector vladDirector);
    public Iterable<VladDirector> getAllDirectors();
    public VladDirector getDirector(int id);
    public void deleteDirector(int id);
}
