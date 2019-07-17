package ru.liplib.eLibraries.service;

import ru.liplib.eLibraries.model.AccountNonFiction;

import java.util.List;

public interface NonfictionService {
    List<AccountNonFiction> allAccsNF();
    void addAccNF (AccountNonFiction accountNonFiction);
    void editAccNF (AccountNonFiction accountNonFiction);
    AccountNonFiction getAccNFById(int id);
}
