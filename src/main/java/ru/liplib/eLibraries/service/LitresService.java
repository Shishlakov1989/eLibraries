package ru.liplib.eLibraries.service;

import ru.liplib.eLibraries.model.AccountLitres;

import java.util.List;

public interface LitresService {
    List<AccountLitres> allAccsLR();
    void addAccLR (AccountLitres accountLitres);
    void editAccLR (AccountLitres accountLitres);
    AccountLitres getAccLRById(int id);
}
