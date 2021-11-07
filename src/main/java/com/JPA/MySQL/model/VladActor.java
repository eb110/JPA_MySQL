package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "VladActor")
@Table(name = "vlad_actor")
public class VladActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
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
