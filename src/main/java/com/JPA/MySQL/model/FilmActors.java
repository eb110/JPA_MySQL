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
public class FilmActors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idFilm;
    private int idActor;
}
