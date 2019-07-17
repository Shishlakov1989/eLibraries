package ru.liplib.eLibraries.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.liplib.eLibraries.model.Person;

import java.util.*;

@Repository
public class PersonDaoImpl implements PersonDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> allPersons() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Person").list();
    }

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Override
    public void editPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
    }

    @Override
    public void deletePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(person);
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }
}
