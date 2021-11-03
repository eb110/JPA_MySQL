package com.JPA.MySQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String attrib1;
    private String testfield;

    public Test(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttrib1() {
        return attrib1;
    }

    public void setAttrib1(String attrib1) {
        this.attrib1 = attrib1;
    }

    public String getTestfield() {
        return testfield;
    }

    public void setTestfield(String testfield) {
        this.testfield = testfield;
    }
}
