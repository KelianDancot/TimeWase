package io.timewase.spring.TimeWase.service;

import io.timewase.spring.TimeWase.model.GoalReport;
import io.timewase.spring.TimeWase.repository.GoalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalReportService {

    @Autowired
    private GoalReportRepository goalReportRepository;

    public List<GoalReport> getAllGoalReports() {
        return goalReportRepository.findAll();
    }

    public Optional<GoalReport> getGoalReportById(Long reportId) {
        return goalReportRepository.findById(reportId);
    }

    public GoalReport saveGoalReport(GoalReport goalReport) {
        return goalReportRepository.save(goalReport);
    }

    public void deleteGoalReport(Long reportId) {
        goalReportRepository.deleteById(reportId);
    }
}
