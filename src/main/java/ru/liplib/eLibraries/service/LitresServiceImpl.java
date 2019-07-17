package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.dao.LitresDAO;
import ru.liplib.eLibraries.model.AccountLitres;

import java.util.List;

@Service
public class LitresServiceImpl implements LitresService {
    private LitresDAO litresDAO;

    @Autowired
    public void setLitresDAO(LitresDAO litresDAO) {
        this.litresDAO = litresDAO;
    }

    @Override
    public List<AccountLitres> allAccsLR() {
        return litresDAO.allAccsLR();
    }

    @Override
    public void addAccLR(AccountLitres accountLitres) {
        litresDAO.addAccLR(accountLitres);
    }

    @Override
    public void editAccLR(AccountLitres accountLitres) {
        litresDAO.editAccLR(accountLitres);
    }

    @Override
    public AccountLitres getAccLRById(int id) {
        return litresDAO.getAccLRById(id);
    }
}
