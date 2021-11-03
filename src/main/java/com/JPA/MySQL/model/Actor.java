package com.JPA.MySQL.model;

import com.JPA.MySQL.repository.ActorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String nationality;
    private Timestamp dob;

    public Actor(int id, String name, String surname, String nationality, Timestamp dob){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.dob = dob;
    }

    @OneToMany(targetEntity = FilmActors.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<Actor> filmActorsList;

    @OneToMany(targetEntity = ActorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idActor", referencedColumnName = "id")
    private List<Actor> filmActorFeedbackList;

}
