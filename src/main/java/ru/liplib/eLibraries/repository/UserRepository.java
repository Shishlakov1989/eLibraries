package ru.liplib.eLibraries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liplib.eLibraries.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
