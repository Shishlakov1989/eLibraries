package ru.liplib.eLibraries.dao;

import ru.liplib.eLibraries.model.AccountNonFiction;

import java.util.List;

public interface NonfictionDAO {
    List<AccountNonFiction> allAccsNF();
    void addAccNF (AccountNonFiction accountNonFiction);
    void editAccNF (AccountNonFiction accountNonFiction);
    AccountNonFiction getAccNFById(int id);
}
