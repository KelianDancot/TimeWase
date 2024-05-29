package io.timewase.spring.TimeWase.controller;

import io.timewase.spring.TimeWase.model.Goal;
import io.timewase.spring.TimeWase.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @CrossOrigin("*")
    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        Optional<Goal> goal = goalService.getGoalById(id);
        return goal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.saveGoal(goal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @RequestBody Goal goalDetails) {
        Optional<Goal> updatedGoal = goalService.getGoalById(id)
                .map(goal -> {
                    goal.setUser(goalDetails.getUser());
                    goal.setTitle(goalDetails.getTitle());
                    goal.setDescription(goalDetails.getDescription());
                    goal.setStartDate(goalDetails.getStartDate());
                    goal.setEndDate(goalDetails.getEndDate());
                    goal.setCreatedAt(goalDetails.getCreatedAt());
                    goal.setUpdatedAt(goalDetails.getUpdatedAt());
                    return goalService.saveGoal(goal);
                });
        return updatedGoal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        if (goalService.getGoalById(id).isPresent()) {
            goalService.deleteGoal(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
