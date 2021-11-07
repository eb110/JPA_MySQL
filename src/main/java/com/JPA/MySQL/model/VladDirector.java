package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class VladDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String nationality;
    private Date dob;

    public VladDirector(String name, String surname, String nationality){
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
    }

    @OneToMany(targetEntity = VladFilm.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDirector", referencedColumnName = "id")
    private List<VladFilm> filmList = new ArrayList<>();

    @OneToMany(targetEntity = VladDirectorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDirector", referencedColumnName = "id")
    private List<VladDirectorFeedback> directorFeedbackList = new ArrayList<>();
}
