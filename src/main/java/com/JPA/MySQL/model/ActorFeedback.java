package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ActorFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idActor;
    private int idUser;
    private String feedback;
}
