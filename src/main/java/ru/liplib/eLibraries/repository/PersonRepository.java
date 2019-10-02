package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.Person;

import java.sql.Date;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByFioContaining (String fio);
    List<Person> findByFioAndBirthdate (String fio, Date birthdate);
}
