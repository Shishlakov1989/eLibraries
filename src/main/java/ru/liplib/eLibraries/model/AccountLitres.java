package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "accLitres")
public class AccountLitres {
    @Id
    @Column(name = "id_accLitres")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private boolean issued;
    private String dateOfIssue;
    private int id_person;
    private int libraryNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int user) {
        this.id_person = user;
    }

    public int getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(int libraryNum) {
        this.libraryNum = libraryNum;
    }
}
