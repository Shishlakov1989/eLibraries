package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.liplib.eLibraries.service.LitresService;
import ru.liplib.eLibraries.service.NonfictionService;

import java.util.Map;

@Controller
@RequestMapping("/statistic")
@PreAuthorize("hasAuthority('ADMIN')")
public class StatController {
    @Autowired
    private LitresService litresService;
    @Autowired
    private NonfictionService nonfictionService;

    @GetMapping
    public String statPage(Model model) {
        return "admin/stat";
    }

    @PostMapping
    public String viewStat(
            Map<String, String> form,
            Model model) {


        return "admin/stat";
    }
}
