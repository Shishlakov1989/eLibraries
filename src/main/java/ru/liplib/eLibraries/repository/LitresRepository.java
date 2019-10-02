package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.LitresAcc;

import java.util.List;

public interface LitresRepository extends CrudRepository<LitresAcc, Long> {
    List<LitresAcc> findByIssuedFalseAndValidTrue();
    List<LitresAcc> findByValidFalse();
}
