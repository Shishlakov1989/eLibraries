package ru.liplib.eLibraries.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Not be empty")
    private String fio;
    @NotNull(message = "Not be null")
    private Date birthdate;
    private String hasLitres;
    private String hasNonfiction;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "litres_id")
    private LitresAcc litres;

    public Person() {
    }

    public Person(String fio, Date birthdate, String hasLitres, String hasNonfiction) {
        this.fio = fio;
        this.birthdate = birthdate;
        this.hasLitres = hasLitres;
        this.hasNonfiction = hasNonfiction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LitresAcc getLitres() {
        return litres;
    }

    public void setLitres(LitresAcc litres) {
        this.litres = litres;
    }
}
