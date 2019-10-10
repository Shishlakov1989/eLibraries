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
                } else
                    return "Not litres";
            }
            if (personform.getGiveNonfiction() != null) {
                NonfictionAcc acc = nonfictionService.giveNonfiction(user.getFilial());
                if (acc != null) {
                    person.setNonfiction(acc);
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
                    } else
                        return "Not litres";
                }
            }
            if (personform.getGiveNonfiction() != null) {
                NonfictionAcc acc = nonfictionService.giveNonfiction(user.getFilial());
                if (acc != null) {
                    person.setNonfiction(acc);
                } else
                    return "Not nonfiction";
            }
        }

        personRepository.save(person);

        return person.getId().toString();
    }

    public String personEdit(PersonForm personform, User user) {
        Person person = personRepository.findById(personform.getId()).get();

        person.setFio(personform.getFio());

        if (personform.getBirthdate() != null) {
            person.setBirthdate(ControllerUtil.parseDate(personform.getBirthdate()));
        }

        if (personform.getGiveLitres() != null) {
            LitresAcc acc = litresService.giveLitres(user.getFilial());
            if (acc != null) {
                person.setLitres(acc);
            } else
                return "Not litres";
        }
        if (personform.getGiveNonfiction() != null) {
            NonfictionAcc acc = nonfictionService.giveNonfiction(user.getFilial());
            if (acc != null) {
                person.setNonfiction(acc);
            } else
                return "Not nonfiction";
        }

        personRepository.save(person);

        return person.getId().toString();
    }

    public void saveFromFile(Person person, LitresAcc litresAcc) {
        Person p;
        List<Person> list = personRepository.findByFioAndBirthdate(person.getFio(), person.getBirthdate());

        if (person.getFio().equals("<none>") || list == null || list.size() == 0) {
            p = person;
            p.setLitres(litresService.save(litresAcc));
        } else {
            p = list.get(list.size() - 1);

            if (p.getLitres() == null) {
                p.setLitres(litresService.save(litresAcc));
            } else {
                LitresAcc oldAcc = p.getLitres();

                oldAcc.setValid(false);
                oldAcc.setIssued(false);
                oldAcc.setFilial(0);
                oldAcc.setDateOfIssue(null);

                litresService.save(oldAcc);

                p.setLitres(litresService.save(litresAcc));
            }
        }

        personRepository.save(p);
    }

    public void saveFromFile(Person person, NonfictionAcc nonfictionAcc) {
        Person p;
        List<Person> list = personRepository.findByFioAndBirthdate(person.getFio(), person.getBirthdate());

        if (person.getFio().equals("<none>") || list == null || list.size() == 0) {
            p = person;
            p.setNonfiction(nonfictionService.save(nonfictionAcc));
        } else {
            p = list.get(list.size() - 1);

            if (p.getNonfiction() == null) {
                p.setNonfiction(nonfictionService.save(nonfictionAcc));
            } else {
                NonfictionAcc oldAcc = p.getNonfiction();

                oldAcc.setValid(false);
                oldAcc.setIssued(false);
                oldAcc.setFilial(0);
                oldAcc.setDateOfIssue(null);

                nonfictionService.save(oldAcc);

                p.setNonfiction(nonfictionService.save(nonfictionAcc));
            }
        }

        personRepository.save(p);
    }

    public Person getById(long id) {
        Person person = personRepository.findById(id).get();

        return person;
    }
}
