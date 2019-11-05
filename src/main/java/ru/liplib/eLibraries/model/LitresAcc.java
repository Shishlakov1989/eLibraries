package ru.liplib.eLibraries.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class LitresAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    @Column(name = "password")
    private byte[] enc_pass;

    @Transient
    private String password;

    private boolean issued;
    private Date dateOfIssue;
    private int filial;
    private boolean valid;

    public LitresAcc() {

    }

    public LitresAcc(String login, String password) {
        this.login = login;
        this.password = password;
        this.valid = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte[] getEnc_pass() {
        return enc_pass;
    }

    public void setEnc_pass(byte[] enc_pass) {
        this.enc_pass = enc_pass;
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

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
