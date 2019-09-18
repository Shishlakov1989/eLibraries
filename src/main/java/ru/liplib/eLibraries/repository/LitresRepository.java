package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.LitresAcc;

public interface LitresRepository extends CrudRepository<LitresAcc, Long> {
}
