package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.dao.NonfictionDAO;
import ru.liplib.eLibraries.model.AccountNonFiction;

import java.util.List;

@Service
public class NonfictionServiceImpl implements NonfictionService {
    private NonfictionDAO nonfictionDAO;

    @Autowired
    public void setNonfictionDAO(NonfictionDAO nonfictionDAO) {
        this.nonfictionDAO = nonfictionDAO;
    }

    @Override
    public List<AccountNonFiction> allAccsNF() {
        return nonfictionDAO.allAccsNF();
    }

    @Override
    public void addAccNF(AccountNonFiction accountNonFiction) {
        nonfictionDAO.addAccNF(accountNonFiction);
    }

    @Override
    public void editAccNF(AccountNonFiction accountNonFiction) {
        nonfictionDAO.editAccNF(accountNonFiction);
    }

    @Override
    public AccountNonFiction getAccNFById(int id) {
        return nonfictionDAO.getAccNFById(id);
    }
}
