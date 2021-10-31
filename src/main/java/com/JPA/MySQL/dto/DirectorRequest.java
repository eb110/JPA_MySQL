package com.JPA.MySQL.dto;

import com.JPA.MySQL.model.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DirectorRequest {
    private Director director;
}
