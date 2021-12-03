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
import java.util.List;

/*
the data-base table film feedback model
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class VladFilmFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idFilm;
    private int idUser;
    private String feedback;
}
