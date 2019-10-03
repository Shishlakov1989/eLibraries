package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.model.LitresAcc;
import ru.liplib.eLibraries.repository.LitresRepository;

import java.sql.Date;
import java.util.List;

@Service
public class LitresService {
    @Autowired
    private LitresRepository litresRepository;

    public LitresAcc save(LitresAcc acc) {


        return acc;
    }

    public LitresAcc giveLitres(int filial) {
        List<LitresAcc> litresAccs = litresRepository.findByIssuedFalseAndValidTrue();

        if (litresAccs == null || litresAccs.size() == 0) {
            return null;
        } else {
            LitresAcc acc = litresAccs.get(0);
            acc.setFilial(filial);
            acc.setDateOfIssue(new Date(new java.util.Date().getTime()));
            acc.setIssued(true);

            litresRepository.save(acc);

            return acc;
        }
    }
}
