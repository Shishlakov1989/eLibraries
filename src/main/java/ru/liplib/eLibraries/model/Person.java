package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fio;
    private Date birthdate;
    private long id_litres;
    private long id_nonfiction;
    @Transient
    private String hasLitres;
    @Transient
    private String hasNonfiction;
    @Transient
    private int libNum;

    public Person() {
    }

    public Person(String fio, Date birthdate, String hasLitres, String hasNonfiction, int libNum) {
        this.fio = fio;
        this.birthdate = birthdate;
        this.hasLitres = hasLitres;
        this.hasNonfiction = hasNonfiction;
        this.libNum = libNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public long getId_litres() {
        return id_litres;
    }

    public void setId_litres(long id_litres) {
        this.id_litres = id_litres;
    }

    public long getId_nonfiction() {
        return id_nonfiction;
    }

    public void setId_nonfiction(long id_nonfiction) {
        this.id_nonfiction = id_nonfiction;
    }

    public String getHasLitres() {
        return hasLitres;
    }

    public void setHasLitres(String hasLitres) {
        this.hasLitres = hasLitres;
    }

    public String getHasNonfiction() {
        return hasNonfiction;
    }

    public void setHasNonfiction(String hasNonfiction) {
        this.hasNonfiction = hasNonfiction;
    }

    public int getLibNum() {
        return libNum;
    }

    public void setLibNum(int libNum) {
        this.libNum = libNum;
    }
}
