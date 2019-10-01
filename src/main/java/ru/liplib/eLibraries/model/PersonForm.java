package ru.liplib.eLibraries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class PersonForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthdate;
    private String giveLitres;
    private String giveNonfiction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGiveLitres() {
        return giveLitres;
    }

    public void setGiveLitres(String giveLitres) {
        this.giveLitres = giveLitres;
    }

    public String getGiveNonfiction() {
        return giveNonfiction;
    }

    public void setGiveNonfiction(String giveNonfiction) {
        this.giveNonfiction = giveNonfiction;
    }
}