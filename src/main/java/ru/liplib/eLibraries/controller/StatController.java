package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.service.LitresService;
import ru.liplib.eLibraries.service.NonfictionService;
import ru.liplib.eLibraries.service.StatisticService;

import java.sql.Date;
import java.util.Map;

@Controller
@RequestMapping("/statistic")
@PreAuthorize("hasAuthority('ADMIN')")
public class StatController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public String statPage(Model model) {
        return "admin/stat";
    }

    @PostMapping
    public String viewStat(
            Map<String, String> form,
            Model model) {
        if (form.isEmpty()) {
            model.addAttribute("empty","Не заполнено ни одно поле");
        } else {
            model.mergeAttributes(statisticService.getStatistic(form));
        }

        return "admin/stat";
    }
}
