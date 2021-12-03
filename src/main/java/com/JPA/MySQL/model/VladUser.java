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
import java.util.ArrayList;
import java.util.List;

/*
the data-base table user model
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class VladUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String email;
    private String password;

    @OneToMany(targetEntity = VladFilmFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private List<VladFilmFeedback> filmFeedbackList = new ArrayList<>();

    @OneToMany(targetEntity = VladDirectorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private List<VladDirectorFeedback> directorFeedbackList = new ArrayList<>();

    @OneToMany(targetEntity = VladActorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private List<VladActorFeedback> actorFeedbackList = new ArrayList<>();
}
