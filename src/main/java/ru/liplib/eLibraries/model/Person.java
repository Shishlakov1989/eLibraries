package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fio;
    private Date birthdate;
    private String hasLitres;
    private String hasNonfiction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User librarian;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "litres_id")
    private LitresAcc litres;

    public Person() {
    }

    public Person(String fio, Date birthdate, String hasLitres, String hasNonfiction, User user) {
        this.fio = fio;
        this.birthdate = birthdate;
        this.hasLitres = hasLitres;
        this.hasNonfiction = hasNonfiction;
        this.librarian = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public User getLibrarian() {
        return librarian;
    }

    public void setLibrarian(User librarian) {
        this.librarian = librarian;
    }

    public LitresAcc getLitres() {
        return litres;
    }

    public void setLitres(LitresAcc litres) {
        this.litres = litres;
    }

    public String librarianName() {
        return librarian != null ? librarian.getUsername() : "<none>";
    }
}
