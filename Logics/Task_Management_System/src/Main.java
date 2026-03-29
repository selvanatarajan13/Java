import concurrent.TaskWorkerPool;
import ds.AuditLogger;
import ds.EmailNotifier;
import ds.TaskEventBus;
import ds.TaskSorter;
import model.Priority;
import model.Task;
import model.TaskEvent;
import model.TaskSnapshot;
import patterns.TaskBuilder;
import service.TaskManager;
import service.TaskQueryService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // ── 1. Get the singleton manager ─────────────────────────────
        TaskManager manager = TaskManager.getInstance();

        // ── 2. Register observers ─────────────────────────────────────
        TaskEventBus bus = manager.getEventBus();
        bus.subscribe(TaskEvent.CREATED,   new AuditLogger());
        bus.subscribe(TaskEvent.COMPLETED, new EmailNotifier());
        bus.subscribe(TaskEvent.COMPLETED, new AuditLogger());
        bus.subscribe(TaskEvent.OVERDUE,   new EmailNotifier());

        // ── 3. Build tasks with Builder ───────────────────────────────
        Task t1 = TaskBuilder.create("Design database schema")
                .priority(Priority.CRITICAL).dueIn(1)
                .assignTo("alice").tag("db", "backend").build();

        Task t2 = TaskBuilder.create("Write unit tests")
                .priority(Priority.HIGH).dueIn(3)
                .assignTo("bob").tag("testing").build();

        Task t3 = TaskBuilder.create("Update documentation")
                .priority(Priority.LOW).dueIn(7)
                .assignTo("alice").tag("docs").build();

        Task t4 = TaskBuilder.create("Fix auth bug")
                .priority(Priority.CRITICAL).dueIn(1)
                .assignTo("bob").tag("bug", "auth").build();

        Task t5 = TaskBuilder.create("Fix dashboard bug")
                .priority(Priority.CRITICAL).dueIn(1)
                .assignTo("mahend").tag("FE").build();

        // ── 4. Add to manager (triggers CREATED events) ───────────────
        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);
        manager.addTask(t4);

        // ── 5. Query with Streams ─────────────────────────────────────
        TaskQueryService query = new TaskQueryService(manager.getAllTasks());

        System.out.println("\n── Critical TODOs ──");
        query.getCriticalTodoTitles().forEach(System.out::println);

        System.out.println("\n── Tasks per Assignee ──");
        query.taskCountPerAssignee()
                .forEach((user, count) -> System.out.println(user + " → " + count));

        System.out.println("\n── Status Summary ──");
        query.getStatusSummary()
                .forEach((s, c) -> System.out.println(s + ": " + c));

        // ── 6. Sort with Strategy ─────────────────────────────────────
        TaskSorter sorter = new TaskSorter(TaskSorter.BY_PRIORITY_THEN_DEADLINE);
        System.out.println("\n── Sorted by Priority → Deadline ──");
        sorter.sort(manager.getAllTasks()).forEach(System.out::println);

        // ── 7. Process with thread pool ───────────────────────────────
        TaskWorkerPool pool = new TaskWorkerPool(3);
        pool.start();
        pool.processBatch(List.of(t1, t2, t4)); // runs concurrently!

        System.out.println("\n── Post-processing Summary ──");
        query = new TaskQueryService(manager.getAllTasks());
        query.getStatusSummary()
                .forEach((s, c) -> System.out.println(s + ": " + c));

        // ── 8. Undo last action ───────────────────────────────────────
//        if (manager.getHistory().canUndo()) {
//            TaskSnapshot snap = manager.getHistory().undo();
//            System.out.println("\n[Undo] Reverted: " + snap.task);
//        }

        pool.shutdown();
    }
}