package ru.liplib.eLibraries.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.liplib.eLibraries.model.Person;
import ru.liplib.eLibraries.model.PersonForm;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtil {
    static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );

        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    static Map<String, String> checkForm(PersonForm form) {
        Map<String, String> errors = new HashMap<>();

        String surname = form.getSurname();
        surname = surname.trim();
        surname = surname.replace('ё', 'е');

        if (surname.length() < 2 || surname.length() > 20) {
            errors.put("surnameError", "Данное поле должно содержать от 2 до 20 символов");
        } else if (surname.contains(".") || surname.contains(",")) {
            errors.put("surnameError", "Данное поле не должно содержать специальных символов");
        }

        String name = form.getName();
        name = name.trim();
        name = name.replace('ё', 'е');

        if (name.length() < 2 || name.length() > 10) {
            errors.put("nameError", "Данное поле должно содержать от 2 до 10 символов");
        } else if (name.contains(".") || name.contains(",")) {
            errors.put("nameError", "Данное поле не должно содержать специальных символов");
        }

        String patronymic = form.getPatronymic();
        patronymic = patronymic.trim();
        patronymic = patronymic.replace('ё', 'е');

        if (patronymic.length() < 2 || patronymic.length() > 15) {
            errors.put("patronymicError", "Данное поле должно содержать от 2 до 15 символов");
        } else if (patronymic.contains(".") || patronymic.contains(",")) {
            errors.put("patronymicError", "Данное поле не должно содержать специальных символов");
        }

        String birthdate = form.getBirthdate();

        if (birthdate == null || birthdate.isEmpty()) {
            errors.put("birthdateError", "Данное поле обязательно для заполнения");
        } else {
            Date date = parseDate(birthdate);

            if (date == null) {
                errors.put("birthdateError", "Проверьте правильность даты рождения");
            } else
                form.setBirthday(date);
        }

        if ((form.getGiveLitres() == null || form.getGiveLitres().isEmpty()) &&
                (form.getGiveNonfiction() == null || form.getGiveNonfiction().isEmpty())) {
            errors.put("accountsError", "Выберите электронную библиотеку для выдачи логина");
        }

        return errors;
    }

    private static Date parseDate(String str) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            java.util.Date date = format.parse(str);

            return new Date(date.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static PersonForm convertToForm(Person person) {
        PersonForm form = new PersonForm();

        String[] fio = person.getFio().split(" ");
        form.setSurname(fio[0]);
        form.setName(fio[1]);
        form.setPatronymic(fio[2]);

        return form;
    }
}