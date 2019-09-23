package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.liplib.eLibraries.model.Role;
import ru.liplib.eLibraries.model.User;
import ru.liplib.eLibraries.repository.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "admin/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "Пользователь уже существует");
            return "admin/registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/";
    }
}