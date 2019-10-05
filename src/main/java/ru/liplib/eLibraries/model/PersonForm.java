package ru.liplib.eLibraries.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class PersonForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Данное поле не может быть пустым")
//    @Size(min = 2, max = 20, message = "Данное поле должно содержать от 2 до 20 символов")
    private String surname;

//    @NotBlank(message = "Данное поле не может быть пустым")
//    @Size(min = 2, max = 10, message = "Данное поле должно содержать от 2 до 10 символов (возможно использованы недопустимые символы)")
    private String name;

//    @NotBlank(message = "Данное поле не может быть пустым")
//    @Size(min = 2, max = 15, message = "Данное поле должно содержать от 2 до 15 символов (возможно использованы недопустимые символы)")
    private String patronymic;

    private String birthdate;
    @Transient
    private Date birthday;
    private String giveLitres;
    private String giveNonfiction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGiveLitres() {
        return giveLitres;
    }

    public void setGiveLitres(String giveLitres) {
        this.giveLitres = giveLitres;
    }

    public String getGiveNonfiction() {
        return giveNonfiction;
    }

    public void setGiveNonfiction(String giveNonfiction) {
        this.giveNonfiction = giveNonfiction;
    }

    public String getFio() {
        return this.surname + " " + this.name + " " + this.patronymic;
    }
}