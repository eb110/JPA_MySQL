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
public class DirectorFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idUser;
    private int idDirector;
    private String feedback;
}
