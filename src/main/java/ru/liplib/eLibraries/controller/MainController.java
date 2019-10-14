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
import ru.liplib.eLibraries.model.LitresAcc;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.PersonForm;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.PersonRepository;
import ru.liplib.eLibraries.service.LitresService;
import ru.liplib.eLibraries.service.NonfictionService;
import ru.liplib.eLibraries.service.PersonService;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;
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
            Model model,
            @PageableDefault(sort = {"id"}, size = 25, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Person> persons;

        if (filter != null && !filter.isEmpty()) {
            persons = personRepository.findByFioContaining(filter, pageable);
        } else {
            persons = personRepository.findAll(pageable);
        }

        for (Person p: persons) {
            if (p.getLitres() != null)
                p.getLitres().setPassword(litresService.decrypt(p.getLitres().getEnc_pass()));
            if (p.getNonfiction() != null)
                p.getNonfiction().setPassword(nonfictionService.decrypt(p.getNonfiction().getEnc_pass()));
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
                    model.addAttribute("person", personRepository.findById(l));
                    return "redirect:/person/" + l;
            }
        }

        Page<Person> persons;
        persons = personRepository.findAll(pageable);

        model.addAttribute("persons", persons);
        model.addAttribute("url", "/");

        return "greeting";
    }

    @GetMapping("/manager")
    public String managerPage(Map<String, Object> model) {
        return "admin/manager";
    }

    @GetMapping("/test")
    public String testPage(Model model) {
        long id = 958;
        LitresAcc acc = litresService.getById(id);

        model.addAttribute("acc", acc);

        return "test";
    }
}
