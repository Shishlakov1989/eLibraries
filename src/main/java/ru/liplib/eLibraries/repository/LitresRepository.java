package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.LitresAcc;

import java.util.List;

public interface LitresRepository extends CrudRepository<LitresAcc, Long> {
    List<LitresAcc> findByIssuedFalseAndValidTrue();
    List<LitresAcc> findByValidFalse();
    LitresAcc findByLogin(String login);
    List<LitresAcc> findByDateOfIssueAfter(String startDate);
    List<LitresAcc> findByDateOfIssueBefore(String endDate);
    List<LitresAcc> findByDateOfIssueBetween(String startDate, String endDate);
    List<LitresAcc> findByDateOfIssueAfterAndFilial(String startDate, int filial);
    List<LitresAcc> findByDateOfIssueBeforeAndFilial(String endDate, int filial);
    List<LitresAcc> findByDateOfIssueBetweenAndFilial(String startDate, String endDate, int filial);
}
