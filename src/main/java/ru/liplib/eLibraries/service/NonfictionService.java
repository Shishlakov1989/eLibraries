package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.model.NonfictionAcc;
import ru.liplib.eLibraries.repository.NonfictionRepository;

import java.sql.Date;
import java.util.List;

@Service
public class NonfictionService {
    @Autowired
    private NonfictionRepository nonfictionRepository;

    public NonfictionAcc save(NonfictionAcc acc) {
        if (nonfictionRepository.findByLogin(acc.getLogin()) == null)
            nonfictionRepository.save(acc);

        return acc;
    }

    public NonfictionAcc giveNonfiction(int filial) {
        List<NonfictionAcc> nonfictionAccs = nonfictionRepository.findByIssuedFalseAndValidTrue();

        if (nonfictionAccs == null || nonfictionAccs.size() == 0) {
            return null;
        } else {
            NonfictionAcc acc = nonfictionAccs.get(0);
            acc.setFilial(filial);
            acc.setDateOfIssue(new Date(new java.util.Date().getTime()));
            acc.setIssued(true);

            nonfictionRepository.save(acc);

            return acc;
        }
    }
}
