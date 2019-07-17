package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liplib.eLibraries.dao.PersonDAO;
import ru.liplib.eLibraries.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Person> allPersons() {
        return personDAO.allPersons();
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        personDAO.deletePerson(person);
    }

    @Override
    @Transactional
    public void editPerson(Person person) {
        personDAO.editPerson(person);
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }
}
