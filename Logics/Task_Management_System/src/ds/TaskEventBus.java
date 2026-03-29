package ds;

import model.Task;
import model.TaskEvent;

import java.util.*;

public class TaskEventBus {
    private final Map<TaskEvent, List<TaskObserver>> listener = new HashMap<>();

    public void subscribe(TaskEvent event, TaskObserver taskObserver) {
        listener.computeIfAbsent(event, k -> new ArrayList<>()).add(taskObserver);
    }

    public void publish(TaskEvent event, Task task) {
        List<TaskObserver> obs = listener.getOrDefault(event, Collections.emptyList());
        obs.forEach(o -> o.onTaskEvent(event, task));
    }
}
