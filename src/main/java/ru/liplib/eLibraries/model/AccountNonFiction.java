package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "accNonfiction")
public class AccountNonFiction {
    @Id
    @Column(name = "id_accNonfiction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int nf_id;
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

    public int getNf_id() {
        return nf_id;
    }

    public void setNf_id(int nf_id) {
        this.nf_id = nf_id;
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

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public int getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(int libraryNum) {
        this.libraryNum = libraryNum;
    }
}
