package com.example.pr2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prepod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname, name, middlename, predmets, grafic;

    public Prepod(String Surname, String Name, String MiddleName, String Predmets, String Grafic) {
        this.surname = Surname;
        this.name = Name;
        this.middlename = MiddleName;
        this.predmets = Predmets;
        this.grafic = Grafic;
    }

    public Prepod() {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPredmets() {
        return predmets;
    }

    public void setPredmets(String predmets) {
        this.predmets = predmets;
    }

    public String getGrafic() {
        return grafic;
    }

    public void setGrafic(String grafic) {
        this.grafic = grafic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
