package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.Actor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    Actor actor = new Actor();

    @Test
    void getId() {
        actor.setId(1);
        assertEquals(1, actor.getId(), "The id is not correct");
    }

    @Test
    void getName() {
    }

    @Test
    void getSurname() {
    }

    @Test
    void getNationality() {
    }

    @Test
    void getDob() {
    }

    @Test
    void setId() {
    }

    @Test
    void setName() {
    }

    @Test
    void setSurname() {
    }

    @Test
    void setNationality() {
    }

    @Test
    void setDob() {
    }
}