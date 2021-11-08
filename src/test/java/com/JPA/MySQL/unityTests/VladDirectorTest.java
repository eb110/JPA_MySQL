package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.VladDirector;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VladDirectorTest {

    VladDirector director = new VladDirector();

    @Test
    void getId() {
        director.setId(1);
        assertEquals(1, director.getId(), "The id is not correct");
    }

    @Test
    void setId() {
        director.setId(1);
        assertEquals(1, director.getId(), "The id is not correct");
    }

    @Test
    void getName() {
        director.setName("zenek");
        assertEquals("zenek",director.getName(), "The name is not correct");
    }

    @Test
    void setName() {
        director.setName("zenek");
        assertEquals("zenek",director.getName(), "The name is not correct");
    }

    @Test
    void getSurname() {
        director.setSurname("plech");
        assertEquals("plech", director.getSurname(), "The surname is not correct");
    }

    @Test
    void setSurname() {
        director.setSurname("plech");
        assertEquals("plech", director.getSurname(), "The surname is not correct");
    }

    @Test
    void getNationality() {
        director.setNationality("polish");
        assertEquals("polish", director.getNationality(), "The surname is not correct");
    }

    @Test
    void setNationality() {
        director.setNationality("polish");
        assertEquals("polish", director.getNationality(), "The surname is not correct");
    }

    @Test
    void getDob() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try{
            date = dateFormat.parse("1955/12/24");
        }catch (Exception e){}
        director.setDob(new Timestamp(date.getTime()));
        assertEquals("1955-12-24 00:00:00.0", director.getDob().toString(), "The date is not correct");
    }

    @Test
    void setDob() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try{
            date = dateFormat.parse("1955/12/24");
        }catch (Exception e){}
        director.setDob(new Timestamp(date.getTime()));
        assertEquals("1955-12-24 00:00:00.0", director.getDob().toString(), "The date is not correct");
    }

    @Test
    void getFilmList() {
        director.setFilmList(new ArrayList<>());
        assertNotEquals(null, director.getFilmList(), "getActorFeedback doesn't work");
    }

    @Test
    void setFilmList() {
        director.setFilmList(new ArrayList<>());
        assertNotEquals(null, director.getFilmList(), "getActorFeedback doesn't work");
    }

    @Test
    void getDirectorFeedbackList() {
        director.setDirectorFeedbackList(new ArrayList<>());
        assertNotEquals(null, director.getDirectorFeedbackList(), "getActorFeedback doesn't work");
    }

    @Test
    void setDirectorFeedbackList() {
        director.setDirectorFeedbackList(new ArrayList<>());
        assertNotEquals(null, director.getDirectorFeedbackList(), "getActorFeedback doesn't work");
    }
}