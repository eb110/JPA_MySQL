package com.JPA.MySQL.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VladFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //
    private String title;
    private int idDirector;

    @OneToMany(targetEntity = VladFilmFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFilm", referencedColumnName = "id")
    private List<VladFilmFeedback> filmFeedbackList = new ArrayList<>();

    @OneToMany(targetEntity = VladFilmActors.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFilm", referencedColumnName = "id")
    private List<VladFilmActors> filmActorsList = new ArrayList<>();

    public VladFilm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public List<VladFilmFeedback> getFilmFeedbackList() {
        return filmFeedbackList;
    }

    public void setFilmFeedbackList(List<VladFilmFeedback> filmFeedbackList) {
        this.filmFeedbackList = filmFeedbackList;
    }

    public List<VladFilmActors> getFilmActorsList() {
        return filmActorsList;
    }

    public void setFilmActorsList(List<VladFilmActors> filmActorsList) {
        this.filmActorsList = filmActorsList;
    }
}
