/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
the data-base table film model
 */

@Entity
public class VladFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //
    private String title;
    private String description;
    private String length;
    private String rating;
   // private int release_year;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

   // public int getRelease_year() {
   //     return release_year;
 //   }

  //  public void setRelease_year(int release_year) {
    //    this.release_year = release_year;
   // }
}
