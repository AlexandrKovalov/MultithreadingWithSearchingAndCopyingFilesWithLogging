package FilesSearching;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public interface ISearchUtils {
    public void find (String where, String what, PrintStream out) throws FileNotFoundException;
}
