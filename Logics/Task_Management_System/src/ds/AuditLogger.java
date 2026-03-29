package ds;

import model.Task;
import model.TaskEvent;

import java.time.LocalDateTime;

public class AuditLogger implements TaskObserver {
    @Override
    public void onTaskEvent(TaskEvent event, Task task) {
        System.out.printf("[AUDIT] %s | Task: %s | Time: %s%n", event, task.getId(), LocalDateTime.now());
    }
}
