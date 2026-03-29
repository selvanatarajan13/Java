package ds;

import model.Task;

import java.util.List;

public interface SortStrategy {
    List<Task> sort(List<Task> tasks);
}
