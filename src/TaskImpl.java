import interfaces.Task;

public abstract class TaskImpl implements Task {

    private int tryCount;
    protected int id;

    @Override
    public int getTryCount() {
        return tryCount;
    }

    @Override
    public void incTryCount() {
        tryCount++;
    }

    @Override
    public int getId() {
        return id;
    }
}
