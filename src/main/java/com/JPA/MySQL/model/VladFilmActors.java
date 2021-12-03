/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/*
the data-base table actor-film model
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "VladFilmActors")
@Table(name = "vlad_film_actors")
public class VladFilmActors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int idFilm;
    private int idActor;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    private VladActor actor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VladFilmActors )) return false;
        return id != null && id.equals(((VladFilmActors) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
     */

}
