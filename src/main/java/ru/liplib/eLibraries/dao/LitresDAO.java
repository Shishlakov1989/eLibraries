package ru.liplib.eLibraries.dao;

import ru.liplib.eLibraries.model.AccountLitres;

import java.util.List;

public interface LitresDAO {
    List<AccountLitres> allAccsLR();
    void addAccLR (AccountLitres accountLitres);
    void editAccLR (AccountLitres accountLitres);
    AccountLitres getAccLRById(int id);
}
