package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.PersonForm;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.PersonRepository;
import ru.liplib.eLibraries.service.PersonService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String greeting(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Person> persons;

        if (filter != null && !filter.isEmpty()) {
            persons = personRepository.findByFioContaining(filter);
        } else {
            persons = personRepository.findAll();

            Collections.reverse((List)persons);
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
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorMap = ControllerUtil.getErrors(bindingResult);
//
//            model.mergeAttributes(errorMap);
        Map<String, String> err = ControllerUtil.checkForm(form);

        if (!err.isEmpty()) {
            model.mergeAttributes(err);
            model.addAttribute("form", form);
        } else {
            String temp = personService.save(form, user);

            switch (temp) {
                case "Not litres":
                    model.addAttribute("lrError", temp);
                    break;
                case "Not nonfiction":
                    model.addAttribute("nfError", temp);
                    break;
                default:
                    long l = Long.parseLong(temp);
                    model.addAttribute("person", personRepository.findById(l));
                    return "redirect:/person/" + l;
            }
        }

        List<Person> persons = (List) personRepository.findAll();

        Collections.reverse(persons);
        model.addAttribute("persons", persons);

        return "greeting";
    }

    @GetMapping("/manager")
    public String managerPage(Map<String, Object> model) {
        return "admin/manager";
    }
}
