package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.PersonRepository;

import java.sql.Date;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String greeting(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Person> persons;

        if (filter != null && !filter.isEmpty()) {
            persons = personRepository.findByFio(filter);
        } else {
            persons = personRepository.findAll();
        }

        model.addAttribute("persons", persons);
        model.addAttribute("filter", filter);

        return "greeting";
    }

    @PostMapping("/addReader")
    public String addPerson(
            @AuthenticationPrincipal User user,
            @RequestParam String fio,
            @RequestParam Date birthdate,
            @RequestParam (required = false) String hasLitres,
            @RequestParam (required = false) String hasNonfiction,
            Map<String, Object> model) {
        Person person = new Person(fio, birthdate, hasLitres, hasNonfiction, user);
        personRepository.save(person);

        return "redirect:/";
    }

    @GetMapping("/manager")
    public String managerPage(Map<String, Object> model) {
        return "admin/manager";
    }
}
