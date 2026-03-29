package ds;

import model.Task;
import model.TaskEvent;

public class EmailNotifier implements TaskObserver {
    @Override
    public void onTaskEvent(TaskEvent event, Task task) {
        System.out.printf("[EMAIL] Task '%s' → %s%n", task.getTitle(), event);
    }
}
