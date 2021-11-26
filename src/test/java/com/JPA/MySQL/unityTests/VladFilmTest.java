package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.VladFilm;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VladFilmTest {
    VladFilm vladFilm = new VladFilm();

    @Test
    public void getId() {
        vladFilm.setId(1);
        assertEquals(1, vladFilm.getId(), "The id of the film is not correct");
    }

    @Test
    public void getTitle() {
        vladFilm.setTitle("new title");
        assertEquals("new title", vladFilm.getTitle(), "getTitle doesn't work");
    }

    @Test
    public void getIdDirector() {
        vladFilm.setIdDirector(1);
        assertEquals(1, vladFilm.getIdDirector(), "getIdDirector doesn't work");
    }

    @Test
    public void getFilmFeedbackList() {
        vladFilm.setFilmFeedbackList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmFeedbackList(), "getFilmFeedback doesn't work");
    }

    @Test
    public void getFilmActorsList() {
        vladFilm.setFilmActorsList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmActorsList(), "getFilmActorsList doesn't work");
    }

    @Test
    public void setId() {
        vladFilm.setId(1);
        assertEquals(1, vladFilm.getId(), "The id of the film is not correct");
    }

    @Test
    public void setTitle() {
        vladFilm.setTitle("new title");
        assertEquals("new title", vladFilm.getTitle(), "getTitle doesn't work");
    }

    @Test
    public void setIdDirector() {
        vladFilm.setIdDirector(1);
        assertEquals(1, vladFilm.getIdDirector(), "getIdDirector doesn't work");
    }

    @Test
    public void setFilmFeedbackList() {
        vladFilm.setFilmFeedbackList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmFeedbackList(), "getFilmFeedback doesn't work");
    }

    @Test
    public void setFilmActorsList() {
        vladFilm.setFilmActorsList(new ArrayList<>());
        assertNotEquals(null, vladFilm.getFilmActorsList(), "getFilmActorsList doesn't work");
    }
}