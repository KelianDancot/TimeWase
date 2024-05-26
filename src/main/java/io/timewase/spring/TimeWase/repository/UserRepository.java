package io.timewase.spring.TimeWase.repository;

import io.timewase.spring.TimeWase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
