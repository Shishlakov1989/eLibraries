package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.repository.LitresRepository;
import ru.liplib.eLibraries.repository.NonfictionRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticService {
    @Autowired
    private LitresRepository litresRepository;
    @Autowired
    private NonfictionRepository nonfictionRepository;

    public Map<String, Integer> getStatistic(Map<String, String> form) {
        Map<String, Integer> result = new HashMap<>();
        int litres = 0;
        int nonfiction = 0;



        switch (form.size()) {
            case 1:
                if (form.containsKey("startDate")) {
                    for (int i = 1; i < 28; i++) {
                        /*litres = litresRepository.findByDateOfIssueAfterAndFilial(form.get("startDate"), i).size();
                        nonfiction = nonfictionRepository.findByDateOfIssueAfterAndFilial(form.get("startDate"), i).size();

                        result.put("lr" + i, litres);
                        result.put("nf" + i, nonfiction);*/
                    }


                } else {

                }
                break;
            case 2:
                for (int i = 1; i < 28; i++) {

                }
                break;
            default:
                break;
        }



        return result;
    }
}
