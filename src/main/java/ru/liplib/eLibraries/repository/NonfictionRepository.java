package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.NonfictionAcc;

import java.util.List;

public interface NonfictionRepository extends CrudRepository<NonfictionAcc, Long> {
    List<NonfictionAcc> findByIssuedFalseAndValidTrue();
    List<NonfictionAcc> findByValidFalse();
    NonfictionAcc findByLogin(String login);
    List<NonfictionAcc> findByDateOfIssueAfter(String startDate);
    List<NonfictionAcc> findByDateOfIssueBefore(String endDate);
    List<NonfictionAcc> findByDateOfIssueBetween(String startDate, String endDate);
    List<NonfictionAcc> findByDateOfIssueAfterAndFilial(String startDate, int filial);
    List<NonfictionAcc> findByDateOfIssueBeforeAndFilial(String endDate, int filial);
    List<NonfictionAcc> findByDateOfIssueBetweenAndFilial(String startDate, String endDate, int filial);
}
