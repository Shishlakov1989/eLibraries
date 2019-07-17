package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.service.PersonService;

import java.util.List;

@Controller
public class MainController {
    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        List<Person> persons = personService.allPersons();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("personList", persons);

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPerson(@ModelAttribute("person") Person person) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        personService.addPerson(person);

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable int id) {
        Person person = personService.getPersonById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("person", person);

        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editPerson(@ModelAttribute("person") Person person) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        personService.editPerson(person);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePerson(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Person person = personService.getPersonById(id);
        personService.deletePerson(person);

        return modelAndView;
    }

    @RequestMapping(value = "/allReaders", method = RequestMethod.GET)
    public ModelAndView allReaders() {
        List<Person> personList = personService.allPersons();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allReaders");
        modelAndView.addObject("persons", personList);

        return modelAndView;
    }
}
