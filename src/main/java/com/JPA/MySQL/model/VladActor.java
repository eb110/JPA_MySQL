package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class VladActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String nationality;
    private Timestamp dob;

    @OneToMany(targetEntity = VladFilmActors.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<VladActor> filmActorsList;

    @OneToMany(targetEntity = VladActorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<VladActor> filmActorFeedbackList;

}
