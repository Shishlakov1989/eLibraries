package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "acclitres")
public class AccLitres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_accLitres;
    private String login;
    private String password;
    private boolean issued;
    private Date dateOfIssue;
    private int libraryNum;

    public AccLitres() {
    }

    public long getId_accLitres() {
        return id_accLitres;
    }

    public void setId_accLitres(long id_accLitres) {
        this.id_accLitres = id_accLitres;
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

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public int getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(int libraryNum) {
        this.libraryNum = libraryNum;
    }
}
