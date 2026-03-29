package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task implements Comparable<Task> {
    private final String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime deadLine;
    private String assigneeId;
    private List<String> tags;
    private LocalDateTime createdAt;

    public Task(String title, Priority priority, LocalDateTime deadLine) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.priority = priority;
        this.deadLine = deadLine;
        this.status = Status.TODO;
        this.tags = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public int compareTo(Task o) {
        return this.deadLine.compareTo(o.deadLine);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | Due: %s",
                priority, title, status, deadLine.toLocalDate());
    }
}
