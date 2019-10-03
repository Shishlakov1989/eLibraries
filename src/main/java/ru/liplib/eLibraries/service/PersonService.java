package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.controller.ControllerUtil;
import ru.liplib.eLibraries.model.*;
import ru.liplib.eLibraries.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private LitresService litresService;
    @Autowired
    private NonfictionService nonfictionService;

    public String save(PersonForm personform, User user) {
        if (personform.getBirthday() == null && personform.getBirthdate() != null) {
            personform.setBirthday(ControllerUtil.parseDate(personform.getBirthdate()));
        }

        Person person = new Person(personform);

        List<Person> list = personRepository.findByFioAndBirthdate(person.getFio(), person.getBirthdate());

        if (list == null || list.size() == 0) {
            if (personform.getGiveLitres() != null) {
                LitresAcc acc = litresService.giveLitres(user.getFilial());
                if (acc != null) {
                    person.setLitres(acc);
                    personRepository.save(person);
                } else
                    return "Not litres";
            }
            if (personform.getGiveNonfiction() != null) {
                NonfictionAcc acc = nonfictionService.giveNonfiction(user.getFilial());
                if (acc != null) {
                    person.setNonfiction(acc);
                    personRepository.save(person);
                } else
                    return "Not nonfiction";
            }
        } else {
            person = list.get(list.size() - 1);

            if (personform.getGiveLitres() != null) {
                if (person.getLitres() == null) {
                    LitresAcc acc = litresService.giveLitres(user.getFilial());
                    if (acc != null) {
                        person.setLitres(acc);
                        personRepository.save(person);
                    } else
                        return "Not litres";
                }
            }
            if (personform.getGiveNonfiction() != null) {
                NonfictionAcc acc = nonfictionService.giveNonfiction(user.getFilial());
                if (acc != null) {
                    person.setNonfiction(acc);
                    personRepository.save(person);
                } else
                    return "Not nonfiction";
            }
        }

        return person.getId().toString();
    }

    public Person getById(long id) {
        Person person = personRepository.findById(id).get();

        return person;
    }
}
