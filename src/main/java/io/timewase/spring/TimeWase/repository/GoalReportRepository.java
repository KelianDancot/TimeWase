package io.timewase.spring.TimeWase.repository;

import io.timewase.spring.TimeWase.model.GoalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalReportRepository extends JpaRepository<GoalReport, Long> {
}
