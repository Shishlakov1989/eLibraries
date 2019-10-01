package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;
    private String name;
    private String patronymic;
    private Date birthdate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "litres_id")
    private LitresAcc litres;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nonfiction_id")
    private Nonfiction nonfiction;

    public Person() {
    }

    public Person(String surname, String name, String patronymic, Date birthdate) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
    }

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

    public LitresAcc getLitres() {
        return litres;
    }

    public void setLitres(LitresAcc litres) {
        this.litres = litres;
    }
}
