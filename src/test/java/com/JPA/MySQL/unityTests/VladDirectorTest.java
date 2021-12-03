/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.unityTests;

import com.JPA.MySQL.model.VladDirector;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VladDirectorTest {

    VladDirector director = new VladDirector();

    @Test
    public void getId() {
        director.setId(1);
        assertEquals(1, director.getId());
    }

    @Test
    public void setId() {

    }

    @Test
    public void getName() {

    }

    @Test
    public void setName() {
    }

    @Test
    public void getSurname() {
    }

    @Test
    public void setSurname() {
    }

    @Test
    public void getNationality() {
    }

    @Test
    public void setNationality() {
    }

    @Test
    public void getDob() {
    }

    @Test
    public void setDob() {
    }

    @Test
    public void getFilmList() {
    }

    @Test
    public void setFilmList() {
    }

    @Test
    public void getDirectorFeedbackList() {
    }

    @Test
    public void setDirectorFeedbackList() {
    }
}