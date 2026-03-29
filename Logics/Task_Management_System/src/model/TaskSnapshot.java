package model;

import java.time.LocalDateTime;

public class TaskSnapshot {
    private final String taskId;
    private final Status previousStatus;
    private final Priority previousPriority;
    private final LocalDateTime timestamp;

    public TaskSnapshot(Task task) {
        this.taskId          = task.getId();
        this.previousStatus  = task.getStatus();
        this.previousPriority= task.getPriority();
        this.timestamp       = LocalDateTime.now();
    }
}
