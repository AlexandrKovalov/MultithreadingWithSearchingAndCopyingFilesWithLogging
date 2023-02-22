import exceptions.TaskExecutionFailedException;
import interfaces.Task;
import interfaces.TaskExecutor;
import interfaces.TasksStorage;
import org.apache.log4j.Logger;

public class TaskExecutorImpl implements TaskExecutor, Runnable {
    private static final Logger LOGGER = Logger.getLogger(TaskExecutorImpl.class);

    private TasksStorage storage;
    private boolean isStopped;

    @Override
    public void setStorage(TasksStorage storage) throws NullPointerException {
        this.storage = storage;
    }

    @Override
    public TasksStorage getStorage() {
        return storage;
    }

    @Override
    public void start() throws NullPointerException, IllegalStateException {
        new Thread(this).start();
    }

    @Override
    public void stop() throws IllegalStateException {
        isStopped = true;
    }

    @Override
    public void run() {
        while (!isStopped) {
            Task task = storage.get();
            String name = Thread.currentThread().getName();

            if (task == null) {
                LOGGER.debug(String.format("����� %s �������� ������.\n", name));
                stop();
            } else {
                int id = task.getId();
                try {
                    LOGGER.debug(String.format("����� %s �������� ������.\n", name));
                    task.execute();
                    LOGGER.debug(String.format("����� %s �������� ��������� ������ %d.\n", name, id));
                } catch (TaskExecutionFailedException e) {
                    LOGGER.debug(String.format("������ ��� ���������� ������ %d.\n", id));

                    if (task.getTryCount() < 5) {
                        task.incTryCount();
                        storage.add(task);
                        LOGGER.debug(String.format("����� %s ������ ������ %d � ��������� ����� %d ������� ����������.\n",
                                name, id, task.getTryCount()));
                    } else {
                        LOGGER.debug(String.format("������ %d �������.\n", id));
                    }
                }
            }
        }
    }
}
