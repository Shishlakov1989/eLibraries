package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.NonfictionAcc;

public interface NonfictionRepository extends CrudRepository<NonfictionAcc, Long> {
}
