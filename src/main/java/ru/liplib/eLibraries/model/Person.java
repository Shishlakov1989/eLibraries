package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;
    private Date birthdate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "litres_id")
    private LitresAcc litres;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nonfiction_id")
    private NonfictionAcc nonfiction;

    public Person() {
    }

    public Person(PersonForm personForm) {
        this.fio = personForm.getFio();
        this.birthdate = personForm.getBirthday();
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

    public LitresAcc getLitres() {
        return litres;
    }

    public void setLitres(LitresAcc litres) {
        this.litres = litres;
    }

    public NonfictionAcc getNonfiction() {
        return nonfiction;
    }

    public void setNonfiction(NonfictionAcc nonfiction) {
        this.nonfiction = nonfiction;
    }
}
