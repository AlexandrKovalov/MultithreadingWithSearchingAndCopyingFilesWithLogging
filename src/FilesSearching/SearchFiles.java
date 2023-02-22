package FilesSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SearchFiles implements ISearchUtils{
    @Override
    public void find(String where, String what, PrintStream out) throws FileNotFoundException {
        try {
            File startDir = new File(where);
            File[] files = startDir.listFiles(x -> x.getName().toLowerCase().startsWith(what));
            for (File file : files) {
                out.println(file.getAbsolutePath());
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
