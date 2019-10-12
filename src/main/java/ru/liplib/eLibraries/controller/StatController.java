package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.service.StatisticService;

import java.util.Map;

@Controller
@RequestMapping("/statistic")
public class StatController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public String statPage(Model model) {
        return "stat";
    }

    @PostMapping
    public String viewStat(
            @RequestParam Map<String, String> form,
            Model model) {
        form.remove("_csrf");

        if (form.get("startDate").isEmpty())
            form.remove("startDate");

        if (form.get("endDate").isEmpty())
            form.remove("endDate");

        model.mergeAttributes(statisticService.getStatistic(form));
        model.mergeAttributes(form);
        model.addAttribute("table", "show");

        return "stat";
    }
}
