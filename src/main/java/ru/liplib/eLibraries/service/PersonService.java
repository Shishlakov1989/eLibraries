package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liplib.eLibraries.model.LitresAcc;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.PersonForm;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LitresService litresService;

    public String save(PersonForm personform, User user) {
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
        }

        return person.getId().toString();
    }
}
