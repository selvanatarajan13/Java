package ds;

import model.Task;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskSorter {
    public static final SortStrategy BY_DEADLINE =
            tasks -> tasks.stream()
                    .sorted(Comparator.comparing(Task::getDeadLine))
                    .collect(Collectors.toList());

    public static final SortStrategy BY_PRIORITY =
            tasks -> tasks.stream()
                    .sorted(Comparator.comparingInt(
                            t -> -t.getPriority().ordinal()))  // highest first
                    .collect(Collectors.toList());

    public static final SortStrategy BY_CREATION =
            tasks -> tasks.stream()
                    .sorted(Comparator.comparing(Task::getCreatedAt).reversed())
                    .collect(Collectors.toList());

    // Composed strategy: priority first, then deadline as tiebreaker
    public static final SortStrategy BY_PRIORITY_THEN_DEADLINE =
            tasks -> tasks.stream()
                    .sorted(Comparator
                            .comparingInt((Task t) -> -t.getPriority().ordinal())
                            .thenComparing(Task::getDeadLine))
                    .collect(Collectors.toList());

    // Runtime selection
    private SortStrategy strategy;

    public TaskSorter(SortStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(SortStrategy s)  { this.strategy = s; }
    public List<Task> sort(List<Task> tasks) { return strategy.sort(tasks); }
}
