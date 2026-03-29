package ds;

import model.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskPriorityQueue {

    // Min-heap by: CRITICAL > HIGH > MEDIUM > LOW, then by deadline
    private final PriorityQueue<Task> queue;

    // O(1) lookup by ID
    private final Map<String, Task> index;

    public TaskPriorityQueue() {
        // Custom comparator: higher priority first, then earlier deadline
        this.queue = new PriorityQueue<>((a,b) -> {
            int priorityComp = b.getPriority().ordinal() - a.getPriority().ordinal();
            if (priorityComp != 0) return priorityComp;
            return a.getDeadLine().compareTo(b.getDeadLine());
        });
        this.index = new HashMap<>();
    }

    public void push(Task task) {
        queue.offer(task);
        index.put(task.getId(), task);
    }

    // Always returns the most urgent task — O(log n)
    public Task poll() {
        Task task = queue.poll();
        if (task != null) index.remove(task.getId());
        return task;
    }

    public Task peek() {
        return queue.peek();
    }

    public Task findById(String id) {
        return index.get(id);
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
