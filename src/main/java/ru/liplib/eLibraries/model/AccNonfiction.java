package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "accnonfiction")
public class AccNonfiction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_accNonfiction;
    private int nf_id;
    private String login;
    private String password;
    private boolean issued;
    private Date dateOfIssue;
    private int libraryNum;

    public AccNonfiction() {
    }

    public long getId_accNonfiction() {
        return id_accNonfiction;
    }

    public void setId_accNonfiction(long id_accNonfiction) {
        this.id_accNonfiction = id_accNonfiction;
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
