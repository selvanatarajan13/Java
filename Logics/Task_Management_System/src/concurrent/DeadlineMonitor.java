package concurrent;

import ds.TaskEventBus;
import model.Status;
import model.TaskEvent;
import service.TaskManager;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadlineMonitor {

    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();
    private final TaskManager manager;
    private final TaskEventBus eventBus;

    public DeadlineMonitor() {
        this.manager  = TaskManager.getInstance();
        this.eventBus = manager.getEventBus();
    }

    // Runs every 60 seconds in background — checks for overdue tasks
    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now();

            manager.getAllTasks().stream()
                    .filter(t -> t.getStatus() != Status.DONE)
                    .filter(t -> t.getStatus() != Status.CANCELLED)
                    .filter(t -> t.getDeadLine().isBefore(now))
                    .forEach(t -> {
                        System.out.printf("[MONITOR] ⚠️  OVERDUE: %s (due %s)%n",
                                t.getTitle(), t.getDeadLine().toLocalDate());
                        eventBus.publish(TaskEvent.OVERDUE, t);
                    });

        }, 0, 60, TimeUnit.SECONDS);

        System.out.println("[Monitor] Deadline monitor started");
    }

    public void stop() {
        scheduler.shutdown();
    }
}
