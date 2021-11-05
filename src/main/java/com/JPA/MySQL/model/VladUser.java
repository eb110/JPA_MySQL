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
public class VladUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private String encryptedPassword;

    @OneToMany(targetEntity = VladFilmFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private List<VladUser> filmFeedbackList;

    @OneToMany(targetEntity = VladDirectorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private List<VladUser> directorFeedbackList;

    @OneToMany(targetEntity = VladActorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private List<VladUser> actorFeedbackList;
}
