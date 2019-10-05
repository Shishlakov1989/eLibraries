package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.model.LitresAcc;
import ru.liplib.eLibraries.model.NonfictionAcc;
import ru.liplib.eLibraries.repository.LitresRepository;
import ru.liplib.eLibraries.repository.NonfictionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {
    @Autowired
    private LitresRepository litresRepository;
    @Autowired
    private NonfictionRepository nonfictionRepository;

    public Map<String, String> getStatistic(Map<String, String> form) {
        Map<String, String> result = new HashMap<>();
        int litres = 0;
        int nonfiction = 0;
        int filial = 0;

        try {
            filial = Integer.parseInt(form.get("filial"));
        } catch (NumberFormatException e) {

        }

        switch (form.size()) {
            case 1:
                if (form.containsKey("startDate")) {
                    litres = litresRepository.findByDateOfIssueAfter(form.get("startDate")).size();
                    nonfiction = nonfictionRepository.findByDateOfIssueAfter(form.get("startDate")).size();
                } else if (form.containsKey("endDate")) {
                    litres = litresRepository.findByDateOfIssueBefore(form.get("endDate")).size();
                    nonfiction = nonfictionRepository.findByDateOfIssueBefore(form.get("endDate")).size();
                } else if (form.containsKey("filial")) {
                    if (filial > 0 && filial < 28) {
                        litres = litresRepository.findByFilial(filial).size();
                        nonfiction = nonfictionRepository.findByFilial(filial).size();
                    } else {
                        List<LitresAcc> litresAccs = (List) litresRepository.findAll();
                        List<NonfictionAcc> nonfictionAccs = (List) nonfictionRepository.findAll();

                        litres = litresAccs.size();
                        nonfiction = nonfictionAccs.size();
                    }
                }
                break;
            case 2:

                break;
            case 3:
                litres = litresRepository.findByDateOfIssueBetweenAndFilial(form.get("startDate"), form.get("endDate"), Integer.parseInt(form.get("filial"))).size();
                nonfiction = nonfictionRepository.findByDateOfIssueBetweenAndFilial(form.get("startDate"), form.get("endDate"), Integer.parseInt(form.get("filial"))).size();
                break;
        }

        return result;
    }
}
