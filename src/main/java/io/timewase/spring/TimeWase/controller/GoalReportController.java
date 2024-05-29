package io.timewase.spring.TimeWase.controller;

import io.timewase.spring.TimeWase.model.GoalReport;
import io.timewase.spring.TimeWase.service.GoalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goalReports")
public class GoalReportController {

    @Autowired
    private GoalReportService goalReportService;

    @CrossOrigin("*")
    @GetMapping
    public List<GoalReport> getAllGoalReports() {
        return goalReportService.getAllGoalReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalReport> getGoalReportById(@PathVariable Long id) {
        Optional<GoalReport> goalReport = goalReportService.getGoalReportById(id);
        return goalReport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GoalReport createGoalReport(@RequestBody GoalReport goalReport) {
        return goalReportService.saveGoalReport(goalReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalReport> updateGoalReport(@PathVariable Long id, @RequestBody GoalReport goalReportDetails) {
        Optional<GoalReport> updatedGoalReport = goalReportService.getGoalReportById(id)
                .map(goalReport -> {
                    goalReport.setGoal(goalReportDetails.getGoal());
                    goalReport.setUser(goalReportDetails.getUser());
                    goalReport.setContent(goalReportDetails.getContent());
                    goalReport.setCreatedAt(goalReportDetails.getCreatedAt());
                    return goalReportService.saveGoalReport(goalReport);
                });
        return updatedGoalReport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoalReport(@PathVariable Long id) {
        if (goalReportService.getGoalReportById(id).isPresent()) {
            goalReportService.deleteGoalReport(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
