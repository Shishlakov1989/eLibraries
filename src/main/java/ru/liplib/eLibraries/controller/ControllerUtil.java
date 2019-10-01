package ru.liplib.eLibraries.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.liplib.eLibraries.model.PersonForm;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtil {
    static boolean validAddReader(
            PersonForm personForm,
            Model model)
    {
        boolean valid = true;

        /*if (!form.containsKey("giveLitres") & !form.containsKey("giveNonfiction")) {
            valid = false;
            model.addAttribute("accountsError", "Не выбраны желаемые электронные библиотеки");
        }

        for (Map.Entry pair: form.entrySet()) {
            String key = (String) pair.getKey();
            String value;

            switch (key) {
                case "surname":
                    value = (String) pair.getValue();
                    value = value.trim();

                    if (value == null || value.isEmpty()) {
                        valid = false;
                        model.addAttribute(key + "Error", "Поле обязательно для заполнения");
                    } else if (value.length() < 2 || value.length() > 20) {
                        model.addAttribute(key + "Error", "Длина поля должна быть от 2 до 20 символов");
                    }

                    break;
                case "name":
                    value = (String) pair.getValue();
                    value = value.trim();

                    if (value == null || value.isEmpty()) {
                        valid = false;
                        model.addAttribute(key + "Error", "Поле обязательно для заполнения");
                    } else if (value.length() < 2 || value.length() > 10) {
                        model.addAttribute(key + "Error", "Длина поля должна быть от 2 до 10 символов");
                    } else if (value.contains(".")) {
                        valid = false;
                        model.addAttribute(key + "Error", "Поле содержит недопустимые символы (сокращения запрещены)");
                    }

                    break;
                case "patronymic":
                    value = (String) pair.getValue();
                    value = value.trim();

                    if (value == null || value.isEmpty()) {
                        valid = false;
                        model.addAttribute(key + "Error", "Поле обязательно для заполнения");
                    } else if (value.length() < 2 || value.length() > 15) {
                        valid = false;
                        model.addAttribute(key + "Error", "Длина поля должна быть от 2 до 15 символов");
                    } else if (value.contains(".")) {
                        valid = false;
                        model.addAttribute(key + "Error", "Поле содержит недопустимые символы (сокращения запрещены)");
                    }

                    break;
                case "birthdate":
                    value = (String) pair.getValue();

                    if (value == null || value.isEmpty()) {
                        valid = false;
                        model.addAttribute(key + "Error", "Поле обязательно для заполнения");
                    }

                    break;
            }
        }*/

        return valid;
    }
}