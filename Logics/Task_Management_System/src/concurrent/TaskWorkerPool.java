package concurrent;

import model.Task;
import service.TaskManager;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TaskWorkerPool {

    private final ExecutorService executor;
    private final TaskManager manager;
    private final AtomicInteger processedCount = new AtomicInteger(0);
    private final AtomicBoolean running        = new AtomicBoolean(false);
    private final BlockingQueue<Task> workQueue = new LinkedBlockingQueue<>();

    public TaskWorkerPool(int workerCount) {
        this.executor = Executors.newFixedThreadPool(workerCount);
        this.manager  = TaskManager.getInstance();
    }

    public void start() {
        running.set(true);
        System.out.println("[Pool] Started with " +
                ((ThreadPoolExecutor) executor).getCorePoolSize() + " workers");
    }

    // Submit a task for async processing
    public Future<String> submitTask(Task task) {
        return executor.submit(() -> {
            System.out.printf("[Worker-%s] Processing: %s%n",
                    Thread.currentThread().getName(), task.getTitle());

            // Simulate work based on priority
            int workTime = switch (task.getPriority()) {
                case CRITICAL -> 500;
                case HIGH     -> 800;
                case MEDIDUM   -> 1200;
                case LOW      -> 2000;
            };
            Thread.sleep(workTime);

            manager.completeTask(task.getId());
            processedCount.incrementAndGet(); // atomic — no race condition

            return "Completed: " + task.getTitle();
        });
    }

    // Process multiple tasks and wait for ALL to finish
    public void processBatch(List<Task> tasks) throws InterruptedException {
        List<Future<String>> futures = tasks.stream()
                .map(this::submitTask)
                .collect(Collectors.toList());

        // Wait for all and collect results
        futures.forEach(f -> {
            try {
                System.out.println("[Result] " + f.get()); // blocks until done
            } catch (Exception e) {
                System.err.println("[Error] " + e.getMessage());
            }
        });
    }

    public int getProcessedCount() { return processedCount.get(); }

    public void shutdown() throws InterruptedException {
        running.set(false);
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("[Pool] Shutdown. Total processed: " + processedCount.get());
    }
}
