import exceptions.TaskExecutionFailedException;
import interfaces.FindFilesTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import FilesSearching.ISearchUtils;

public class FindFilesTaskImpl  extends TaskImpl implements FindFilesTask  {
    private PrintStream out;

    private String directory;

    private String searchString;

    private ISearchUtils searchUtils;

    public FindFilesTaskImpl(PrintStream out, String directory, String searchString, int id) {
        this.out = out;
        this.directory = directory;
        this.searchString = searchString;
        this.id = id;
    }


    @Override
    public void setDirectory(String directory) throws NullPointerException, FileNotFoundException {
        this.directory = directory;
    }

    @Override
    public void setFileNameSearchString(String searchString) throws IllegalArgumentException {
        this.searchString = searchString;
    }

    @Override
    public void setPrintStream(PrintStream out) throws FileNotFoundException  {
        this.out = out;
    }

    @Override
    public void setSearchUtils(ISearchUtils searchUtils) {
        this.searchUtils = searchUtils;
    }

    @Override
    public void execute() throws TaskExecutionFailedException {
        try {
            searchUtils.find(directory, searchString, out);
        } catch (FileNotFoundException e) {
            throw new TaskExecutionFailedException(e);
        }

    }
}
