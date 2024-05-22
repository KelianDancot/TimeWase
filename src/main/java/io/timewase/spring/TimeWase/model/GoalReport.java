package io.timewase.spring.TimeWase.model;

import java.time.LocalDateTime;

public class GoalReport {

    public GoalReport(Long reportId, Goal goal, User user, String content, LocalDateTime createdAt) {
        this.reportId = reportId;
        this.goal = goal;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private Long reportId;
    private Goal goal;
    private User user;
    private String content;
    private LocalDateTime createdAt;

    // Getters and Setters
}
