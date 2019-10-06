package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.liplib.eLibraries.model.LitresAcc;
import ru.liplib.eLibraries.model.NonfictionAcc;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.LitresRepository;
import ru.liplib.eLibraries.repository.NonfictionRepository;
import ru.liplib.eLibraries.repository.PersonRepository;
import ru.liplib.eLibraries.service.LitresService;
import ru.liplib.eLibraries.service.NonfictionService;
import ru.liplib.eLibraries.service.PersonService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class FileUtil {
    @Autowired
    private LitresService litresService;
    @Autowired
    private NonfictionService nonfictionService;
    @Autowired
    private PersonService personService;

    void addAccounts(String filename, User user) {
        List<String> strings = readFile(filename);

        if (strings == null) {
            return;
        }

        for (String str: strings) {
            String[] parts = str.split("\t");
            LitresAcc litres;
            NonfictionAcc nonfiction;
            Person person;

            switch (parts.length) {
                case 2:
                    litres = new LitresAcc(parts[0], parts[1]);
                    litresService.save(litres);
                    litres = null;
                    break;
                case 3:
                    nonfiction = new NonfictionAcc(parts[0], parts[1], parts[2]);
                    nonfictionService.save(nonfiction);
                    nonfiction = null;
                    break;
                case 6:
                    litres = new LitresAcc(parts[0], parts[1]);
                    person = new Person();

                    if (!parts[2].equals("-")) {
                        person.setFio(parts[2]);
                    } else {
                        person.setFio("<none>");
                    }

                    if (!parts[3].equals("-"))
                        person.setBirthdate(parseDate(parts[3]));

                    if (!parts[4].equals("-")) {
                        String temp = parts[4];

                        try {
                            litres.setFilial(Integer.parseInt(temp));
                        } catch (NumberFormatException e) {
                            litres.setFilial(setLibrary(temp));
                        }
                    }

                    if (!parts[5].equals("-")) {
                        litres.setDateOfIssue(parseDate(parts[5]));
                    }

                    litres.setIssued(true);

                    personService.saveFromFile(person, litres);

                    litres = null;
                    person = null;
                    break;
                case 7:
                    nonfiction = new NonfictionAcc(parts[0], parts[1], parts[2]);
                    person = new Person();

                    if (!parts[2].equals("-")) {
                        person.setFio(parts[3]);
                    }

                    if (!parts[3].equals("-"))
                        person.setBirthdate(parseDate(parts[4]));

                    if (!parts[4].equals("-")) {
                        String temp = parts[5];

                        try {
                            nonfiction.setFilial(Integer.parseInt(temp));
                        } catch (NumberFormatException e) {
                            nonfiction.setFilial(setLibrary(temp));
                        }
                    }

                    if (!parts[6].equals("-")) {
                        nonfiction.setDateOfIssue(parseDate(parts[5]));
                    }

                    nonfiction.setIssued(true);

                    personService.saveFromFile(person, nonfiction);

                    nonfiction = null;
                    person = null;
                    break;
            }
        }
    }

    private List<String> readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            List<String> strings = new ArrayList<>();

            while (reader.ready()) {
                String temp = reader.readLine();

                while (!Character.isDigit(temp.charAt(0))) {
                    temp = temp.substring(1);
                }

                /*if (!Character.isDigit(temp.charAt(0))) {
                    temp = temp.substring(1);
                }*/

                strings.add(temp);
            }

            System.out.println("Прочитано " + strings.size() + " строк");

            return strings;
        } catch (FileNotFoundException e1) {
            System.out.println("Не удалось найти файл");
        } catch (IOException e2) {
            System.out.println("Ошибка чтения файла");
        }

        return null;
    }

    private Date parseDate(String str) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        try {
            if (str.length() == 4) {
                java.util.Date date = format.parse("01.01." + str);

                return new Date(date.getTime());
            } else {
                java.util.Date date = format.parse(str);

                return new Date(date.getTime());
            }
        } catch (ParseException e) {

        }

        return null;
    }

    private int setLibrary(String str) {
        str = str.toLowerCase();

        if (str.contains("бунин"))
            return 1;
        else if (str.contains("смургис"))
            return 3;
        else if (str.contains("бартен"))
            return 5;
        else if (str.contains("социал"))
            return 4;
        else if (str.contains("рудн"))
            return 9;
        else if (str.contains("левобер"))
            return 10;
        else if (str.contains("стш") || str.contains("с-т-ш") || str.contains("семен"))
            return 6;
        else if (str.contains("нк") || str.contains("культ"))
            return 7;
        else if (str.contains("бсч"))
            return 25;
        else if (str.contains("виб") || str.contains("водоп"))
            return 2;
        else if (str.contains("дачн"))
            return 8;
        else if (str.contains("матыр"))
            return 17;
        else if (str.contains("сокол"))
            return 11;
        else if (str.contains("эрудит"))
            return 21;
        else if (str.contains("солнеч"))
            return 12;
        else if (str.contains("преобр"))
            return 19;
        else if (str.contains("цгб") || str.contains("есенин"))
            return 26;
        else if (str.contains("цгдб") || str.contains("пришв"))
            return 27;
        else
            return 0;
    }
}
