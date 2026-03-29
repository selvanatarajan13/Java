package ds;

import model.Task;
import model.TaskSnapshot;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskHistory {

    // Each entry = snapshot of a task's previous state
    private final Deque<TaskSnapshot> undoStack = new ArrayDeque<>();
    private final Deque<TaskSnapshot> redoStack = new ArrayDeque<>();
    private static final int MAX_HISTORY = 50;

    public void saveState(Task task) {
        if (undoStack.size() >= MAX_HISTORY) undoStack.pollLast(); // drop oldest
        undoStack.push(new TaskSnapshot(task));
        redoStack.clear(); // new action clears redo
    }

    public TaskSnapshot undo() {
        if (undoStack.isEmpty()) throw new IllegalStateException("Nothing to undo");
        TaskSnapshot snap = undoStack.pop();
        redoStack.push(snap);
        return snap;
    }

    public TaskSnapshot redo() {
        if (redoStack.isEmpty()) throw new IllegalStateException("Nothing to redo");
        TaskSnapshot snap = redoStack.pop();
        undoStack.push(snap);
        return snap;
    }

    public boolean canUndo() { return !undoStack.isEmpty(); }
    public boolean canRedo() { return !redoStack.isEmpty(); }
}
