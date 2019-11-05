package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.LitresAcc;

import java.sql.Date;
import java.util.List;

public interface LitresRepository extends CrudRepository<LitresAcc, Long> {
    List<LitresAcc> findByIssuedFalseAndValidTrue();
    List<LitresAcc> findByValidFalse();
    List<LitresAcc> findByIssuedTrue();
    List<LitresAcc> findByIssuedFalse();
    LitresAcc findByLogin(String login);
    List<LitresAcc> findByFilial(int filial);
    List<LitresAcc> findByDateOfIssueAfter(Date startDate);
    List<LitresAcc> findByDateOfIssueBefore(Date endDate);
    List<LitresAcc> findByDateOfIssueBetween(Date startDate, Date endDate);
    List<LitresAcc> findByDateOfIssueAfterAndFilial(Date startDate, int filial);
    List<LitresAcc> findByDateOfIssueBeforeAndFilial(Date endDate, int filial);
    List<LitresAcc> findByDateOfIssueBetweenAndFilial(Date startDate, Date endDate, int filial);
}
