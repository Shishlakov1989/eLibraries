package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.PersonForm;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.PersonRepository;

import javax.validation.Valid;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private FileUtil fileUtil;

    @GetMapping("/")
    public String greeting(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Person> persons;

        if (filter != null && !filter.isEmpty()) {
            persons = personRepository.findBySurname(filter);
        } else {
            persons = personRepository.findAll();
        }

        model.addAttribute("persons", persons);
        model.addAttribute("filter", filter);

        return "greeting";
    }

    @PostMapping("/")
    public String addPerson(
            @AuthenticationPrincipal User user,
            @ModelAttribute PersonForm form,
            Model model) {
        if (ControllerUtil.validAddReader(form, model)) {

        }

        model.addAttribute("persons", personRepository.findAll());

        return "greeting";
    }

    @GetMapping("/manager")
    public String managerPage(Map<String, Object> model) {
        return "admin/manager";
    }

    private Date parseDate(String str) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            java.util.Date date = format.parse(str);

            return new Date(date.getTime());
        } catch (ParseException e) {

        }

        return null;
    }
}
