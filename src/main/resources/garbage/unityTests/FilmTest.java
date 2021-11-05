package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.VladFilm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    VladFilm vladFilm = new VladFilm();

    @Test
    void getId() {
        vladFilm.setId(1);
        assertEquals(1, vladFilm.getId(), "The id of the film is not correct");
    }

    @Test
    void getTitle() {
    }

    @Test
    void getIdDirector() {
    }

    @Test
    void setId() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setIdDirector() {
    }
}