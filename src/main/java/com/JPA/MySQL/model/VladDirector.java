/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
the data-base table director model
 */

@Entity
public class VladDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String nationality;
    private Date dob;

    public VladDirector() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<VladFilm> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<VladFilm> filmList) {
        this.filmList = filmList;
    }

    public List<VladDirectorFeedback> getDirectorFeedbackList() {
        return directorFeedbackList;
    }

    public void setDirectorFeedbackList(List<VladDirectorFeedback> directorFeedbackList) {
        this.directorFeedbackList = directorFeedbackList;
    }

    @OneToMany(targetEntity = VladFilm.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDirector", referencedColumnName = "id")
    private List<VladFilm> filmList = new ArrayList<>();

    @OneToMany(targetEntity = VladDirectorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDirector", referencedColumnName = "id")
    private List<VladDirectorFeedback> directorFeedbackList = new ArrayList<>();
}
