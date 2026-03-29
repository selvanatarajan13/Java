package ds;

import model.Task;
import model.TaskEvent;

public interface TaskObserver {
    void onTaskEvent(TaskEvent event, Task task);
}
