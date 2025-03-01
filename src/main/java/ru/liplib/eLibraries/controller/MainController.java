package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.PersonForm;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.service.LitresService;
import ru.liplib.eLibraries.service.NonfictionService;
import ru.liplib.eLibraries.service.PersonService;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonService personService;
    @Autowired
    private LitresService litresService;
    @Autowired
    private NonfictionService nonfictionService;

    @GetMapping("/")
    public String greeting(
            @RequestParam(required = false, defaultValue = "") String filter,
            @RequestParam(required = false, defaultValue = "") String login,
            @RequestParam(required = false, defaultValue = "") String chooseEL,
            Model model,
            @PageableDefault(sort = {"id"}, size = 25, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Person> persons = null;

        if (filter != null && !filter.isEmpty()) {
            persons = personService.findByFioContaining(filter, pageable);
        } else if (login != null && !login.isEmpty()) {
            Person p = personService.findByLogin(login, chooseEL);
            persons = personService.findByFioAndBirthdate(p.getFio(), p.getBirthdate(), pageable);
        } else {
            persons = personService.findAll(pageable);
        }

        for (Person p: persons) {
            if (p.getLitres() != null)
                litresService.decrypt(p.getLitres());
            if (p.getNonfiction() != null)
                nonfictionService.decrypt(p.getNonfiction());
        }

        model.addAttribute("persons", persons);

        model.addAttribute("url", "/");
        model.addAttribute("filter", filter);

        return "greeting";
    }

    @PostMapping("/")
    public String addPerson(
            @AuthenticationPrincipal User user,
            @ModelAttribute PersonForm form,
            Model model,
            @PageableDefault(sort = {"id"}, size = 25, direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, String> err = ControllerUtil.checkForm(form, "add");

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
                    model.addAttribute("person", personService.getById(l));
                    return "redirect:/person/" + l;
            }
        }

        Page<Person> persons;
        persons = personService.findAll(pageable);

        model.addAttribute("persons", persons);
        model.addAttribute("url", "/");

        return "greeting";
    }

    @GetMapping("/manager")
    public String managerPage(Map<String, Object> model) {
        return "admin/manager";
    }
}
