package patterns;

import model.Priority;
import model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskBuilder {
    private String title;
    private String description = "";
    private Priority priority  = Priority.MEDIDUM;
    private LocalDateTime deadline;
    private String assigneeId;
    private List<String> tags  = new ArrayList<>();

    public static TaskBuilder create(String title) {
        TaskBuilder taskBuilder = new TaskBuilder();
        taskBuilder.title = title;
        return taskBuilder;
    }

    public TaskBuilder description(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder priority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public TaskBuilder dueIn(int days) {
        this.deadline = LocalDateTime.now().plusDays(days);
        return this;
    }

    public TaskBuilder assignTo(String uid) {
        this.assigneeId = uid;
        return this;
    }

    public TaskBuilder tag(String... t) {
        tags.addAll(List.of(t));
        return this;
    }

    public Task build() {
        Objects.requireNonNull(title, "Title is required");
        Objects.requireNonNull(deadline, "DeadLine is required");
        Task task = new Task(title, priority, deadline);
        task.setAssigneeId(assigneeId);
        List<String> taskTags = tags.stream().toList();
        task.setTags(taskTags);
        return task;
    }
}
