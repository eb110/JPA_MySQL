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
public class VladFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int idDirector;

    @OneToMany(targetEntity = VladFilmFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFilm", referencedColumnName = "id")
    private List<VladFilm> vladFilmFeedbackList;

    @OneToMany(targetEntity = VladFilmActors.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFilm", referencedColumnName = "id")
    private List<VladFilm> vladFilmActorsList;
}
