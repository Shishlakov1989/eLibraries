package ru.liplib.eLibraries.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.Person;

import java.sql.Date;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Page<Person> findAll(Pageable pageable);
    Page<Person> findByFioContaining (String fio, Pageable pageable);
    List<Person> findByFioAndBirthdate (String fio, Date birthdate);
    Person findByLitres(Long id);
    Person findByNonfiction(Long id);
}
