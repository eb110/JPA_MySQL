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

/*
the data-base table actor feedback model
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "VladActorFeedback")
@Table(name = "vlad_actor_feedback")
public class VladActorFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idActor;
    private int idUser;
    private String feedback;

}
