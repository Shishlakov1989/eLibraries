package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("{person}")
    public String userEditForm(@PathVariable Person person, Model model) {
        model.addAttribute("person", person);

        return "personInfo";
    }
}
