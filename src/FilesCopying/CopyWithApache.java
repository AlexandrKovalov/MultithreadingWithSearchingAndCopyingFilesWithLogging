package FilesCopying;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CopyWithApache implements ICopyUtils {

    @Override
    public void copy(String from, String to) throws IOException {
        try {
            File fileFrom = new File(from);
            File fileTo = new File(to);
            FileUtils.copyFile(fileFrom, fileTo);
        } catch (Exception e) {
            throw e;
        }
    }
}
