import interfaces.Task;
import interfaces.TasksStorage;

import java.util.ArrayList;
import java.util.List;

public class TasksStorageImpl implements TasksStorage {

    private List<Task> tasks = new ArrayList<>();

    @Override
    public synchronized void add(Task task) throws NullPointerException {
        tasks.add(task);
    }

    @Override
    public synchronized Task get() {
        if (!tasks.isEmpty()) {
            return tasks.remove(0);
        }
        return null;
    }

    @Override
    public synchronized int count() {
        return tasks.size();
    }
}
