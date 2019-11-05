package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PersonForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String birthdate;

    @Transient
    private Date birthday;

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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getFio() {
        StringBuilder sb = new StringBuilder(this.surname);

        if (!this.name.isEmpty()) {
            sb.append(" ");
            sb.append(this.name);
        }

        if (!this.patronymic.isEmpty()) {
            sb.append(" ");
            sb.append(this.patronymic);
        }

        return sb.toString();
    }
}