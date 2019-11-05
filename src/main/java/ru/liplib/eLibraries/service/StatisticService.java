package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.controller.ControllerUtil;
import ru.liplib.eLibraries.repository.LitresRepository;
import ru.liplib.eLibraries.repository.NonfictionRepository;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticService {
    @Autowired
    private LitresRepository litresRepository;
    @Autowired
    private NonfictionRepository nonfictionRepository;

    public Map<String, Long> getStatistic(Map<String, String> form) {
        Map<String, Long> result = new HashMap<>();
        long litres = 0;
        long nonfiction = 0;

        Date start;
        Date end;

        switch (form.size()) {
            case 1:
                if (form.containsKey("startDate")) {
                    start = ControllerUtil.parseDate(form.get("startDate"));

                    for (int i = 1; i < 28; i++) {
                        litres = litresRepository.findByDateOfIssueAfterAndFilial(start, i).size();
                        nonfiction = nonfictionRepository.findByDateOfIssueAfterAndFilial(start, i).size();

                        result.put("lr" + i, litres);
                        result.put("nf" + i, nonfiction);
                    }

                    litres = litresRepository.findByDateOfIssueAfter(start).size();
                    nonfiction = nonfictionRepository.findByDateOfIssueAfter(start).size();
                } else {
                    end = ControllerUtil.parseDate(form.get("endDate"));

                    for (int i = 1; i < 28; i++) {
                        litres = litresRepository.findByDateOfIssueBeforeAndFilial(end, i).size();
                        nonfiction = nonfictionRepository.findByDateOfIssueBeforeAndFilial(end, i).size();

                        result.put("lr" + i, litres);
                        result.put("nf" + i, nonfiction);
                    }

                    litres = litresRepository.findByDateOfIssueBefore(end).size();
                    nonfiction = nonfictionRepository.findByDateOfIssueBefore(end).size();
                }
                break;
            case 2:
                start = ControllerUtil.parseDate(form.get("startDate"));
                end = ControllerUtil.parseDate(form.get("endDate"));

                for (int i = 1; i < 28; i++) {
                    litres = litresRepository.findByDateOfIssueBetweenAndFilial(start,end, i).size();
                    nonfiction = nonfictionRepository.findByDateOfIssueBetweenAndFilial(start,end, i).size();

                    result.put("lr" + i, litres);
                    result.put("nf" + i, nonfiction);
                }

                litres = litresRepository.findByDateOfIssueBetween(start,end).size();
                nonfiction = nonfictionRepository.findByDateOfIssueBetween(start,end).size();
                break;
            default:
                for (int i = 1; i < 28; i++) {
                    litres = litresRepository.findByFilial(i).size();
                    nonfiction = nonfictionRepository.findByFilial(i).size();

                    result.put("lr" + i, litres);
                    result.put("nf" + i, nonfiction);
                }

                litres = (long) litresRepository.findByIssuedTrue().size();
                nonfiction = (long) nonfictionRepository.findByIssuedTrue().size();
                break;
        }

        result.put("lrAll", litres);
        result.put("nfAll", nonfiction);
        result.put("freeLr", (long) litresRepository.findByIssuedFalse().size());
        result.put("freeNf", (long) nonfictionRepository.findByIssuedFalse().size());

        return result;
    }
}
