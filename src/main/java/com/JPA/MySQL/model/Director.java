package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String nationality;
    private Date dob;

    @OneToMany(targetEntity = Film.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDirector", referencedColumnName = "id")
    private List<Director> filmDirectorList;

    @OneToMany(targetEntity = DirectorFeedback.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDirector", referencedColumnName = "id")
    private List<Director> directorFeedbackList;
}
