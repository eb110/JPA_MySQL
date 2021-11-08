package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.VladActor;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VladActorTest {

    VladActor actor = new VladActor();

    @Test
    void getId() {
        actor.setId(1);
        assertEquals(1, actor.getId(), "The id is not correct");
    }

    @Test
    void getName() {
        actor.setName("zenek");
        assertEquals("zenek", actor.getName(), "The name is not correct");
    }

    @Test
    void getSurname() {
        actor.setSurname("plech");
        assertEquals("plech", actor.getSurname(), "The surname is not correct");
    }

    @Test
    void getNationality() {
        actor.setNationality("polish");
        assertEquals("polish", actor.getNationality(), "The surname is not correct");
    }

    @Test
    void getDob() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try{
            date = dateFormat.parse("1955/12/24");
        }catch (Exception e){}
        actor.setDob(new Timestamp(date.getTime()));
        assertEquals("1955-12-24 00:00:00.0", actor.getDob().toString(), "The date is not correct");
    }

    @Test
    void setId() {
        actor.setId(1);
        assertEquals(1, actor.getId(), "The id is not correct");
    }

    @Test
    void setName() {
        actor.setName("zenek");
        assertEquals("zenek", actor.getName(), "The name is not correct");
    }

    @Test
    void setSurname() {
        actor.setSurname("plech");
        assertEquals("plech", actor.getSurname(), "The surname is not correct");
    }

    @Test
    void setNationality() {
        actor.setNationality("polish");
        assertEquals("polish", actor.getNationality(), "The surname is not correct");
    }

    @Test
    void setDob() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try{
            date = dateFormat.parse("1955/12/24");
        }catch (Exception e){}
        actor.setDob(new Timestamp(date.getTime()));
        assertEquals("1955-12-24 00:00:00.0", actor.getDob().toString(), "The date is not correct");
    }

    @Test
    void setActorFeedbackList() {
        actor.setActorFeedbackList(new ArrayList<>());
        assertNotEquals(null, actor.getActorFeedbackList(), "getActorFeedback doesn't work");
    }

    @Test
    void setFilmActorsList() {
        actor.setFilmActorList(new ArrayList<>());
        assertNotEquals(null, actor.getFilmActorList(), "getFilmActorsList doesn't work");
    }

    @Test
    void getActorFeedbackList() {
        actor.setActorFeedbackList(new ArrayList<>());
        assertNotEquals(null, actor.getActorFeedbackList(), "getActorFeedback doesn't work");
    }

    @Test
    void getFilmActorsList() {
        actor.setFilmActorList(new ArrayList<>());
        assertNotEquals(null, actor.getFilmActorList(), "getFilmActorsList doesn't work");
    }
}