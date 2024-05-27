package io.timewase.spring.TimeWase.service;

import io.timewase.spring.TimeWase.model.Goal;
import io.timewase.spring.TimeWase.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Optional<Goal> getGoalById(Long goalId) {
        return goalRepository.findById(goalId);
    }

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public void deleteGoal(Long goalId) {
        goalRepository.deleteById(goalId);
    }
}
