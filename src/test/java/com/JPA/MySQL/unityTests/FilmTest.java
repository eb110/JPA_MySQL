package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    Film film = new Film();

    @Test
    void getId() {
        film.setId(1);
        assertEquals(1, film.getId(), "The id of the film is not correct");
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