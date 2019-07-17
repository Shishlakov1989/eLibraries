package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fio;
    private Calendar birthdate;
    private int id_accLitres;
    private int id_accNonfiction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public int getId_accLitres() {
        return id_accLitres;
    }

    public void setId_accLitres(int id_accLitres) {
        this.id_accLitres = id_accLitres;
    }

    public int getId_accNonfiction() {
        return id_accNonfiction;
    }

    public void setId_accNonfiction(int id_accNonfiction) {
        this.id_accNonfiction = id_accNonfiction;
    }

    @Override
    public String toString() {
        return fio + " " + birthdate;
    }
}
