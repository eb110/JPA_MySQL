package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.VladFilm;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VladFilmTest {

    VladFilm vladFilm = new VladFilm();

    @Test
    void getId() {
        vladFilm.setId(1);
        assertEquals(1, vladFilm.getId(), "The id of the film is not correct");
    }

    @Test
    void getTitle() {
        vladFilm.setTitle("new title");
        assertEquals("new title", vladFilm.getTitle(), "getTitle doesn't work");
    }

    @Test
    void getIdDirector() {
        vladFilm.setIdDirector(1);
        assertEquals(1, vladFilm.getIdDirector(), "getIdDirector doesn't work");
    }

    @Test
    void getFilmFeedbackList() {
        vladFilm.setFilmFeedbackList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmFeedbackList(), "getFilmFeedback doesn't work");
    }

    @Test
    void getFilmActorsList() {
        vladFilm.setFilmActorsList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmActorsList(), "getFilmActorsList doesn't work");
    }

    @Test
    void setId() {
        vladFilm.setId(1);
        assertEquals(1, vladFilm.getId(), "The id of the film is not correct");
    }

    @Test
    void setTitle() {
        vladFilm.setTitle("new title");
        assertEquals("new title", vladFilm.getTitle(), "getTitle doesn't work");
    }

    @Test
    void setIdDirector() {
        vladFilm.setIdDirector(1);
        assertEquals(1, vladFilm.getIdDirector(), "getIdDirector doesn't work");
    }

    @Test
    void setFilmFeedbackList() {
        vladFilm.setFilmFeedbackList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmFeedbackList(), "getFilmFeedback doesn't work");
    }

    @Test
    void setFilmActorsList() {
        vladFilm.setFilmActorsList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmActorsList(), "getFilmActorsList doesn't work");
    }
}