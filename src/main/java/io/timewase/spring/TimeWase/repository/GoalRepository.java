package io.timewase.spring.TimeWase.repository;

import io.timewase.spring.TimeWase.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
