import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class AppFileBefore {
    void transform(File in, File out) {
        Collection<String> src = FileUtils.readLines(in, "UTF-8");
        Collection<String> desc = new ArrayList<String>(src.size());

        for (String line : src) {
            desc.add(line.trim());
        }

        FileUtils.writeLines(out, desc, "UTF-8");
    }
}

class FileUtils {
    public static Collection<String> readLines(File f, String format) {
        return null;
    }

    public static void writeLines(File f, Collection<String> desc, String format) {
    }
}