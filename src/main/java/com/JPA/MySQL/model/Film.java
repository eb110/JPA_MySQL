package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int idDirector;

    @OneToMany(targetEntity = FilmFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFilm", referencedColumnName = "id")
    private List<Film> filmFeedbackList;

    @OneToMany(targetEntity = FilmActors.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFilm", referencedColumnName = "id")
    private List<Film> filmActorsList;
}
