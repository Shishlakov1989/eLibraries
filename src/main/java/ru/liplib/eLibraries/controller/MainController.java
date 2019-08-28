package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.repository.PersonRepository;

import java.sql.Date;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Person> persons = personRepository.findAll();

        model.put("persons", persons);

        return "main";
    }

    @GetMapping(value = "/addPerson")
    public String addPerson() {
        return "addPerson";
    }

    @PostMapping(value = "/addPerson")
    public String addPerson(@RequestParam String fio, @RequestParam Date birthdate,
                            @RequestParam String hasLitres, @RequestParam String hasNonfiction,
                            @RequestParam int libNum, Map<String, Object> model) {
        Person person = new Person(fio, birthdate, hasLitres, hasNonfiction, libNum);

        personRepository.save(person);

        return "redirect:/";
    }
}
