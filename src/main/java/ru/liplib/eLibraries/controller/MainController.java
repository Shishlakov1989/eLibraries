package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.PersonRepository;

import javax.validation.Valid;
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
            @Valid Person person,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("person", person);
        } else {
            personRepository.save(person);
            model.addAttribute("person", null);
        }

        return "redirect:/";
    }

    @GetMapping("/manager")
    public String managerPage(Map<String, Object> model) {
        return "admin/manager";
    }
}
