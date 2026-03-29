package service;

import ds.TaskEventBus;
import ds.TaskHistory;
import ds.TaskPriorityQueue;
import model.Status;
import model.Task;
import model.TaskEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager {
    // Thread-safe lazy singleton
    private static volatile TaskManager instance;

    private final Map<String, Task> taskStore  = new ConcurrentHashMap<>();
    private final TaskPriorityQueue queue      = new TaskPriorityQueue();
    private final TaskEventBus eventBus   = new TaskEventBus();
    private final TaskHistory history    = new TaskHistory();

    private TaskManager() {}

    public static TaskManager getInstance() {
        if (instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) instance = new TaskManager();
            }
        }
        return instance;
    }

    public Task addTask(Task task) {
        taskStore.put(task.getId(), task);
        queue.push(task);
        history.saveState(task);
        eventBus.publish(TaskEvent.CREATED, task);
        return task;
    }

    public void completeTask(String taskId) {
        Task task = taskStore.get(taskId);
        if (task == null) throw new NoSuchElementException("Task not found: " + taskId);
        history.saveState(task);
        task.setStatus(Status.DONE);
        eventBus.publish(TaskEvent.COMPLETED, task);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskStore.values());
    }

    public TaskEventBus getEventBus()  { return eventBus; }
    public TaskHistory  getHistory()   { return history; }
}
