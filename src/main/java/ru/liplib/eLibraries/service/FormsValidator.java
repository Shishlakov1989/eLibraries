package ru.liplib.eLibraries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liplib.eLibraries.repository.UserRepository;

import java.util.Map;

@Service
public class FormsValidator {
    public void checkRegistration(String username, String password, Model model) {
        if (username == null || username.isEmpty())
            model.addAttribute("usernameError", "Имя пользователя не может быть пустым");

        if (username == null || username.isEmpty())
            model.addAttribute("passwordError", "Пароль не может быть пустым");
    }

    public boolean checkAddPerson(Map<String, String> form, Map<String, Object> model) {
        boolean valid = true;

        for (Map.Entry pair: form.entrySet()) {
            String key = (String) pair.getKey();
            String value = (String) pair.getValue();
            switch (key) {
                case "surname":
                    if (value.length() < 2 || value.length() > 30) {
                        model.put("surnameError", "Поле должно иметь длину от 2 до 30 символов");
                        valid = false;
                    }
                    break;
                case "name":
                    if (value.length() < 2 || value.length() > 15) {
                        model.put("nameError", "Поле должно иметь длину от 2 до 15 символов");
                        valid = false;
                    }
                    break;
                case "patronymic":
                    if (value.length() < 2 || value.length() > 15) {
                        model.put("patronymicError", "Поле должно иметь длину от 2 до 15 символов");
                        valid = false;
                    }
                    break;
                case "birthdate":
                    if (value == null || value.isEmpty()) {
                        model.put("birthdateError", "Поле обязательно для заполнения");
                        valid = false;
                    }
                    break;
            }
        }

        return valid;
    }
}
