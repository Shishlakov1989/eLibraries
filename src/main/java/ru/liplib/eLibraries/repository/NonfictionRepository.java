package ru.liplib.eLibraries.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liplib.eLibraries.model.NonfictionAcc;

import java.sql.Date;
import java.util.List;

public interface NonfictionRepository extends CrudRepository<NonfictionAcc, Long> {
    List<NonfictionAcc> findByIssuedFalseAndValidTrue();
    List<NonfictionAcc> findByValidFalse();
    List<NonfictionAcc> findByIssuedTrue();
    NonfictionAcc findByLogin(String login);
    List<NonfictionAcc> findByFilial(int filial);
    List<NonfictionAcc> findByDateOfIssueAfter(Date startDate);
    List<NonfictionAcc> findByDateOfIssueBefore(Date endDate);
    List<NonfictionAcc> findByDateOfIssueBetween(Date startDate, Date endDate);
    List<NonfictionAcc> findByDateOfIssueAfterAndFilial(Date startDate, int filial);
    List<NonfictionAcc> findByDateOfIssueBeforeAndFilial(Date endDate, int filial);
    List<NonfictionAcc> findByDateOfIssueBetweenAndFilial(Date startDate, Date endDate, int filial);
}
