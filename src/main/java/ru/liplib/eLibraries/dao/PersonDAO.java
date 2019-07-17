package ru.liplib.eLibraries.dao;

import ru.liplib.eLibraries.model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> allPersons();
    void addPerson(Person person);
    void editPerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(int id);
}
