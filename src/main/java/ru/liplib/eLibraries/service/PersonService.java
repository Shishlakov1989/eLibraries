package ru.liplib.eLibraries.service;

import ru.liplib.eLibraries.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> allPersons();
    void addPerson(Person person);
    void deletePerson(Person person);
    void editPerson(Person person);
    Person getPersonById(int id);
}
