import interfaces.CopyFileTask;
import FilesCopying.ICopyUtils;
import exceptions.TaskExecutionFailedException;

import java.io.IOException;

public class CopyFileTaskImpl extends TaskImpl implements CopyFileTask {

    private ICopyUtils copyUtils;
    private String from;
    private String to;

    public CopyFileTaskImpl(String from, String to, int id) {
        this.from = from;
        this.to = to;
        this.id = id;
    }

    @Override
    public void setFileCopyUtils(ICopyUtils copyUtils) {
        this.copyUtils = copyUtils;
    }

    @Override
    public void execute() throws TaskExecutionFailedException {
        try {
            copyUtils.copy(from, to);
        } catch (IOException e) {
            throw new TaskExecutionFailedException(e);
        }
    }
}
