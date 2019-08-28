package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
