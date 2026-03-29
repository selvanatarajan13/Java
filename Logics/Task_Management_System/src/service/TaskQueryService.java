package service;

import model.Priority;
import model.Status;
import model.Task;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskQueryService {
    private final List<Task> tasks;

    public TaskQueryService(List<Task> tasks) {
        this.tasks = tasks;
    }

    // ── Filter overdue tasks ──────────────────────────────────────────
    public List<Task> getOverdueTasks() {
        LocalDateTime now = LocalDateTime.now();
        return tasks.stream()
                .filter(t -> t.getStatus() != Status.DONE)
                .filter(t -> t.getDeadLine().isBefore(now))
                .sorted(Comparator.comparing(Task::getDeadLine))
                .collect(Collectors.toList());
    }

    // ── Group tasks by priority ───────────────────────────────────────
    public Map<Priority, List<Task>> groupByPriority() {
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getPriority));
    }

    // ── Group tasks by assignee, count per person ─────────────────────
    public Map<String, Long> taskCountPerAssignee() {
        return tasks.stream()
                .filter(t -> t.getAssigneeId() != null)
                .collect(Collectors.groupingBy(
                        Task::getAssigneeId,
                        Collectors.counting()
                ));
    }

    // ── Get tasks by tag (flatMap example) ───────────────────────────
    public List<Task> findByTag(String tag) {
        return tasks.stream()
                .filter(t -> t.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    // ── Summary statistics on deadlines ──────────────────────────────
    public Optional<Task> getMostUrgentPendingTask() {
        return tasks.stream()
                .filter(t -> t.getStatus() == Status.TODO ||
                        t.getStatus() == Status.IN_PROGRESS)
                .min(Comparator.comparing(Task::getDeadLine));
    }

    // ── Dashboard stats ───────────────────────────────────────────────
    public Map<Status, Long> getStatusSummary() {
        return tasks.stream()
                .collect(Collectors.groupingBy(
                        Task::getStatus,
                        Collectors.counting()
                ));
    }

    // ── Functional pipeline: get titles of high-priority TODO tasks ───
    public List<String> getCriticalTodoTitles() {
        return tasks.stream()
                .filter(t -> t.getPriority() == Priority.CRITICAL)
                .filter(t -> t.getStatus() == Status.TODO)
                .sorted(Comparator.comparing(Task::getDeadLine))
                .map(Task::getTitle)          // Task → String
                .collect(Collectors.toList());
    }

    // ── Partition: done vs not done ───────────────────────────────────
    public Map<Boolean, List<Task>> partitionByCompletion() {
        return tasks.stream()
                .collect(Collectors.partitioningBy(
                        t -> t.getStatus() == Status.DONE
                ));
    }
}
