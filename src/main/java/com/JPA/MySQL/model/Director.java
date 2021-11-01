package com.JPA.MySQL.model;

import jdk.jfr.DataAmount;
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
    private int id;
    private String name;
    private String surname;
    private String nationality;
    @OneToMany(targetEntity = Film.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDirector", referencedColumnName = "id")
    private List<Director> directors;
}
