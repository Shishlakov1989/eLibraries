package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.liplib.eLibraries.model.*;
import ru.liplib.eLibraries.repository.LitresRepository;
import ru.liplib.eLibraries.repository.NonfictionRepository;
import ru.liplib.eLibraries.repository.PersonRepository;
import ru.liplib.eLibraries.service.LitresService;
import ru.liplib.eLibraries.service.NonfictionService;
import ru.liplib.eLibraries.service.PersonService;

import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private NonfictionRepository nonfictionRepository;
    @Autowired
    private LitresService litresService;
    @Autowired
    private NonfictionService nonfictionService;

    @GetMapping("{person}")
    public String personEditForm(@PathVariable Person person, Model model) {
        PersonForm form = ControllerUtil.convertToForm(person);

        model.addAttribute("pform", form);

        if (person.getLitres() != null) {
            person.getLitres().setPassword(litresService.decrypt(person.getLitres().getEnc_pass()));
            model.addAttribute("litres", person.getLitres());
        }

        if (person.getNonfiction() != null) {
            person.getNonfiction().setPassword(nonfictionService.decrypt(person.getNonfiction().getEnc_pass()));
            model.addAttribute("nonfiction", person.getNonfiction());
        }

        return "personInfo";
    }

    @PostMapping
    public String personSave(
            @AuthenticationPrincipal User user,
            @ModelAttribute PersonForm form,
            Model model) {
        Map<String, String> err = ControllerUtil.checkForm(form, "edit");

        if (!err.isEmpty()) {
            model.mergeAttributes(err);
            model.addAttribute("form", form);
        } else {
            String temp = personService.personEdit(form, user);

            switch (temp) {
                case "Not litres":
                    model.addAttribute("lrError", "Отсутствуют свободные аккаунты Литрес");
                    model.addAttribute("form", form);
                    break;
                case "Not nonfiction":
                    model.addAttribute("nfError", "Отсутствуют свободные аккаунты Нон-фикшн");
                    model.addAttribute("form", form);
                    break;
                default:
                    long l = Long.parseLong(temp);
                    model.addAttribute("person", personService.getById(l));
                    return "redirect:/person/" + l;
            }
        }

        return "redirect:/person/" + form.getId();
    }

    @PostMapping("passLR")
    public String changeLrPass(
            @RequestParam(required = false) Long lrId,
            @RequestParam Long pId,
            @RequestParam String lrPassword,
            Model model
            ) {
        LitresAcc acc = litresService.getById(lrId);

        acc.setPassword(lrPassword);
        litresService.save(acc);

        return "redirect:/person/" + pId;
    }

    @PostMapping("passNF")
    public String changeNfPass(
            @RequestParam(required = false) Long nfId,
            @RequestParam Long pId,
            @RequestParam String nfPassword,
            Model model
    ) {
        NonfictionAcc acc = nonfictionService.getById(nfId);

        acc.setPassword(nfPassword);
        nonfictionService.save(acc);

        return "redirect:/person/" + pId;
    }
}
