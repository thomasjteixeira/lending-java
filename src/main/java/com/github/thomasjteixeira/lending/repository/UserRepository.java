package com.github.thomasjteixeira.lending.repository;

import com.github.thomasjteixeira.lending.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findByUsername(String username);
}
