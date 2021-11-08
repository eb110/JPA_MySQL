package com.JPA.MySQL.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VladActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;

    public VladActor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public List<VladActorFeedback> getActorFeedbackList() {
        return actorFeedbackList;
    }

    public void setActorFeedbackList(List<VladActorFeedback> actorFeedbackList) {
        this.actorFeedbackList = actorFeedbackList;
    }

    public List<VladFilmActors> getFilmActorList() {
        return filmActorList;
    }

    public void setFilmActorList(List<VladFilmActors> filmActorList) {
        this.filmActorList = filmActorList;
    }

    private String nationality;
    private Timestamp dob;

    @OneToMany(targetEntity = VladActorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<VladActorFeedback> actorFeedbackList = new ArrayList<>();

    @OneToMany(targetEntity = VladFilmActors.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<VladFilmActors> filmActorList = new ArrayList<>();

    /*
    @OneToMany(
            mappedBy = "actor",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<VladFilmActors> filmActorList = new ArrayList<>();

    @OneToMany(
            mappedBy = "actor",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<VladActorFeedback> actorFeedbackList = new ArrayList<>();

    public void addFilmActors(VladFilmActors filmActors) {
        filmActorList.add(filmActors);
        filmActors.setActor(this);
    }

    public void removeComment(VladFilmActors filmActors) {
        filmActorList.remove(filmActors);
        filmActors.setActor(null);
    }
    */

}
